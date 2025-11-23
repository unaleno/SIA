
package Interfaz;

import javax.swing.SwingUtilities;

public class ConsolaSIA {

    public static void main(String[] args) { 
    
        SwingUtilities.invokeLater(() -> {
            VentanaLogin login = new VentanaLogin();
            login.setVisible(true);
        });
   
    }
}