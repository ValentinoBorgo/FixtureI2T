package com.example.Fixture.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "partido")
@Entity
@AllArgsConstructor
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_local")
    private Long idLocal;

    @Column(name = "id_visitante")
    private Long idVisitante;

    @Column(name = "id_competencia")
    private Long idCompetencia;

    @Column(name = "goles_local")
    private Integer golesLocal;

    @Column(name = "goles_visitante")
    private Integer golesVisitante;

    @Column(name = "fecha_realizacion")
    private LocalDateTime fecha_realizacion;

    @Column(name = "fecha_baja")
    private LocalDateTime fecha_baja;



}
