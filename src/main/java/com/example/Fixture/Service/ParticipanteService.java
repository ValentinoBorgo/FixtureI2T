package com.example.Fixture.Service;

import com.example.Fixture.Model.Participante;
import com.example.Fixture.Model.Partido;
import com.example.Fixture.Repository.IParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService implements IParticipanteService{

    @Autowired
    private IParticipanteRepository participanteRepo;

    @Override
    public List<Participante> getParticipante() {
        return participanteRepo.findAll();
    }

    @Override
    public Participante guardarParticipante(Participante participante) {
        return participanteRepo.save(participante);
    }

    @Override
    public String borrarParticipante(Long id) {

        participanteRepo.deleteById(id);

        return "Participante eliminado.";
    }

    @Override
    public Participante getParticipante(Long id) {
        return participanteRepo.findById(id).orElse(null);
    }

    @Override
    public Participante editarParticipante(Long id, Participante participante) {
        Participante participantenew = new Participante();

        //buscamos el id que hay que editar
        if (participantenew!=null) {
            participantenew = this.getParticipante(id);

            //guardamos el partido nuevo
            participantenew = participanteRepo.save(participante);

            //devolvemos el partido nuevo con sus cambio
        }
        return participantenew;
    }
}
