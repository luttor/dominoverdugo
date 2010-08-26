package servidor.dato;

/**
 *
 * @author Javy
 */
import java.util.*;



public class ListaFicha
{
    private List <Ficha> ListadeFichas;
    int ID=0;

    public List<Ficha> getListadeFichas() {
        return ListadeFichas;
    }

    public void setListadeFichas(List<Ficha> ListadeFichas) {
        this.ListadeFichas = ListadeFichas;
    }


    public ListaFicha()
    {
        /*
         * Se inicializa el comparador con el constructor de la clase
         * CompararApellido y se inicializa el TreeSet con este comparador,
         * para poder establecer el criterio de ordenamiento de la colección
         */
        ListadeFichas = new ArrayList();

    }


   
   
   public void Barajear(){
       Collections.shuffle(ListadeFichas);
   }

   public Iterator getIterator()
    {
        return ListadeFichas.iterator();
    }
    /**
     *
     * Método public void imprimirColeccion(): Este método imprime el
     * contenido de la colección miSet
     */
    public void ImprimirColeccion()
    {
        int i;
        Ficha registro;

        /*
         * Se define un arreglo de tipo Object (la clase genérica Java)
         */
        Object [] arreglo;

        /*
         * Se convierte la colección pasada como parámetro a un array, que
         * es asignado al arreglo de tipo Object
         */
        arreglo = ListadeFichas.toArray();

        System.out.println("Fichas");

        /*
         * Se hace un recorrido del arreglo de tipo Object y se imprime
         * la información de la casilla i
         */
        for(i=0 ; i<arreglo.length ; i++)
        {
            registro = (Ficha) arreglo[i];
            System.out.println(registro.getID()+": "+registro.getX()+"/"+registro.getY());

        }

        System.out.println("\n\n");
    }
        public void DevolverListadeFichas()
    {
        int i;
        Ficha registro;
        String Fichas="",x="",y="",ID="";


        /*
         * Se define un arreglo de tipo Object (la clase genérica Java)
         */
        Object [] arreglo;

        /*
         * Se convierte la colección pasada como parámetro a un array, que
         * es asignado al arreglo de tipo Object
         */
        arreglo = ListadeFichas.toArray();


        /*
         * Se hace un recorrido del arreglo de tipo Object y se imprime
         * la información de la casilla i
         */

        for(i=0 ; i<arreglo.length ; i++)
        {
            registro = (Ficha) arreglo[i];
            ID=Integer.toString(registro.getID());
            x=Integer.toString(registro.getX());
            y=Integer.toString(registro.getY());
            Fichas=Fichas+ID+"-"+x+"-"+y+":";

//                           System.out.println("entro a devolver fichas");
        }
       System.out.println(Fichas);

        System.out.println("\n\n");
    }


    /**
     *
     * Método public boolean agregarElemento(Nodo objeto): Este método agrega
     * el Nodo "objeto" a la colección miSet
     */
    public boolean AgregarElemento(Ficha objeto)
    {
        return ListadeFichas.add(objeto);
    }


    /**
     *
     * Método public boolean removerElemento(Nodo objeto): Este método elimina
     * el Nodo "objeto" de la colección miSet
     */

}


