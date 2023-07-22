package Prac2;

//import org.apache.log4j.Logger;
import java.awt.*;

public class Arbol {

    private int posx1;
    private int posy1;
    private int posx2;
    private int posy2;
    private int ancho;
    private int complegidad;
    private int desplazamiento;
    private int inicioColor;

    //private static final Logger logger = Logger.getRootLogger();
    private Color[] colors = {
            new Color(96, 48, 0),
            new Color(142, 71, 0),
            new Color(159, 108, 23),
            new Color(155, 163, 20),
            new Color(65, 157, 26),
            new Color(35, 86, 14)
    };
    //private double desplaParaX = 0.85 ;
    //private double desplaParay = 0.7;
    //private double desplazamiento2x = 1.15 ;
    //private double desplazamiento2y = 0.7 ;
    //private int desplazamiento = 75;


    public Arbol(int posx1, int posy1, int posx2, int posy2, int ancho, int complegidad, int desplazamiento, int inicioColor) {
        this.posx1 = posx1;
        this.posy1 = posy1;
        this.posx2 = posx2;
        this.posy2 = posy2;
        this.ancho = ancho;
        this.complegidad = complegidad;
        this.desplazamiento = desplazamiento;
        this.inicioColor = inicioColor;

    }

    public void dibujarArbol(int inicioColor, int ancho, int desplazamiento, int posx, int posy, int posx2, int posy2, int complegidad, Graphics g) {


        int tamaño = (int) Math.sqrt(Math.pow((posx2 - posx), 2) + Math.pow((posy2 - posy), 2));
        if (complegidad <= 0) {
            return;
        }

        BasicStroke str = new BasicStroke(ancho);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(colors[inicioColor]);
        inicioColor = inicioColor + 1;
        g2.setStroke(str);
        if (inicioColor > 5) {
            inicioColor = 5;
        }

        //logger.info("posicion x1: " + posx + " posicion y1: " + posy + " ---- " + " posicion x2: " + posx2 + " posicion y2: " + posy2 + "  -----  " + " Con un tamaño de: " + tamaño+" Con una anchura de: "+ancho+"--- Con un desplazamiento de: "+desplazamiento);
        g2.drawLine(posx, posy, posx2, posy2);

        //int finalx = (int)(posx2*desplaParaX);
        //int finaly = (int)(posy2*desplaParay);
        int finalx = posx2 - desplazamiento+35 ; //35
        int finaly = posy2 - desplazamiento+25 ; //25
        int nuevoDesplazamiento = desplazamiento - 10;
        int nuevaAnchura = ancho - 2;

        if (nuevaAnchura <= 2 ) {
            nuevaAnchura = 1;
        }
        if (nuevoDesplazamiento <= 30 ) {
            nuevoDesplazamiento = 30;
        }




        dibujarArbol(inicioColor, nuevaAnchura, nuevoDesplazamiento, posx2, posy2, finalx, finaly, complegidad - 1, g);

        int finalx2 = posx2 + desplazamiento-35 ; //35
        //int finalyz = posy2-desplazamiento;
        //int nuevoDesplazamiento2 = desplazamiento-15;

        //int finalxz = (int)(posx2*desplazamiento2x);
        //int finalyz = (int)(posy2*desplazamiento2y);

        dibujarArbol(inicioColor, nuevaAnchura, nuevoDesplazamiento, posx2, posy2, finalx2, finaly, complegidad - 1, g);

    }

    public int getPosx1() {
        return posx1;
    }

    public void setPosx1(int posx1) {
        this.posx1 = posx1;
    }

    public int getPosy1() {
        return posy1;
    }

    public void setPosy1(int posy1) {
        this.posy1 = posy1;
    }

    public int getPosx2() {
        return posx2;
    }

    public void setPosx2(int posx2) {
        this.posx2 = posx2;
    }

    public int getPosy2() {
        return posy2;
    }

    public void setPosy2(int posy2) {
        this.posy2 = posy2;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getComplegidad() {
        return complegidad;
    }

    public void setComplegidad(int complegidad) {
        this.complegidad = complegidad;
    }

    public int getDesplazamiento() {
        return desplazamiento;
    }

    public void setDesplazamiento(int desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    public int getInicioColor() {
        return inicioColor;
    }

    public void setInicioColor(int inicioColor) {
        this.inicioColor = inicioColor;
    }


}
