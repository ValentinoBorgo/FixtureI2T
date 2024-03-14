package com.example.Fixture.Service;

import com.example.Fixture.Model.Competencia;
import com.example.Fixture.Model.Participante;
import com.example.Fixture.Repository.ICompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompetenciaService implements ICompetenciaService{

    @Autowired
    private ICompetenciaRepository competenciaRepo;

    @Override
    public List<Competencia> getListaCompetencias() {
        return competenciaRepo.findAll();
    }

    @Override
    public Competencia guardarCompetencia(Competencia competencia) {
        competencia.setFecha_creacion(LocalDateTime.now());
        return competenciaRepo.save(competencia);
    }

    @Override
    public String borrarCompetencia(Long id) {

        competenciaRepo.deleteById(id);

        return "competencia borrada";
    }

    @Override
    public Competencia getCompetencia(Long id) {
        return competenciaRepo.findById(id).orElse(null);

    }

    @Override
    public Competencia editarCompetencia(Long id, Competencia competencia) {
        Competencia competencianew = new Competencia();

        //buscamos el id que hay que editar
        if (competencianew!=null) {
            competencianew = this.getCompetencia(id);

            //guardamos la comp nueva
            competencianew = competenciaRepo.save(competencia);

            //devolvemos la compentencia nueva con sus cambios
        }
        return competencianew;
    }
}
