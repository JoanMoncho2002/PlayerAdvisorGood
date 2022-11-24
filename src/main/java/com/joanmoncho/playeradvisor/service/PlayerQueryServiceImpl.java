package com.joanmoncho.playeradvisor.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.joanmoncho.playeradvisor.dao.PlayerDao;
import com.joanmoncho.playeradvisor.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlayerQueryServiceImpl implements PlayerQueryService {
    @Autowired
    PlayerDao dao;

    private Predicate<Player> predicate;

    @PostConstruct
    public void init() {
        predicate = null;
    }

    public Collection<Player> exec() {

        // @formatter:off
        return dao.findAll().stream().filter(predicate).collect(Collectors.toList());
        // @formatter:on

    }

    public PlayerQueryServiceImpl anyNationality(String... nationalities) {
        Predicate<Player> pAnyNationality = (player -> Arrays.stream(nationalities).anyMatch(player.getNacionalidad()::contains));
        predicate = (predicate == null) ? pAnyNationality : predicate.and(pAnyNationality);
        return this;
    }

    public PlayerQueryServiceImpl allNationalities(String... nationalities) {
        Predicate<Player> pAllNationalities = (player -> Arrays.stream(nationalities).allMatch(player.getNacionalidad()::contains));
        predicate = (predicate == null) ?pAllNationalities: predicate.and(pAllNationalities);
        return this;
    }

    /*public PlayerQueryServiceImpl year(String year) {
        Predicate<Player> pYear = (film -> film.getYear().equalsIgnoreCase(year));
        predicate = (predicate == null) ? pYear : predicate.and(pYear);
        return this;
    }

    public PlayerQueryServiceImpl betweenYears(String from, String to) {
        Predicate<Player> pBetweenYears = (film -> {
            LocalDate fromYear = LocalDate.of(Integer.parseInt(from), 1, 1);
            LocalDate toYear = LocalDate.of(Integer.parseInt(to), 1, 3);
            LocalDate filmYear = LocalDate.of(Integer.parseInt(film.getYear()), 1, 2);

            return filmYear.isAfter(fromYear) && filmYear.isBefore(toYear);
        });

        predicate = (predicate == null) ? pBetweenYears : predicate.and(pBetweenYears);

        return this;
    }
     */

    public PlayerQueryServiceImpl nombreContains(String nombre) {
        Predicate<Player> pNombreContains  = (player -> player.getNombre().toLowerCase().contains(nombre.toLowerCase()));
        predicate = (predicate == null) ? pNombreContains : predicate.and(pNombreContains);

        return this;
    }


}
