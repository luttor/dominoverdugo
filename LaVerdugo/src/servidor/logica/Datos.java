/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.logica;;

import servidor.dato.ListaUsuario;
import servidor.dato.ListaPartida;
import servidor.dato.ArchivoXml;
import servidor.dato.Usuario;
import servidor.dato.Partida;
import servidor.dato.ListaFicha;

import java.util.*;

//     public static boolean CargarPartida (String nickname,String ID)
//   {
//       //String ID=String.valueOf(Datos.)
//       Partida laPartida = new Partida (nickname,ID);
//       if( Datos.getListadoDePartidas().BuscarElemento(laPartida)){
//           //llamo al xml de las fichas para cargar
//           // llamo al xml de la partida
//        return(Datos.getListadoDePartidas().BuscarElemento(laPartida));
//       }
//       return(false);
//   }
//          public static boolean GuardarPartida (String nickname,String ID)
//   {
//       //String ID=String.valueOf(Datos.)
//       Partida laPartida = new Partida (nickname,ID);
//       if( Datos.getListadoDePartidas().BuscarElemento(laPartida)){
//           //llamo al xml de las fichas para cargar
//           // llamo al xml de la partida
//        return(Datos.getListadoDePartidas().BuscarElemento(laPartida));
//       }
//       return(false);
//   }
// Procedimientos de Fichas
/**
 *
 * @author Javy
 */
public class Datos {

    private static ListaUsuario listadoDeUsuario = null;
    private static ListaPartida listadoDePartidas = null;
    private static ListaFicha listadeFichasPote = null;
    private static ListaFicha listadeFichasUsuario = null;
    private static ListaFicha listadeFichasServidor = null;
    

    private Datos() {
    }
// Inicializo mis listas

    public static void generarInstancia() {
        if (listadoDeUsuario == null) {
            listadoDeUsuario = new ListaUsuario();
        }
        if (listadoDePartidas == null) {
            listadoDePartidas = new ListaPartida();
        }
        ArchivoXml.leerArchivoXML(listadoDeUsuario);
        
        
        }

    // <Procedimientos de Get>
    public static ListaUsuario getListadoDeUsuario() {
        return listadoDeUsuario;
    }

    public static ListaFicha getListadeFichasPote() {
        return listadeFichasPote;
    }

    public static ListaFicha getListadeFichasServidor() {
        return listadeFichasServidor;
    }

    public static ListaFicha getListadeFichasUsuario() {
        return listadeFichasUsuario;
    }



     public static ListaPartida getListadoDePartidas() {
        return listadoDePartidas;
    }

// </Procedimientos de Get>

// <Procedimientos de Imprimir>
    public static void ImprimirListaUsuario() {
        listadoDeUsuario.ImprimirColeccion();
    }

    public static void ImprimirListaPartidas() {
        listadoDePartidas.ImprimirColeccion();
    }

    public static void ImprimirListaFichas(){
//        System.out.println("Fichas Pote");
//        listadeFichasPote.ImprimirColeccion();
//        System.out.println("Fichas Servidor");
//        listadeFichasServidor.ImprimirColeccion();
        System.out.println("Fichas Usuario");
        listadeFichasUsuario.ImprimirColeccion();
        listadeFichasUsuario.DevolverListadeFichas();
    }

    // </Procedimientos de Imprimir>

    // <Usuario>
   public static boolean RegistrarUsuario(String nickname, String clave, String nombre, String apellido,String fechanaci,String avatar)
   {
       Usuario elUsuario = new Usuario(nickname,clave,nombre,apellido,fechanaci,avatar);
       if(listadoDeUsuario.AgregarElemento(elUsuario)){
           ArchivoXml.guardarArchivoXML(listadoDeUsuario);
           ArchivoXml.leerArchivoXML(listadoDeUsuario);
            return(true);
       }
       return(false);

    }

    public static String LogearUsuario(String nickname, String clave)
    {
        ArchivoXml.leerArchivoXML(listadoDePartidas);
   Usuario elUsuario = new Usuario(nickname,clave);
   return(BuscarUsuario(nickname,clave));

    }
    public static String BuscarUsuario(String nickname, String clave)
    {
      Usuario elUsuario = new Usuario(nickname,clave);
      Usuario UsuarioEncontrado = new Usuario();
      if(listadoDeUsuario.BuscarUsuario(elUsuario)){
        UsuarioEncontrado=listadoDeUsuario.BuscarUsuarioDevolver(elUsuario);
       String Devolver=(UsuarioEncontrado.getNombre()+":"+UsuarioEncontrado.getApellido()+":"+UsuarioEncontrado.getFechanaci()+":"+UsuarioEncontrado.getAvatar());
        return(Devolver);
      }
      else
          return("false");
    }
   // </Usuario>

    // <Procedimientos de Partidas>

       public static void CrearFichas(ListaFicha listadeFichas){
            ArchivoXml.leerArchivoXML(listadeFichas);

        }
    public static boolean IniciarPartidaNueva(String nickname, String fechainicio) {
        listadeFichasPote = new ListaFicha();
        CrearFichas(listadeFichasPote);
        listadeFichasPote.Barajear();
        listadeFichasUsuario = new ListaFicha();
        listadeFichasServidor = new ListaFicha();
        for (int j = 0; j < 7; j++) {
            listadeFichasUsuario.AgregarElemento(listadeFichasPote.getListadeFichas().get(j));
            listadeFichasPote.getListadeFichas().remove(j);
        }
        for (int j = 0; j < 7; j++) {
            listadeFichasServidor.AgregarElemento(listadeFichasPote.getListadeFichas().get(j));
            listadeFichasPote.getListadeFichas().remove(j);
        }
       // Partida laPartida = new Partida(nickname,fechainicio, listadeFichasServidor, listadeFichasUsuario, listadeFichasPote);
        //listadoDePartidas.AgregarElemento(laPartida);

        return (true);

    }

    // </Procedimientos de Partidas>

      // <Procedimientos de Guardado>
    public static void GuardarArchivoUsuario()
   {
       ArchivoXml.guardarArchivoXML(listadoDeUsuario);
   }
   public static void GuardarArchivoPartida(String nickname)
   {
       Partida Busqueda= new Partida(nickname);

       Busqueda=listadoDePartidas.BuscarPartidaDevolver(Busqueda);
       if (Busqueda==null){
           Partida NuevaPartida= new Partida(nickname,"Poner Fecha Actual","Fecha Inicio",listadeFichasServidor,listadeFichasUsuario,listadeFichasPote);
           listadoDePartidas.AgregarElemento(NuevaPartida);
       }
       else{
           Partida NuevaPartida= new Partida(Busqueda.getNickname(),"Poner Fecha Actual",Busqueda.getFechainicio(),listadeFichasServidor,listadeFichasUsuario,listadeFichasPote);
           listadoDePartidas.RemoverElemento(Busqueda);
           listadoDePartidas.AgregarElemento(NuevaPartida);
                              
            }
            System.out.println("voy a imprimir Listado de pote: ");
           listadeFichasPote.ImprimirColeccion();
              ArchivoXml.guardarArchivoXML(listadoDePartidas);// para las partidas
           ArchivoXml.guardarArchivoXML(listadoDePartidas, true);//para las fichas
       
   }

// </Procedimientos de Guardado>

   //<Procedimientos de Carga>
    public static void CargaArchivoUsuario()
   {
        ArchivoXml.leerArchivoXML(listadoDeUsuario);
    }

}







