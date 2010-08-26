/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente.logica;
import cliente.dato.*;
import ve.edu.ucab.cliente.ClienteSocket;
import ve.edu.ucab.server.logica.LogicaServidor;
//import cliente.dato.Ficha;
import cliente.dato.ListaFicha;
//
//import ve.edu.ucab.server.logica.LogicaServidor;
/**
 *
 * @author Minerva Verdugo Ruiz
 */

public class ComunicacionServidor implements LogicaServidor {

    public ComunicacionServidor() {
    }

public String realizarOperacion(String arg) {

String[] subArg = arg.split(":");
String[] elusuario;
Usuario usuariologeando= new Usuario();

String nick="",respuesta="";
int Opcion=0;
Opcion=(Integer.parseInt(subArg[0]));
Partida iniciopartida= new Partida();


//        subArg = resultado.split(":");
        int i=1;
        while (i<subArg.length)
        {
            elusuario = subArg[i].split(":");

            usuariologeando.setNickname(subArg[1]);


            usuariologeando.setNombre(nick);
            usuariologeando.setApellido(subArg[3]);
            usuariologeando.setAvatar(subArg[4]);
            usuariologeando.setFechanaci(subArg[5]);
            usuariologeando.setClave(subArg[2]);
            i++;

            System.out.println(elusuario);

        }
        return respuesta;
          }

   public void PicarFicha(String resultado){

        String[] subArg, pieza;
        Ficha laPieza;
        subArg = resultado.split(":");


       int i = 0;

        while (i<subArg.length)
        {
            pieza = subArg[i].split("-");


            laPieza = new Ficha(Integer.parseInt(pieza[0]), Integer.parseInt(pieza[1]),Integer.parseInt(pieza[2]),pieza[3],pieza[4],pieza[5],pieza[6],pieza[7],Integer.parseInt(pieza[8]));
//            Datos.getListaDePiezasJugador().AgregarElemento(laPieza);

            i++;
        }

        }
        }
