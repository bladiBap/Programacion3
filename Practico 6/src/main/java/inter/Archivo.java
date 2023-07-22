package inter;

import java.text.DecimalFormat;

public class Archivo extends ArchivoCarpeta{
    

    private String tipoNombre;
    private String tipo;
    private String direccion;
    @Override
    public String toString() {
        return this.getNombre();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void setTamaño(float tamaño) {
        super.setTamaño(tamaño);
        convertir(tamaño);
    }

    public void convertir (float bytes){
        DecimalFormat df = new DecimalFormat("#.00");
        String n = "";
        float num = (float) 1.21;
        if (bytes>=0 && bytes <= 1024){
            this.tamaño = bytes;
            tipoNombre =  "bytes";
        } else if (bytes>1024 && bytes <= 1048576) {
            //this.tamaño = bytes/1024;
            n = df.format(bytes/1024);
            n = cambiarStrin(n);
            System.out.println(n);
            this.tamaño = Float.parseFloat(n);
            tipoNombre =  "Kb";
        } else if (bytes > 1048576 && bytes <= 1073741824) {
            n = df.format(bytes/1048576);
            n = cambiarStrin(n);
            System.out.println(n);
            this.tamaño = Float.parseFloat(n);
            tipoNombre =  "Mb";
        }
    }

    public String getTipoNombre() {
        return tipoNombre;
    }

    public void setTipoNombre(String tipoNombre) {
        this.tipoNombre = tipoNombre;
    }

    public String cambiarStrin (String m){
        for (int i = 0; i<m.length();i++){
            String letra = m.substring(i,i+1);
            if (letra.equals(",")) {
                String finnaS = m.substring(0,i-1)+"."+m.substring(i+1,m.length()+1-1);
                return finnaS;
            }
        }
        return null;
    }
}
