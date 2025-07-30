package com.alura.forohub.service;

import com.alura.forohub.dto.respuestas.DatosActualizacionRespuesta;
import com.alura.forohub.dto.respuestas.DatosDetalleRespuesta;
import com.alura.forohub.dto.respuestas.DatosRegistroRespuesta;
import com.alura.forohub.exceptions.ValidacionException;
import com.alura.forohub.model.Respuesta;
import com.alura.forohub.repository.RespuestaRepository;
import com.alura.forohub.repository.TopicoRepository;
import com.alura.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionDeRespuestas {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    public DatosDetalleRespuesta responderTopico(DatosRegistroRespuesta datos) {
        var usuario = usuarioRepository.getReferenceById(datos.autor());
        var topico = topicoRepository.getReferenceById(datos.topico());

        if (usuario.getId() == null) {
            throw new ValidacionException("No existe un usuario con id indicado.");
        }
        if (topico.getId() == null) {
            throw new ValidacionException("No existe un topico con el id indicado.");
        }

        var respuesta = new Respuesta(datos, usuario, topico);

        respuestaRepository.save(respuesta);

        return new DatosDetalleRespuesta(respuesta);
    }

    public DatosDetalleRespuesta editarRespuesta(DatosActualizacionRespuesta datos) {
        var respuesta = respuestaRepository.getReferenceById(datos.id());
        var usuario = usuarioRepository.getReferenceById(datos.autor());
        var topico = topicoRepository.getReferenceById(datos.topico());

        if (topico.getId() == null) {
            throw new ValidacionException("No existe un topico con el id indicado.");
        }
        if (usuario.getId() == null) {
            throw new ValidacionException("No existe un usuario con id indicado.");
        }
        if (respuesta.getId() == null) {
            throw new ValidacionException("No existe una respuesta con el id indicado.");
        }

        respuesta.actualizarInformacion(datos, usuario, topico);

        return new DatosDetalleRespuesta(respuesta);
    }
}
