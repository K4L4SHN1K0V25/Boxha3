package com.include;

// <editor-fold defaultstate="collapsed" desc="Librerias">       
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
// </editor-fold> 

public class Barcodes {
    private static final double KJOULES = 4.184;
    
    private double toKJ(String kcal) {
        double kJ = Double.parseDouble(kcal) * KJOULES;
        
        return kJ;
    }
    
    //Metodo que genera el documento con los códigos de barras 
    public void getAllProductsPDF() {
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        Image img;
        
        //Establecer la conexion con la BD
        Conexion cn = new Conexion();
        con = cn.getConexion();
        
        try {
            //Acceder a la tabla 'in_ventas'
            ps = con.prepareStatement("select * from nutrimental");
            rs = ps.executeQuery();
            
            //Crear el documento pdf
            Document doc = new Document();
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("codigosProductos.pdf"));
            doc.open(); //Acceder al documento
            
            //Crear un codigo de barras en blanco
            Barcode128 code = new Barcode128();
            
            //Para cada elemento de la columna 'codigo_pro':
            while (rs.next()) {
                //Crear un nuevo producto
                Productos pr = new Productos();
                pr.setNombre(rs.getString("producto"));
                pr.setCodigo(rs.getString("codigo_pro"));
                pr.setProteina(rs.getString("proteina"));
                pr.setGrasa(rs.getString("grasa"));
                pr.setCarbohidratos(rs.getString("h_carbono"));
                pr.setAzucares(rs.getString("azucares"));
                pr.setFibra(rs.getString("fibra"));
                pr.setSodio(rs.getString("sodio"));
                pr.setGluten(rs.getString("gluten"));
                pr.setCalorias(rs.getString("energia"));
                pr.setHumedad(rs.getString("humedad"));
                pr.setCeniza(rs.getString("ceniza"));
                
                //Agregar el nombre del producto al doumento
                doc.add(new Paragraph(pr.getNombre()+":"));
                doc.add(new Paragraph(" ")); //Salto de línea
                //Generar un codigo de barras nuevo de acuerdo al codigo de producto
                code.setCode(pr.getCodigo());
                //Generar la imagen del codigo de barras
                img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);

                //Agregar el codigo de barras al documento
                doc.add(img);
                
                doc.add(new Paragraph(" ")); //Salto de línea
                
                //Crear tabla
                PdfPTable table = new PdfPTable(2);
                table.setWidthPercentage(50);
                PdfPCell space = new PdfPCell(new Phrase(" "));
                space.setBackgroundColor(BaseColor.GRAY);
                space.setHorizontalAlignment(Element.ALIGN_CENTER);
                PdfPCell aport = new PdfPCell(new Phrase("Aportaciones por cada 100g"));
                aport.setBackgroundColor(BaseColor.GRAY);
                aport.setHorizontalAlignment(Element.ALIGN_CENTER);
                PdfPCell element = new PdfPCell(new Phrase("Elemento"));
                element.setBackgroundColor(BaseColor.GRAY);
                element.setHorizontalAlignment(Element.ALIGN_CENTER);
                PdfPCell value = new PdfPCell(new Phrase("Valor"));
                value.setBackgroundColor(BaseColor.GRAY);
                value.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                //Llenar la tabla
                table.addCell(space);
                table.addCell(aport);
                table.addCell(element);
                table.addCell(value);
                
                table.addCell(new Phrase("Contenido energético"));
                table.addCell(pr.getCalorias()+"kcal ("+toKJ(pr.getCalorias())+"kJ)");
                table.addCell(new Phrase("Proteina"));
                table.addCell(pr.getProteina()+"g");
                table.addCell(new Phrase("Grasa"));
                table.addCell(pr.getGrasa()+"g");
                table.addCell(new Phrase("Hidratos de Carbono"));
                table.addCell(pr.getCarbohidratos() + "g");
                table.addCell(new Phrase("Azucares"));
                table.addCell(pr.getAzucares() + "g");
                table.addCell(new Phrase("Fibra"));
                table.addCell(pr.getFibra()+"g");
                table.addCell(new Phrase("Sodio"));
                table.addCell(pr.getSodio()+"g");
                table.addCell(new Phrase("Informacion adicional"));
                table.addCell(pr.getGluten()+"g Gluten");
                
                
                //Agregar la tabla al documento
                doc.add(table);
                
                doc.add(new Paragraph(" ")); //Salto de línea
                doc.add(new Paragraph(" ")); //Salto de línea
                doc.add(new Paragraph(" ")); //Salto de línea
                doc.add(new Paragraph(" ")); //Salto de línea
                }
            
            
            doc.close(); //Cerrar el documento
            
