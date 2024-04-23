package com.example.Fixture.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.Fixture.Model.Autoridad;
import com.example.Fixture.Model.Usuario;
import com.example.Fixture.Repository.IUsuarioRepository;
import com.example.Fixture.Utils.NombreAutoridad;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioService implements IUsuarioService{

    @Autowired
    private IUsuarioRepository userRepo;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(IUsuarioRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

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
        usuario.setContrasenia(passwordEncoder.encode(user.getContrasenia()));
        usuario.setFecha_baja(user.getFecha_baja());

        log.info("AUTORIDAD +  ", user);


        List<Autoridad> autoridades = new ArrayList<>();
       
        //Add authorities for roles of the users

        for (Autoridad autoridad : user.getAutoridades()) {
            String nombreAutoridadStr = autoridad.getNombre().name();
            Long idAutoridad = autoridad.getId();
            NombreAutoridad nombreAutoridad = NombreAutoridad.parsearNombreAutoridad(nombreAutoridadStr);
            autoridades.add(new Autoridad(nombreAutoridad, idAutoridad));
        }

        usuario.setAutoridades(autoridades);
        
        return userRepo.save(usuario);
    }

    @Override
    public String borrarUsuario(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borarUsuario'");
    }

    @Override
    public Usuario getUsuario(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public Usuario editarUsuario(Long id, Usuario user) {

        Usuario u = this.getUsuario(id);
        
        u.setApellido(user.getApellido());
        u.setAutoridades(user.getAutoridades());
        u.setCompetencias(user.getCompetencias());
        u.setContrasenia(user.getContrasenia());
        u.setFecha_baja(user.getFecha_baja());
        u.setId(user.getId());
        u.setMail(user.getMail());
        u.setNombre(user.getNombre());

        return userRepo.save(u);

    }

    @Override
    public Usuario buscarPorNombre(String nombre) {

        Optional<Usuario> user = userRepo.findByNombre(nombre);

        Usuario userDenegado = new Usuario();
        userDenegado.setNombre("No Encontrados");

        Usuario usuarioEfectivo = user.orElse(userDenegado);

        return usuarioEfectivo;

    }
}
