package com.alura.forohub.dto.usuarios;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionUsuario(
        @NotNull Long id,
        String nombre,
        String correoElectronico,
        String contrasena
) {
}
