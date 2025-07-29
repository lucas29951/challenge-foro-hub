package com.alura.forohub.dto.usuarios;

import com.alura.forohub.model.Usuario;

public record DatosListaUsuario(
        Long id,
        String nombre,
        String email,
        String contrasena
) {

    public DatosListaUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getContrasena()
        );
    }
}
