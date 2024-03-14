package com.example.Fixture.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "competencia")
public class Competencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_baja")
    private LocalDateTime fecha_baja;

    @Column(name = "fecha_inicio")
    private LocalDateTime fecha_inicio;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    @DateTimeFormat(pattern = "dd-MM-YYYY HH:mm:ss")
    private LocalDateTime fecha_creacion;

    //@Column(name = "id_usuario")
    //private Long id_usuario;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private Usuario usuario;

    @PrePersist
    protected void onCreate() {
        fecha_creacion = LocalDateTime.now(); // Configurar la fecha de creación como la fecha y hora actuales al
                                              // persistir por primera vez
    }
}