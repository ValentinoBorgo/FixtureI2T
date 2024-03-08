package com.example.Fixture.Dto;

public class ClasificacionDTO {

    //TRAER : 
        //NOMBRE DEL EQUIPO
        //PUNTOS : TENGO QUE CREARLOS YO
        //SISTEMA DE PUNTOS : PARTIDO GANADO 3, PARTIDO EMPATADO 1, PARTIDO PERDIDO 0.
        //GOLES A FAVOR DEL EQUIPO
        //GOLES EN CONTRA DEL EQUIPO
        //DIFERENCIA DE GOLES

    private String nombre;

    private int puntos;

    private int golesAFavor;

    private int golesEnContra;

    private int diferencia;

    private int partidosGanados;

    private int partidosEmpatados;

    private int partidosPerdidos;

    

    public ClasificacionDTO() {
    }

    public ClasificacionDTO(String nombre, int puntos, int golesAFavor, int golesEnContra, int diferencia,
            int partidosGanados, int partidosEmpatados, int partidosPerdidos) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.golesAFavor = golesAFavor;
        this.golesEnContra = golesEnContra;
        this.diferencia = diferencia;
        this.partidosGanados = partidosGanados;
        this.partidosEmpatados = partidosEmpatados;
        this.partidosPerdidos = partidosPerdidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public void setGolesAFavor(int golesAFavor) {
        this.golesAFavor = golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    public int getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(int diferencia) {
        this.diferencia = diferencia;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    


}