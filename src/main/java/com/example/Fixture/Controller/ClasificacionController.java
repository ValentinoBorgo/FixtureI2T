package com.example.Fixture.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Fixture.Model.Clasificacion;
import com.example.Fixture.Model.Competencia;
import com.example.Fixture.Service.IClasificacionService;
import java.util.List;
import com.example.Fixture.Service.ClasificacionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/clasificaciones")
public class ClasificacionController {

    @Autowired
    private IClasificacionService clasificacionService;

    @GetMapping("/get")
    public List<Clasificacion> getClasificaciones() {

        return clasificacionService.getListaClasificacion();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Clasificacion> obtenerClasificacionPorId(@PathVariable Long id) {
        try {
            Clasificacion clasificacion = clasificacionService.getClasificacion(id);
            return clasificacion != null ? ResponseEntity.ok(clasificacion) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Clasificacion> crearClasificacion(@RequestBody Clasificacion clasificacion) {
        try {
            Clasificacion nuevaClasificacion = clasificacionService.guardarClasificacion(clasificacion);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaClasificacion);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clasificacion> actualizarClasificacion(@PathVariable Long id, @RequestBody Clasificacion clasificacion) {
        try {
            Clasificacion clasificacionActualizada = clasificacionService.editarClasificacion(id, clasificacion);
            return clasificacionActualizada != null ? ResponseEntity.ok(clasificacionActualizada) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarClasificacion(@PathVariable Long id) {
        try {
            String mensaje = clasificacionService.borrarClasificacion(id);
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
