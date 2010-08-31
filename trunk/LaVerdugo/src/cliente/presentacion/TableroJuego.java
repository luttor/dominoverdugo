/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente.presentacion;


import cliente.dato.ListaUsuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.UIManager.*;
import servidor.dato.ArchivoFicha;
import servidor.dato.ArchivoUsuario;
import servidor.dato.ListaFicha;

/**
 *
 * @author 
 */
public class TableroJuego   {

    /**
     * @param args the command line arguments
     */

    public static int Contador=25;
    public static int X=360;
    public static int Y=170;
    public static int NFicha=0;
    public static Vector <JButton> Fichas= new Vector();
    public static int Posi=0;
    public static JFrame Frame2= new JFrame();
    public static String Posicion="RDLU";
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        // TODO code application logic here


      /* try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            com.birosoft.liquid.LiquidLookAndFeel.setLiquidDecorations(true);
           
            com.birosoft.liquid.LiquidLookAndFeel.setToolbarFlattedButtons(false);
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
 

       JFrame Frame= new JFrame();
       JPanel Panel = new JPanel();
       JLabel Label= new JLabel();
       JTextField TextField= new JTextField();
       JButton Boton4= new JButton();
       JButton Boton3= new JButton();
       

       ImageIcon FondoF= new ImageIcon("G:/InterfacesJava/src/interfacesjava/images/titulotext.PNG");
       Label.setBounds(100,5,FondoF.getIconWidth(),FondoF.getIconHeight()); // Importante, (x,y,largo,ancho)
       Label.setIcon(FondoF);

      

      

       Boton4.setBounds(650, 250, 100, 20);
       Boton4.setText("Rotar");
       Boton4.setName("Boton4");
       AsignarAccion(Boton4,TextField,"Rotar",null,Frame);


       Boton3.setBounds(650, 280, 100, 20);
       Boton3.setText("IReporte");
       Boton3.setName("Boton3");
       AsignarAccion(Boton3,TextField,"Reportes",null,Frame);


      Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
      Frame.setTitle("Frame Creado");
      Frame.setSize(800,500);
      Frame.getContentPane().add(Label);
      Frame.getContentPane().add(Boton4);
      Frame.getContentPane().add(Boton3);

       ListaFicha A= new ListaFicha();
      ArchivoFicha AR= new ArchivoFicha();
      AR.cargarArchivoPiezas(A);
      A.ImprimirColeccion();
      A.Barajear();
      A.ImprimirColeccion();
     System.out.println(A.getListadeFichas().get(0).getImagenAsociadaA());

     ListaUsuario U= new ListaUsuario();
     ArchivoUsuario AU= new ArchivoUsuario();
     AU.leerArchivoXML();



      Fichas=LlenarFichas(Fichas,Frame,A);
       for (int i=0;i<7;i++){
           Fichas.get(i).setBounds(50+ (100*i), 400, Fichas.get(i).getIcon().getIconWidth()+10,Fichas.get(i).getIcon().getIconHeight()+10);
           Frame.getContentPane().add(Fichas.get(i));
       }



       for (int i=0;i<7;i++){
           for (int j=0;j<4;j++){
           JButton Boton2= new JButton();
           Boton2.setBounds(150+ (70*i), 100+(70*j), 70,70);
           Frame.getContentPane().add(Boton2);
           }
       }


       

      Panel.setBackground(Color.red);
      Frame.getContentPane().add(Panel);
      Frame.setLocation(280, 100);
  
      Frame.validate();
      Frame.setVisible(true);
     

     
      
    }

  



     public static  Vector <JButton> LlenarFichas ( Vector <JButton> Fichas, JFrame Frame, ListaFicha A){

     for (int i=0;i<7;i++){

          JButton Boton= new JButton();
          ImageIcon FondoF= new ImageIcon("C:/Users/Minerva Verdugo Ruiz/Desktop/LaVerdugo/LaVerdugo/src/imagen/"+A.getListadeFichas().get(i).getImagenAsociadaA());
          Boton.setIcon(FondoF);
          AsignarAccion(Boton,null,"MoverBoton",null,Frame);
          Fichas.add(Boton);
     }
     return Fichas;
    }
 
      public static JFrame  Jugar (JFrame Frame,int X,int Y, String Direccion){
      Frame.setVisible(false);
      ImageIcon FondoF= new ImageIcon(Direccion);
      JLabel Imagen= new JLabel(FondoF);
      Imagen.setLocation(X+Contador,Y);
      Contador+=35;
      Frame.getContentPane().add(Imagen);
      return Frame;

    }


    public static void Rotar(JButton Boton, int i, int j){

        if (Posi==3){
            Posi=0;
        }
        else{
            Posi++;
        }
          ImageIcon FondoF= new ImageIcon("G:/InterfacesJava/src/interfacesjava/images/ficha"+Integer.toString(i)+Integer.toString(j)+Posicion.charAt(Posi)+".PNG");
         
        
          Boton.setIcon(FondoF);
          Boton.setSize(Boton.getIcon().getIconWidth()+10,Boton.getIcon().getIconHeight()+10);
    }




    public static  void AsignarAccion (final JButton Boton,  final JTextField Text,String Accion, final String Valor, final JFrame Frame){
    
    Boton.setActionCommand(Accion);
    Boton.addActionListener(new ActionListener()
       {
         public void actionPerformed (ActionEvent e)
         {
             
            String comando = e.getActionCommand();
          
            
            if (comando.equals("Rotar")){


                Rotar(Fichas.get(NFicha),0,1);
            }

             if (comando.equals("MoverBoton")){
                Frame.getContentPane().getComponentAt(X,Y).setVisible(false);
                Boton.setSize(70, 70);

                
                if (X<640){
                 Boton.setLocation(X,Y);
                X+=70;
                }
                else{       
                    X=150;
                    Y+=70;
                    Boton.setLocation(X,Y);
                    X+=70;
                }
                 
                NFicha+=1;
                 Frame.getContentPane().setBackground(Color.red);
            }


         }
       });

   }


  




}



