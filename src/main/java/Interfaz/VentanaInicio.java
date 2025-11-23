package Interfaz;

import Business.MotorSIA;
import Data.Estudiante;

import javax.swing.*;
import java.awt.*;

public class VentanaInicio extends JFrame {

    private Estudiante estudiante;
    private MotorSIA motor;

    private JPanel panelContenido;

    public VentanaInicio(Estudiante est, MotorSIA motor) {

        this.estudiante = est;
        this.motor = motor;

        setTitle("SIA - Panel Principal");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ==================================
        // ENCABEZADO
        // ==================================
        add(new EncabezadoSia(), BorderLayout.NORTH);

  
        JPanel menuLateral = crearMenuLateralEstilizado();
        add(menuLateral, BorderLayout.WEST);

        // ==================================
        // PANEL CENTRAL
        // ==================================
        panelContenido = new JPanel(new BorderLayout());
        panelContenido.setBackground(new Color(255, 245, 210));  // amarillo suave

        panelContenido.add(crearPanelBienvenida(), BorderLayout.CENTER);

        add(panelContenido, BorderLayout.CENTER);
    }


    // ======================================================
    // PANEL DE BIENVENIDA (TARJETA EN EL CENTRO)
    // ======================================================
    private JPanel crearPanelBienvenida() {

        JPanel tarjeta = new JPanel();
        tarjeta.setPreferredSize(new Dimension(600, 300));
        tarjeta.setBackground(Color.WHITE);
        tarjeta.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        tarjeta.setLayout(new GridBagLayout());

        JLabel bienvenido = new JLabel("Bienvenido, " + estudiante.getNombreCompleto());
        bienvenido.setFont(new Font("Helvetica", Font.BOLD, 30));
        tarjeta.add(bienvenido);

        JPanel contenedor = new JPanel(new GridBagLayout());
        contenedor.setBackground(new Color(255, 245, 210)); // mismo amarillo que fondo
        contenedor.add(tarjeta);

        return contenedor;
    }


    // ======================================================
    // MENÚ LATERAL ESTILIZADO COMPLETO
    // ======================================================
    private JPanel crearMenuLateralEstilizado() {

        JPanel menu = new JPanel();
        menu.setBackground(new Color(255, 248, 220)); // amarillo muy claro
        menu.setPreferredSize(new Dimension(260, 700));
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

        // Título superior
        JLabel tituloMenu = new JLabel("Navegación estudiante ▼");
        tituloMenu.setFont(new Font("Helvetica", Font.BOLD, 18));
        tituloMenu.setForeground(new Color(90, 60, 20));
        tituloMenu.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 10));
        menu.add(tituloMenu);

        // Íconos por defecto
        Icon icoInicio = UIManager.getIcon("FileView.homeIcon");

        // =============================
        // BOTÓN INICIO (CAFÉ)
        // =============================
        JButton btnInicio = new JButton(" Inicio", icoInicio);
        btnInicio.setFont(new Font("Helvetica", Font.BOLD, 17));
        btnInicio.setBackground(new Color(120, 93, 38)); // café UNAL
        btnInicio.setForeground(Color.WHITE);
        btnInicio.setFocusPainted(false);
        btnInicio.setOpaque(true);
        btnInicio.setBorder(BorderFactory.createEmptyBorder(12, 15, 12, 10));
        btnInicio.setHorizontalAlignment(SwingConstants.LEFT);
        btnInicio.addActionListener(e -> cargarInicio());

        menu.add(btnInicio);
        menu.add(Box.createVerticalStrut(20));

        // =============================
        // SECCIÓN ARCHIVO (+ Archivo)
        // =============================
        JButton btnArchivo = crearBotonCategoria("+ Archivo");
        JPanel subArchivo = crearSubmenuPanel();

        JButton itemHistoria = crearBotonItem("Historia Académica");
        JButton itemDatos = crearBotonItem("Datos Personales");

        subArchivo.add(itemHistoria);
        subArchivo.add(itemDatos);

        btnArchivo.addActionListener(e -> toggle(subArchivo));

        itemHistoria.addActionListener(e -> cargarHistoriaAcademica());
        itemDatos.addActionListener(e -> cargarDatosPersonales());

        // =============================
        // SECCIÓN ZONA DE BÚSQUEDA (+)
        // =============================
        JButton btnZona = crearBotonCategoria("+ Zona de Búsqueda");
        JPanel subZona = crearSubmenuPanel();

        JButton itemBuscar = crearBotonItem("Buscador de cursos");
        subZona.add(itemBuscar);

        btnZona.addActionListener(e -> toggle(subZona));

        itemBuscar.addActionListener(e -> cargarBuscadorCursos());

        // =============================
        // ADD TODO AL MENÚ
        // =============================
        menu.add(btnArchivo);
        menu.add(subArchivo);

        menu.add(Box.createVerticalStrut(20));
        menu.add(btnZona);
        menu.add(subZona);

        return menu;
    }


    // ======================================================
    // ESTILOS MENÚ
    // ======================================================
    private JButton crearBotonCategoria(String nombre) {
        JButton b = new JButton(nombre);
        b.setFont(new Font("Helvetica", Font.BOLD, 17));
        b.setBackground(new Color(255, 236, 179));  // amarillo más fuerte
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 10));
        b.setHorizontalAlignment(SwingConstants.LEFT);
        return b;
    }

    private JPanel crearSubmenuPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(255, 245, 210)); // amarillo suave
        p.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, new Color(220, 220, 220)));
        p.setVisible(false);
        return p;
    }

    private JButton crearBotonItem(String texto) {
        JButton b = new JButton("   • " + texto);
        b.setFont(new Font("Helvetica", Font.PLAIN, 15));
        b.setBackground(new Color(255, 250, 225)); // tono suave
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(8, 25, 8, 10));
        b.setHorizontalAlignment(SwingConstants.LEFT);
        return b;
    }


    private void toggle(JPanel panel) {
        panel.setVisible(!panel.isVisible());
        panel.revalidate();
    }


    // ======================================================
    // CARGA DE PANTALLAS
    // ======================================================
    private void cargarInicio() {
        panelContenido.removeAll();
        panelContenido.add(crearPanelBienvenida(), BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void cargarHistoriaAcademica() {
        cambiarContenido("HISTORIA ACADÉMICA (en desarrollo)");
    }

    private void cargarDatosPersonales() {
        cambiarContenido("DATOS PERSONALES (en desarrollo)");
    }

    private void cargarBuscadorCursos() {
        cambiarContenido("BUSCADOR DE CURSOS (en desarrollo)");
    }

    private void cambiarContenido(String texto) {
        panelContenido.removeAll();

        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setFont(new Font("Helvetica", Font.BOLD, 24));

        panelContenido.add(label, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }

}
