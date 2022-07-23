
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
import javax.swing.table.DefaultTableModel;


public class Lagrange3Unico extends javax.swing.JFrame {
    
    private double DX[];
    private double DY[];
    private double a[];
    
    DefaultTableModel modelo;
    
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

    public Lagrange3Unico() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        modelo = new DefaultTableModel();
        modelo.addColumn("X");
        modelo.addColumn("Y");
        this.tabla.setModel(modelo);
        setIconImage(getIconImage());
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagen/Boxha.png"));
        return retValue;
    }
    
    public Lagrange3Unico(double y[], double x[]) {
		this.DX = x;
		this.DY = y;
		a=new double[x.length];
	}
    
    private void getPolinomios_a() {
        double mult;
	for(int i=0;i<DY.length;i++){
            mult = 1;
            for(int j=0;j<DX.length;j++){
		if(i==j)continue;
                    mult=(DX[i]-DX[j])*mult;
            }
            a[i]=DY[i]/mult;
            ///System.out.print("a"+"["+i+"]="+a[i]+"  ");
	}
    }
    
    public double getResultadoP(int p){
        getPolinomios_a();
	double mult=1;
	double valores[]=new double[a.length];
	//System.out.println("");
	for(int i=0;i<a.length;i++){
            mult=1;
            for(int j=0;j<a.length;j++){
		if(i==j)continue;
                    mult=(p-DX[j])*mult;
            }
            valores[i]=a[i]*mult;
            //System.out.print(valores[i]);
            //if(i!=a.length-1)System.out.print(" + ");
	}
	double resultado=0;
	for(int k=0;k<valores.length;k++){
            resultado=resultado+valores[k];
	}
	return resultado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ND = new javax.swing.JTextField();
        IDX = new javax.swing.JButton();
        IDY = new javax.swing.JButton();
        MDX = new javax.swing.JButton();
        MDY = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        calcular = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        calcu = new javax.swing.JTextField();
        resultado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Procesos = new javax.swing.JButton();
        advertencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lagrange");

        jLabel1.setText("Numero de datos a ingresar:");

        IDX.setText("Ingresar datos X");
        IDX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDXActionPerformed(evt);
            }
        });

        IDY.setText("Ingresar datos Y");
        IDY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDYActionPerformed(evt);
            }
        });

        MDX.setText("Mostrar datos X");
        MDX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MDXActionPerformed(evt);
            }
        });

        MDY.setText("Mostrar datos Y");
        MDY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MDYActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        jButton2.setText("Mostrar Tabla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        calcular.setText("Calcular resultado");
        calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularActionPerformed(evt);
            }
        });

        jLabel2.setText("Valor a buscar:");

        resultado.setEditable(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Resultado");

        Procesos.setText("Procesos");
        Procesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcesosActionPerformed(evt);
            }
        });

        advertencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/crisis.png"))); // NOI18N
        advertencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advertenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(advertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Procesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ND, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MDY)
                            .addComponent(MDX))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDY)
                            .addComponent(IDX))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resultado)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(calcu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDX)
                    .addComponent(jButton2)
                    .addComponent(MDX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDY)
                    .addComponent(MDY))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(calcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(calcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(resultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(advertencia, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(Procesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IDXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDXActionPerformed
        // TODO add your handling code here:

        int tam = Integer.parseInt(ND.getText());
        DX = new double[tam];
        for(int i=0;i<tam;i++){
            String dax = JOptionPane.showInputDialog(this, "Ingrese dato: "+(i+1));
            DX[i]=Double.parseDouble(dax);
        }

    }//GEN-LAST:event_IDXActionPerformed

    private void IDYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDYActionPerformed
        // TODO add your handling code here:

        int tam = Integer.parseInt(ND.getText());
        DY = new double[tam];
        for(int i=0;i<tam;i++){
            String day = JOptionPane.showInputDialog(this, "Ingrese dato: "+(i+1));
            DY[i]=Double.parseDouble(day);
        }
    }//GEN-LAST:event_IDYActionPerformed

    private void MDXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MDXActionPerformed
        // TODO add your handling code here:
        
        String listaX = "";
        for(int j=0;j<DX.length;j++){
            String lisX = Double.toString(DX[j]);
            listaX+=lisX+"\n";
        }
        JOptionPane.showMessageDialog(this, listaX);
    }//GEN-LAST:event_MDXActionPerformed

    private void MDYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MDYActionPerformed
        // TODO add your handling code here:
        
        String listaY = "";
        for(int j=0;j<DY.length;j++){
            String lisY = Double.toString(DY[j]);
            listaY+=lisY+"\n";
        }
        JOptionPane.showMessageDialog(this, listaY);
    }//GEN-LAST:event_MDYActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        int tam = Integer.parseInt(ND.getText());
        String []info=new String[2];
        
        for(int k=0;k<tam;k++){
            info[0]=Double.toString(DX[k]);
            info[1]=Double.toString(DY[k]);
            modelo.addRow(info);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularActionPerformed
        resultado.setText("");
        int cal = Integer.parseInt(calcu.getText());
        a = new double[cal];
        Lagrange3 l=new Lagrange3(DY, DX);
	  double res=l.getResultadoP(cal);
          resultado.setText(resultado.getText()+ res);
          //JOptionPane.showMessageDialog(this, res);
	  
	  //System.out.println("El resultado es "+res);
    }//GEN-LAST:event_calcularActionPerformed

    private void ProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcesosActionPerformed
        this.setVisible(false);
        Proceso JF1 = new Proceso();
        JF1.setVisible(true);
    }//GEN-LAST:event_ProcesosActionPerformed

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
            java.util.logging.Logger.getLogger(Lagrange3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lagrange3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lagrange3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lagrange3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lagrange3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IDX;
    private javax.swing.JButton IDY;
    private javax.swing.JButton MDX;
    private javax.swing.JButton MDY;
    private javax.swing.JTextField ND;
    private javax.swing.JButton Procesos;
    private javax.swing.JButton advertencia;
    private javax.swing.JTextField calcu;
    private javax.swing.JButton calcular;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField resultado;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
