
package Data;

public class Usuario {
    
    private String usuario;
    private String contraseña;

    public Usuario(String username, String password) {
        this.usuario = username;
        this.contraseña = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
    
}
