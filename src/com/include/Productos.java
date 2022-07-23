package com.include;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.JOptionPane;

//Clase que obtiene los datos de la BD
public class Productos {

    private int id;
    private String proteina;
    private String grasa;
    private String carbohidratos;
    private String azucares;
    private String fibra;
    private String sodio;
    private String gluten;
    private String calorias;
    private String humedad;
    private String ceniza;
    private String nombre;
    private String codigo;

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public int getId() {
        return id;
        }

    public void setId(int id) {
        this.id = id;
        }

    public String getProteina() {
        return proteina;
        }

    public void setProteina(String proteina) {
        this.proteina = proteina;
        }

    public String getGrasa() {
        return grasa;
        }

    public void setGrasa(String grasa) {
        this.grasa = grasa;
        }

    public String getCarbohidratos() {
        return carbohidratos;
        }

    public void setCarbohidratos(String carbohidratos) {
        this.carbohidratos = carbohidratos;
        }

    public String getAzucares() {
        return azucares;
        }

    public void setAzucares(String azucares) {
        this.azucares = azucares;
        }

    public String getFibra() {
        return fibra;
        }

    public void setFibra(String fibra) {
        this.fibra = fibra;
        }

    public String getSodio() {
        return sodio;
        }

    public void setSodio(String sodio) {
        this.sodio = sodio;
        }

    public String getGluten() {
        return gluten;
        }

    public void setGluten(String gluten) {
        this.gluten = gluten;
        }

    public String getCalorias() {
        return calorias;
        }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
        }

    public String getHumedad() {
        return humedad;
        }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
        }

    public String getCeniza() {
        return ceniza;
        }

    public void setCeniza(String ceniza) {
        this.ceniza = ceniza;
        }

    public String getNombre() {
        return nombre;
        }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        }

    public String toString() {
        return this.nombre;
        }

    public String getCodigo() {
        return codigo;
        }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        }
    // </editor-fold> 
    
    //Metodo que obtiene el id y el nombre de los productos (para rellenar el ComboBox)
    public Vector<Productos> showProductos() {
        //Conectarse a la BD
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        
        Vector<Productos> datos = new Vector<Productos>();
        Productos prod = null;
        
        try {
            //Acceder a la tabla
            String query = "SELECT * FROM nutrimental";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            //Primera opcion del ComboBox (se muestra por default / no seleccionable)
            prod = new Productos();
            prod.setId(0);
            prod.setNombre("Seleccione producto");
            prod.setCodigo(null);
            datos.add(prod);
            
            //Opciones del ComboBox (seleccionables)
            while (rs.next()) {
                prod = new Productos();
                prod.setId(rs.getInt("id"));
                prod.setNombre(rs.getString("producto"));
                prod.setCodigo(rs.getString("codigo_pro"));
                datos.add(prod);
                }
            
            //Terminar la conexion con la BD
            rs.close();
            } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:"+ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        
        return datos;
        }
}
