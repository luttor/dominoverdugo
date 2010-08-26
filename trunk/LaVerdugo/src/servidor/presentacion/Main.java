/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor.presentacion;
import ve.edu.ucab.server.logica.Servidor;
/**
 *
 * @author Javy
 */
public class Main {


    public static void main(String [] args)
    {
        String[] parametros = {"7687", "logica.GestionPartida"};

//        Comunicacion.inicializarEstructuras();
//        Comunicacion.cargarDatos();

        Servidor.main(parametros);

    }
}





