package com.joanmoncho.playeradvisor.service;

import com.joanmoncho.playeradvisor.model.Player;

import java.util.Collection;

public interface PlayerQueryService {

    public Collection<Player> exec();

    public PlayerQueryService anyNationality(String... nationality);

    public PlayerQueryService allNationalities(String... nationality);

    //public PlayerQueryService year(String year);

    //public PlayerQueryService betweenYears(String from, String to);

    public PlayerQueryService nombreContains(String nombre);

}
