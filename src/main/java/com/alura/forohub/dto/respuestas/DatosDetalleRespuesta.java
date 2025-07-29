package com.alura.forohub.dto.respuestas;

import com.alura.forohub.model.Estado;
import com.alura.forohub.model.Respuesta;
import com.alura.forohub.model.Topico;

import java.time.LocalDateTime;

public record DatosDetalleRespuesta(
        Long id,
        String mensaje,
        Long idTopico,
        LocalDateTime fecha_creacion,
        Long idAutor
) {

    public DatosDetalleRespuesta(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getTopico().getId(),
                respuesta.getFecha_creacion(),
                respuesta.getAutor().getId()
        );
    }
}
