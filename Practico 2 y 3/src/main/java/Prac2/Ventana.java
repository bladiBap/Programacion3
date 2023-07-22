package Prac2;

//import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ventana extends JFrame implements MouseListener {

    //private static final Logger logger = Logger.getRootLogger();
    private Panel panel;
    private Arbol arbol;

    public Ventana() {
        setTitle("Practico 2 Fractales");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        cargarElementos();
    }

    private void cargarElementos() {

        panel = new Panel();
        panel.addMouseListener(this);
        this.add(panel);
        //panel.setBackground(Color.orange);


    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //verificacion(e.getY(), e.getX());
        if (e.getY() <= panel.getAnchoCielo()) {
            JOptionPane.showMessageDialog(null, "No se puede crear un arbol en el cielo");
            return;
        } else {
            int desplazamiento = definirDesplazamiento(e.getY());
            int altura = alturaTronco(e.getY());
            //logger.info("La Posicision en X: " + e.getX() + " y Posicion en Y: " + e.getY() + " es valida");
            arbol = new Arbol(e.getX(), e.getY(), e.getX(), e.getY() - altura, 15, 8, desplazamiento, 0);
            panel.addLista(arbol);
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /*
        public void verificacion(int y, int x) {

            if (y <= panel.getAnchoCielo()) {
                JOptionPane.showMessageDialog(null, "No se puede crear un arbol en el cielo");
                return;
            }
            logger.info("La Posicision en X: " + x + " y Posicion en Y: " + y + " es valida");
        }
        ">" y "<"

     */
    public int definirDesplazamiento(int posy) {
        if (posy >= 500) {
            return 100;   //90
        } else {
            if (posy >= 400 && posy < 500) {
                return 90;  //80
            } else {
                if (posy >= 300 && posy < 400) {
                    return 80;  //70
                } else {
                    return 50;  //60
                }
            }
        }
    }

    public int alturaTronco (int posy){
        if (posy >= 500) {
            return 100;
        } else {
            if (posy >= 400 && posy < 500) {
                return 85;
            } else {
                if (posy >= 300 && posy < 400) {
                    return 70;
                } else {
                    return 55;
                }
            }
        }
    }
}



