/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor.logica;





/**
 *
 * @author Javy
 */
public class Comunicacion

{
    public static void generarInstancia() {
        Datos.generarInstancia();
    }


// <Procedimientos de Imprimir>
    public static void SolicitarListaUsuario() {
        Datos.ImprimirListaUsuario();
    }

    public static void SolicitarListaPartidas() {
        Datos.ImprimirListaPartidas();
    }

    public static void SolicitarListaFichas(){
        Datos.ImprimirListaFichas();
    }

    // </Procedimientos de Imprimir>

    // <Usuario>
    public static boolean SolicitarRegistrarUsuario(String nickname, String clave, String nombre, String apellido,String fechanaci,String avatar)
   {
      generarInstancia();
      return(Datos.RegistrarUsuario(nickname, clave, nombre, apellido, fechanaci, avatar));
    }

    public static String SolicitarLogearUsuario(String nickname, String clave)
    {
        generarInstancia();
        return(Datos.LogearUsuario(nickname, clave));
        //
    }
        public static String DatosLogearUsuario(String nickname, String clave)
    {
          return(Datos.BuscarUsuario(nickname, clave));
    }
   // </Usuario>
    // <Procedimientos de Partidas>

    public static boolean SolicitarIniciarPartidaNueva(String nickname, String fechainicio) {
        return (Datos.IniciarPartidaNueva(nickname, fechainicio));
    }

    // </Procedimientos de Partidas>

      // <Procedimientos de Guardado>
    public static void SolicitarGuardarArchivoUsuario()
   {
     Datos.CargaArchivoUsuario();
   }
   public static void SolicitarGuardarArchivoPartida(String nickname)
   {
        Datos.GuardarArchivoPartida(nickname);
   }

// </Procedimientos de Guardados>

   //<Procedimientos de Carga>
      public static void SolicitarCargaUsuarios()
   {
        Datos.CargaArchivoUsuario();
   }
      //</Procedimientos de Guardados>
}