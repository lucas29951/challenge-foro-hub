package com.alura.forohub.dto.topicos;

import com.alura.forohub.model.Curso;
import com.alura.forohub.model.Estado;
import com.alura.forohub.model.Topico;
import com.alura.forohub.model.Usuario;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_creacion,
        Estado status,
        Long idAutor,
        Long idCurso
) {

    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha_creacion(),
                topico.getStatus(),
                topico.getAutor().getId(),
                topico.getCurso().getId()
        );
    }
}
