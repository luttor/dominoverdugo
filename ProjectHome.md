Proyecto de Algoritmos y Programacion III



i-Dominó.  Un juego entretenido,  basado en Java.

La finalidad que se busca desarrollar en “Dominó Verdugo Project”  es adquirir y demostrar mucha destreza en cuanto a la implementación de algoritmos haciendo uso de principios orientados a objetos, y la correcta aplicación del análisis y diseño del dominio para resolución de problemas de negocio, utilizando tanto código realizado por ellos como librerías externas para la solución.

La idea central es la elaboración y desarrollo de una versión del popular juego “Dominó” denominado “iDominó”.  Para ello se debe realizar el análisis, diseño e implementación de una serie de módulos que compondrán el sistema. Para el desarrollo de la solución informática se tomó una herramienta ya existente para el envío de información vía Sockets mediante el protocolo de red TCP/IP,   dicha herramienta lleva por nombre “JSockets”.  Por otra parte, en este proyecto se considera para la arquitectura del juego la implementación de un servidor donde se encuentra el core con todas las funcionalidades del juego y a donde solo podrá tener acceso personal autorizado.

iDominó, se estructuró en base a las reglas de dominó en modalidad maracucho, el cual señala las siguientes pautas:

En modo de dos jugadores:

Jugadores: Un (1) solo jugador real, en contra de la maquina.
Objetivo: La partida se compone de varias manos y termina cuando exista un jugador (real o maquina) que alcance los 100 puntos.
Salida: En el Dominó Maracucho el jugador que posee el doble seis realiza la salida de la primera ronda. De resto se alternaran las salidas los jugadores
Paso: Cuando un jugador no disponga de piezas con las combinaciones posibles en el tablero, se le cederá el turno a su adversario.
Puntuación El jugador ganador de la mano se le sumará la totalidad de los puntos no jugados, es decir, la suma de los puntos en las fichas que resten por jugar a su adversario.
Tranca La tranca es individual, es decir, cada jugador cuenta sus tantos y el que posea menos es el ganador de la ronda (la mano ganada le corresponde a al jugador que tenga menos puntos por jugar). Al jugador ganador se sumará  los puntos en las fichas que resten por jugar a su adversario. En caso de empate, la partida se termina y no se sumaran puntos a ninguno de los jugadores.
Para esta primera versión de iDominó no se permiten partidas entre dos jugadores o parejas de jugadores reales, sólo se podrá entre jugador y máquina.
El juego “I-Dominó”  fue creado para ser evaluado en la cátedra de Algoritmos y Programación III, escuela de Ingeniería Informática de la Universidad Católica Andrés Bello,  bajo la tutela del Profesor Ing. Ricardo Casanova.
Por:	Minerva Verdugo Ruiz (Líder y Desarrolladora de Software)
> Curso de Verano 201023 – UCAB
Caracas - Venezuela - 2010

Profesor  y  Colaborador: Ing. Ricardo Casanova


Integrante:
Minerva Verdugo Ruiz