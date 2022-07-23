
// <editor-fold defaultstate="collapsed" desc="Librerias">  
import com.include.Barcodes;
import com.include.Productos;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.connectcode.Code128Auto;
// </editor-fold> 

public class Nutrimental extends javax.swing.JFrame {

    // <editor-fold defaultstate="collapsed" desc="Alerta">  
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
        
    } // </editor-fold> 
    
    private Productos prod = new Productos();
    
    //Se declaran los parametros necesarios para imprimir la tabla
    //DefaultTableModel modelo = new DefaultTableModel();
    Statement ejecutor = null;
    //Parametros por defecto que vienen por defecto al instalar la base de datos.
    Connection con;
    
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private final String user="root";
    private final String pass="";
    private final String url="jdbc:mysql://127.0.0.1/db_test";
    
    private void conectar(){
        con = null;
        
        try{
            //Metodo para hacer la conexion, si se logra la conexion se imprime un mensaje de exito
            Class.forName(DRIVER);
            con = (Connection) DriverManager.getConnection(url,user,pass);
            if(con != null) {
               conLbl.setText("*Conexion exitosa*");
               }
            } 
        catch (Exception ex){
            //Si no se logra la conexion imprime mensaje de error y el error
            conLbl.setText("*Conexion fallida*");
            JOptionPane.showMessageDialog(null, "Conexion fallida: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
            returnBttn.doClick();
            }
        }
    
    private void loadData() {
        try {
                DefaultTableModel modelo = new DefaultTableModel();
                nutrimentalTbl.setModel(modelo);
                
                PreparedStatement ps = null;
                ResultSet rs = null;
                
                //Conectarse a la BD
                String query = "SELECT proteina, grasa, h_carbono, azucares, fibra, sodio, gluten, energia, humedad, ceniza FROM nutrimental WHERE id=" + prod.getId();
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();
                
                //Crear las columnas de la tabla
                modelo.addColumn("Proteina");
                modelo.addColumn("Grasa");
                modelo.addColumn("Carbos");
                modelo.addColumn("Azucares");
                modelo.addColumn("Fibra");
                modelo.addColumn("Sodio");
                modelo.addColumn("Gluten");
                modelo.addColumn("Energia");
                modelo.addColumn("Humedad");
                modelo.addColumn("Ceniza");
                
                String datos[] = new String[10];
                
                //Rellenar la tabla
                while (rs.next()) {
                    datos[0]=rs.getString("proteina")+"g";
                    datos[1]=rs.getString("grasa")+"g";
                    datos[2]=rs.getString("h_carbono")+"g";
                    datos[3]=rs.getString("azucares")+"g";
                    datos[4]=rs.getString("fibra")+"g";
                    datos[5]=rs.getString("sodio")+"mg";
                    datos[6]=rs.getString("gluten")+"g";
                    datos[7]=rs.getString("energia")+"kcal";
                    datos[8]=rs.getString("humedad")+"%";
                    datos[9]=rs.getString("ceniza")+"%";
                    modelo.addRow(datos);
                    }
                
                nutrimentalTbl.setRowHeight(60); //Cambiar la altura de la fila
                
                Code128Auto code128 = new Code128Auto();
                
                //Obtener el codigo del producto
                String code = prod.getCodigo();
                //Crear el codigo de barras
                String barcode = code128.encode(code);

                //Mostrar el codigo de barras
                barcodeLbl.setText(barcode);
                    barcodeLbl.setFont(new java.awt.Font("CCode128_S3_Trial",java.awt.Font.PLAIN,25));
                codeLbl.setText(code); 
            
                rs.close();
                }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
    private void loadComboBox() {
        //Insertar las opciones del ComboBox
        Productos cc = new Productos();
        DefaultComboBoxModel modeloProd = new DefaultComboBoxModel(cc.showProductos());
        prodCbx.setModel(modeloProd);
        }
    
    public Nutrimental() {
        super("Procesos");
        initComponents();
        this.setLocationRelativeTo(null);
        
        conectar();
        loadComboBox();
        setIconImage(getIconImage());
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagen/Boxha.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        advertencia = new javax.swing.JButton();
        returnBttn = new javax.swing.JButton();
        allPdfBttn = new javax.swing.JButton();
        updateBttn = new javax.swing.JButton();
        pane1 = new javax.swing.JScrollPane();
        nutrimentalTbl = new javax.swing.JTable();
        noteLbl = new javax.swing.JLabel();
        conLbl = new javax.swing.JLabel();
        prodLbl = new javax.swing.JLabel();
        prodCbx = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        barcodeLbl = new javax.swing.JLabel();
        codeLbl = new javax.swing.JLabel();
        onePdfBttn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        title.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Tabla Nutrimental");

        advertencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/crisis.png"))); // NOI18N
        advertencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advertenciaActionPerformed(evt);
            }
        });

        returnBttn.setText("Return");
        returnBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBttnActionPerformed(evt);
            }
        });

        allPdfBttn.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        allPdfBttn.setText("Generar PDF de todos los productos");
        allPdfBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allPdfBttnActionPerformed(evt);
            }
        });

        updateBttn.setBackground(new java.awt.Color(102, 102, 102));
        updateBttn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updateBttn.setForeground(new java.awt.Color(255, 255, 255));
        updateBttn.setText("ACTUALIZAR");
        updateBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBttnActionPerformed(evt);
            }
        });

        pane1.setBackground(new java.awt.Color(204, 204, 204));

        nutrimentalTbl.setBackground(new java.awt.Color(204, 204, 204));
        nutrimentalTbl.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nutrimentalTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Proteina", "Grasa", "Carbohidratos", "Azúcares", "Fibra", "Sodio", "Gluten", "Calorías", "Humedad", "Ceniza"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        nutrimentalTbl.getTableHeader().setReorderingAllowed(false);
        pane1.setViewportView(nutrimentalTbl);

        noteLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noteLbl.setText("Por cada 100g de Producto");

        conLbl.setBackground(new java.awt.Color(255, 255, 255));
        conLbl.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        conLbl.setForeground(new java.awt.Color(51, 51, 51));
        conLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        conLbl.setText("ooooooooo");

        prodLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prodLbl.setText("Producto:");

        prodCbx.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                prodCbxItemStateChanged(evt);
            }
        });

        barcodeLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        codeLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codeLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barcodeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barcodeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        onePdfBttn.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        onePdfBttn.setText("Generar PDF del producto actual");
        onePdfBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onePdfBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(title, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(noteLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(conLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(allPdfBttn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(advertencia)
                        .addGap(669, 669, 669)
                        .addComponent(returnBttn))
                    .addComponent(onePdfBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(prodLbl)
                        .addGap(36, 36, 36)
                        .addComponent(prodCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(updateBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(277, 277, 277))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(noteLbl)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prodLbl)
                    .addComponent(prodCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(updateBttn)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(onePdfBttn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(allPdfBttn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(advertencia))
                    .addComponent(returnBttn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(conLbl)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void returnBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBttnActionPerformed
        this.setVisible(false);
        Panel RE = new Panel();
        RE.setVisible(true);
    }//GEN-LAST:event_returnBttnActionPerformed

    private void allPdfBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allPdfBttnActionPerformed
        // TODO add your handling code here:
        Barcodes bc = new Barcodes();
        bc.getAllProductsPDF();
    }//GEN-LAST:event_allPdfBttnActionPerformed

    private void updateBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBttnActionPerformed
        this.setVisible(false);
        Nutrimental tb = new Nutrimental();
        tb.setVisible(true);
    }//GEN-LAST:event_updateBttnActionPerformed

    private void prodCbxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_prodCbxItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            prod = (Productos) prodCbx.getSelectedItem();
            loadData();
            }
    }//GEN-LAST:event_prodCbxItemStateChanged

    private void onePdfBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onePdfBttnActionPerformed
        // TODO add your handling code here:
        Barcodes bc = new Barcodes();
        bc.getOneProductPDF(prod);
    }//GEN-LAST:event_onePdfBttnActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nutrimental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nutrimental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nutrimental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nutrimental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nutrimental().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton advertencia;
    private javax.swing.JButton allPdfBttn;
    private javax.swing.JLabel barcodeLbl;
    private javax.swing.JLabel codeLbl;
    private javax.swing.JLabel conLbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel noteLbl;
    private javax.swing.JTable nutrimentalTbl;
    private javax.swing.JButton onePdfBttn;
    private javax.swing.JScrollPane pane1;
    private javax.swing.JComboBox<String> prodCbx;
    private javax.swing.JLabel prodLbl;
    private javax.swing.JButton returnBttn;
    private javax.swing.JLabel title;
    private javax.swing.JButton updateBttn;
    // End of variables declaration//GEN-END:variables
}
