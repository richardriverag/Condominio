/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package G2_Usuarios;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author JoisH
 */
public class ValidarLogin {
    private String nombreUsuario;
    private String ci;
    private String pin;
    private String contraseña;
    
    public ValidarLogin(String nombreUsuario , String ci, String pin, String contraseñaInicial){
        this.nombreUsuario = nombreUsuario;
        this.ci = ci;
        this.pin = pin;
        this.contraseña = contraseñaInicial;
    }
    
    public void cambiarContraseña(String nuevaContraseña) {
        this.contraseña = nuevaContraseña;
    }
    
    public boolean resetearContraseña(String nombreUsuarioInput, String ciInput, String pinInput, String nuevaContraseña) {
        if (nombreUsuarioInput.equals(nombreUsuario) && ciInput.equals(ci) && pinInput.equals(pin)) {
            this.contraseña = nuevaContraseña;
            return true; // Cambio de contraseña exitoso
        } else {
            return false; // No coinciden los datos, no se realiza el cambio de contraseña
        }
    }

    public String obtenerContraseña() {
        return this.contraseña;
    }
    
    public void validateUserName(JTextField textLabel) {
    // Obtener el texto del JLabel
    String text = textLabel.getText();

    // Validar que el texto sea una cadena alfanumérica de hasta 20 caracteres
    boolean isValid = text.matches("^[a-zA-Z0-9]{1,20}$");

    // Mostrar el resultado de la validación en el JLabel
    if (isValid) {
        JOptionPane.showMessageDialog(null, "Usuario válido", "Validación", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "Usuario inválido", "Validación", JOptionPane.WARNING_MESSAGE);
    }
     
}
   
    

    public void PasswordStrengthVerifier(JTextField passwordField, JLabel resultField) {
        
       passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                verifyPasswordStrength(passwordField.getText(),  resultField);
            }
        });

    }
    
    
    private void verifyPasswordStrength(String password,  JLabel resultField) {
        if (isStrongPassword(password)) {
            resultField.setText("¡Excelente contraseña!");
            resultField.setForeground(java.awt.Color.green);//color de letras
        } else if (isMediumPassword(password)) {
            resultField.setText("*Contraseña media: Debe tener 12+caracteres especiales ");
            resultField.setForeground(java.awt.Color.red);//color de letras
        } else if (isWeakPassword(password)){
            resultField.setText("*Contraseña débil: Fácil de adivinar");
            resultField.setForeground(java.awt.Color.red);//color de letras
        }
    }

 private boolean isStrongPassword(String password) {
    // Check if the password is at least 8 characters long.
    if (password.length() < 12) {
        return false;
    }

    // Check if the password contains at least one uppercase letter.
    if (!password.matches(".*[A-Z].*")) {
        return false;
    }

    // Check if the password contains at least one lowercase letter.
    if (!password.matches(".*[a-z].*")) {
        return false;
    }

    // Check if the password contains at least one number.
    if (!password.matches(".*\\d.*")) {
        return false;
    }

    // Check if the password contains at least one special character.
    if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
        return false;
    }

    // The password is strong.
    return true;
}

    

    private boolean isMediumPassword(String password) {
       return password.length() >= 8 && password.length() <= 12 &&
            password.matches(".*\\d.*") &&
            password.matches(".*[a-zA-Z].*");
    }

private boolean isWeakPassword(String password) {
    // Check if the password is longer than 1 character.
    if (password.length() <= 1) {
        return false;
    }

    // Check if the password contains only letters and digits.
    if (!password.matches("[a-zA-Z0-9]+")) {
        return false;
    }

    // The password is weak.
    return true;
}



    
   
    public static boolean validateCedula(String cedula) {
    // Verificar que la cédula tenga 10 dígitos
    if (cedula.length() != 10) {
        return false;
    }
    
    // Verificar que los primeros dos dígitos sean válidos
    int provincia = Integer.parseInt(cedula.substring(0, 2));
    if (provincia < 1 || provincia > 24) {
        return false;
    }
    
    // Verificar el último dígito de la cédula (dígito verificador)
    int verificador = Integer.parseInt(cedula.substring(9));
    int suma = 0;
    for (int i = 0; i < 9; i++) {
        int digito = Integer.parseInt(cedula.substring(i, i + 1));
        if (i % 2 == 0) {
            digito *= 2;
            if (digito > 9) {
                digito -= 9;
            }
        }
        suma += digito;
    }
    int residuo = suma % 10;
    int resultado;
    if (residuo == 0) {
        resultado = 0;
    } else {
        resultado = 10 - residuo;
    }
    if (resultado != verificador) {
        return false;
    }
    
    return true;
}
    
    
}
