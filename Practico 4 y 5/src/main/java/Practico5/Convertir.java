package Practico5;

public abstract class Convertir {
    protected Imagen imagen;

    public abstract void transformar (int x1, int y1,int x2,int y2);

    public Imagen getImagennnn() {
        return imagen;
    }

    public void setImagennnnn(Imagen imagen) {
        this.imagen = imagen;
    }
}
