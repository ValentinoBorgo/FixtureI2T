/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Fixture.Service;

import com.example.Fixture.Repository.IUsuarioRepository;
import com.example.Fixture.Security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */

@Service
public class SecurityUserDetailsService implements UserDetailsService{
    
    @Autowired
    private IUsuarioRepository userRepo;

    public SecurityUserDetailsService(IUsuarioRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        var opUser = userRepo.findByNombre(username);
        
        if(opUser.isPresent()){
            
            return new SecurityUser(opUser.get());
            
        }
        
        throw new UsernameNotFoundException("Usuario no encontrado " + username);
        
    }
    
    
    
}
