
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Panel extends javax.swing.JFrame {
    
    private static final String codigo = "12345";//codigo para desactivar la alerta
    public Clip clip;
    public String ruta="/Sonidos/";
    
    //Sonido de alrta para ingresar código
    public void sonido(String archivo){
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta+archivo+".wav")));
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } 
        catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Panel() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
        setIconImage(getIconImage());
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagen/Boxha.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Proceso = new javax.swing.JButton();
        PaP = new javax.swing.JButton();
        Inve = new javax.swing.JButton();
        XD = new javax.swing.JButton();
        advertencia = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        Proceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/boton-de-play.png"))); // NOI18N
        Proceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcesoActionPerformed(evt);
            }
        });

        PaP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/procesamiento-por-lotes.png"))); // NOI18N
        PaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaPActionPerformed(evt);
            }
        });

        Inve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/inventario.png"))); // NOI18N
        Inve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InveActionPerformed(evt);
            }
        });

        XD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/analisis-de-datos.png"))); // NOI18N
        XD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XDActionPerformed(evt);
            }
        });

        advertencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/crisis.png"))); // NOI18N
        advertencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advertenciaActionPerformed(evt);
            }
        });

        jLabel1.setText("Inciar proceso");

        jLabel2.setText("    Procesos");

        jLabel3.setText("   Inventario");

        jLabel4.setText("Tabla y barra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Proceso, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Inve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(XD)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(advertencia)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PaP, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Inve, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(XD, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(Proceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addComponent(advertencia)
                .addGap(114, 114, 114))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcesoActionPerformed
        this.setVisible(false);
        Lagrange3 JF1 = new Lagrange3();
        JF1.setVisible(true);
        Manual JF = new Manual();
        JF.setVisible(true);
    }//GEN-LAST:event_ProcesoActionPerformed

    private void advertenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advertenciaActionPerformed
        //nombre del archivo del sonido de alerta
        sonido("alerta");
        //ventana emergente que solicita un codigo para desactivar
        String respuesta = JOptionPane.showInputDialog(null, "Escriba Código para desactivar", "Alerta!", JOptionPane.ERROR_MESSAGE);
        //minetras no sea el codigo no sea correcto no desaparecera
        if(respuesta == null ? codigo != null : !respuesta.equals(codigo)){
            clip.stop();
            advertencia.doClick();
        }
        clip.stop();
    }//GEN-LAST:event_advertenciaActionPerformed

    private void PaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaPActionPerformed
        this.setVisible(false);
        Proceso JF2 = new Proceso();
        JF2.setVisible(true);
    }//GEN-LAST:event_PaPActionPerformed

    private void XDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XDActionPerformed
        this.setVisible(false);
        Nutrimental JF4 = new Nutrimental();
        JF4.setVisible(true);
    }//GEN-LAST:event_XDActionPerformed

    private void InveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InveActionPerformed
        this.setVisible(false);
        Tabla_Inventario JF3 = new Tabla_Inventario();
        JF3.setVisible(true);
    }//GEN-LAST:event_InveActionPerformed

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
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Inve;
    private javax.swing.JButton PaP;
    private javax.swing.JButton Proceso;
    private javax.swing.JButton XD;
    private javax.swing.JButton advertencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
