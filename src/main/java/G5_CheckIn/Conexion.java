/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G5_CheckIn;

/**
 *
 * @author Usuario
 */
import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion {

        Connection con;

        // Funcion que va conectarse a mi base de datos de mysql 
        public Connection conectar(){
        // Reseteamos a null la conexion a la bd
        con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Nos conectamos a la base de datos
            
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/condominio?serverTimezone=UTC", "root", "Hidalgo.2212");
            if(con !=null){
               // JOptionPane.showMessageDialog(null, "Conexion existosa", "alert", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Conexion NO existosa", "alert", JOptionPane.ERROR_MESSAGE);
            }
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "alert", JOptionPane.ERROR_MESSAGE);
        }
        return con;
        }
        

        
    }
    