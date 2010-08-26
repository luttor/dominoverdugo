/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor.dato;
import java.util.*;
/**
 *
 * @author Minerva Verdugo Ruiz
 */
public class ListaPartida
{
    private SortedSet <Partida> PartidasJugadas;

    private Comparator CompararPartida;

    public ListaPartida()
    {
        /*
         * Se inicializa el comparador con el constructor de la clase
         * CompararApellido y se inicializa el TreeSet con este comparador,
         * para poder establecer el criterio de ordenamiento de la colección
         */
        CompararPartida = new CompararPartida();

        PartidasJugadas = new TreeSet(CompararPartida);
    }

   public Iterator getIterator()
    {
        return PartidasJugadas.iterator();
    }

    public void setPartidasJugadas(SortedSet<Partida> PartidasJugadas) {
        this.PartidasJugadas = PartidasJugadas;
    }
    /**
     *
     * Método public void imprimirColeccion(): Este método imprime el
     * contenido de la colección miSet
     */
   
    public void ImprimirColeccion()
    {
        int i;
        Partida registro;

        /*
         * Se define un arreglo de tipo Object (la clase genérica Java)
         */
        Object [] arreglo;

        /*
         * Se convierte la colección pasada como parámetro a un array, que
         * es asignado al arreglo de tipo Object
         */
        arreglo = PartidasJugadas.toArray();

        System.out.println("DATOS");

        /*
         * Se hace un recorrido del arreglo de tipo Object y se imprime
         * la información de la casilla i
         */
        for(i=0 ; i<arreglo.length ; i++)
        {
            registro = (Partida) arreglo[i];
            System.out.println("Nick: " + registro.getNickname());
            System.out.println("fecha : " + registro.getFechaactual());
            System.out.println();
        }

        System.out.println("\n\n");
    }


    /**
     *
     * Método public boolean agregarElemento(Nodo objeto): Este método agrega
     * el Nodo "objeto" a la colección miSet
     */
    public boolean AgregarElemento(Partida objeto)
    {
        return PartidasJugadas.add(objeto);
    }


    /**
     *
     * Método public boolean removerElemento(Nodo objeto): Este método elimina
     * el Nodo "objeto" de la colección miSet
     */
    public Partida BuscarPartidaDevolver(Partida objeto)
    {
        boolean encontrado = false;
        Partida auxiliar = null;

        /*
         * Se define un iterador inicializado con el iterador de la colección
         */
        Iterator iterador = PartidasJugadas.iterator();

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
            auxiliar = (Partida) iterador.next();

            /*
             * Se invoca al método equals de la clase Nodo para determinar si son
             * iguales. En caso de serlo, se encontró el elemento buscado
             */
            //if (objeto.equals(auxiliar))
            if((objeto.getNickname().contentEquals(auxiliar.getNickname())))
                return (auxiliar);

        }
        return(null);
    }
     public boolean RemoverElemento(Partida objeto)
    {
        boolean encontrado = false;
        Partida auxiliar = null;

        /*
         * Se define un iterador inicializado con el iterador de la colección
         */
        Iterator iterador = PartidasJugadas.iterator();

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
            auxiliar = (Partida) iterador.next();

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
            if (PartidasJugadas.remove(auxiliar))
                return true;
        }

        return false;
    }
   
}
