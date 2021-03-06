/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.inali.helioxhelper.gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import mx.inali.helioxhelper.entidades.clases.Lenguaje;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import mx.inali.helioxhelper.entidades.clases.Boton;
import mx.inali.helioxhelper.negocio.NegocioHeliox;

/**
 *
 * @author Adolfo
 */
public class AdministrarLenguaje extends javax.swing.JDialog {
    NegocioHeliox nh;
    Lenguaje lenguaje;
    
    /**
     * Creates new form AdministrarLenguaje
     */
    public AdministrarLenguaje(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        nh = new NegocioHeliox();
        llenarLista();
        eliminarLenguaje.setEnabled(false);
    }
    
    
    private void llenarLista() throws SQLException{
        ArrayList<Lenguaje> len = new ArrayList<>();
        len = nh.listadoLenguajes();
        
        DefaultListModel model = new DefaultListModel();
        for(int i=0; i<len.size();i++){
            model.addElement(len.get(i));
        }
        
        listaLenguajes.setModel(model);
    }
    
    private void actualizarContenido(){
        AdministrarLenguaje.this.pack();
        AdministrarLenguaje.this.repaint();
    }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaLenguajes = new javax.swing.JList();
        labelTip1 = new javax.swing.JLabel();
        eliminarLenguaje = new javax.swing.JButton();
        agregarLenguaje = new javax.swing.JButton();
        jLabelIdioma = new javax.swing.JLabel();
        labelTip2 = new javax.swing.JLabel();
        agregarBoton = new javax.swing.JButton();
        eliminarBoton = new javax.swing.JButton();
        panelBotones = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        listaLenguajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaLenguajesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaLenguajes);

        labelTip1.setText("Seleccione un lenguaje para consultar o modificar los botones.");

        eliminarLenguaje.setText("-");
        eliminarLenguaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarLenguajeActionPerformed(evt);
            }
        });

        agregarLenguaje.setText("+");
        agregarLenguaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarLenguajeActionPerformed(evt);
            }
        });

        jLabelIdioma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelIdioma.setText("Español");

        labelTip2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTip2.setText("Seleccione un botón si no cuenta con ninguno agregue uno nuevo.");

        agregarBoton.setText("+");
        agregarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBotonActionPerformed(evt);
            }
        });

        eliminarBoton.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(agregarLenguaje, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarLenguaje, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTip2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTip1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabelIdioma)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(agregarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eliminarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelTip1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelIdioma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTip2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eliminarLenguaje, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarLenguaje, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBotonActionPerformed
        // TODO add your handling code here:
        AgregarBoton ab = new AgregarBoton(null, true, lenguaje);
        ab.setVisible(true);
    }//GEN-LAST:event_agregarBotonActionPerformed

    private void agregarLenguajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarLenguajeActionPerformed
        // TODO add your handling code here:
        String nombre = JOptionPane.showInputDialog(this, "Nombre del lenguaje", "Agregar lenguaje", JOptionPane.OK_OPTION);
        try {
            if(!nombre.equals("")){
                Lenguaje l = new Lenguaje();
                l.setNombre(nombre);
                nh.agregarLenguaje(l);
                llenarLista();
            }
        }catch (SQLException ex) {
            Logger.getLogger(AdministrarLenguaje.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NullPointerException ex){
            Logger.getLogger(AdministrarLenguaje.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_agregarLenguajeActionPerformed

    private void eliminarLenguajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarLenguajeActionPerformed
        // TODO add your handling code here:
        lenguaje = (Lenguaje) listaLenguajes.getSelectedValue();
        int dialog = JOptionPane.YES_NO_OPTION;
        int e = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar este botón?", "Eliminar lenguaje", dialog);

        if (e == JOptionPane.YES_NO_OPTION) {
            try {
                nh.eliminarLenguaje(lenguaje);
            } catch (SQLException ex) {
                Logger.getLogger(AdministrarLenguaje.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                llenarLista();
            } catch (SQLException ex) {
                Logger.getLogger(AdministrarLenguaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }//GEN-LAST:event_eliminarLenguajeActionPerformed

    private void listaLenguajesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaLenguajesMouseClicked
        lenguaje = (Lenguaje) listaLenguajes.getSelectedValue();
        System.out.println(lenguaje.getId());
        jLabelIdioma.setText(lenguaje.getNombre());
        eliminarLenguaje.setEnabled(true);
        panelBotones.removeAll();
        panelBotones.repaint();
        ArrayList<Boton> botones = new ArrayList<Boton>();
        try {
            botones = nh.listadoBotonesLenguaje(lenguaje.getId());

            int space = 0;
            for(int i=0;i<5;i++){
                JLabel image = new JLabel();
                JLabel descripcion = new JLabel();
                JPanel contenido = new JPanel();
                JButton editar = new JButton();
                JButton eliminar = new JButton();

                Border blackline;
                blackline = BorderFactory.createLineBorder(Color.BLACK);

                contenido.setBounds(10, 10+space, 365, 70);
                contenido.setBorder(blackline);

                image.setBounds(10, 10, 50, 50);
                image.setBorder(blackline);

                descripcion.setBounds(80,10,280,20);
                //descripcion.setText("descripcion: "+botones.get(i).getDescripcion());
                descripcion.setText("descripcion: ");

                editar.setBounds(200, 35, 80, 25);
                editar.setText("Editar");

                eliminar.setBounds(280, 35, 80, 25);
                eliminar.setText("Eliminar");

                contenido.add(image);
                contenido.add(descripcion);
                contenido.add(editar);
                contenido.add(eliminar);
               
                panelBotones.add(contenido);
                space+=80; 
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarLenguaje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listaLenguajesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdministrarLenguaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministrarLenguaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministrarLenguaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministrarLenguaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdministrarLenguaje dialog = null;
                try {
                    dialog = new AdministrarLenguaje(new javax.swing.JFrame(), true);
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarLenguaje.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBoton;
    private javax.swing.JButton agregarLenguaje;
    private javax.swing.JButton eliminarBoton;
    private javax.swing.JButton eliminarLenguaje;
    private javax.swing.JLabel jLabelIdioma;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTip1;
    private javax.swing.JLabel labelTip2;
    private javax.swing.JList listaLenguajes;
    private javax.swing.JScrollPane panelBotones;
    // End of variables declaration//GEN-END:variables
}
