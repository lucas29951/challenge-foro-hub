package com.alura.forohub.dto.cursos;

import com.alura.forohub.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso(
        @NotBlank String nombre,
        @NotNull Categoria categoria
        ) {
}
