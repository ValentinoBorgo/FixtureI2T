package com.example.Fixture.Service;

import com.example.Fixture.Model.Usuario;
import java.util.List;

public interface IUsuarioService {
    
public List<Usuario> getListaUsuarios();

public Usuario guardarUsuario(Usuario user);

public String borrarUsuario(Long id);

public Usuario getUsuario(Long id);

public Usuario editarUsuario(Long id, Usuario user);

public Usuario buscarPorNombre(String nombre);

}
