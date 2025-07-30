package com.alura.forohub.model;

import com.alura.forohub.dto.respuestas.DatosActualizacionRespuesta;
import com.alura.forohub.dto.respuestas.DatosRegistroRespuesta;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico")
    private Topico topico;
    private LocalDateTime fecha_creacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor")
    private Usuario autor;


    public Respuesta(DatosRegistroRespuesta datos, Usuario usuario, Topico topico) {
        this.id = null;
        this.mensaje = datos.mensaje();
        this.topico = topico;
        this.fecha_creacion = LocalDateTime.now();
        this.autor = usuario;
    }

    public void actualizarInformacion(@Valid DatosActualizacionRespuesta datos, Usuario usuario, Topico topico) {
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (usuario != null) {
            this.autor = usuario;
        }
        if (topico != null) {
            this.topico = topico;
        }
        this.fecha_creacion = LocalDateTime.now();
    }
}
