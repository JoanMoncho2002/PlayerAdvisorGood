package com.joanmoncho.playeradvisor.model;

import java.util.List;

public class Jugador {

    private long id;
    private String nombre;
    private String apellido;
    private String posicion;
    private String nacionalidad;
    private List<String> liga;
    private  List<String> equipo;

    public Jugador(){}

    public Jugador(long id, String nombre, String apellido, String posicion, String nacionalidad, List<String> liga, List<String> equipo) {
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public List<String> getLiga() {
        return liga;
    }

    public List<String> getEquipo() {
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
