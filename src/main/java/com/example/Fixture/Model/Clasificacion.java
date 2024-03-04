package com.example.Fixture.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clasificacion")
public class Clasificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_competidor")
    private Long id_competidor;

    @Column(name = "id_competencia")
    private Long id_competencia;

    @Column(name = "nro_ganados")
    private Integer numero_ganados;

    @Column(name = "nro_empatados")
    private Integer numero_empatados;

    @Column(name = "nro_perdidos")
    private Integer numero_perdidos;

    @Column(name = "fecha_baja")
    private LocalDateTime fecha_baja;

}
