package inter;

import inter.ArchivoCarpeta;

public class Carpeta extends ArchivoCarpeta {

    private Carpeta padre;

    public Carpeta (){}

    public Carpeta (String x){
        this.nombre =x;
    }
    private String tipo = "";
    public void tipo(){
        tipo = "Archivito";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    @Override
    public Carpeta getPadre() {
        return padre;
    }

    public void setPadre(Carpeta padre) {
        this.padre = padre;
    }
}
