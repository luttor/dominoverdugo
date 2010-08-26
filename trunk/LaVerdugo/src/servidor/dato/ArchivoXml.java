package servidor.dato;

import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;




public class ArchivoXml{

    private static String nombreArchivo = "src/servidor/dato/ListaUsuario.xml";
    private static String nombreArchivoPartida = "src/servidor/dato/ListaPartida.xml";
    private static String nombreArchivoFicha = "src/servidor/dato/ListaFicha.xml";
    private static String nombreArchivoFichaInicial = "src/servidor/dato/ListaFichaInicial.xml";

    /**
     *
     * Método public static void leerArchivoXML(ListaUsuarios listaDeUsuarios): Este método
     * permite leer un archivo XML que contiene los datos de los usuarios a través de jdom
     */
    public static void leerArchivoXML(ListaUsuario listaDeUsuarios)
    {
        try
        {
            SAXBuilder builder = new SAXBuilder();

            /* Se crea un documento nuevo con el nombre del archivo */
            Document doc = builder.build(nombreArchivo);

            /* Se obtiene la raíz del archivo (la etiqueta inicial) */
            Element raiz = doc.getRootElement();

            /* Se puede obtener el atributo de la raíz (de la etiqueta) */
            System.out.println(raiz.getAttributeValue("tipo"));

            /* Se obtienen todos los hijos cuya etiqueta esa "usuario"  */
            /* y se asignan esos hijos a un List                        */
            List listaUsuarios = raiz.getChildren("usuario");

            System.out.println("Formada por:" + listaUsuarios.size() + " usuarios");
            System.out.println("------------------");

            /* Se genera un iterador para recorrer el List que se generó */
            Iterator i = listaUsuarios.iterator();

            /* Se recorre el List */
            while (i.hasNext())
            {
                /* Se obtiene cada uno y se asigna a un objeto de tipo Element */
                Element e = (Element) i.next();

                /* Se obtiene el nombre, apellido y cargo de cada una de las etiquetas  */
                /* hijas de usuario, es decir, nombre, apellido y cargo                 */
                Element nick = e.getChild("nick");
                Element clave = e.getChild("clave");
                Element nombre = e.getChild("nombre");
                Element apellido = e.getChild("apellido");
                Element fechanac = e.getChild("fechanac");
                Element avatar = e.getChild("avatar");


                /* Se crea un nodo nuevo con la información y se agrega a la lista de usuarios */
                Usuario elUsuario = new Usuario(nick.getText(),clave.getText(), nombre.getText(),apellido.getText(),fechanac.getText(),avatar.getText());

                listaDeUsuarios.AgregarElemento(elUsuario);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
  /**
     *
     * Método public static void guardarArchivoXML(ListaUsuarios listaDeUsuarios): Este método
     * permite guardar la lista de usuarios en un archivo XML. El procesamiento se hace con jdom
     */
    public static void guardarArchivoXML(ListaUsuario listaDeUsuarios)
    {
        Usuario nodoAuxiliar;

        /* Se crea una raiz de la estructura */
        Element root = new Element("usuarios");

        /* Es posible agregar atributos a la estructura inicial */
        root.setAttribute("tipo","lista de usuarios");

        Iterator iterador = listaDeUsuarios.getIterator();

        while (iterador.hasNext())
        {
            /* Se crea la etiqueta "usuario" */
            Element usuarios = new Element("usuario");

            nodoAuxiliar = (Usuario) iterador.next();

            /* Se crean las etiquetas nombre, apellido y cargo */
            Element nick = new Element("nick");
            Element clave = new Element("clave");
            Element nombre = new Element("nombre");
            Element apellido = new Element("apellido");
            Element fechanac = new Element("fechanac");
            Element avatar = new Element("avatar");

            /* Se inicializa cada etiqueta con sus valores de la lista */
            nick.setText(nodoAuxiliar.getNickname());
            clave.setText(nodoAuxiliar.getClave());
            nombre.setText(nodoAuxiliar.getNombre());
            apellido.setText(nodoAuxiliar.getApellido());
            fechanac.setText(nodoAuxiliar.getFechanaci());
            avatar.setText(nodoAuxiliar.getAvatar());

            /* Se añaden las etiquetas a la etiqueta principal (usuario)    */
            /* estableciendo que un usuario tiene nombre, apellido y cargo  */
            usuarios.addContent(nick);
            usuarios.addContent(clave);
            usuarios.addContent(nombre);
            usuarios.addContent(apellido);
            usuarios.addContent(fechanac);
            usuarios.addContent(avatar);

            /* Se añade el nuevo usuario a la estructura XML */
            root.addContent(usuarios);
        }

        /* Se crea un documento nuevo */
        Document doc = new Document(root);

        try
        {
            /* Se genera un flujo de salida de datos XML */
            XMLOutputter out = new XMLOutputter();

            /* Se asocia el flujo de salida con el archivo donde se guardaran los datos */
            FileOutputStream file = new FileOutputStream(nombreArchivo);

            /* Se manda el documento generado hacia el archivo XML */
            out.output(doc,file);

            /* Se limpia el buffer ocupado por el objeto file y se manda a cerrar el archivo */
            file.flush();
            file.close();

            /* En este caso se manda a imprimir el archivo por la consola   */
            /* ESTE PROCESO NO ES OBLIGATORIO PARA PROCESAR EL XML          */
            out.output(doc,System.out);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    // Empieza La Carga de la Partida
public static void leerArchivoXML(ListaPartida listaDePartidas)
    {
        try
        {
            SAXBuilder builder = new SAXBuilder();

            /* Se crea un documento nuevo con el nombre del archivo */
            Document doc = builder.build(nombreArchivoPartida);

            /* Se obtiene la raíz del archivo (la etiqueta inicial) */
            Element raiz = doc.getRootElement();

            /* Se puede obtener el atributo de la raíz (de la etiqueta) */
            System.out.println(raiz.getAttributeValue("tipo"));

            /* Se obtienen todos los hijos cuya etiqueta esa "usuario"  */
            /* y se asignan esos hijos a un List                        */
            List listaPartida= raiz.getChildren("partida");

            System.out.println("Formada por:" + listaPartida.size() + " Partidas");
            System.out.println("------------------");

            /* Se genera un iterador para recorrer el List que se generó */
            Iterator i = listaPartida.iterator();

            /* Se recorre el List */
            while (i.hasNext())
            {
                /* Se obtiene cada uno y se asigna a un objeto de tipo Element */
                Element e = (Element) i.next();

                /* Se obtiene el nombre, apellido y cargo de cada una de las etiquetas  */
                /* hijas de usuario, es decir, nombre, apellido y cargo                 */
                Element nick = e.getChild("Usuario");
                Element ID = e.getChild("ID");
                Element fechaactual = e.getChild("fechaactual");
                Element fechainicio = e.getChild("fechainicio");
                 /* Se crea un nodo nuevo con la información y se agrega a la lista de usuarios */
                Partida laPartida = new Partida(nick.getText(),fechainicio.getText(),fechaactual.getText());
                listaDePartidas.AgregarElemento(laPartida);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void guardarArchivoXML(ListaPartida listaDePartidas)
    {
        Partida nodoAuxiliar;

        /* Se crea una raiz de la estructura */
        Element root = new Element("partidas");

        /* Es posible agregar atributos a la estructura inicial */
        root.setAttribute("tipo","lista de partidas");

        Iterator iterador = listaDePartidas.getIterator();

        while (iterador.hasNext())
        {
            /* Se crea la etiqueta "usuario" */
            Element partidas = new Element("partida");

            nodoAuxiliar = (Partida) iterador.next();

            /* Se crean las etiquetas nombre, apellido y cargo */
            Element nick = new Element("nick");
            
            Element fechainicio = new Element("fechainicio");
            Element fechaactual= new Element("fechaactual");
            /* Se inicializa cada etiqueta con sus valores de la lista */
            nick.setText(nodoAuxiliar.getNickname());
            
            fechainicio.setText(nodoAuxiliar.getFechainicio());
            fechaactual.setText(nodoAuxiliar.getFechaactual());

            /* Se añaden las etiquetas a la etiqueta principal (usuario)    */
            /* estableciendo que un usuario tiene nombre, apellido y cargo  */
            partidas.addContent(nick);
            
            partidas.addContent(fechainicio);
            partidas.addContent(fechaactual);

            /* Se añade el nuevo usuario a la estructura XML */
            root.addContent(partidas);
        }

        /* Se crea un documento nuevo */
        Document doc = new Document(root);

        try
        {
            /* Se genera un flujo de salida de datos XML */
            XMLOutputter out = new XMLOutputter();

            /* Se asocia el flujo de salida con el archivo donde se guardaran los datos */
            FileOutputStream file = new FileOutputStream(nombreArchivoPartida);

            /* Se manda el documento generado hacia el archivo XML */
            out.output(doc,file);

            /* Se limpia el buffer ocupado por el objeto file y se manda a cerrar el archivo */
            file.flush();
            file.close();

            /* En este caso se manda a imprimir el archivo por la consola   */
            /* ESTE PROCESO NO ES OBLIGATORIO PARA PROCESAR EL XML          */
            out.output(doc,System.out);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void guardarArchivoXML(ListaPartida listaDePartidas, boolean valor)
    {

        Partida partidaActual;
        Ficha fichaActual;

        /* Se crea una raiz de la estructura */
        Element root = new Element("fichas");

        /* Es posible agregar atributos a la estructura inicial */
        root.setAttribute("tipo","lista de fichas");

        Iterator iteradorPartida = listaDePartidas.getIterator();
        Iterator iteradorFichaUsuario;
        Iterator iteradorFichaPote;
        Iterator iteradorFichaServidor;

        Element nick;
        Element fichaPote;
        Element fichaUsuario;
        Element fichaServidor;
        Element fichaX;
        Element fichaY;
        Element fichaID;
        Element fichaA;
        Element fichaB;
        Element fichaD;
        Element fichaI;

        while (iteradorPartida.hasNext())
        {
            nick = new Element("nick");
            fichaPote = new Element("fichapote");
            fichaUsuario = new Element("fichausuario");
            fichaServidor = new Element("fichaservidor");

            partidaActual = (Partida) iteradorPartida.next();
            System.out.println(partidaActual.getNickname());
           // partidaActual.getFichapote().ImprimirColeccion();

            nick.setText(partidaActual.getNickname());

            iteradorFichaPote = partidaActual.getFichapote().getIterator();

            while (iteradorFichaPote.hasNext())
            {
                fichaID = new Element("ID");
                fichaX = new Element("X");
                fichaY = new Element("Y");
                fichaA = new Element("imagenA");
                fichaB = new Element("imagenB");
                fichaI = new Element("imagenI");
                fichaD= new Element("imagenD");

                fichaActual = (Ficha) iteradorFichaPote.next();
                fichaID.setText(Integer.toString(fichaActual.getID()));
                fichaX.setText(Integer.toString(fichaActual.getX()));
                fichaY.setText(Integer.toString(fichaActual.getY()));
                fichaA.setText(fichaActual.getImagenAsociadaA());
                fichaB.setText(fichaActual.getImagenAsociadaB());
                fichaD.setText(fichaActual.getImagenAsociadaD());
                fichaI.setText(fichaActual.getImagenAsociadaI());
                fichaPote.addContent(fichaID);
                fichaPote.addContent(fichaY);
                fichaPote.addContent(fichaX);
                fichaPote.addContent(fichaA);
                fichaPote.addContent(fichaB);
                fichaPote.addContent(fichaD);
                fichaPote.addContent(fichaI);
            }

            nick.addContent(fichaPote);

            iteradorFichaUsuario = partidaActual.getFichausuario().getIterator();

            while (iteradorFichaUsuario.hasNext())
            {
                fichaID = new Element("ID");
                fichaX = new Element("X");
                fichaY = new Element("Y");
                fichaA = new Element("imagenA");
                fichaB = new Element("imagenB");
                fichaI = new Element("imagenI");
                fichaD= new Element("imagenD");

                fichaActual = (Ficha) iteradorFichaUsuario.next();
                fichaID.setText(Integer.toString(fichaActual.getID()));
                fichaX.setText(Integer.toString(fichaActual.getX()));
                fichaY.setText(Integer.toString(fichaActual.getY()));
                fichaA.setText(fichaActual.getImagenAsociadaA());
                fichaB.setText(fichaActual.getImagenAsociadaB());
                fichaD.setText(fichaActual.getImagenAsociadaD());
                fichaI.setText(fichaActual.getImagenAsociadaI());
                fichaUsuario.addContent(fichaID);
                fichaUsuario.addContent(fichaY);
                fichaUsuario.addContent(fichaX);
                fichaUsuario.addContent(fichaA);
                fichaUsuario.addContent(fichaB);
                fichaUsuario.addContent(fichaD);
                fichaUsuario.addContent(fichaI);
                
            }

            nick.addContent(fichaUsuario);

            iteradorFichaServidor = partidaActual.getFichaservidor().getIterator();

            while (iteradorFichaServidor.hasNext())
            {
                fichaID = new Element("ID");
                fichaX = new Element("X");
                fichaY = new Element("Y");
                fichaA = new Element("imagenA");
                fichaB = new Element("imagenB");
                fichaI = new Element("imagenI");
                fichaD= new Element("imagenD");

                fichaActual = (Ficha) iteradorFichaServidor.next();
                fichaID.setText(Integer.toString(fichaActual.getID()));
                fichaX.setText(Integer.toString(fichaActual.getX()));
                fichaY.setText(Integer.toString(fichaActual.getY()));
                fichaA.setText(fichaActual.getImagenAsociadaA());
                fichaB.setText(fichaActual.getImagenAsociadaB());
                fichaD.setText(fichaActual.getImagenAsociadaD());
                fichaI.setText(fichaActual.getImagenAsociadaI());
                fichaServidor.addContent(fichaID);
                fichaServidor.addContent(fichaY);
                fichaServidor.addContent(fichaX);
                fichaServidor.addContent(fichaA);
                fichaServidor.addContent(fichaB);
                fichaServidor.addContent(fichaD);
                fichaServidor.addContent(fichaI);
                
            }

            nick.addContent(fichaServidor);

            root.addContent(nick);
        }
        
        /* Se crea un documento nuevo */
        Document doc = new Document(root);

        try
        {
            /* Se genera un flujo de salida de datos XML */
            XMLOutputter out = new XMLOutputter();

            /* Se asocia el flujo de salida con el archivo donde se guardaran los datos */
            FileOutputStream file = new FileOutputStream(nombreArchivoFicha);

            /* Se manda el documento generado hacia el archivo XML */
            out.output(doc,file);

            /* Se limpia el buffer ocupado por el objeto file y se manda a cerrar el archivo */
            file.flush();
            file.close();

            /* En este caso se manda a imprimir el archivo por la consola   */
            /* ESTE PROCESO NO ES OBLIGATORIO PARA PROCESAR EL XML          */
            out.output(doc,System.out);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

        public static void leerArchivoXML(ListaFicha ListadeFichas)
    {
        try
        {
            SAXBuilder builder = new SAXBuilder();

            /* Se crea un documento nuevo con el nombre del archivo */
            Document doc = builder.build(nombreArchivoFichaInicial);

            /* Se obtiene la raíz del archivo (la etiqueta inicial) */
            Element raiz = doc.getRootElement();

            List listaFichas = raiz.getChildren("ficha");

            /* Se genera un iterador para recorrer el List que se generó */
            Iterator i = listaFichas.iterator();

            /* Se recorre el List */
            while (i.hasNext())
            {
                /* Se obtiene cada uno y se asigna a un objeto de tipo Element */
                Element e = (Element) i.next();

                /* Se obtiene el nombre, apellido y cargo de cada una de las etiquetas  */
                /* hijas de usuario, es decir, nombre, apellido y cargo                 */

                Element ID = e.getChild("ID");
                Element X = e.getChild("X");
                Element Y = e.getChild("Y");
                Element imagenA = e.getChild("imagenA");
                Element imagenB = e.getChild("imagenB");
                Element imagenI = e.getChild("imagenI");
                Element imagenD = e.getChild("imagenD");

                Ficha laFicha = new Ficha(Integer.parseInt(ID.getText()),Integer.parseInt(X.getText()),Integer.parseInt(Y.getText()),imagenA.getText(), imagenB.getText(),imagenI.getText(), imagenD.getText());
                ListadeFichas.AgregarElemento(laFicha);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
