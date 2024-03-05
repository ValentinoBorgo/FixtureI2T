package com.example.Fixture.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Fixture.Model.Competencia;
import com.example.Fixture.Model.Participante;
import com.example.Fixture.Service.ICompetenciaService;
import java.util.List;
import com.example.Fixture.Service.CompetenciaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/competencias")
public class CompetenciaController {

    @Autowired
    private ICompetenciaService competenciaService;

    @GetMapping("/get")
    public List<Competencia> getCompetencias() {

        return competenciaService.getListaCompetencias();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Competencia> obtenerCompetenciaPorId(@PathVariable Long id) {
        try {
            Competencia competencia = competenciaService.getCompetencia(id);
            return competencia != null ? ResponseEntity.ok(competencia) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Competencia> crearCompetencia(@RequestBody Competencia competencia) {
        try {
            Competencia nuevaCompetencia = competenciaService.guardarCompetencia(competencia);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCompetencia);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competencia> editarCompetencia(@PathVariable Long id, @RequestBody Competencia competencia) {
        try {
            Competencia competenciaActualizada = competenciaService.editarCompetencia(id, competencia);
            return competenciaActualizada != null ? ResponseEntity.ok(competenciaActualizada) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarCompetencia(@PathVariable Long id) {
        try {
            String mensaje = competenciaService.borrarCompetencia(id);
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
