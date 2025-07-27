package com.alura.forohub.dto.cursos;

import com.alura.forohub.model.Categoria;
import com.alura.forohub.model.Curso;

public record DatosDetalleCurso(
        Long id,
        String nombre,
        Categoria categoria
) {

    public DatosDetalleCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
