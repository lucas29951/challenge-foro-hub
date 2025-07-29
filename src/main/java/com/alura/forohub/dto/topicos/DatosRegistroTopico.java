package com.alura.forohub.dto.topicos;

import com.alura.forohub.model.Curso;
import com.alura.forohub.model.Estado;
import com.alura.forohub.model.Usuario;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,

        @Future
        LocalDateTime fechaCreacion,

        Estado status,
        @NotNull Usuario autor,
        @NotNull Curso curso
) {
}
