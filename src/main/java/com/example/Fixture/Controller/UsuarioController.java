package com.example.Fixture.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Fixture.Model.Usuario;
import java.util.List;

import com.example.Fixture.Service.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService uService;

    @GetMapping("/getUsers")
    public List<Usuario> getUsuarios(){
        return uService.getUsuarios();
    }


}
