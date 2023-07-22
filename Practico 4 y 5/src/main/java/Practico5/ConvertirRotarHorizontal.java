package Practico5;

import org.apache.log4j.Logger;

public class ConvertirRotarHorizontal extends Convertir {

    private static final org.apache.log4j.Logger logger = Logger.getRootLogger();

    public ConvertirRotarHorizontal(Imagen img) {
        this.imagen = img;
    }
    @Override
    public void transformar(int x1, int y1,int x2,int y2) {
        int[][] pixeles = imagen.getPixeles();
        int contador = 1;
        int limite = x2;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                int c = pixeles[i][j];
                logger.info(contador+" Desde: "+i+" "+j+" hasta: "+i+" " +limite +"       "+limite);
                imagen.setColor(c,i,limite );
                contador++;
                limite--;
            }
            contador = 1;
            limite = x2;
        }
        imagen.transformada();
    }
}
