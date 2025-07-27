package com.alura.forohub.dto.cursos;

import com.alura.forohub.model.Categoria;
import jakarta.validation.constraints.NotNull;

public record DatosActualizacionCurso(
        @NotNull Long id,
        String nombre,
        Categoria categoria
) {
}
