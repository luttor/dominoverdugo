 /* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor.logica;
import ve.edu.ucab.server.logica.LogicaServidor;

public class MenuJugador implements LogicaServidor {

public String realizarOperacion(String arg) {
String[] subArg = arg.split(":");
int Opcion=0;
Opcion=(Integer.parseInt(subArg[0]));
String resultado;

    if (Opcion==1){
        System.out.print("estoy en 1");
      
     resultado=(Comunicacion.SolicitarLogearUsuario(subArg[1], subArg[2]));

           return(resultado);
           }

    if (Opcion==2){

        System.out.println("Entre en la opcion 2");
        Comunicacion.SolicitarIniciarPartidaNueva(subArg[1], subArg[2]);
        Comunicacion.SolicitarListaFichas();
        return(resultado="true");
        }
    if (Opcion==3){

         if(Comunicacion.SolicitarRegistrarUsuario(subArg[1],subArg[2],subArg[3],subArg[4],subArg[5],subArg[6])){
            resultado = "true";
            return(resultado);
         }
        return (resultado="false");
    }
    if (Opcion==4){

        Comunicacion.SolicitarGuardarArchivoPartida(subArg[1]);

        return (resultado="true");
        }
    if (Opcion==5){

        resultado = "TRUE5";
        System.out.println("Entre en la opcion 5");
        return resultado;
        }
    if (Opcion==6){

        resultado = "TRUE";
        System.out.println("Entre en la opcion 6");
        return resultado;
        }
    if (Opcion==7){

        resultado = "TRUE";
        System.out.println("Entre en la opcion 7");
        return resultado;
    }
    if (Opcion==8){
       
        Comunicacion.SolicitarGuardarArchivoUsuario();
        resultado = "Hasta Luego";
        return resultado;
    }
    return("Opcion Invalida");

}
}

