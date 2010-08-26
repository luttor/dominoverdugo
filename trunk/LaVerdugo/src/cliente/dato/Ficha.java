/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente.dato;
import servidor.dato.*;
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
 private String imagenA;
 private String imagenB;
 private String imagenI;
 private String imagenD;
 private String imagenActual;
 private int    idImagenSeleccionada;

 public Ficha (){
     this.ID = 0;
     this.x=0;
     this.y=0;
     this.imagenA = "";
     this.imagenB = "";
     this.imagenI = "";
     this.imagenD = "";
     this.imagenActual = "";
     this.idImagenSeleccionada = 0;
 }


   public Ficha(int ID, int x, int y){
     this.ID = ID;
     this.x=x;
     this.y=y;

  }

    public Ficha(int ID, int x, int y, String imagenA, String imagenB, String imagenI, String imagenD, String imagenActual, int idImagenSeleccionada) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.imagenA = imagenA;
        this.imagenB = imagenB;
        this.imagenI = imagenI;
        this.imagenD = imagenD;
        this.imagenActual = imagenActual;
        this.idImagenSeleccionada = this.idImagenSeleccionada;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdImagenSeleccionada() {
        return idImagenSeleccionada;
    }

    public void setIdImagenSeleccionada(int idImagenSeleccionada) {
        this.idImagenSeleccionada = idImagenSeleccionada;
    }

    public String getImagenA() {
        return imagenA;
    }

    public void setImagenA(String imagenA) {
        this.imagenA = imagenA;
    }

    public String getImagenActual() {
        return imagenActual;
    }

    public void setImagenActual(String imagenActual) {
        this.imagenActual = imagenActual;
    }

    public String getImagenB() {
        return imagenB;
    }

    public void setImagenB(String imagenB) {
        this.imagenB = imagenB;
    }

    public String getImagenD() {
        return imagenD;
    }

    public void setImagenD(String imagenD) {
        this.imagenD = imagenD;
    }

    public String getImagenI() {
        return imagenI;
    }

    public void setImagenI(String imagenI) {
        this.imagenI = imagenI;
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

 

   public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Ficha other = (Ficha) obj;
        if (this.ID != other.ID)
        {
            return false;
        }
        return true;
    }

  
    public int hashCode()
    {
        int hash = 5;
        hash = 59 * hash + this.ID;
        return hash;
    }
    
     public void rotarposicion(boolean rotarDerecha)
    {
        if (rotarDerecha)
        {
            idImagenSeleccionada++;

            if (idImagenSeleccionada == 4)
                idImagenSeleccionada = 0;
        }
        else
        {
            idImagenSeleccionada--;

            if (idImagenSeleccionada == -1)
                idImagenSeleccionada = 3;
        }

        switch (idImagenSeleccionada)
        {
            case 0:
                imagenActual = this.imagenActual;
            break;

            case 1:
                imagenActual = this.imagenD;
            break;

            case 2:
                imagenActual = this.imagenB;
            break;

            case 3:
                imagenActual = this.imagenI;
            break;

            default:
                imagenActual = this.imagenA;
        }
    }
    
    
    
    
    
}

//System.out.println(" " + Aux);




