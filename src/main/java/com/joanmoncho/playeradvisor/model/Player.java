package com.joanmoncho.playeradvisor.model;

import java.util.List;

public class Player {

    private long id;
    private String nombre;
    private String apellido;
    private String posicion;
    private List<String> nacionalidad;
    private String liga;
    private  String equipo;

    public Player(){}

    public Player(long id, String nombre, String apellido, String posicion, List<String> nacionalidad, String liga, String equipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
        this.liga = liga;
        this.equipo = equipo;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPosicion() {
        return posicion;
    }

    public List<String> getNacionalidad() {
        return nacionalidad;
    }

    public String getLiga() {
        return liga;
    }

    public String getEquipo() {
        return equipo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", posicion='" + posicion + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", liga=" + liga +
                ", equipo=" + equipo +
                '}';
    }

}
