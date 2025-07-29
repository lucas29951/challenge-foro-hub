package com.alura.forohub.model;

import com.alura.forohub.dto.usuarios.DatosActualizacionUsuario;
import com.alura.forohub.dto.usuarios.DatosRegistroUsuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;

    public Usuario(DatosRegistroUsuario datos) {
        this.id = null;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.contrasena = datos.contrasena();
    }

    public Usuario(DatosRegistroUsuario datos, String contrasenaEncriptada) {
        this.id = null;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.contrasena = contrasenaEncriptada;
    }

    public void actualizarInformacion(@Valid DatosActualizacionUsuario datos, String contrasenaEncriptada) {
        if (datos.nombre() != null) {
            this.nombre = datos.nombre();
        }
        if (datos.email() != null) {
            this.email = datos.email();
        }
        if (!contrasenaEncriptada.equalsIgnoreCase("")) {
            this.contrasena = contrasenaEncriptada;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
