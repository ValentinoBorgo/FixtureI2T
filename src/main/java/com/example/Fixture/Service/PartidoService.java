package com.example.Fixture.Service;

import com.example.Fixture.Model.Partido;
import com.example.Fixture.Repository.IPartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService implements IPartidoService{

    @Autowired
    private IPartidoRepository partidoRepo;
    @Override
    public List<Partido> getListaPartidos() {
        return partidoRepo.findAll();
    }

    @Override
    public Partido guardarPartido(Partido partido) {
        return partidoRepo.save(partido);
    }

    @Override
    public String borrarPartido(Long id) {
        partidoRepo.deleteById(id);
        return "Partido borrado";
    }

    @Override
    public Partido getPartido(Long id) {
        return partidoRepo.findById(id).orElse(null);
    }

    @Override
    public Partido editarPartido(Long id, Partido partido) {
        Partido partidonew = new Partido();
        //buscamos el id que hay que editar

        if(partidonew!=null) {
            partidonew = this.getPartido(id);

            //guardamos el partido nuevo
            partidonew = partidoRepo.save(partido);
        }
        //devolvemos el partido nuevo con sus cambios
        return partidonew;

    }
}
