/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Fixture.Model;

import com.example.Fixture.Utils.NombreAutoridad;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 *
 * @author Usuario
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "autoridades")
public class Autoridad {
    
    @Id
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private NombreAutoridad nombre;

    public Autoridad(NombreAutoridad nombre) {
        this.nombre = nombre;
    }

    
    
}
