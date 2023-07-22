package modelo;

public record cliente(int id, String nombre, String apelllidoP, String apellidoM) {

    public String[] getDatos(){
        return new String[]{id+"", nombre,apelllidoP,apellidoM};
    }
}
