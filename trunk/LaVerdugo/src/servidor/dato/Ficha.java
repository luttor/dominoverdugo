/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor.dato;
import java.util.*;
import java.util.Vector;
import java.util.Collections;
/**
 *
 * @author Minerva Verdugo Ruiz
 */
public class Ficha {
 private int ID;
 private int x; //parte inferior
 private int y;//  parte superior
 private String imagenAsociadaA;
 private String imagenAsociadaB;
 private String imagenAsociadaI;
 private String imagenAsociadaD;
 private String imagenAsociadaActual;
 private int    indiceImagenSeleccionada;

 public Ficha (){
     this.x=0;
     this.y=0;
 }

    public Ficha(int ID, int x, int y, String imagenAsociadaA, String imagenAsociadaB, String imagenAsociadaI, String imagenAsociadaD, int indiceImagenSeleccionada) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.imagenAsociadaA = imagenAsociadaA;
        this.imagenAsociadaB = imagenAsociadaB;
        this.imagenAsociadaI = imagenAsociadaI;
        this.imagenAsociadaD = imagenAsociadaD;
        indiceImagenSeleccionada = 0;
        imagenAsociadaActual = this.imagenAsociadaA;
    }
    
    // para la carga de fichas iniciales
       public Ficha(int ID, int x, int y, String imagenAsociadaA, String imagenAsociadaB, String imagenAsociadaI, String imagenAsociadaD) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.imagenAsociadaA = imagenAsociadaA;
        this.imagenAsociadaB = imagenAsociadaB;
        this.imagenAsociadaI = imagenAsociadaI;
        this.imagenAsociadaD = imagenAsociadaD;
    }

    public String getImagenAsociadaA() {
        return imagenAsociadaA;
    }

    public String getImagenAsociadaActual() {
        return imagenAsociadaActual;
    }

    public String getImagenAsociadaB() {
        return imagenAsociadaB;
    }

    public String getImagenAsociadaD() {
        return imagenAsociadaD;
    }

    public String getImagenAsociadaI() {
        return imagenAsociadaI;
    }

    public int getIndiceImagenSeleccionada() {
        return indiceImagenSeleccionada;
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getID() {
        return ID;
    }



//System.out.println(" " + Aux);

}



