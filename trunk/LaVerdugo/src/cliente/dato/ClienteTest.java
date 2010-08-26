/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente.dato;
import ve.edu.ucab.cliente.ClienteSocket;
/**
 *
 * @author Javy
 */
import cliente.logica.Comunicacion;
public class ClienteTest {

public static void main(String[] args) {
boolean resultado;

ClienteSocket cliente = new ClienteSocket();

resultado=Comunicacion.RegistrarUsuario( "javiccs", "clave", "nombre", "apellido","10/10/10","1");

//resultado=Comunicacion.RegistrarUsuario( "javiccs", "123", "javier", "perze","12/10/10","2");
//System.out.println(resultado);
resultado = Comunicacion.LogearUsuario("javiccs", "clave");
//System.out.println(resultado);
resultado = Comunicacion.CrearPartida("javiccs", "13/10/10");

//System.out.println(resultado);
resultado= Comunicacion.GuardaPartida("javiccs");
resultado = Comunicacion.CrearPartida("mine", "14/10/10");
resultado= Comunicacion.GuardaPartida("mine");
//System.out.println(resultado);
//resultado=Comunicacion.FinPartida();


System.out.println(resultado);
}
}



