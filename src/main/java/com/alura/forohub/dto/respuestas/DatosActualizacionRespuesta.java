package com.alura.forohub.dto.respuestas;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizacionRespuesta(
        @NotNull Long id,
        String mensaje,
        Long topico,
        LocalDateTime fecha_creacion,
        Long autor
) {
}
