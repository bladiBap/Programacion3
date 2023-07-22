package Prac3;

//import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelImagen extends JPanel implements MouseListener, PropertyChangeListener {

    //private static final org.apache.log4j.Logger logger = Logger.getRootLogger();

    private Imagen MiImagen;
    private int posx1;
    private int posy1;
    private int posx2;
    private int posy2;


    public PanelImagen( Imagen imagen) {
        MiImagen = imagen;
        this.addMouseListener(this);

    }
    @Override
    public Dimension getPreferredSize() {

        return new Dimension(600,600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (MiImagen == null) {
            return;
        }

        BufferedImage rsm = new BufferedImage(
                MiImagen.getAncho(), MiImagen.getAlto(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rsm.createGraphics();

        MiImagen.dibujar(g2d);
        g.drawImage(rsm, 0, 0, null);
    }


    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getX() + " ------ " + e.getY());
        this.posx1 = e.getX();
        this.posy1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println(e.getX() + " ------ " + e.getY());
        if (e.getX() > this.getWidth() || e.getX() < 0) {
            JOptionPane.showMessageDialog(null, "Esta a fuera");
        } else {
            if (e.getY() > this.getHeight() || e.getY() < 0) {
                JOptionPane.showMessageDialog(null, "Esta a fuera");
            }
        }

        if (e.getX() <= this.getWidth() && e.getX() >=0 ) {
            if (e.getY() >= 0 && e.getY() <= this.getHeight()) {
                this.posx2 = e.getX();
                this.posy2 = e.getY();
                this.repaint();
                ordenarPuntos(posx1, posy1,posx2,posy2);
                //logger.info("Las posiciones para punto 1: "+posx1+" " +posy1+"   posicion para el punto2:  "+posx2+" "+posy2);
                VentanaEmergente v2 = new VentanaEmergente(MiImagen,posx1, posy1,posx2,posy2);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public Imagen getMiImagen() {
        return MiImagen;
    }

    public void setMiImagen(Imagen miImagen) {
        MiImagen = miImagen;
        MiImagen.addObserver(this);
        //MiImagen.leerDeArchivo();
        repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() != "IMAGEN") {
            return;
        }
        repaint();
    }

    public void ordenarPuntos (int x1, int y1,int x2,int y2){
        if (x1<x2 && y1 < y2){
            this.posx1 = x1;
            this.posy1 = y1;
            this.posx2 = x2;
            this.posy2 = y2;
            return;
        }
        if (x1>x2 && y1 > y2){
            this.posx1 = x2;
            this.posy1 = y2;
            this.posx2 = x1;
            this.posy2 = y1;
            return;
        }
        if (x1>x2 && y1 < y2){
            this.posx1 = x2;
            this.posy1 = y1;
            this.posx2 = x1;
            this.posy2 = y2;
            return;
        }
        if (x1<x2 && y1 > y2){
            this.posx1 = x1;
            this.posy1 = y2;
            this.posx2 = x2;
            this.posy2 = y1;
            return;
        }
    }
}