            con.close(); //Terminar la conexion con la DB
            
            JOptionPane.showMessageDialog(null, "Documento generado exitosamente", "PDF", JOptionPane.INFORMATION_MESSAGE);
            }
        //Excepciones
        catch (FileNotFoundException ex) {
            Logger.getLogger(Barcodes.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (DocumentException ex) {
            Logger.getLogger(Barcodes.class.getName()).log(Level.SEVERE, null, ex);
            } 
        catch (SQLException ex) {
            Logger.getLogger(Barcodes.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    
    public void getOneProductPDF(Productos prod) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        Image img;
        
        //Establecer la conexion con la BD
        Conexion cn = new Conexion();
        con = cn.getConexion();
        
        try {
            //Acceder a la tabla 'nutrimental'
            ps = con.prepareStatement("SELECT * FROM nutrimental WHERE id = "+Integer.toString(prod.getId()));
            rs = ps.executeQuery();
            
            //Crear el documento pdf
            Document doc = new Document();
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream(prod.getNombre()+".pdf"));
            doc.open(); //Acceder al documento
            
            //Crear un codigo de barras en blanco
            Barcode128 code = new Barcode128();
            
            //Para cada elemento de la columna 'codigo_pro':
            while (rs.next()) {
                //Crear un nuevo producto
                Productos pr = new Productos();
                pr.setNombre(rs.getString("producto"));
                pr.setCodigo(rs.getString("codigo_pro"));
                pr.setProteina(rs.getString("proteina"));
                pr.setGrasa(rs.getString("grasa"));
                pr.setCarbohidratos(rs.getString("h_carbono"));
                pr.setAzucares(rs.getString("azucares"));
                pr.setFibra(rs.getString("fibra"));
                pr.setSodio(rs.getString("sodio"));
                pr.setGluten(rs.getString("gluten"));
                pr.setCalorias(rs.getString("energia"));
                pr.setHumedad(rs.getString("humedad"));
                pr.setCeniza(rs.getString("ceniza"));
                
                //Agregar el nombre del producto al doumento
                doc.add(new Paragraph(pr.getNombre()+":"));
                doc.add(new Paragraph(" ")); //Salto de línea
                //Generar un codigo de barras nuevo de acuerdo al codigo de producto
                code.setCode(pr.getCodigo());
                //Generar la imagen del codigo de barras
                img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);

                //Agregar el codigo de barras al documento
                doc.add(img);
                
                doc.add(new Paragraph(" ")); //Salto de línea
                
                //Crear tabla
                PdfPTable table = new PdfPTable(2);
                table.setWidthPercentage(50);
                PdfPCell space = new PdfPCell(new Phrase(" "));
                space.setBackgroundColor(BaseColor.GRAY);
                space.setHorizontalAlignment(Element.ALIGN_CENTER);
                PdfPCell aport = new PdfPCell(new Phrase("Aportaciones por cada 100g"));
                aport.setBackgroundColor(BaseColor.GRAY);
                aport.setHorizontalAlignment(Element.ALIGN_CENTER);
                PdfPCell element = new PdfPCell(new Phrase("Elemento"));
                element.setBackgroundColor(BaseColor.GRAY);
                element.setHorizontalAlignment(Element.ALIGN_CENTER);
                PdfPCell value = new PdfPCell(new Phrase("Valor"));
                value.setBackgroundColor(BaseColor.GRAY);
                value.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                //Llenar la tabla
                table.addCell(space);
                table.addCell(aport);
                table.addCell(element);
                table.addCell(value);
                
                table.addCell(new Phrase("Contenido energético"));
                table.addCell(pr.getCalorias()+"kcal ("+toKJ(pr.getCalorias())+"kJ)");
                table.addCell(new Phrase("Proteina"));
                table.addCell(pr.getProteina()+"g");
                table.addCell(new Phrase("Grasa"));
                table.addCell(pr.getGrasa()+"g");
                table.addCell(new Phrase("Hidratos de Carbono"));
                table.addCell(pr.getCarbohidratos() + "g");
                table.addCell(new Phrase("Azucares"));
                table.addCell(pr.getAzucares() + "g");
                table.addCell(new Phrase("Fibra"));
                table.addCell(pr.getFibra()+"g");
                table.addCell(new Phrase("Sodio"));
                table.addCell(pr.getSodio()+"g");
                table.addCell(new Phrase("Informacion adicional"));
                table.addCell(pr.getGluten()+"g Gluten");
                
                //Agregar la tabla al documento
                doc.add(table);
                
                doc.add(new Paragraph(" ")); //Salto de línea
                doc.add(new Paragraph(" ")); //Salto de línea
                doc.add(new Paragraph(" ")); //Salto de línea
                doc.add(new Paragraph(" ")); //Salto de línea
                }
            
            
            doc.close(); //Cerrar el documento
            
            con.close(); //Terminar la conexion con la DB
            
            JOptionPane.showMessageDialog(null, "Documento generado exitosamente", "PDF", JOptionPane.INFORMATION_MESSAGE);
            }
        //Excepciones
        catch (FileNotFoundException ex) {
            Logger.getLogger(Barcodes.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (DocumentException ex) {
            Logger.getLogger(Barcodes.class.getName()).log(Level.SEVERE, null, ex);
            } 
        catch (SQLException ex) {
            Logger.getLogger(Barcodes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public void getInventoryPDF() {
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        Image img;
        
        //Establecer la conexion con la BD
        Conexion cn = new Conexion();
        con = cn.getConexion();
        
        try {
            //Acceder a la tabla 'in_ventas'
            ps = con.prepareStatement("select * from in_ventas");
            rs = ps.executeQuery();
            
            //Crear el documento pdf
            Document doc = new Document();
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("codigosInventario.pdf"));
            doc.open(); //Acceder al documento
            
            //Crear un codigo de barras en blanco
            Barcode128 code = new Barcode128();
            
            //Para cada elemento de la columna 'codigo_pro':
            while (rs.next()) {
                //Agregar el nombre del producto al doumento
                doc.add(new Paragraph(rs.getString("producto")+":"));
                doc.add(new Paragraph(" ")); //Salto de línea
                //Generar un codigo de barras nuevo de acuerdo al codigo de producto
                code.setCode(rs.getString("codigo_pro"));
                //Generar la imagen del codigo de barras
                img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);

                //Agregar el codigo de barras al documento
                doc.add(img);
                
                doc.add(new Paragraph(" ")); //Salto de línea
                }
            
            
            doc.close(); //Cerrar el documento
            
            con.close(); //Terminar la conexion con la DB
            
            JOptionPane.showMessageDialog(null, "Documento generado exitosamente", "PDF", JOptionPane.INFORMATION_MESSAGE);
            }
        //Excepciones
        catch (FileNotFoundException ex) {
            Logger.getLogger(Barcodes.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (DocumentException ex) {
            Logger.getLogger(Barcodes.class.getName()).log(Level.SEVERE, null, ex);
            } 
        catch (SQLException ex) {
            Logger.getLogger(Barcodes.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
