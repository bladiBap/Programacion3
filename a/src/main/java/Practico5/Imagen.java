package Practico5;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;

public class Imagen {
    private PropertyChangeSupport cambios;
    private static final org.apache.log4j.Logger logger = Logger.getRootLogger();
    private int pos = 0;

    protected int[][] pixeles;

    private ListaImagen <int[][]> listaImagen = new ListaImagen<>();

    private String path;
    protected int ancho;
    protected int alto;

    public Imagen (String path){
        cambios = new PropertyChangeSupport(this);
        this.path = path;
        leerDeArchivo(this.path);
        int[][] pixelesAux =new int[ancho][alto] ;
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                pixelesAux [i][j] = pixeles[i][j];
            }
        }
        listaImagen.adicionar(pixelesAux);


    }


    private void initImagen(BufferedImage bi) {
        ancho = bi.getWidth();
        alto = bi.getHeight();

        pixeles = new int[ancho][alto];
        for (int j = 0; j < alto; j++) {
            for (int i = 0; i < ancho; i++) {
                int bgr = bi.getRGB(i, j);
                pixeles[i][j] = bgr;
            }
        }

        cambios.firePropertyChange("IMAGEN", 1, 0);
    }

    public void dibujar(Graphics2D g) {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                g.setColor(new Color(pixeles[i][j]));
                g.drawLine(i,j,i,j);
            }
        }


    }


    public int[][] getPixeles() {
        return pixeles;
    }



    public int getAncho() {
        return ancho;
    }

    public void setPixeles(int[][] pixeles) {
        this.pixeles = pixeles;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    protected void initImagen(int w, int h) {
        pixeles = new int[w][h];
        ancho = w;
        alto = h;
        cambios.firePropertyChange("IMAGEN", 1, 0);
    }

    public void leerDeArchivo(String path) {
        BufferedImage bi = null;
        try {
            File f = new File(path);
            bi = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        initImagen(bi);
    }

    public void setColor(int c, int i, int j){
        pixeles[i][j] = c;
    }

    public void addObserver(PanelImagen paintPanel) {
        cambios.addPropertyChangeListener(paintPanel);
    }

    public void transformada() {
        cambios.firePropertyChange("IMAGEN", 1, 0);
    }

    public void cambio (){
        if(pos+1==listaImagen.tamano()) {
            int[][] pixelesAux = new int[ancho][alto];
            for (int i = 0; i < ancho; i++) {
                for (int j = 0; j < alto; j++) {
                    pixelesAux[i][j] = pixeles[i][j];
                }
            }
            listaImagen.adicionar(pixelesAux);
            this.pos ++;
        }else {
            for (int i = listaImagen.tamano(); i >0 ; i--) {

                if(pos+1==listaImagen.tamano()) {
                    break;
                }else{
                    listaImagen.eliminar(i-1);
                    logger.info("-----------------------FOR-------Tamaño: "+listaImagen.tamano()+"  la posicion es: "+ this.pos+"  i"+(i-1));
                }
                logger.info("FOR-------Tamaño: "+listaImagen.tamano()+"  la posicion es: "+ this.pos);
            }
        }
        logger.info("Tamaño: "+listaImagen.tamano()+"  la posicion es: "+ this.pos);

    }

    public int getPos() {
        return pos;
    }

    public void masPos() {
        this.pos ++;
        if(this.pos>listaImagen.tamano()-1){
            this.pos = listaImagen.tamano()-1;
        }
        logger.info("PosicionAumentado: "+this.pos+" Tamaño lista "+listaImagen.tamano());
    }
    public void menosPos() {
        this.pos --;
        if(this.pos<0){
            this.pos = 0;
        }
        logger.info("PosicionRestado: "+this.pos+" Tamaño lista "+listaImagen.tamano());
    }

    public void moverImagenes (){
        pixeles = listaImagen.obtener(pos);}

}

