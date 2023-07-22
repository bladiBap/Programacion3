package dao;

import modelo.Conexion;
import modelo.producto;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class productoDao extends AbstractDAO<producto> {

    @Override
    public producto get(int id) {
        return null;
    }

    public ArrayList<producto> getProductos(){
        Conexion conexion = Conexion.getInstance();
        ArrayList<producto> productos = new ArrayList<>();

        String comando = "SELECT * FROM producto";

        try {
            conexion.conectar();
            Statement statement = conexion.getConexion().createStatement();
            ResultSet rs = conexion.consulta(statement, comando);

            while (rs.next()){
                producto producto = new producto(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("codigo"),
                        rs.getDouble("precio"),
                        rs.getInt("cantidad"),
                        rs.getString("fechaVencimiento"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productos;
    }

    public void registrarProducto(producto producto){
        Conexion conexion = Conexion.getInstance();

        String comando = "INSERT INTO producto VALUES( "+  producto.id() + "," + "'" +  producto.nombre() + "'"
                + "," + "'" +producto.codigo() + "'" + "," + "'" + producto.precio() + "'" + "," +"'"+ producto.cantidad()+ "'" + "," + "'" + producto.fechaVencimiento() + "'" + ")";

        try {
            conexion.conectar();
            Statement statement = conexion.getConexion().createStatement();
            conexion.ejecutar(statement, comando);
            JOptionPane.showMessageDialog(null,"Producto registrado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al introducir en Producto");
            throw new RuntimeException(e);
        }
    }

    public int consultaCantidad(int idP){
        Conexion conexion = Conexion.getInstance();
        int cantidad = 0;
        String comando = "select cantidad from producto where id ="+idP;
        try {
            conexion.conectar();
            Statement statement = conexion.getConexion().createStatement();
            ResultSet rs = conexion.consulta(statement, comando);
            while (rs.next()){
            cantidad = rs.getInt("cantidad");}

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cantidad;
    }

    public void actualizarCantidad(int cantidadAnterior,int id){
        Conexion conexion = Conexion.getInstance();

        String comando =  "update producto set cantidad = "+ (cantidadAnterior-1) +" where id = "+id;

        try {
            conexion.conectar();
            Statement statement = conexion.getConexion().createStatement();
            conexion.ejecutar(statement, comando);
            //JOptionPane.showMessageDialog(null,"Producto registrado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al introducir en Producto");
            throw new RuntimeException(e);
        }
    }

    public boolean consultaIDProductos(int idProducto){
        boolean verificador = false;
        Conexion conexion = Conexion.getInstance();
        ArrayList<Integer> ides = new ArrayList<>();

        String comando = "SELECT id FROM producto";

        try {
            conexion.conectar();
            Statement statement = conexion.getConexion().createStatement();
            ResultSet rs = conexion.consulta(statement, comando);

            while (rs.next()){
                int id = rs.getInt("id");
                ides.add(id);
            }

            for (int i = 0; i < ides.size(); i++) {
                if (idProducto == ides.get(i)){
                    verificador = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return verificador;
    }

    public void eliminarProducto(int id){
        Conexion conexion = Conexion.getInstance();

        String comando =  "delete from producto where id = "+ id;

        try {
            conexion.conectar();
            Statement statement = conexion.getConexion().createStatement();
            conexion.ejecutar(statement, comando);
            JOptionPane.showMessageDialog(null,"Producto Eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al introducir en Producto");
            throw new RuntimeException(e);
        }
    }

    public void aumentarCantidad(int cantidad,int id){
        Conexion conexion = Conexion.getInstance();

        String comando =  "update producto set cantidad = "+ cantidad +" where id = "+id;

        try {
            conexion.conectar();
            Statement statement = conexion.getConexion().createStatement();
            conexion.ejecutar(statement, comando);
            JOptionPane.showMessageDialog(null,"Cantidad añadida");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al introducir los datos");
            throw new RuntimeException(e);
        }
    }
}
