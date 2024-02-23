
package G1_Finanzas;

import java.sql.*;
import javax.swing.JOptionPane;
public class ConexionGrupo1 {

        Connection con;

        // Funcion que va conectarse a mi base de datos de mysql 
        public Connection conectar(){
        // Reseteamos a null la conexion a la bd
        con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Nos conectamos a la base de datos
            
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/condominio1?serverTimezone=UTC", "root", "P@ssw0rd");
            if(con !=null){
               // JOptionPane.showMessageDialog(null, "Conexion existosa", "alert", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Conexion NO    existosa", "alert", JOptionPane.ERROR_MESSAGE);
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
    
