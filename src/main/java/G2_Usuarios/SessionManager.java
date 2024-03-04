/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G2_Usuarios;

/**
 *
 * @author gilso
 */
public class SessionManager {
    private static String usuario;
    private static String contrasenia;

    public static void iniciarSesion(String usuario, String contrasenia) {
        SessionManager.usuario = usuario;
        SessionManager.contrasenia = contrasenia;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static String getContrasenia() {
        return contrasenia;
    }
}
