package com.joanmoncho.playeradvisor.dao;

import com.joanmoncho.playeradvisor.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.joanmoncho.playeradvisor.config.AppConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class PlayerDaoImplMemory implements PlayerDao{

    public List<Player> players = new ArrayList<>();
    @Autowired
    private AppConfig appConfig;

    public void init(){
        players = UtilPlayerFileReader.readFile(appConfig.getFile(), appConfig.getSeparator(), appConfig.getListSeparator());
    }

    @Override
    public Player findById(long id) {

        Optional<Player> result = players.stream().filter(f -> f.getId() == id).findFirst();

        return result.orElse(null);
    }

    @Override
    public Collection<Player> findAll() {
        return players;
    }

    @Override
    public void insert(Player player) {
        players.add(player);
    }

    @Override
    public void edit(Player player) {
        int index = getIndexOf(player.getId());
        if (index != -1)
            players.set(index, player);
    }

    @Override
    public void delete(long id) {
        int index = getIndexOf(id);
        if (index != -1)
            players.remove(index);
    }

    private int getIndexOf(long id) {
        boolean encontrado = false;
        int index = 0;

        while (!encontrado && index < players.size()) {
            if (players.get(index).getId() == id)
                encontrado = true;
            else
                index++;
        }

        return (encontrado) ?index: -1;
    }
}
