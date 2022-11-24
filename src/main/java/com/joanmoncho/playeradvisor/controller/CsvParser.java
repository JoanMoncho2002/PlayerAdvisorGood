package com.joanmoncho.playeradvisor.controller;

import com.joanmoncho.playeradvisor.model.Player;
import org.springframework.util.ResourceUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvParser {

    public static List<Player> readFile(final String path, final String separator, final String listSeparator) {
        List<Player> result = new ArrayList<>();

        try {
            result = Files
                    .lines(Paths.get(ResourceUtils.getFile(path).toURI()))
                    .skip(1)
                    .map(line -> {
                        String[] values = line.split(separator);
                        return new Player(Long.parseLong(values[0]), values[1], values[2], values[3], Arrays.asList(values[4].split(listSeparator)),
                                values[5], values[6]);
                    }).collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error de lectura del fichero de datos: futbolistas.csv");
            System.exit(-1);
        }
        return result;
    }
}