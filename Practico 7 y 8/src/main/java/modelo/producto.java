package modelo;

public record producto(int id,String nombre, String codigo, Double precio, int  cantidad, String fechaVencimiento) {

    public String[] getDatos(){
        return new String[]{id+"", nombre,codigo,precio+"",cantidad+"",fechaVencimiento};
    }
}
