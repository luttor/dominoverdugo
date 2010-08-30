/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package servidor.dato;

import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;

/**
 *
 * @author ricardocasanova
 */
public class ArchivoFicha
{
    private static String nombreArchivoPiezas = "src/ListaFichaInicial.xml";

    public static ListaFicha cargarArchivoPiezas(ListaFicha laLista)
    {
        try
        {
            SAXBuilder builder = new SAXBuilder();

            /* Se crea un documento nuevo con el nombre del archivo */
            Document doc = builder.build(nombreArchivoPiezas);

            /* Se obtiene la raíz del archivo (la etiqueta inicial) */
            Element raiz = doc.getRootElement();

            List listaPiezas = raiz.getChildren("ficha");

            /* Se genera un iterador para recorrer el List que se generó */
            Iterator i = listaPiezas.iterator();

            /* Se recorre el List */
            while (i.hasNext())
            {
                /* Se obtiene cada uno y se asigna a un objeto de tipo Element */
                Element e = (Element) i.next();

             

                Element ID = e.getChild("ID");
                Element valSup = e.getChild("X");
                Element valInf = e.getChild("Y");
                Element imagenA = e.getChild("imagenA");
                Element imagenB = e.getChild("imagenB");
                Element imagenI = e.getChild("imagenI");
                Element imagenD = e.getChild("imagenD");

               Ficha laFicha = new Ficha(Integer.parseInt(ID.getText()),Integer.parseInt(valSup.getText()),Integer.parseInt(valInf.getText()),imagenA.getText(), imagenB.getText(),imagenI.getText(), imagenD.getText());
                
                laLista.AgregarElemento(laFicha);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return laLista;
    }

    public static void guardarArchivoPiezas(ListaFicha laLista)
    {
        Ficha nodoAuxiliar;

        /* Se crea una raiz de la estructura */
        Element root = new Element("piezas");

        /* Es posible agregar atributos a la estructura inicial */
        root.setAttribute("tipo","lista de piezas");

        Iterator iterador = laLista.getIterator();

        while (iterador.hasNext())
        {
            /* Se crea la etiqueta "usuario" */
            Element pieza = new Element("pieza");

            nodoAuxiliar = (Ficha) iterador.next();

            /* Se crean las etiquetas nombre, apellido y cargo */
            Element ID = new Element("ID");
            Element valSup = new Element("valSup");
            Element valInf = new Element("valInf");
            Element imagenA = new Element("imagenA");
            Element imagenB = new Element("imagenB");
            Element imagenI = new Element("imagenI");
            Element imagenD = new Element("imagenD");

            /* Se inicializa cada etiqueta con sus valores de la lista */
            ID.setText(Integer.toString(nodoAuxiliar.getID()));
//            valSup.setText(Integer.toString(nodoAuxiliar.getValorSup()));
//            valInf.setText(Integer.toString(nodoAuxiliar.getValorInf()));
            imagenA.setText(nodoAuxiliar.getImagenAsociadaA());
            imagenB.setText(nodoAuxiliar.getImagenAsociadaB());
            imagenI.setText(nodoAuxiliar.getImagenAsociadaI());
            imagenD.setText(nodoAuxiliar.getImagenAsociadaD());

            pieza.addContent(ID);
            pieza.addContent(valSup);
            pieza.addContent(valInf);
            pieza.addContent(imagenA);
            pieza.addContent(imagenB);
            pieza.addContent(imagenI);
            pieza.addContent(imagenD);

            root.addContent(pieza);
        }

        /* Se crea un documento nuevo */
        Document doc = new Document(root);

        try
        {
            /* Se genera un flujo de salida de datos XML */
            XMLOutputter out = new XMLOutputter();

            /* Se asocia el flujo de salida con el archivo donde se guardaran los datos */
            FileOutputStream file = new FileOutputStream(nombreArchivoPiezas);

            /* Se manda el documento generado hacia el archivo XML */
            out.output(doc,file);

            /* Se limpia el buffer ocupado por el objeto file y se manda a cerrar el archivo */
            file.flush();
            file.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
