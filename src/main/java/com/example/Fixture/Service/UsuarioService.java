package com.example.Fixture.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Fixture.Model.Usuario;
import com.example.Fixture.Repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private IUsuarioRepository userRepo;

    @Override
    public List<Usuario> getUsuarios() {
        return userRepo.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarUsuario'");
    }

    @Override
    public String borarUsuario(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borarUsuario'");
    }

    @Override
    public Usuario getUsuario(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsuario'");
    }

    @Override
    public Usuario editarUsuario(Long id, Usuario user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editarUsuario'");
    }

}
