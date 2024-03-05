/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Fixture.Security;

import com.example.Fixture.Model.Usuario;
import java.util.Collection;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.Fixture.Security.SecurityAutoridad;

/**
 *
 * @author Usuario
 */
@AllArgsConstructor
public class SecurityUser implements UserDetails {

    private final Usuario user;

    @Override
    public String getPassword() {
        return user.getContrasenia();
    }

    @Override
    public String getUsername() {
        return user.getNombre();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAutoridades().stream().map(SecurityAutoridad::new).toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
