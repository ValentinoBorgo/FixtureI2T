package com.example.Fixture.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Fixture.Model.Usuario;
import java.util.Optional;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombre(String nombre);
    
}