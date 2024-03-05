package com.example.Fixture.Service;

import com.example.Fixture.Model.Participante;

import java.util.List;

public interface IParticipanteService {

    public List<Participante> getParticipante();

    public Participante guardarParticipante(Participante participante);

    public String borrarParticipante(Long id);

    public Participante getParticipante(Long id);

    public Participante editarParticipante(Long id, Participante participante);
}
