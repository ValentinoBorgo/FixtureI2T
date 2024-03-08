package com.example.Fixture.Service;

import com.example.Fixture.Dto.ClasificacionDTO;
import com.example.Fixture.Model.Clasificacion;

import java.util.List;

public interface IClasificacionService {

    public List<ClasificacionDTO> getListaClasificacion();

    public Clasificacion guardarClasificacion(Clasificacion clasificacion);

    public String borrarClasificacion(Long id);

    public Clasificacion getClasificacion(Long id);

    public Clasificacion editarClasificacion(Long id, Clasificacion clasificacion);
}
