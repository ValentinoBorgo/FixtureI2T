package com.example.Fixture.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "mail")
    private String mail;
    @Column(name = "contrasenia")
    private String contrasenia;
    @Column(name = "fecha_baja")
    private String fecha_baja;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_autoridades",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "autoridad_id", referencedColumnName = "id"))
    private List<Autoridad> autoridades;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Competencia> competencias = new ArrayList<>();

    public Usuario(Long id, String nombre, String apellido, String mail, String contrasenia, String fecha_baja, List<Autoridad> autoridades, List<Competencia> competencias) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.contrasenia = contrasenia;
        this.fecha_baja = fecha_baja;
        this.autoridades = autoridades;
        this.competencias = competencias;
    }
}
