package com.joanmoncho.playeradvisor.dao;

import com.joanmoncho.playeradvisor.model.Jugador;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UtilPlayerFileReader {

    public static List<Jugador> readFile(final String path, final String separator, final String listSeparator) {
        List<Jugador> result = new ArrayList<Jugador>();

        try {
            // @formatter:off
            result = Files
                    .lines(Paths.get(ResourceUtils.getFile(path).toURI()))
                    .skip(1)
                    .map(line -> {
                        String[] values = line.split(separator);
                        return new Jugador(Long.parseLong(values[0]), values[1], values[2], values[3], values[4],
                                Arrays.asList(values[5].split(listSeparator)), Arrays.asList(values[6].split(listSeparator)));
                    }).collect(Collectors.toList());
            // @formatter:on

        } catch (IOException e) {
            System.err.println("Error de lectura del fichero de datos: imdb_data");
            System.exit(-1);
        }

        return result;
    }

}
