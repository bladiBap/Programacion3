package Practico5;

public class ConvertirPixel extends Convertir {
    public ConvertirPixel(Imagen img) {
        this.imagen = img;
    }
    @Override
    public void transformar(int x1, int y1, int x2, int y2) {
        int[][] pixeles = imagen.getPixeles();
        for (int i = x1; i < x2; i+=3) {
            for (int j = y1; j < y2; j+=3) {
                int a = pixeles[i][j];



                imagen.setColor(a, i, j);
                imagen.setColor(a, i+1, j);
                imagen.setColor(a, i+2, j);
                imagen.setColor(a, i, j+1);
                imagen.setColor(a, i+1, j+1);
                imagen.setColor(a, i+2, j+1);
                imagen.setColor(a, i, j+2);
                imagen.setColor(a, i+1, j+2);
                imagen.setColor(a, i+2, j+2);
            }
        }
        imagen.transformada();
    }
}
