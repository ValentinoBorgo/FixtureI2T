package com.example.Fixture.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Fixture.Model.Usuario;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

}