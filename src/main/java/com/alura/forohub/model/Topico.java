package com.alura.forohub.model;

import com.alura.forohub.dto.topicos.DatosActualizacionTopico;
import com.alura.forohub.dto.topicos.DatosRegistroTopico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha_creacion;
    @Enumerated(EnumType.STRING)
    private Estado status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor")
    private Usuario autor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso")
    private Curso curso;


    public Topico(DatosRegistroTopico datos, Usuario usuario, Curso curso) {
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fecha_creacion = LocalDateTime.now();
        this.status = Estado.ABIERTO;
        this.autor = usuario;
        this.curso = curso;
    }

    public void actualizarInformacion(@Valid DatosActualizacionTopico datos, Usuario usuario, Curso curso) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.status() != null) {
            this.status = datos.status();
        }
        if (usuario != null) {
            this.autor = usuario;
        }
        if (curso != null) {
            this.curso = curso;
        }
        this.fecha_creacion = LocalDateTime.now();
    }
}
