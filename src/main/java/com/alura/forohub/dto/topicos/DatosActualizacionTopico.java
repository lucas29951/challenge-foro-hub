package com.alura.forohub.dto.topicos;

import com.alura.forohub.model.Curso;
import com.alura.forohub.model.Estado;
import com.alura.forohub.model.Usuario;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizacionTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_creacion,
        Estado status,
        Long autor,
        Long curso
) {
}
