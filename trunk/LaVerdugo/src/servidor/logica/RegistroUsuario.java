/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor.logica;

import servidor.dato.Usuario;
import servidor.dato.ListaUsuario;
import servidor.dato.*;
import javax.swing.JTextField;
/**
 *
 * @author Javy
 */
public class RegistroUsuario {

    private static ListaUsuario ListaUsuariosRegistrados;
    private Usuario NuevoUsuario=null;

      public static boolean inicializarEstructuras(){
        ListaUsuariosRegistrados = new ListaUsuario();


//        ListaUsuariosRegistrados.agregarElemento(new Usuario("Ricardonick", "Casanova", "Profesor"));
//        ListaUsuariosRegistrados.agregarElemento(new Usuario("Glorianick", "Tarrio", "Coordinadora"));
//        ListaUsuariosRegistrados.agregarElemento(new Usuario("Susananick", "Garcia", "Directora"));
//        ListaUsuariosRegistrados.agregarElemento(new Usuario("Evelenirnick", "Barreto", "Profesora"));
//        ListaUsuariosRegistrados.agregarElemento(new Usuario("Evelenirnick", "Barreto", "Profesora"));
//        ListaUsuariosRegistrados.imprimirColeccion();
//        ListaUsuariosRegistrados.removerElemento(new Usuario("Ricardonick", "Casanova", "Profesor"));

        ListaUsuariosRegistrados.ImprimirColeccion();
        return(true);
    }


      public static void AgregarUsuario(JTextField nickname, JTextField clave, JTextField nombre, JTextField apellido,String avatar){
    
      }
          
            //NuevoUsuario=new Usuario(nickname.getText(),clave.getText(),nombre.getText(),apellido.getText(),avatar);
             //ListaUsuariosRegistrados.AgregarElemento(NuevoUsuario);
      }

 
