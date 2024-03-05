/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Fixture.Security;

import com.example.Fixture.Model.Autoridad;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Usuario
 */
@AllArgsConstructor
public class SecurityAutoridad implements GrantedAuthority{

    private final Autoridad autoridad;
    
    @Override
    public String getAuthority() {
        return autoridad.getNombre().toString();
    }
    
    
    
}
