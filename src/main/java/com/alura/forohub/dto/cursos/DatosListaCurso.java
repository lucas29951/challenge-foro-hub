package com.alura.forohub.dto.cursos;

import com.alura.forohub.model.Categoria;
import com.alura.forohub.model.Curso;

public record DatosListaCurso(
        Long id,
        String nombre,
        Categoria categoria
) {

    public DatosListaCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
