package com.alura.forohub.dto.topicos;

import com.alura.forohub.model.Curso;
import com.alura.forohub.model.Estado;
import com.alura.forohub.model.Topico;
import com.alura.forohub.model.Usuario;

import java.time.LocalDateTime;

public record DatosListaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Estado status,
        Usuario autor,
        Curso curso
) {

    public DatosListaTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
