
package G1_Finanzas;

import static java.awt.image.ImageObserver.HEIGHT;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Metodo_ValidacionDatos {
    
    // Métodos de validación

    public static boolean validarCamposIngreso(JTextField codigoUsuario, JTextField valorRegistro, JRadioButton rbExtraordinario, JRadioButton rbOrdinario) {
        // Verificar que ningún campo esté vacío
        if (!validarCampoNoVacio(codigoUsuario, "Campo de código de usuario vacío, verificar") ||
            !validarCampoNoVacio(valorRegistro, "Campo de valor de registro vacío, verificar")) {
            return false;
        }

        // Verificar que el código de usuario comience con las letras "USR" seguido de números
        if (!validarCodigoUsuario(codigoUsuario.getText().trim())) {
            showMessage("El código de usuario no cumple con el formato esperado (USR seguido de números).");
            return false;
        }

        // Verificar que el campo de valores solo contenga números
        if (!validarNumeros(valorRegistro.getText().trim())) {
            showMessage("El campo de valores solo debe contener números.");
            return false;
        }

        // Verificar que al menos un tipo de ingreso/egreso esté seleccionado
        if (!rbExtraordinario.isSelected() && !rbOrdinario.isSelected()) {
            showMessage("Por favor, selecciona Extraordinario o Ordinario.");
            return false;
        }

        return true;
    }
    public static boolean validarCamposEgreso(JTextField codigoUsuario, JTextField valorRegistro) {
        // Verificar que ningún campo esté vacío
        if (!validarCampoNoVacio(codigoUsuario, "Campo de código de usuario vacío, verificar") ||
            !validarCampoNoVacio(valorRegistro, "Campo de valor de registro vacío, verificar")) {
            return false;
        }

        // Verificar que el código de usuario comience con las letras "USR" seguido de números
        // como manejan los registros de los egresos // 
        if (!validarCodigoUsuarioEgresos(codigoUsuario.getText().trim())) {
            showMessage("El código de usuario no cumple con el formato esperado (USR seguido de números).");
            return false;
        }

        // Verificar que el campo de valores solo contenga números
        if (!validarNumeros(valorRegistro.getText().trim())) {
            showMessage("El campo de valores solo debe contener números.");
            return false;
        }

     

        return true;
    }
        
    

    // Método para mostrar el mensaje de error
    private static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", HEIGHT);
    }

    // Métodos de validación adicionales
    public static boolean validarCodigoUsuario(String codigoUsuario) {
        return codigoUsuario.matches("^USR\\d+$");
    }
    public static boolean validarCodigoUsuarioEgresos(String codigoUsuario) {
        return codigoUsuario.matches("^USR\\d+$");
    }
 
    public static boolean validarNumeros(String datos) {
        return datos.matches("[0-9]*");
    } 

    public static boolean validarCampoNoVacio(JTextField campo, String mensajeError) {
        if (campo.getText().isEmpty()) {
            showMessage(mensajeError);
            return false;
        }
        return true;
    }
    
    //----------------- Validacion Filtros 
    
    public static boolean validarDatosFiltro(JRadioButton jRFiltrarCondominio, JRadioButton jRBFiltrarUnidad, JRadioButton jRBFiltrarExtraordinarios, JRadioButton jRBFiltrarOrdinariosYExtraordinarios) {

        // Verificar que al menos un tipo de ingreso/egreso esté seleccionado
        if (!jRFiltrarCondominio.isSelected() && !jRBFiltrarUnidad.isSelected()&& !jRBFiltrarExtraordinarios.isSelected() && !jRBFiltrarOrdinariosYExtraordinarios.isSelected()) {
            showMessage("Por favor, seleccione una de las opciones mostradas.");
            return false;
        }

        return true;
    }
    

}