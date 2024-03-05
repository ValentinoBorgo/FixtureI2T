package com.example.Fixture.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.springframework.stereotype.Service;

import com.example.Fixture.Model.Usuario;
import com.example.Fixture.Repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private IUsuarioRepository userRepo;

    @Override
    public List<Usuario> getListaUsuarios() {
        return userRepo.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario user) {
        // TODO Auto-generated method stub
        Usuario usuario = new Usuario();
        usuario.setNombre(user.getNombre());
        usuario.setApellido(user.getApellido());
        usuario.setMail(user.getMail());
        usuario.setContrasenia(user.getContrasenia());
        usuario.setFecha_baja(user.getFecha_baja());
        return userRepo.save(usuario);
    }

    @Override
    public String borrarUsuario(Long id) {
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
