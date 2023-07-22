package modelo;

public record compra(int idC,String nombreCliente, int idP, String nombreProducto) {

    public String[] getDatos(){
        return new String[]{idC+"",nombreCliente,idP+"",nombreProducto};
    }
}
