/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente.dato;

/**
 *
 * @author Javy
 */
import servidor.dato.*;
import java.util.*;



public class ListaUsuario
{
    private SortedSet <Usuario> UsuariosRegistrados;

    private Comparator ComparadorNick;

    public ListaUsuario()
    {
        /*
         * Se inicializa el comparador con el constructor de la clase
         * CompararApellido y se inicializa el TreeSet con este comparador,
         * para poder establecer el criterio de ordenamiento de la colección
         */
        ComparadorNick = new CompararNick();

        UsuariosRegistrados = new TreeSet(ComparadorNick);
    }

   public Iterator getIterator()
    {
        return UsuariosRegistrados.iterator();
    }
    /**
     *
     * Método public void imprimirColeccion(): Este método imprime el
     * contenido de la colección miSet
     */
       public boolean BuscarUsuario(Usuario objeto)
    {
        boolean encontrado = false;
        Usuario auxiliar = null;

        /*
         * Se define un iterador inicializado con el iterador de la colección
         */
        Iterator iterador = UsuariosRegistrados.iterator();

        /*
         * Mientras no se encuentre el elemento y existan mas elementos en la
         * colección, se sigue entrando en el ciclo
         */
        while (!encontrado && iterador.hasNext())
        {
            /*
             *  Se obtiene el siguiente objeto del iterador y se le hace un cast
             *  para asignarlo al objeto de tipo Nodo
             */
            auxiliar = (Usuario) iterador.next();

            /*
             * Se invoca al método equals de la clase Nodo para determinar si son
             * iguales. En caso de serlo, se encontró el elemento buscado
             */
            //if (objeto.equals(auxiliar))
            if ((objeto.getNickname().contentEquals(auxiliar.getNickname()))&&(objeto.getClave().contentEquals(auxiliar.getClave())))
                return true;

        }
        return false;
    }
       public Usuario BuscarUsuarioDevolver(Usuario objeto)
    {
        boolean encontrado = false;
        Usuario auxiliar = null;

        /*
         * Se define un iterador inicializado con el iterador de la colección
         */
        Iterator iterador = UsuariosRegistrados.iterator();

        /*
         * Mientras no se encuentre el elemento y existan mas elementos en la
         * colección, se sigue entrando en el ciclo
         */
        while (!encontrado && iterador.hasNext())
        {
            /*
             *  Se obtiene el siguiente objeto del iterador y se le hace un cast
             *  para asignarlo al objeto de tipo Nodo
             */
            auxiliar = (Usuario) iterador.next();

            /*
             * Se invoca al método equals de la clase Nodo para determinar si son
             * iguales. En caso de serlo, se encontró el elemento buscado
             */
            //if (objeto.equals(auxiliar))
            if ((objeto.getNickname().contentEquals(auxiliar.getNickname()))&&(objeto.getClave().contentEquals(auxiliar.getClave())))
                return (auxiliar);

        }
        return(objeto);
    }
    public void ImprimirColeccion()
    {
        int i;
        Usuario registro;

        /*
         * Se define un arreglo de tipo Object (la clase genérica Java)
         */
        Object [] arreglo;

        /*
         * Se convierte la colección pasada como parámetro a un array, que
         * es asignado al arreglo de tipo Object
         */
        arreglo = UsuariosRegistrados.toArray();

        System.out.println("DATOS");

        /*
         * Se hace un recorrido del arreglo de tipo Object y se imprime
         * la información de la casilla i
         */
        for(i=0 ; i<arreglo.length ; i++)
        {
            registro = (Usuario) arreglo[i];
            System.out.println("Nick: " + registro.getNickname());
            System.out.println("Clave: " + registro.getClave());
            System.out.println("Nombre" + registro.getNombre());
            System.out.println();
        }

        System.out.println("\n\n");
    }


    /**
     *
     * Método public boolean agregarElemento(Nodo objeto): Este método agrega
     * el Nodo "objeto" a la colección miSet
     */
    public boolean AgregarElemento(Usuario objeto)
    {
        return UsuariosRegistrados.add(objeto);
    }


    /**
     *
     * Método public boolean removerElemento(Nodo objeto): Este método elimina
     * el Nodo "objeto" de la colección miSet
     */
    public boolean RemoverElemento(Usuario objeto)
    {
        boolean encontrado = false;
        Usuario auxiliar = null;

        /*
         * Se define un iterador inicializado con el iterador de la colección
         */
        Iterator iterador = UsuariosRegistrados.iterator();

        /*
         * Mientras no se encuentre el elemento y existan mas elementos en la
         * colección, se sigue entrando en el ciclo
         */
        while (!encontrado && iterador.hasNext())
        {
            /*
             *  Se obtiene el siguiente objeto del iterador y se le hace un cast
             *  para asignarlo al objeto de tipo Nodo
             */
            auxiliar = (Usuario) iterador.next();

            /*
             * Se invoca al método equals de la clase Nodo para determinar si son
             * iguales. En caso de serlo, se encontró el elemento buscado
             */
            //if (objeto.equals(auxiliar))
            if (objeto.getNickname().contentEquals(auxiliar.getNickname()))
                encontrado = true;
        }

        /*
         * Si se encontró el elemento, se procede a ejecutar el remove
         */
        if (encontrado)
        {
            if (UsuariosRegistrados.remove(auxiliar))
                return true;
        }

        return false;
    }

}
