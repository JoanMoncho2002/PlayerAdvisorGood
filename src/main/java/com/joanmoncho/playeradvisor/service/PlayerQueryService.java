package com.joanmoncho.playeradvisor.service;

import com.joanmoncho.playeradvisor.model.Player;

import java.util.Collection;

public interface PlayerQueryService {

    public Collection<Player> exec();
    public PlayerQueryService anyNationality(String... nationality);
    public PlayerQueryService allNationalities(String... nationality);
    public PlayerQueryService nombreContains(String nombre);
    public PlayerQueryService apellidoContains(String apellido);
    public PlayerQueryService posicionContains(String apellido);

    //public PlayerQueryService year(String year);
    //public PlayerQueryService betweenYears(String from, String to);
}
