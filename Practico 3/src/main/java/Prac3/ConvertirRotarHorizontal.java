package Prac3;

//import org.apache.log4j.Logger;

public class ConvertirRotarHorizontal extends Convertir {

    //private static final org.apache.log4j.Logger logger = Logger.getRootLogger();

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
                //int d = pixeles[i][limite];
                //logger.info(contador+" Desde: "+i+" "+j+" hasta: "+i+" " +limite +"       "+limite);

                imagen.setColor(c,i,limite );
                //imagen.setColor(d, i, j);

                contador++;
                limite--;
            }
            contador = 1;
            limite = x2;
        }
        imagen.transformada();
    }
    /*
    public void transformar(int x1, int y1,int x2,int y2) {
        int[][] pixeles = imagen.getPixeles();
        System.out.println("Verdaderos puntos: "+x1+" "+y1+"      "+(((x2-x1)/2)+x1)+" "+y2+" ");

        for (int i = y1; i < y2; i++) {
            int limite = x2;
            System.out.println("asd");
            for (int j = x1; j < ((x2-x1)/2)+x1; j++) {
                System.out.println(limite);
                int c = pixeles[i][j];
                int d = pixeles[i][limite];

                System.out.println("Desde: "+i+" "+j+" hasta: "+i+" " +limite);

                imagen.setColor(c, i, limite);
                imagen.setColor(d, i, j);
                limite--;
            }
        }
        imagen.transformada();
    }

     */
}
