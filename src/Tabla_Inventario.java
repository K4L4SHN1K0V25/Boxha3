
import com.mysql.cj.protocol.Resultset;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author moyse
 */
public class Tabla_Inventario extends javax.swing.JFrame {
    
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
    
    //Se declaran los parametros necesarios para imprimir la tabla.
    DefaultTableModel modelo=new DefaultTableModel();
    Statement ejecutor=null;
    //Parametros por defecto que vienen por defecto al instalar la base de datos.
    Connection con;
    String driver="com.mysql.cj.jdbc.Driver";
    String user="root";
    String pass="";
    String url="jdbc:mysql://localhost:3306/db_test";//localhost/inventario
    protected void Cargatabla(){
        this.setLocationRelativeTo(null);
        //Se indica que sa comience en la posicion 0.
        modelo.setRowCount(0);
        //Se declara un arreglo donde se guardaran los datos, y tambien desde donse seran importados.
        String datos[]=new String[5];
        String query="select * from in_productos";
        //Se saca la informacion de la tabla inventari de la base de datos.
        ResultSet rs;
        try{
            //Se realiza la conexion, y con un ciclo while, mientras se encuentren datos se imprimiran en la tabla.
            ejecutor=con.createStatement();
            ejecutor.setQueryTimeout(20);
            rs=(ResultSet) ejecutor.executeQuery(query);
            while(rs.next()==true)
            {
                //Se guardan en el arreglo la informacion de cada campo y se imprimen
                datos[0]=rs.getString("ID");
                datos[1]=rs.getString("Producto");
                datos[2]=rs.getString("Cantidad");
                datos[3]=rs.getString("Codigo_Producto");
                datos[4]=rs.getString("Fecha_Caducidad");
                modelo.addRow(datos);
            }
            //Se cargan los datos en la tabla.
            Tabla_Empleados.setModel(modelo);
            
        }catch (Exception e){
            
        }  
    }
    
    protected void buscar(){
        //Se pide el producto para realizar la busqueda 
        String Producto = JOptionPane.showInputDialog(this, "Ingrese el producto: ");
        modelo.setRowCount(0);
        //Se declara un arreglo donde se guardaran los datos, y tambien desde donse seran importados.
        String datos[]=new String[5];
        //Esta es una condicion que siempre sera correcta
        String where=" where 1=1 ";
        if(Producto.isEmpty()==false){
            where=where+" and Producto='"+Producto+"'";
            //Se guarda el nombre y se busca en la tabla
        }
        String query="select * from in_productos" +where+"";
        //Se saca la informacion de la tabla inventaro de la base de datos mediante el nombre.
        ResultSet rs;
        try{
            //Se realiza la conexion, y con un ciclo while, mientras se encuentren datos se imprimiran en la tabla.
            ejecutor=con.createStatement();
            ejecutor.setQueryTimeout(20);
            rs=(ResultSet) ejecutor.executeQuery(query);
            while(rs.next()==true)
            {
                //Se guardan en el arreglo la informacion de cada campo y se imprimen
                datos[0]=rs.getString("ID");
                datos[1]=rs.getString("Producto");
                datos[2]=rs.getString("Cantidad");
                datos[3]=rs.getString("Codigo_Producto");
                datos[4]=rs.getString("Fecha_Caducidad");
                modelo.addRow(datos);
            }
            //Se cargan los datos en la tabla.
            Tabla_Empleados.setModel(modelo);
            
        }catch (Exception e){
            
        } 
}
    
