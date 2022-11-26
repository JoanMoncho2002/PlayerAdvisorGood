package com.joanmoncho.playeradvisor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.joanmoncho.playeradvisor.model.Player;
import com.joanmoncho.playeradvisor.service.PlayerQueryService;
import com.joanmoncho.playeradvisor.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joanmoncho.playeradvisor.service.PlayerQueryService;
import com.joanmoncho.playeradvisor.service.PlayerService;


@Component
public class PlayerAdvisorRunApp {

    @Autowired
    PlayerService playerService;
    @Autowired
    PlayerQueryService playerQueryService;
    @Autowired
    PlayerAdvisorHelp help;

    public void run(String[] args) {

        if (args.length < 1) {
            System.out.println("Error de sintaxis");
            System.out.println(help.getHelp());
        } else if (args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "-lg":
                    playerService.findAllNationalities().forEach(System.out::println);
                    break;
                case "-h":
                    System.out.println(help.getHelp());
                    break;
                default:
                    System.out.println("Error de sintaxis");
                    System.out.println(help.getHelp());

            }
        } else if (args.length % 2 != 0) {
            System.out.println("Error de sintaxis");
            System.out.println(help.getHelp());
        } else if (args.length > 8) {
            System.out.println("Error de sintaxis");
            System.out.println(help.getHelp());
        } else {

            List<String[]> argumentos = new ArrayList<>();

            for (int i = 0; i < args.length; i += 2) {
                argumentos.add(new String[] { args[i], args[i + 1] });
            }

            boolean error = false;

            for (String[] argumento : argumentos) {
                switch (argumento[0].toLowerCase()) {
                    case "-ag":
                        playerQueryService.anyNationality(argumento[1].split(","));
                        break;
                    case "-tg":
                        playerQueryService.allNationalities(argumento[1].split(","));
                        break;
                    case "-y":
                        //playerQueryService.year(argumento[1]);
                        break;
                    case "-b":
                        String[] years = argumento[1].split(",");
                        //playerQueryService.betweenYears(years[0], years[1]);
                        break;
                    case "-t":
                        playerQueryService.nombreContains(argumento[1]);
                        break;
                    default: error = true;
                        System.out.println("Error de sintaxis");
                        System.out.println(help.getHelp());
                }

            }

            if (!error) {
                Collection<Player> result = playerQueryService.exec();
                System.out.printf("%s\t%-50s\t%s\t%s\n","ID","Nombre", "Apellido", "Posicion", "Nacionalidad", "Liga", "Equipo");
                if (result != null) {
                    result.forEach(f -> System.out.printf("%s\t%-50s\t%s\t%s\n",
                            f.getId(), f.getNombre(), f.getApellido(), f.getPosicion(),
                            f.getNacionalidad().stream().collect(Collectors.joining(", ")), f.getLiga(), f.getEquipo()));
                } else {
                    System.out.println("No hay jugadores que cumplan esos criterios. Lo sentimos");
                }
            }
        }

    }

}