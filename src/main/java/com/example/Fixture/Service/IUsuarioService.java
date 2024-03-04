package com.example.Fixture.Service;

import com.example.Fixture.Model.Usuario;
import java.util.List;

public interface IUsuarioService {
    
public List<Usuario> getUsuarios();

public Usuario guardarUsuario(Usuario user);

public String borarUsuario(Long id);

public Usuario getUsuario(Long id);

public Usuario editarUsuario(Long id, Usuario user);

}
