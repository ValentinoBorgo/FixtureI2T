package com.example.Fixture.Controller;

//import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.Fixture.Dto.UsuarioDTO;
import com.example.Fixture.Mappers.UsuarioMapper;
import com.example.Fixture.Model.Autoridad;
import com.example.Fixture.Model.Partido;
import com.example.Fixture.Model.Usuario;
import com.example.Fixture.Service.IUsuarioService;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.Fixture.Service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST})
@RestController
@RequestMapping(path = "/api/users")
public class UsuarioController {

    //@Value("${server.port}")
    //private int puerto;
    @Autowired
    private IUsuarioService usuarioService;
    
    
     private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

     private final UsuarioMapper usuarioMapper = new UsuarioMapper();

    @GetMapping("/get")
    public List<Usuario> getUsuarios() {
        System.out.println("USUARIOS ENCONTRADOS-------------------------------");
        return usuarioService.getListaUsuarios();
    }

    //@GetMapping("/get")
    public ResponseEntity<List<UsuarioDTO>> getUsuariosMaped() {
        List<Usuario> usuarios = usuarioService.getListaUsuarios();
        List<UsuarioDTO> usuariosDTO = usuarios.stream()
                .map(usuario -> {
                    UsuarioDTO dto = usuarioMapper.originalToDTO(usuario); // Utilizamos el mapper para mapear el
                                                                           // Usuario a UsuarioDTO
                    dto.setCompetencias(usuario.getCompetencias()); // Asignamos las competencias
                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(usuariosDTO);

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        try {
            Usuario usuario = usuarioService.getUsuario(id);
            return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping( value = "/registrar/newUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        try {
            return usuarioService.guardarUsuario(usuario);
        } catch (Exception e) {
            System.out.println(usuario.getAutoridades());
            e.printStackTrace();
            Usuario error = new Usuario();
            error.setAutoridades(usuario.getAutoridades());
            return error;
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            System.out.println(usuario.getAutoridades());
            Usuario usuarioActualizado = usuarioService.editarUsuario(id, usuario);
            return usuarioActualizado != null ? ResponseEntity.ok(usuarioActualizado) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> borrarUsuario(@PathVariable Long id) {
        try {
            String mensaje = usuarioService.borrarUsuario(id);
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/login", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<?> handleOptions() {
            try{
                HttpHeaders headers = new HttpHeaders();
                headers.add("Access-Control-Allow-Origin", "http://localhost:4200");
                headers.add("Access-Control-Allow-Methods", "POST, OPTIONS");
                headers.add("Access-Control-Allow-Headers", "*");
                headers.add("Access-Control-Allow-Credentials", "true");
                System.out.println("HEADERS  :  "+headers);
                logger.info("HEADERS: {}", headers);
                return new ResponseEntity<>(headers, HttpStatus.OK);
            }catch(Exception e){
                e.printStackTrace();
                
            }
        return null;
        }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                Usuario usuario = usuarioService.buscarPorNombre(username);
                String access_token = JWT.create()
                        .withSubject(usuario.getMail())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("autoridades",
                                usuario.getAutoridades().stream().map(Autoridad::getNombre)
                                        .collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
                response.setHeader("error", exception.getMessage());
                response.setStatus(HttpStatus.FORBIDDEN.value());
                // response.sendError(HttpStatus.FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }

    @GetMapping("/getByName/{name}")
    public Usuario getIdByName(@PathVariable  String name){

        try {
            return usuarioService.buscarPorNombre(name);
            } 
        catch (Exception e) {    
            return null;
        }


    }
}

