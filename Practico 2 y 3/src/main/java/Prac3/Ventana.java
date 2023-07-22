package Prac3;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Ventana extends JFrame {


    private Imagen modelo;
    private PanelImagen panelImg;
    public Ventana (){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension (600,400));
        setLocationRelativeTo(null);
        setTitle("Practico 3");
        cargarComponentes();
        setVisible(true);
    }

    public void cargarComponentes (){
        //modelo = new Imagen(600,400);
        panelImg = new PanelImagen(modelo);
        this.add(panelImg);

        JMenuBar bar = new JMenuBar();
        this.setJMenuBar(bar);

        JMenu menu = new JMenu("Buscador");
        bar.add(menu);

        JMenuItem item = new JMenuItem("Cargar Imagen");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menuArchivo_cargarImagen();
            }
        });
        menu.add(item);

    }

    protected void menuArchivo_cargarImagen() {
        //modelo.leerDeArchivo("D:\\Criptos\\CriptoGodFather Collection\\01_04_07.png");
        JFileChooser fileChooser = new JFileChooser();
        int respuesta = fileChooser.showOpenDialog(null);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            this.modelo = new Imagen(fileChooser.getSelectedFile().getPath());
            panelImg.setMiImagen(modelo);
        }


    }
    public Imagen getModelo() {
        return modelo;
    }

    public void setModelo(Imagen modelo) {
        this.modelo = modelo;
    }


}
