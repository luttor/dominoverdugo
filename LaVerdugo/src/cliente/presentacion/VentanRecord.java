/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentanRecord.java
 *
 * Created on Aug 6, 2010, 7:31:57 AM
 */

package cliente.presentacion;
import javax.swing.JFrame;
/**
 *
 * @author Isra
 */
public class VentanRecord extends javax.swing.JFrame {

    /** Creates new form VentanRecord */
    public VentanRecord() {
        initComponents();
        ventanaPadre=null;
        
    }
        public void setVentanaPadre(JFrame ventanaPadre) {
        this.ventanaPadre = ventanaPadre;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jcpTablaDatos = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jlimg1 = new javax.swing.JLabel();
        jbVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Score de IDomino");
        setBackground(new java.awt.Color(0, 0, 0));

        jlTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/titulotext.png"))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jcpTablaDatos.setViewportView(jTable1);

        jlimg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/trofeoVDP.png"))); // NOI18N

        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap(64, Short.MAX_VALUE)
                        .add(jlTitulo))
                    .add(layout.createSequentialGroup()
                        .add(156, 156, 156)
                        .add(jlimg1)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jcpTablaDatos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 443, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(482, 482, 482)
                .add(jbVolver)
                .addContainerGap(349, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jlTitulo)
                        .add(64, 64, 64)
                        .add(jlimg1))
                    .add(layout.createSequentialGroup()
                        .add(140, 140, 140)
                        .add(jcpTablaDatos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 68, Short.MAX_VALUE)
                .add(jbVolver)
                .add(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
this.dispose();
ventanaPadre.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jbVolverActionPerformed

    /**
    * @param args the command line arguments
    */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbVolver;
    private javax.swing.JScrollPane jcpTablaDatos;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlimg1;
    // End of variables declaration//GEN-END:variables
    JFrame ventanaPadre;
}
