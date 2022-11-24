package com.joanmoncho.playeradvisor.dao;

import com.joanmoncho.playeradvisor.model.Jugador;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class PlayerDaoImplMemory implements PlayerDao{

    public List<Jugador> jugadores = new ArrayList<>();

    public void init(){
        //jugadores = UtilPlayerFileReader.readFile();
    }


    @Override
    public Jugador findById(long id) {
        return null;
    }

    @Override
    public Collection<Jugador> findAll() {
        return null;
    }

    @Override
    public void insert(Jugador jugador) {

    }

    @Override
    public void edit(Jugador jugador) {

    }

    @Override
    public void delete(long id) {

    }
}
