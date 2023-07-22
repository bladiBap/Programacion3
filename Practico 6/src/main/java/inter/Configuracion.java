package inter;

public final class Configuracion {
    private static Configuracion instance;
    private String directorioBase;

    private Configuracion (){}

    public static Configuracion getInstance (){
        if (instance == null){
            instance = new Configuracion();
        }
        return instance;
    }

    public String getDirectorioBase (){
        return this.directorioBase;
    }
    public void setDirectorioBase (String direc){
        this.directorioBase = direc;
    }
}
