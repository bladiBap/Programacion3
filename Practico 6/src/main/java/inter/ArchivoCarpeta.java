package inter;

public class ArchivoCarpeta {

    protected String nombre;

    protected String nombreCode;
    protected float tamaño;
    protected String ubicacionFisica;
    protected ArchivoCarpeta padre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(float tamaño) {
        this.tamaño = tamaño;
    }

    public String getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(String ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
    }

    public ArchivoCarpeta getPadre() {
        return padre;
    }

    public void setPadre(ArchivoCarpeta padre) {
        this.padre = padre;
    }

    public void codificarNombre (){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<8; i++){
            sb.append((char) (Math.random()*26+'a'));
        }
        nombreCode =  sb.toString();
    }
    public String getNombreCode() {
        return nombreCode;
    }

    public void setNombreCode(String nombreCode) {
        this.nombreCode = nombreCode;
    }
}
