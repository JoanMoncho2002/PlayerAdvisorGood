package com.joanmoncho.playeradvisor.dao;

import com.joanmoncho.playeradvisor.model.Player;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UtilPlayerFileReader {

    public static List<Player> readFile(final String path, final String separator, final String listSeparator) {
        List<Player> result = new ArrayList<Player>();

        try {
            // @formatter:off
            result = Files
                    .lines(Paths.get(ResourceUtils.getFile(path).toURI()))
                    .skip(1)
                    .map(line -> {
                        String[] values = line.split(separator);
                        return new Player(Long.parseLong(values[0]), values[1], values[2], values[3], Arrays.asList(values[4].split(listSeparator)),
                                values[5], values[6]);
                    }).collect(Collectors.toList());
            // @formatter:on

        } catch (IOException e) {
            System.err.println("Error de lectura del fichero de datos: imdb_data");
            System.exit(-1);
        }

        return result;
    }

}
