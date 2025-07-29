package com.alura.forohub.service;

import com.alura.forohub.dto.topicos.DatosDetalleTopico;
import com.alura.forohub.dto.topicos.DatosRegistroTopico;
import com.alura.forohub.exceptions.ValidacionException;
import com.alura.forohub.model.Topico;
import com.alura.forohub.repository.CursoRepository;
import com.alura.forohub.repository.TopicoRepository;
import com.alura.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionDeTopicos {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public DatosDetalleTopico postear(DatosRegistroTopico datos) {
        if (!usuarioRepository.existsById(datos.autor().getId())) {
            throw new ValidacionException("No existe un usuario con id indicado.");
        }
        if (!cursoRepository.existsById(datos.curso().getId())) {
            throw new ValidacionException("No existe un curso con el id indicado.");
        }

        var topico = new Topico(datos);

        topicoRepository.save(topico);

        return new DatosDetalleTopico(topico);
    }
}
