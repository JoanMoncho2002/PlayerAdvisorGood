package com.joanmoncho.playeradvisor.dao;

import com.joanmoncho.playeradvisor.model.Jugador;

import java.util.Collection;

public interface PlayerDao {

    public Jugador findById(long id);
    public Collection<Jugador> findAll();
    public void insert(Jugador jugador);
    public void edit(Jugador jugador);
    public void delete(long id);

}
