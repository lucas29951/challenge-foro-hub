package com.alura.forohub.controller;

import com.alura.forohub.dto.respuestas.DatosActualizacionRespuesta;
import com.alura.forohub.dto.respuestas.DatosDetalleRespuesta;
import com.alura.forohub.dto.respuestas.DatosListaRespuesta;
import com.alura.forohub.dto.respuestas.DatosRegistroRespuesta;
import com.alura.forohub.repository.RespuestaRepository;
import com.alura.forohub.service.GestionDeRespuestas;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

    @Autowired
    private RespuestaRepository repository;

    @Autowired
    private GestionDeRespuestas gestorDeRespuestas;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroRespuesta datos, UriComponentsBuilder uriComponentsBuilder) {
        var detalleRespuesta = gestorDeRespuestas.responderTopico(datos);

        var uri = uriComponentsBuilder.path("/respuestas/{id}").buildAndExpand(detalleRespuesta.id()).toUri();

        return ResponseEntity.created(uri).body(detalleRespuesta);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaRespuesta>> listar(@PageableDefault(size = 10)Pageable paginacion) {
        var page = repository.findAll(paginacion).map(DatosListaRespuesta::new);

        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionRespuesta datos) {
        var detalleRespuesta = gestorDeRespuestas.editarRespuesta(datos);

        return ResponseEntity.ok(detalleRespuesta);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        var respuesta = repository.getReferenceById(id);
        repository.delete(respuesta);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {
        var respuesta = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleRespuesta(respuesta));
    }
}
