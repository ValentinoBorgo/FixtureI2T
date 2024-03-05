package com.example.Fixture.Service;

import com.example.Fixture.Model.Clasificacion;
import com.example.Fixture.Model.Competencia;
import com.example.Fixture.Repository.IClasificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasificacionService implements IClasificacionService{

    @Autowired
    private IClasificacionRepository clasificacionRepo;

    @Override
    public List<Clasificacion> getListaClasificacion() {

        return clasificacionRepo.findAll();
    }

    @Override
    public Clasificacion guardarClasificacion(Clasificacion clasificacion) {

        return clasificacionRepo.save(clasificacion);
    }

    @Override
    public String borrarClasificacion(Long id) {

        clasificacionRepo.deleteById(id);

        return "clasificacion eliminada";
    }

    @Override
    public Clasificacion getClasificacion(Long id) {


        return clasificacionRepo.findById(id).orElse(null);

    }

    @Override
    public Clasificacion editarClasificacion(Long id, Clasificacion clasificacion) {



        Clasificacion clasificacionnew = new Clasificacion();

        //buscamos el id que hay que editar
        if (clasificacionnew!=null) {
            clasificacionnew = this.getClasificacion(id);

            //guardamos la comp nueva
            clasificacionnew = clasificacionRepo.save(clasificacion);

            //devolvemos la compentencia nueva con sus cambios
        }
        return clasificacionnew;

    }
}
