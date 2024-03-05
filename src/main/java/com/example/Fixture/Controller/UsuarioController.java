package com.example.Fixture.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Fixture.Model.Usuario;
import java.util.List;

import com.example.Fixture.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UsuarioController {
    
    @Value("${server.port}")
    private int puerto;

    @Autowired
    private UsuarioService uService;

    @GetMapping("/get")
    public List<Usuario> getUsuarios(){
         System.out.println("------------------- Estoy en el puerto " + puerto);
        return uService.getListaUsuarios();
    }


}
