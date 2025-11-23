package Interfaz;

import Business.MotorSIA;
import Data.Estudiante;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {

    private MotorSIA motor;
    private JTextField campoUsuario;
    private JPasswordField campoContrasena;

    public VentanaLogin() {

        motor = new MotorSIA();

        // Ventana principal
        setTitle("SIA 2010 - Inicio de Sesión");
        setSize(900, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ================================
        // ENCABEZADO
        // ================================
        EncabezadoSia encabezado = new EncabezadoSia();
        add(encabezado, BorderLayout.NORTH);

        // ================================
        // PANEL CENTRAL (FONDO GRIS)
        // ================================
        JPanel panelFondo = new JPanel(new GridBagLayout());
        panelFondo.setBackground(new Color(235, 235, 235));
        add(panelFondo, BorderLayout.CENTER);

        // ================================
        // CUADRO ESTILO SIA 2010
        // ================================
        JPanel cuadro = new JPanel();
        cuadro.setLayout(null);
        cuadro.setPreferredSize(new Dimension(380, 300));
        cuadro.setBackground(new Color(255, 242, 202)); // crema SIA
        cuadro.setBorder(BorderFactory.createLineBorder(new Color(210, 180, 60), 2));

        // ================================
        // TÍTULO
        // ================================
        JLabel titulo = new JLabel("INICIE SESIÓN AQUÍ");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(new Color(110, 80, 20));
        titulo.setBounds(20, 10, 250, 25);
        cuadro.add(titulo);

        JLabel flecha = new JLabel("↓");
        flecha.setFont(new Font("Arial", Font.BOLD, 24));
        flecha.setForeground(new Color(180, 140, 40));
        flecha.setBounds(18, 30, 40, 40);
        cuadro.add(flecha);

        // ================================
        // USUARIO
        // ================================
        JLabel labelUsuario = new JLabel("🞂 nombre de usuario");
        labelUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        labelUsuario.setForeground(new Color(100, 80, 30));
        labelUsuario.setBounds(40, 75, 200, 20);
        cuadro.add(labelUsuario);

        campoUsuario = new JTextField();
        campoUsuario.setBounds(40, 95, 300, 30);
        campoUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
        cuadro.add(campoUsuario);

        // ================================
        // CLAVE
        // ================================
        JLabel labelClave = new JLabel("🞂 clave");
        labelClave.setFont(new Font("Arial", Font.PLAIN, 14));
        labelClave.setForeground(new Color(100, 80, 30));
        labelClave.setBounds(40, 135, 200, 20);
        cuadro.add(labelClave);

        campoContrasena = new JPasswordField();
        campoContrasena.setBounds(40, 155, 300, 30);
        campoContrasena.setFont(new Font("Arial", Font.PLAIN, 16));
        cuadro.add(campoContrasena);

        // ================================
        // BOTÓN ESTILO SIA
        // ================================
        JButton botonEntrar = new JButton("iniciar sesión    ✔");
        botonEntrar.setBounds(40, 210, 300, 35);
        botonEntrar.setFont(new Font("Arial", Font.BOLD, 16));
        botonEntrar.setFocusPainted(false);

        botonEntrar.setBackground(new Color(255, 215, 0)); // amarillo intenso
        botonEntrar.setForeground(Color.BLACK);
        botonEntrar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 0, 0), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        botonEntrar.addActionListener(e -> validarLogin());
        cuadro.add(botonEntrar);

        // Añadir cuadro al centro
        panelFondo.add(cuadro);
    }

    // ===============================
    // VALIDAR LOGIN
    // ===============================
    private void validarLogin() {
        String usuario = campoUsuario.getText();
        String pass = new String(campoContrasena.getPassword());

        Estudiante est = motor.iniciarSesion(usuario, pass);

        if (est == null) {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            return;
        }

        JOptionPane.showMessageDialog(this, "Bienvenido " + est.getNombreCompleto());

        VentanaInicio inicio = new VentanaInicio(est, motor);
        inicio.setVisible(true);

        dispose();
    }

    // ===============================
    // MAIN
    // ===============================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaLogin().setVisible(true));
    }
}