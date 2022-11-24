package com.joanmoncho.playeradvisor.dao;

import com.joanmoncho.playeradvisor.model.Player;

import java.util.Collection;

public interface PlayerDao {

    public Player findById(long id);
    public Collection<Player> findAll();
    public void insert(Player player);
    public void edit(Player player);
    public void delete(long id);

}
