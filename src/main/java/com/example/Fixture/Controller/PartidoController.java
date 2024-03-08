package com.example.Fixture.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Fixture.Model.Partido;
import com.example.Fixture.Model.Usuario;
import com.example.Fixture.Service.IPartidoService;
import java.util.List;
import com.example.Fixture.Service.PartidoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/partido")
public class PartidoController {

    @Autowired
    private IPartidoService partidoService;

    @GetMapping("/get")
    public List<Partido> getListaPartidos() {

        return partidoService.getListaPartidos();
    }

    @GetMapping("getPartido/{id}")
    public ResponseEntity<Partido> obtenerPartidoPorId(@PathVariable Long id) {
        try {
            Partido partido = partidoService.getPartido(id);
            return partido != null ? ResponseEntity.ok(partido) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Partido> crearPartido(@RequestBody Partido partido) {
        try {
            Partido nuevoPartido = partidoService.guardarPartido(partido);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPartido);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> editarPartido(@PathVariable Long id, @RequestBody Partido partido) {
        try {
            Partido partidoActualizado = partidoService.editarPartido(id, partido);
            return partidoActualizado != null ? ResponseEntity.ok(partidoActualizado) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPartido(@PathVariable Long id) {
        try {
            String mensaje = partidoService.borrarPartido(id);
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}