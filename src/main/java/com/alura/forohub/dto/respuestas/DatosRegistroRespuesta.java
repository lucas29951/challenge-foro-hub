package com.alura.forohub.dto.respuestas;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroRespuesta(
        @NotBlank String mensaje,
        @NotNull Long topico,
        @Future
        LocalDateTime fecha_creacion,
        @NotNull Long autor
) {
}
