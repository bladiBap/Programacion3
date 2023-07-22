package modelo;

import java.sql.*;

public class Conexion {
    private String baseName ="producto";
    private String puerto = "3306";
    private String hostname = "localhost";
    private  String usuario = "root";
    private String contraseña = "root";
    private  String url =  "jdbc:mysql://" + hostname + ":" + puerto + "/" + baseName + "?useSSL=false";
    private Connection conexion;
    private static Conexion instancia;

    private Conexion (){
    }

    public static Conexion getInstance(){
        if (instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }

    public void conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet consulta(Statement statement, String comando){
        try {
            return statement.executeQuery(comando);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ejecutar(Statement statement, String comando){
        try {
            statement.execute(comando);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
