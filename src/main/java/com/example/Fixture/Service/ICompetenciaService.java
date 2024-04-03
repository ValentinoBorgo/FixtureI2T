package com.example.Fixture.Service;

import com.example.Fixture.Model.Competencia;

import java.util.List;

public interface ICompetenciaService {

    public List<Competencia> getListaCompetencias();

    public Competencia guardarCompetencia(Competencia competencia);

    public String borrarCompetencia(Long id);

    public Competencia getCompetencia(Long id);

    public Competencia editarCompetencia(Long id, Competencia competencia);

}
