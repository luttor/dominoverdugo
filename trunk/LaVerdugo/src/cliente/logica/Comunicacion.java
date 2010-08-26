/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente.logica;
import ve.edu.ucab.cliente.ClienteSocket;

public class Comunicacion {
    static String IP="localhost";



    public static boolean LogearUsuario(String Nick, String Clave){
         ClienteSocket cli = new ClienteSocket();
         String get= cli.ejecutarPeticion("1:"+ Nick+ ":"+ Clave, IP, 7687);
         // Devuelve "nombre:apellido:10/10/10:1" o "false"
         if(get.compareTo("false")==0){
             System.out.println("No pude loggear usuario deberia devolver false: "+get);
             return(false);
         }
         else
            System.out.println("loggie usuario deberia devolver cadena: "+get);
            return(true);
 }
      public static boolean CrearPartida(String Nick, String fechainicio){
         ClienteSocket cli = new ClienteSocket();
         String get= cli.ejecutarPeticion("2:"+ Nick+ ":"+ fechainicio, IP, 7687);
         if(get.compareTo("false")==0)
            return(false);
         else
             return(true);
    
    }
     //registrar usuario

    public static boolean RegistrarUsuario(String Nick, String Clave, String nombre,String apellido,String fechadenac, String IDAvatar ){
         ClienteSocket cli = new ClienteSocket();
         String get= cli.ejecutarPeticion("3:"+ Nick+ ":"+ Clave+ ":"+ nombre+ ":" +apellido+ ":"+fechadenac+":" +IDAvatar, IP, 7687);
          // Devuelve "true"; o "false"
         if(get.compareTo("false")==0){
             return (false);
         }
         else{
             return (true);
         }

    }

     public static boolean GuardaPartida(String Nick){
         ClienteSocket cli = new ClienteSocket();
         String get= cli.ejecutarPeticion("4:"+ Nick, IP, 7687);
         if(get.compareTo("false")==0)
             return(false);
         else
             return(true);
       }

    public static String EnviarJugada(String Nick, String idPartida, String jugadaservidor){
         ClienteSocket cli = new ClienteSocket();
         String get= cli.ejecutarPeticion("5:"+ Nick+ ":"+ idPartida+ ":"+jugadaservidor , IP, 7687);

    return get;
    }

   public static String FinPartida(){
         ClienteSocket cli = new ClienteSocket();
         String get= cli.ejecutarPeticion("8:", IP, 7687);

    return get;
    }
}


