/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G5_CheckIn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class G5_GestionDB {
    
     Conexion con = new Conexion();
    //llamando a la clase conexion 
    Connection cn = con.conectar();
    
    
        public void ejecutar (String mysql){
        try 
        { 
            //Conectamos a la base de datos y le pasamos la sentencia mysql 
            PreparedStatement pps = cn.prepareStatement(mysql);
            //se ejecuta todo lo anterior en mysql.
            pps.executeUpdate(); 
        } 
        catch (Exception e) 
        {
            //Insert code
        }  
    }
      
   public void cargarTabla(DefaultTableModel tblAux, JTable tblTablaCine,String nombreTabla,String[] Titulos,int id){
       
     tblAux.setRowCount(0);
     try {
     PreparedStatement pps = cn.prepareStatement(nombreTabla);    
     ResultSet rs = pps.executeQuery();
         tblAux = (DefaultTableModel) tblTablaCine.getModel();
         Object[] variableTabla = new Object[id];
         while (rs.next()){
             try{
                 for(int i=0;i<id;i++){
                    variableTabla[i]=rs.getObject(Titulos[i]);
                 }
             }catch(SQLException ex){
                     System.out.println("error1");  
             }
             tblAux.addRow(variableTabla);
         }
         tblTablaCine.setModel(tblAux);
     } catch (Exception ex) {
         System.out.println("error2");      
     }
 }
   
   public String obtenerNombreUsuario (String idUsuario){
      try{
          String nombre = "";
            String apellido = "";
            String nombreCompleto = "";
            
            String ingresar="SELECT NOMBRE_USUARIO, APELLIDO_USUARIO FROM USUARIO WHERE ID_USUARIO IN(SELECT ID_USUARIO FROM DEPARTAMENTO_F WHERE NUMERO_DEPARTAMENTO_F ='"+idUsuario+"')";
            
            PreparedStatement pps = cn.prepareStatement(ingresar);
              ResultSet rs = pps.executeQuery();
              while (rs.next()) {
                  nombre = rs.getString("NOMBRE_USUARIO");
                  apellido = rs.getString("APELLIDO_USUARIO");
              }
              
              nombreCompleto = nombre +" "+ apellido;
              //System.out.println(nombreCompleto);
              //nombreCompleto = nombreCompleto.replaceAll("\\s+", " ");
              return nombreCompleto;
        }catch(SQLException e){
            return "error";
        }
    }
   
   public boolean validarUsuario (String idUsuario){
        try{
            
            String query="Select NUMERO_DEPARTAMENTO_F from DEPARTAMENTO_F WHERE NUMERO_DEPARTAMENTO_F ='"+idUsuario+"'";
            PreparedStatement pps = cn.prepareStatement(query);
            ResultSet rs = pps.executeQuery();
          //  System.out.println(rs.next());
            return rs.next();
            //si existe el cliente  nos devuelve verdadero y si  no falso ,lo utilizaremos para ingresar en el login ,deja pasar a la cartelera
        }catch(SQLException e){
            return false;
        }
    }
   public String getUsuario (String idUsuario){
        try{
            String id="";
            String query="SELECT ID_USUARIO FROM DEPARTAMENTO_F WHERE NUMERO_DEPARTAMENTO_F ='"+idUsuario+"'";
            PreparedStatement pps = cn.prepareStatement(query);
            ResultSet rs = pps.executeQuery();
            while (rs.next()) {
                  id = rs.getString("ID_USUARIO");
              }
           // System.out.println(id);
            return id;
            //si existe el cliente  nos devuelve verdadero y si  no falso ,lo utilizaremos para ingresar en el login ,deja pasar a la cartelera
        }catch(SQLException e){
            return "no existe";
        }
    }
}
