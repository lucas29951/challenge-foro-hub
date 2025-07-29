package com.alura.forohub.dto.usuarios;

import com.alura.forohub.model.Usuario;

public record DatosDetalleUsuario(
        Long id,
        String nombre,
        String email,
        String contrasena
) {

    public DatosDetalleUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getContrasena()
        );
    }
}
