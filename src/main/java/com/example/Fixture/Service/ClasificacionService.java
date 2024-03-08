package com.example.Fixture.Service;

import com.example.Fixture.Dto.ClasificacionDTO;
import com.example.Fixture.Model.Clasificacion;
import com.example.Fixture.Model.Competencia;
import com.example.Fixture.Model.Participante;
import com.example.Fixture.Model.Partido;
import com.example.Fixture.Model.Usuario;
import com.example.Fixture.Repository.IClasificacionRepository;
import com.example.Fixture.Repository.IParticipanteRepository;
import com.example.Fixture.Repository.IPartidoRepository;
import com.example.Fixture.Repository.IUsuarioRepository;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

@Service
public class ClasificacionService implements IClasificacionService{

    @Autowired
    private IClasificacionRepository clasificacionRepo;

    @Autowired
    private IParticipanteRepository participanteRepo;

    @Autowired
    private IPartidoRepository partidoRepo;
    
    @Override
    public List<ClasificacionDTO> getListaClasificacion() {

        //TRAER : 
        //NOMBRE DEL EQUIPO
        //PUNTOS : TENGO QUE CREARLOS YO
        //SISTEMA DE PUNTOS : PARTIDO GANADO 3, PARTIDO EMPATADO 1, PARTIDO PERDIDO 0.
        //GOLES A FAVOR DEL EQUIPO
        //GOLES EN CONTRA DEL EQUIPO
        //DIFERENCIA DE GOLES

        List<Clasificacion> clasificacion = clasificacionRepo.findAll();
        ArrayList<ClasificacionDTO> rank = new ArrayList<ClasificacionDTO>();

        //ArrayList<String> nombres = new ArrayList<String>();

        for(Clasificacion cla : clasificacion){
            ClasificacionDTO puestos = new ClasificacionDTO();

            Long id = participanteRepo.findById(cla.getId_competidor()).get().getId();
            //nombres.add(participanteRepo.findById(cla.getId_competidor()).get().getNombre());
            puestos.setNombre(participanteRepo.findById(cla.getId_competidor()).get().getNombre());

            HashMap<String, Integer> partidos = new HashMap<String, Integer>();

            partidos.put("Partidos Ganados", cla.getNumero_ganados());
            partidos.put("Partidos Perdidos", cla.getNumero_perdidos());
            partidos.put("Partidos Empatados", cla.getNumero_empatados());

            int partidosGanados = partidos.get("Partidos Ganados");
            int partidosPerdidos = partidos.get("Partidos Perdidos");
            int partidosEmpatados = partidos.get("Partidos Empatados");

            puestos.setPartidosGanados(partidosGanados);
            puestos.setPartidosEmpatados(partidosEmpatados);
            puestos.setPartidosPerdidos(partidosPerdidos);


            int puntos = (partidosGanados*3) + (partidosEmpatados*1);

            puestos.setPuntos(puntos);
            
            Participante participante =  participanteRepo.findById(cla.getId_competidor()).orElse(null);
            List<Partido> partidosAll = partidoRepo.findAll();

            HashMap<String, Integer> goles = new HashMap<String, Integer>();
            int golesAFavor = 0;
            int golesEnContra = 0;
            int diferencia = 0;

            for (Partido p : partidosAll) {
                if(p.getIdLocal() == id){
                    golesAFavor += p.getGolesLocal();
                    golesEnContra += p.getGolesVisitante();
                }else if(p.getIdVisitante() == id){
                    golesAFavor += p.getGolesVisitante();
                    golesEnContra += p.getGolesLocal();
                }
            }

            diferencia = golesAFavor - golesEnContra;

            puestos.setGolesAFavor(golesAFavor);
            puestos.setGolesEnContra(golesEnContra);
            puestos.setDiferencia(diferencia);

            rank.add(puestos);
        }

        Collections.sort(rank, Comparator.comparingInt(ClasificacionDTO::getPuntos).reversed());
        //Collections.sort(rank, Comparator.comparingInt(ClasificacionDTO::getDiferencia).reversed());
        //Collections.sort(rank, Comparator.comparingInt(ClasificacionDTO::getGolesAFavor).reversed());

        return rank;
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
