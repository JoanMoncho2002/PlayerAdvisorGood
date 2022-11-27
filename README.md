# Aplicación Spring Tool

1. He realizado el trabajo sobre jugadores de futbol, aquí muestro el diagrama de clases empleado:
2. Cada jugador tiene:
* id
* nombre
* apellido
* posicion
* nacionalidad
* liga
* equipo

3. Aqui muestro el fichero csv que uilizado:
```
id;nombre;apellido;posicion;nacionalidad;liga;equipo
1;Pedro;Gonzalez;Mediocentro;España;Liga Santander;Barcelona
2;Karim;Benzema;Delantero Centro;Francia;Liga Santander;Madrid
3;Neymar:da Silva Santos;Extremo Izquierdo;Brasil;Ligue 1;Paris Saint Germain
4;Thomas;Muller;Mediocentro Ofensivo;Alemania;Bundesliga;Bayern de Munich
5;Kylian;Mbappe;Delantero Centro;Francia;Ligue 1;Paris Saint Germain
6;Robert;Lewandowski;Delantero Centro;Polonia;Liga Santander;Barcelona
7;Keylor;Navas;Portero;Costa Rica;Ligue 1;Paris Saint Germain
8;Kevin;De Bruyne;Mediocentro;Belgica;Premier League;Manchester City
9;Cristiano;Ronaldo;Delantero Centro;Premier League;Manchester United
10;Lionel;Messi;Extremo Derecho;Argentina;Ligue 1;Paris Saint Germain

```

## EJEMPLO DE USO:
```
java -jar playeradvisor.jar -p Delantero Centro -n Karim
```

```
ID  Nombre  Apellido    Posicion            Nacionalidad    Liga            Equipo
2   Karim   Benzema     Delantero Centro    Francia         Liga Santander  Madrid
```

4. Al iniciar el programa, si no hay parámetros definidos te debería mostrar una alerta de 
que no se han indicado, y mostrará el contenido del fichero de ayuda, para saber que parámetros 
puedes utilizar:

```
Sintaxis: java -jar movieadvisor.jar [OPCIONES]

	-ln
	Lista las nacionalidades de los jugadores.
	No se pueden utilizar más parámetros.

	-tn nacionalidad1,nacionalidad2,nacionalidad...
	Lista todas las nacionalidades.

	-p posicion
    Lista los jugadores por la posicion listada.
    Se ignorará el uso de mayúsculas/minúsculas en la comparación.

	-a apellidos
	Lista los jugadores por el apellido listado.
	Se ignorará el uso de mayúsculas/minúsculas en la comparación.

	-n nombre
	Lista los jugadores por el nombre listado.
	Se ignorará el uso de mayúsculas/minúsculas en la comparación.

	-h
	Muestra este mensaje de ayuda.


EJEMPLOS DE USO

    java -jar playeradvisor.jar -p Delantero Centro -n Karim
    Muestra los jugadores que sean delanteros centro con el nombre de Karim.
    
    java -jar playeradvisor.jar -p Portero
    Muestra los porteros.
    
    java -jar playeradvisor.jar -an Portugal -p Delantero Centro -n Cristiano
    Muestra los jugadores cuyo nombre es Cristiano, son Delanteros Centro y 
    sean de nacionalidad Portuguesa
    
    java -jar playeradvisor.jar -tn
    Muestra un listado con todas las nacionalidades.


LICENCIAS

    Los datos utilizados sobre perifericos utilizados en este ejemplo son
    reales y están sacados del internet.
```




