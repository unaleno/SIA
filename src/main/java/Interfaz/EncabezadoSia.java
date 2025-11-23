package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class EncabezadoSia extends JPanel {

    public EncabezadoSia() {

        setLayout(new BorderLayout());

        // ================================
        // Panel superior (franja amarilla)
        // ================================
        JPanel franjaAmarilla = new JPanel(new BorderLayout());
        franjaAmarilla.setPreferredSize(new Dimension(900, 90));
        franjaAmarilla.setBackground(new Color(234, 185, 0)); // Amarillo SIA

        JLabel titulo = new JLabel("  Sistema de Información Académica");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(new Color(80, 50, 0));
        franjaAmarilla.add(titulo, BorderLayout.WEST);

        // ===================================
        // LOGO UNAL DESDE resources/
        // ===================================
        JLabel logoLabel = new JLabel();
        logoLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        try {
            Image logo = ImageIO.read(
                getClass().getResource("/imagenes/logo_unal.png")
            );

            Image logoEscalado = logo.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            logoLabel.setIcon(new ImageIcon(logoEscalado));

        } catch (Exception e) {
            System.out.println("ERROR: No se encontro la imagen logo_unal.png");
            logoLabel.setText("[logo no encontrado]");
        }

        franjaAmarilla.add(logoLabel, BorderLayout.EAST);

        // ================================
        // Panel inferior (barra café)
        // ================================
        JPanel franjaCafe = new JPanel(new FlowLayout(FlowLayout.LEFT));
        franjaCafe.setPreferredSize(new Dimension(900, 25));
        franjaCafe.setBackground(new Color(120, 93, 38));

        JLabel textoBarra = new JLabel("Visitante [ no identificado ]");
        textoBarra.setForeground(Color.WHITE);
        textoBarra.setFont(new Font("Arial", Font.BOLD, 14));

        franjaCafe.add(textoBarra);

        add(franjaAmarilla, BorderLayout.CENTER);
        add(franjaCafe, BorderLayout.SOUTH);
    }
}
