package servidor.logica;

import ve.edu.ucab.server.logica.LogicaServidor;

/**
 *
 * @author gerardobarcia
 */
public class RealizarPartida implements LogicaServidor {

    public String realizarOperacion(String arg)
    {
        String resultado = "FALSE";
        String[] subArg = arg.split(":");

        switch (Integer.parseInt(subArg[0]))
        {
            case 2:
                System.out.println("Se realizara la operacion de creacion de partida");
                resultado = "";

//                Comunicacion.generarListaPiezasShuffle();
//                System.out.println("Se genera la lista shuffle de piezas " + resultado);
//
//                Comunicacion.distruibuirPiezasJugador();
//                System.out.println("Se generan las piezas del jugador " + resultado);
//
//                resultado = Comunicacion.generarSecuenciaDePiezas();

                System.out.println("Se devolvera al cliente " + resultado);
            break;
        }

        return resultado;
    }
}
