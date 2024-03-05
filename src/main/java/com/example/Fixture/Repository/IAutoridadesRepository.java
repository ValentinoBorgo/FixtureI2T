/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Fixture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Fixture.Model.Autoridad;
import com.example.Fixture.Utils.NombreAutoridad;
import java.util.Optional;

/**
 *
 * @author Usuario
 */
public interface IAutoridadesRepository extends JpaRepository<Autoridad, Long>{
    
    //Retornar una autoridad por su nombre
    Optional<Autoridad> findByNombre(NombreAutoridad nombre);
    
}
