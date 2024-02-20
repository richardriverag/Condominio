
package G6_Comunicacion;

import condominio.Conexion;
import G6_Comunicacion.Comunicado;
import G6_Comunicacion.Principal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fredd
 */
public class consultas {
    
    public static void consultaAdministrador() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Paso 1: Crea la conexión
            connection = Conexion.getCon();

            // Paso 2: Crea el statement
            statement = connection.createStatement();

            // Paso 3: Ejecuta la consulta SQL
            resultSet = statement.executeQuery("SELECT * FROM Administrador");

            // Paso 4: Procesa los resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_Administrador");
                String nombre = resultSet.getString("Nombre_Administrador");
                String apellido = resultSet.getString("Apellido_Administrador");
                String telefono = resultSet.getString("Telefono_Administrador");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Teléfono: " + telefono);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Paso 5: Cierra la conexión y los recursos
            cerrarRecursos(connection, statement, resultSet);
        }
    }
    
    public static void consultaAnunciosGenerales() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Paso 1: Crea la conexión
            connection = Conexion.getCon();

            // Paso 2: Crea el statement
            statement = connection.createStatement();

            // Paso 3: Ejecuta la consulta SQL
            resultSet = statement.executeQuery("SELECT * FROM Anuncios_Generales");

            // Paso 4: Procesa los resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_AnunciosGenerales");
                int idAdministrador = resultSet.getInt("ID_Administrador");
                int idUsuario = resultSet.getInt("ID_Usuario");
                Date fecha = resultSet.getDate("Fecha_Anuncio");
                String titulo = resultSet.getString("Titulo_Anuncio");
                String descripcion = resultSet.getString("Descripcion_Anuncio");

                System.out.println("ID: " + id + ", ID Administrador: " + idAdministrador + ", ID Usuario: " + idUsuario +
                        ", Fecha: " + fecha + ", Título: " + titulo + ", Descripción: " + descripcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Paso 5: Cierra la conexión y los recursos
            cerrarRecursos(connection, statement, resultSet);
        }
    }

    public static void consultaComunicado() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Paso 1: Crea la conexión
            connection = Conexion.getCon();

            // Paso 2: Crea el statement
            statement = connection.createStatement();

            // Paso 3: Ejecuta la consulta SQL
            resultSet = statement.executeQuery("SELECT * FROM Comunicado");

            // Paso 4: Procesa los resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_Comunicado");
                int idAdministrador = resultSet.getInt("ID_Administrador");
                int idUsuario = resultSet.getInt("ID_Usuario");
                Date fecha = resultSet.getDate("Fecha_Comunicado");
                String titulo = resultSet.getString("Titulo_Comunicado");
                String descripcion = resultSet.getString("Descripcion_Comunicado");

                System.out.println("ID: " + id + ", ID Administrador: " + idAdministrador + ", ID Usuario: " + idUsuario +
                        ", Fecha: " + fecha + ", Título: " + titulo + ", Descripción: " + descripcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Paso 5: Cierra la conexión y los recursos
            cerrarRecursos(connection, statement, resultSet);
        }
    }
    
    public static void consultaAnunciosGeneralesGUI() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Paso 1: Crea la conexión
            connection = Conexion.getCon();

            // Paso 2: Crea el statement
            statement = connection.createStatement();

            // Paso 3: Ejecuta la consulta SQL
            resultSet = statement.executeQuery("SELECT * FROM Anuncios_Generales");

            // Paso 4: Procesa los resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_AnunciosGenerales");
                int idAdministrador = resultSet.getInt("ID_Administrador");
                int idUsuario = resultSet.getInt("ID_Usuario");
                Date fecha = resultSet.getDate("Fecha_Anuncio");
                String titulo = resultSet.getString("Titulo_Anuncio");
                String descripcion = resultSet.getString("Descripcion_Anuncio");

                String texto = "ID: " + id + "\nID Administrador: " + idAdministrador + "\nID Usuario: " + idUsuario +
                "\nFecha: " + fecha + "\nTítulo: " + titulo + "\nDescripción: " + descripcion + "\n";

                Principal.jTAnuncio1.append(texto + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Paso 5: Cierra la conexión y los recursos
            cerrarRecursos(connection, statement, resultSet);
        }
        
        
        
        
    }
    
    public static void consultaComunicadoGUI() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String []datos= new String[20];
        
        //generacion de la tabla comunicado
        DefaultTableModel tcomunicado = new DefaultTableModel();
        tcomunicado.addColumn("ID_Comunicado");
        tcomunicado.addColumn("ID_Administrador");
        tcomunicado.addColumn("ID_Usuario");
        tcomunicado.addColumn("Fecha");
        tcomunicado.addColumn("Titulo");
        tcomunicado.addColumn("Descripcion");

        Comunicado.jTable2.setModel(tcomunicado);
        
        
        try {
            // Paso 1: Crea la conexión
            connection = Conexion.getCon();

            // Paso 2: Crea el statement
            statement = connection.createStatement();

            // Paso 3: Ejecuta la consulta SQL
            resultSet = statement.executeQuery("SELECT * FROM Comunicado");

            // Paso 4: Procesa los resultados
            while (resultSet.next()) {
                datos[0] = resultSet.getString(1);
                datos[1] = resultSet.getString(2);
                datos[2] = resultSet.getString(3);
                datos[3] = resultSet.getString(4);
                datos[4] = resultSet.getString(5);
                datos[5] = resultSet.getString(6);
                tcomunicado.addRow(datos);
            }
            Comunicado.jTable2.setModel(tcomunicado);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Paso 5: Cierra la conexión y los recursos
            cerrarRecursos(connection, statement, resultSet);
        }
        
    }
    
    public static void consultaAnunciosGeneralesGUITabla() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String []datos= new String[20];
        
        //generacion de la tabla comunicado
        DefaultTableModel tanuncio = new DefaultTableModel();
        tanuncio.addColumn("ID_AnunciosGenerales");
        tanuncio.addColumn("ID_Administrador");
        tanuncio.addColumn("ID_Usuario");
        tanuncio.addColumn("Fecha");
        tanuncio.addColumn("Titulo");
        tanuncio.addColumn("Descripcion");

        Anuncios.jTAnuncio.setModel(tanuncio);
        
        
        try {
            // Paso 1: Crea la conexión
            connection = Conexion.getCon();

            // Paso 2: Crea el statement
            statement = connection.createStatement();

            // Paso 3: Ejecuta la consulta SQL
            resultSet = statement.executeQuery("SELECT * FROM Anuncios_Generales");

            // Paso 4: Procesa los resultados
            while (resultSet.next()) {
                datos[0] = resultSet.getString(1);
                datos[1] = resultSet.getString(2);
                datos[2] = resultSet.getString(3);
                datos[3] = resultSet.getString(4);
                datos[4] = resultSet.getString(5);
                datos[5] = resultSet.getString(6);
                tanuncio.addRow(datos);
            }
            Anuncios.jTAnuncio.setModel(tanuncio);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Paso 5: Cierra la conexión y los recursos
            cerrarRecursos(connection, statement, resultSet);
        }
    }
    public static void cerrarRecursos(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
}


