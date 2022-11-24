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

    public Collection<Player> findByAnyGenre(String... genres) {

        return queryService.anyNationality(genres).exec();

    }

    public Collection<Player> findByAllNationalities(String... genres) {
        return queryService.allNationalities(genres).exec();
    }

    /*public Collection<Player> findByYear(String year) {
        return queryService.year(year).exec();
    }

    public Collection<Player> findBetweenYears(String from, String to) {
        return queryService.betweenYears(from, to).exec();
    }
     */

    public Collection<Player> findByTitleContains(String nombre) {
        return queryService.nombreContains(nombre).exec();
    }

    public Collection<Player> findAll() {
        return playerDao.findAll();
    }

}
