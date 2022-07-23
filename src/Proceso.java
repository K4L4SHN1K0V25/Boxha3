 
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;


public class Proceso extends javax.swing.JFrame {

    private static final String codigo = "12345";//codigo para desactivar la alerta
    public Clip clip;
    public String ruta="/Sonidos/";
    
    //Sonido de alrta para ingresar código
    public void sonido(String archivo){
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta+archivo+".wav")));
            clip.start();
        } 
        catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Proceso() {
        initComponents();
        this.setLocationRelativeTo(null);
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

        Ret = new javax.swing.JButton();
        advertencia = new javax.swing.JButton();
        LA = new javax.swing.JButton();
        Hu = new javax.swing.JButton();
        Pr = new javax.swing.JButton();
        Gr = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Ce = new javax.swing.JButton();
        Car = new javax.swing.JButton();
        Cal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Procesos");

        Ret.setText("Return");
        Ret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetActionPerformed(evt);
            }
        });

        advertencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/crisis.png"))); // NOI18N
        advertencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advertenciaActionPerformed(evt);
            }
        });

        LA.setText("Lagrange");
        LA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LAActionPerformed(evt);
            }
        });

        Hu.setText("Humedad");
        Hu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HuActionPerformed(evt);
            }
        });

        Pr.setText("Proteina");
        Pr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrActionPerformed(evt);
            }
        });

        Gr.setText("Grasa");
        Gr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Procesos para hacer los metodos por separado");

        Ce.setText("Ceniza");
        Ce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CeActionPerformed(evt);
            }
        });

        Car.setText("Carbos");
        Car.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarActionPerformed(evt);
            }
        });

        Cal.setText("Calorico");
        Cal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(advertencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Ret))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Gr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LA, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Cal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Ce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Hu, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Car, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Pr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(17, 17, 17))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LA, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(Hu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Gr, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Car, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ce, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Cal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(advertencia)
                    .addComponent(Ret))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetActionPerformed
        this.setVisible(false);
        Panel RE = new Panel();
        RE.setVisible(true);
    }//GEN-LAST:event_RetActionPerformed

    private void advertenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advertenciaActionPerformed
        //nombre del archivo del sonido de alerta
        sonido("alerta");
        //ventana emergente que solicita un codigo para desactivar
        String respuesta = JOptionPane.showInputDialog(null, "Escriba Código para desactivar", "Alerta!", JOptionPane.ERROR_MESSAGE);
        //minetras no sea el codigo no sea correcto no desaparecera
        if(respuesta == null ? codigo != null : !respuesta.equals(codigo)){
            advertencia.doClick();
        }
    }//GEN-LAST:event_advertenciaActionPerformed

    private void LAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAActionPerformed
        this.setVisible(false);
        Lagrange3Unico JF1 = new Lagrange3Unico();
        JF1.setVisible(true);
    }//GEN-LAST:event_LAActionPerformed

    private void HuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HuActionPerformed
        this.setVisible(false);
        Humedad1Unico JF2 = new Humedad1Unico();
        JF2.setVisible(true);
    }//GEN-LAST:event_HuActionPerformed

    private void PrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrActionPerformed
        
        this.setVisible(false);
        Proteina1Unico JF3 = new Proteina1Unico();
        JF3.setVisible(true);
    }//GEN-LAST:event_PrActionPerformed

    private void GrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrActionPerformed
       
        this.setVisible(false);
        Grasa1Unico JF4 = new Grasa1Unico();
        JF4.setVisible(true);
    }//GEN-LAST:event_GrActionPerformed

    private void CeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CeActionPerformed
        this.setVisible(false);
        Ceniza1Unico JF5 = new Ceniza1Unico();
        JF5.setVisible(true);
    }//GEN-LAST:event_CeActionPerformed

    private void CarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarActionPerformed
        this.setVisible(false);
        Carbo1Unico JF6 = new Carbo1Unico();
        JF6.setVisible(true);
    }//GEN-LAST:event_CarActionPerformed

    private void CalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalActionPerformed
        this.setVisible(false);
        Calorico1Unico JF7 = new Calorico1Unico();
        JF7.setVisible(true);
    }//GEN-LAST:event_CalActionPerformed

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
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cal;
    private javax.swing.JButton Car;
    private javax.swing.JButton Ce;
    private javax.swing.JButton Gr;
    private javax.swing.JButton Hu;
    private javax.swing.JButton LA;
    private javax.swing.JButton Pr;
    private javax.swing.JButton Ret;
    private javax.swing.JButton advertencia;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
