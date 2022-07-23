package com.include;

//Librerias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private static Connection con = null;
    
    //Declarar datos de conexión a la Base de Datos
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://127.0.0.1/db_test";
    private final String user = "root";
    private final String pass = "";
    
    //Metodo que realiza la conexión a la BD
    public Connection getConexion() {
        
        try {
            Class.forName(DRIVER);
            //Conectarse a la BD
            con = (Connection) DriverManager.getConnection (this.url, this.user, this.pass);
            
            if (con != null) { //Si la conexión fue exitosa
                System.out.println("Conexion establecida:");
                }
            }
        catch (ClassNotFoundException | SQLException e) { //Si la conexión falla
            JOptionPane.showMessageDialog(null, "Error:"+e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        
        return con;
        }
    
    }
