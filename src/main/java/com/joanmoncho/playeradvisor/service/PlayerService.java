package com.joanmoncho.playeradvisor.service;

import com.joanmoncho.playeradvisor.dao.PlayerDao;
import com.joanmoncho.playeradvisor.model.Player;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerService {

    @Autowired
    PlayerDao playerDao;

    @Autowired
    PlayerQueryService queryService;

    public Collection<String> findAllNationalities() {
        List<String> result = null;

        // @formatter:off
        result = playerDao.findAll()
                .stream()
                .map(f -> f.getNacionalidad())
                .flatMap(lista -> lista.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        // @formatter:on

        return result;
    }

    public Collection<Player> findByAnyNationality(String... nationality) {

        return queryService.anyNationality(nationality).exec();

    }

    public Collection<Player> findByAllNationalities(String... nationality) {
        return queryService.allNationalities(nationality).exec();
    }

    /*public Collection<Player> findByYear(String year) {
        return queryService.year(year).exec();
    }

    public Collection<Player> findBetweenYears(String from, String to) {
        return queryService.betweenYears(from, to).exec();
    }
     */

    public Collection<Player> findByNameContains(String nombre) {
        return queryService.nombreContains(nombre).exec();
    }

    public Collection<Player> findByApellidoContains(String apellido) {
        return queryService.apellidoContains(apellido).exec();
    }
    public Collection<Player> findByPosicionContains(String posicion) {
        return queryService.posicionContains(posicion).exec();
    }

    public Collection<Player> findAll() {
        return playerDao.findAll();
    }

}
