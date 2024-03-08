package com.example.Fixture.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Fixture.Model.Participante;
import com.example.Fixture.Service.IParticipanteService;
import java.util.List;
import com.example.Fixture.Service.ParticipanteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/participantes")
public class ParticipanteController {

    @Autowired
    private IParticipanteService participanteService;

    @GetMapping("/get")
    public List<Participante> getParticipantes() {

        return participanteService.getParticipante();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Participante> obtenerParcipantePorId(@PathVariable Long id) {
        try {
            Participante participante = participanteService.getParticipante(id);
            return participante != null ? ResponseEntity.ok(participante) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Participante> crearParticipante(@RequestBody Participante participante) {
        try {
            Participante nuevoParticipante = participanteService.guardarParticipante(participante);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoParticipante);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participante> editarParticipante(@PathVariable Long id, @RequestBody Participante participante) {
        try {
            Participante participanteActualizado = participanteService.editarParticipante(id, participante);
            return participanteActualizado != null ? ResponseEntity.ok(participanteActualizado) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarParticipante(@PathVariable Long id) {
        try {
            String mensaje = participanteService.borrarParticipante(id);
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

