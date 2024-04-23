/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Fixture.Utils;

/**
 *
 * @author Usuario
 */

 //Enumeracion
public enum NombreAutoridad {
    
    READ("WRITE"),
    WRITE("WRITE"),
    ADMIN("ADMIN");
    
    private final String name;

    NombreAutoridad (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static NombreAutoridad parsearNombreAutoridad(String autoridadStr) {
        switch (autoridadStr) {
            case "READ":
                return NombreAutoridad.READ;
            case "WRITE":
                return NombreAutoridad.WRITE;
            case "ADMIN":
                return NombreAutoridad.ADMIN;
            default:
                throw new IllegalArgumentException("Nombre de autoridad no válido: " + autoridadStr);
        }
    }

}