    public void conectar(){
        con=null;
        try{
            //Metodo para hacer la conexion, si se logra la conexion se imprime un mensaje de exito
            Class.forName(driver);
            con=(Connection) DriverManager.getConnection(url,user,pass);
            if(con!=null)
            {
                conexion.setText("Conexion exitosa");
            }
        } catch (Exception e){
            //Si no se logra la conexion imprime mensaje de error y el error
            conexion.setText("Conexion no exitosa: " +e);
        }
    }
    /**
     * Creates new form Tabla_Inventario
     */
    
    
    public Tabla_Inventario() {
        initComponents();
        setIconImage(getIconImage());
    
        //Se declara cada columna que se encuentra en la base de datos.
        //Los .setVisible son para que al momento de compilar el programa, no aparescan estas tablas, se activaran cuando se seleccione un elemento en la tabla
       
        JProducto.setVisible(false);
        JCantidad.setVisible(false);
        JCodigo.setVisible(false);
        JFecha.setVisible(false);
        txtProducto.setVisible(false);
        txtCantidad.setVisible(false);
        txtCodigo.setVisible(false);
        txtFecha.setVisible(false);
        JAceptar.setVisible(false);
        Editar.setVisible(false);
        modelo.addColumn("ID");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Codigo_Producto");
        modelo.addColumn("Fecha_Caducidad");
        conectar();
        Cargatabla();
        //Todo esto se debe copear ya que no esta dentro de ningun boton o algo el cual se lleve el proceso, asi que agregar manualmente al codigo
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        conexion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_Empleados = new javax.swing.JTable();
        AgregarProducto = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtProducto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        JCantidad = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        JProducto = new javax.swing.JLabel();
        JCodigo = new javax.swing.JLabel();
        JFecha = new javax.swing.JLabel();
        Editar = new javax.swing.JButton();
        JAceptar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        advertencia = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabla_Empleados.setBackground(new java.awt.Color(204, 255, 204));
        Tabla_Empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Producoto", "Cantidad", "Codigo_Producto", "Fecha_Caducidad"
            }
        ));
        Tabla_Empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_EmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla_Empleados);

        AgregarProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AgregarProducto.setText("Agregar");
        AgregarProducto.setToolTipText("");
        AgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarProductoActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        JCantidad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JCantidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JCantidad.setText("Cantidad");

        JProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JProducto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JProducto.setText("Producto");

        JCodigo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JCodigo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JCodigo.setText("Codigo del producto");

        JFecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JFecha.setText("Fecha de caducidad");

        Editar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        JAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JAceptar.setText("Aceptar");
        JAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAceptarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton3.setText("Return");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(conexion, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(554, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                                            .addComponent(txtFecha)))
                                    .addComponent(JAceptar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(JProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                            .addComponent(JCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AgregarProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(87, 87, 87)
                                .addComponent(btnEliminar)
                                .addGap(99, 99, 99)
                                .addComponent(jButton2)
                                .addGap(16, 16, 16))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(advertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Editar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(conexion)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgregarProducto)
                    .addComponent(jButton1)
                    .addComponent(btnEliminar)
                    .addComponent(jButton2))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Editar)
                            .addComponent(JAceptar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(advertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarProductoActionPerformed
        agregar();
        //Boton con la funcion de agregar
    }//GEN-LAST:event_AgregarProductoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscar();
        //Boton con la funcino de buscar
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Cargatabla();
        //Boton que actualiza la tabla
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void Tabla_EmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_EmpleadosMouseClicked
        /*Esta funcion lo que hace es que al momento de seleccionar una opcion de la tabla, habilita el voton de editar
        se cargan los datos del elemento ingresado en unos Text Field los cuales tambien estan ocultos, y se pueden modificar*/
        Editar.setVisible(true);
        int registro=Tabla_Empleados.getSelectedRow();
        txtProducto.setText( Tabla_Empleados.getValueAt(registro, 1).toString());
        txtCantidad.setText( Tabla_Empleados.getValueAt(registro, 2).toString());
        txtCodigo.setText( Tabla_Empleados.getValueAt(registro, 3).toString());
        txtFecha.setText( Tabla_Empleados.getValueAt(registro, 4).toString()); 
    }//GEN-LAST:event_Tabla_EmpleadosMouseClicked

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        /*Al darle al boton editar, se habilitan estos campos*/
        JProducto.setVisible(true);
        JCantidad.setVisible(true);
        JCodigo.setVisible(true);
        JFecha.setVisible(true);
        txtProducto.setVisible(true);
        txtCantidad.setVisible(true);
        txtCodigo.setVisible(true);
        txtFecha.setVisible(true);
        JAceptar.setVisible(true);

    }//GEN-LAST:event_EditarActionPerformed

    private void JAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAceptarActionPerformed
        //Boton de aceptar
        String mensajeError="";//Si se detecta algun error se guardara en este mensaje
        int registro=Tabla_Empleados.getSelectedRow();
        PreparedStatement preparar=null;
        //Se comprueban que los Text Field No esten vacios, si lo estan no deja realizar el edit en la tabla
        if(txtProducto.getText().isEmpty()==true)
       {
           mensajeError=mensajeError+"Producto no puede estar vacio\n";
       }
       if(txtCantidad.getText().isEmpty()==true)
       {
           mensajeError=mensajeError+"Cantidad no puede estar vacio\n";
       }
       if(txtCodigo.getText().isEmpty()==true)
       {
           mensajeError=mensajeError+"El codigo del producto no puede estar vacio\n";
       }
       if(txtFecha.getText().isEmpty()==true)
       {
           mensajeError=mensajeError+"Fecha de caducidad del producto no puede estar vacio\n";
       }
       if(mensajeError.isEmpty()==true)
       {
            //Si no se detectaron errores, se realiza el cambio en la tabla 
            String query="UPDATE in_productos SET "
                + " Producto='"+txtProducto.getText()+"', "
                + " Cantidad='"+txtCantidad.getText()+"', "
                + " Codigo_Producto='"+txtCodigo.getText()+"', "
                + " Fecha_Caducidad='"+txtFecha.getText()+"' "
                + " WHERE ID='"+Tabla_Empleados.getValueAt(registro,0)+"'";
        try{
                preparar=con.prepareStatement(query);
                preparar.executeUpdate();
               //preparar=con.prepareStatement(query);
               //preparar.executeQuery();
               Cargatabla();
        } catch (Exception e){
            System.out.println(e);
        }
       }else{
           JOptionPane.showMessageDialog(null, "Produto no editado\n\n"+mensajeError);
       }
       //Al terminar el proceso, se vuelve a ocultar los campos para editar los campos
        JProducto.setVisible(false);
        JCantidad.setVisible(false);
        JCodigo.setVisible(false);
        JFecha.setVisible(false);
        txtProducto.setVisible(false);
        txtCantidad.setVisible(false);
        txtCodigo.setVisible(false);
        txtFecha.setVisible(false);
        JAceptar.setVisible(false);
        Editar.setVisible(false);
    }//GEN-LAST:event_JAceptarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        PreparedStatement pre=null;
        //El precionar el boton, el elemento seleccionado se elimina.
        String query="delete from in_productos "
                + "where ID='"+Tabla_Empleados.getValueAt(Tabla_Empleados.getSelectedRow(),0)+"'; ";
        try{
                pre=con.prepareStatement(query);
                pre.executeUpdate();
               //preparar=con.prepareStatement(query);
               //preparar.executeQuery();
               Cargatabla();
        } catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        Panel RE = new Panel();
        RE.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
    protected void agregar(){
        //Se declara un mensaje de error donde se guardaran los errores
       String mensajeError="";
       String query="";  
       PreparedStatement preparar=null;
       //Se abre una ventana donde se pide cada apartado de la tabla y se guarda en sus respecticas variables.
       String Producto = JOptionPane.showInputDialog(this, "Ingrese el producto: ");
       if(Producto.isEmpty()==true)//Se comprueba si esta vacio o no el campo
       {
           mensajeError=mensajeError+"Producto no puede estar vacio\n";//Si esta vacio se guarda este mensaje de error en la variable
       }
       //Se repite el proceso para cada elemento 
       String Cantidad = JOptionPane.showInputDialog(this, "Ingrese la cantidad: ");
       if(Cantidad.isEmpty()==true)
       {
           mensajeError=mensajeError+"Cantidad no puede estar vacio\n";
       }
       String Codigo = JOptionPane.showInputDialog(this, "Ingrese el codigo: ");
       if(Codigo.isEmpty()==true)
       {
           mensajeError=mensajeError+"El codigo del producto no puede estar vacio\n";
       }
       String Fecha = JOptionPane.showInputDialog(this, "Ingrese la fecha de caducidad: ");
       if(Fecha.isEmpty()==true)
       {
           mensajeError=mensajeError+"Fecha de caducidad del producto no puede estar vacio\n";
       }
       //Si no se guardanada en la variable de error se realiza la accion de guardar los elementos.
       if(mensajeError.isEmpty()==true)
       {
           query="insert into in_productos"
                   + "(Producto, Cantidad, Codigo_Producto, Fecha_Caducidad) values"
                   + "('"+Producto+"','"+Cantidad+"','"+Codigo+"','"+Fecha+"')";
           try{
               preparar=con.prepareStatement(query);
               preparar.execute();
               Cargatabla();
        } catch (Exception e){
          
        }
       }else{
           JOptionPane.showMessageDialog(null, "Produto no ingresado\n\n"+mensajeError);
       }
    }
    
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
            java.util.logging.Logger.getLogger(Tabla_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla_Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarProducto;
    private javax.swing.JButton Editar;
    private javax.swing.JButton JAceptar;
    private javax.swing.JLabel JCantidad;
    private javax.swing.JLabel JCodigo;
    private javax.swing.JLabel JFecha;
    private javax.swing.JLabel JProducto;
    private javax.swing.JTable Tabla_Empleados;
    private javax.swing.JButton advertencia;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel conexion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
