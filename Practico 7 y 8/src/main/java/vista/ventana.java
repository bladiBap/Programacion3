package vista;

import javax.swing.*;
import java.awt.*;

public class ventana extends JFrame {

    private JLabel imagenLogo = new JLabel();

    private ventanaAgregar ventanaAgregar;
    private ventanaVer ventanaVer;

    private JButton botonAgregar = new JButton("Agregar");

    private JButton botonVer = new JButton("Ver Lista");

    private JButton botonActualizar = new JButton();


    public ventana (){
        setTitle("Practico7");
        setSize(500,400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);
        cargarComponentes();
    }

    public void cargarComponentes () {
        setLayout(null);
        botonAgregar.setBounds(100, 230, 100, 40);
        botonVer.setBounds(260, 230, 120, 40);

        botonAgregar.addActionListener(e -> {
            ventanaAgregar = new ventanaAgregar();
            this.dispose();
        });

        botonVer.addActionListener(e -> {
            ventanaVer = new ventanaVer();
            this.dispose();
        });

        ImageIcon logo = new ImageIcon("foto.png");
        imagenLogo.setBounds(170, 50,150,150);

        Icon aux = new ImageIcon(logo.getImage().getScaledInstance(imagenLogo.getWidth(),imagenLogo.getHeight(), Image.SCALE_DEFAULT));
        imagenLogo.setIcon(aux);

        add(botonAgregar);
        add(botonVer);
        add(imagenLogo);
        this.repaint();
    }

}
