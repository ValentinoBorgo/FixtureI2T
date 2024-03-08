package com.example.Fixture.Service;

import com.example.Fixture.Model.Clasificacion;
import com.example.Fixture.Model.Competencia;
import com.example.Fixture.Model.Usuario;
import com.example.Fixture.Repository.IClasificacionRepository;
import com.example.Fixture.Repository.IParticipanteRepository;
import com.example.Fixture.Repository.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClasificacionService implements IClasificacionService{

    @Autowired
    private IClasificacionRepository clasificacionRepo;

    @Autowired
    private IParticipanteRepository participanteRepo;
    
    @Override
    public List<Clasificacion> getListaClasificacion() {

        //TRAER : 
        //NOMBRE DEL EQUIPO
        //PUNTOS : TENGO QUE CREARLOS YO
        //GOLES A FAVOR DEL EQUIPO
        //GOLES EN CONTRA DEL EQUIPO
        //DIFERENCIA DE GOLES

        List<Clasificacion> clasificacion = clasificacionRepo.findAll();
        ArrayList<String> nombres = new ArrayList<String>();

        for(Clasificacion cla : clasificacion){
            nombres.add(participanteRepo.findById(cla.getId_competidor()).get().getNombre());
        }

        System.out.println(nombres);

        return clasificacion;
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
