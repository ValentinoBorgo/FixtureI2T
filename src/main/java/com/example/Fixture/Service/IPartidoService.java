package com.example.Fixture.Service;

import com.example.Fixture.Model.Partido;

import java.util.List;

public interface IPartidoService {

    public List<Partido> getListaPartidos();

    public Partido guardarPartido(Partido partido);

    public String borrarPartido(Long id);

    public Partido getPartido(Long id);

    public Partido editarPartido(Long id, Partido partido);
}
