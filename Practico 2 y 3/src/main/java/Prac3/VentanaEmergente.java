package Prac3;

//import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEmergente extends JFrame implements ActionListener {
    //private static final org.apache.log4j.Logger logger = Logger.getRootLogger();
    private Imagen modelo;
    private int posx1;
    private int posy1;
    private int posx2;
    private int posy2;


    private JButton pixelado = new JButton("Pixelado");
    private JButton suavizado = new JButton("Suavizado");
    private JButton espejoH = new JButton("Espejo Horizontal");
    private JButton tonosGris = new JButton("Tono de Gris");
    private JButton tonosRojos = new JButton("Tonos Rojos");
    private JButton tonosVerde = new JButton("Tonos Verdes");

    public VentanaEmergente (Imagen imagen,int x1, int y1,int x2,int y2){
        this.posx1 = x1;
        this.posy1 = y1;
        this.posx2 = x2;
        this.posy2 = y2;

        this.modelo = imagen;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(400,400));
        setLocationRelativeTo(null);
        setTitle("Efectos");
        cargarBotones();
        setVisible(true);
    }

    public void cargarBotones (){

        this.setLayout(null);
        pixelado.addActionListener(this);
        suavizado.addActionListener(this);
        espejoH.addActionListener(this);
        tonosGris.addActionListener(this);
        tonosRojos.addActionListener(this);
        tonosVerde.addActionListener(this);

        pixelado.setBounds(130,30,120,30);
        suavizado.setBounds(130,75,120,30);
        espejoH.setBounds(120,115,140,30);
        tonosGris.setBounds(130,155,120,30);
        tonosRojos.setBounds(130,195,120,30);
        tonosVerde.setBounds(130,230,120,30);

        this.add(pixelado);
        this.add(suavizado);
        this.add(espejoH);
        this.add(tonosGris);
        this.add(tonosRojos);
        this.add(tonosVerde);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(pixelado)){
            ConvertirPixel cov = new ConvertirPixel(modelo);
            cov.transformar(posx1, posy1,posx2,posy2);
            System.out.println(1);
            this.dispose();
        }
        if (e.getSource().equals(suavizado)){
            System.out.println(2);
            this.dispose();
        }
        if (e.getSource().equals(espejoH)){
            System.out.println(3);
            ConvertirRotarHorizontal cov = new ConvertirRotarHorizontal(modelo);
            cov.transformar(posx1, posy1,posx2,posy2);
            this.dispose();
        }
        if (e.getSource().equals(tonosGris)){
            System.out.println(4);

            ConvertirGris cov = new ConvertirGris(modelo);
            cov.transformar(posx1, posy1,posx2,posy2);
            this.dispose();
        }
        if (e.getSource().equals(tonosRojos)){
            System.out.println(5);
            ConvertirRojo cov = new ConvertirRojo(modelo);
            cov.transformar(posx1, posy1,posx2,posy2);
            this.dispose();
        }
        if (e.getSource().equals(tonosVerde)){
            System.out.println(5);
            ConvertirVerde cov = new ConvertirVerde(modelo);
            cov.transformar(posx1, posy1,posx2,posy2);
            this.dispose();
        }
    }
}
