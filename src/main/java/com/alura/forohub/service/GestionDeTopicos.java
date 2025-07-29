package com.alura.forohub.service;

import com.alura.forohub.dto.topicos.DatosActualizacionTopico;
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
        var usuario = usuarioRepository.getReferenceById(datos.autor());
        var curso = cursoRepository.getReferenceById(datos.curso());

        if (usuario.getId() == null) {
            throw new ValidacionException("No existe un usuario con id indicado.");
        }
        if (curso.getId() == null) {
            throw new ValidacionException("No existe un curso con el id indicado.");
        }

        var topico = new Topico(datos, usuario, curso);

        topicoRepository.save(topico);

        return new DatosDetalleTopico(topico);
    }

    public DatosDetalleTopico actualizar(DatosActualizacionTopico datos) {
        var topico = topicoRepository.getReferenceById(datos.id());
        var usuario = usuarioRepository.getReferenceById(datos.autor());
        var curso = cursoRepository.getReferenceById(datos.curso());

        if (topico.getId() == null) {
            throw new ValidacionException("No existe un topico con el id indicado.");
        }
        if (usuario.getId() == null) {
            throw new ValidacionException("No existe un usuario con id indicado.");
        }
        if (curso.getId() == null) {
            throw new ValidacionException("No existe un curso con el id indicado.");
        }

        topico.actualizarInformacion(datos, usuario, curso);

        return new DatosDetalleTopico(topico);
    }
}
