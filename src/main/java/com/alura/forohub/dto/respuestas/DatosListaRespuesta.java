package com.alura.forohub.dto.respuestas;

import com.alura.forohub.model.Respuesta;

import java.time.LocalDateTime;

public record DatosListaRespuesta(
        Long id,
        String mensaje,
        Long topico,
        LocalDateTime fecha_creacion,
        Long autor
) {

    public DatosListaRespuesta(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getTopico().getId(),
                respuesta.getFecha_creacion(),
                respuesta.getAutor().getId()
        );
    }
}
