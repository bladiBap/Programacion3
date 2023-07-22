package dao;

import modelo.Conexion;
import modelo.cliente;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class clienteDao extends AbstractDAO <cliente>{
    @Override
    public cliente get(int id) {
        return null;
    }

    public ArrayList<cliente> getClientes(){
        Conexion conexion = Conexion.getInstance();
        ArrayList<cliente> clientes = new ArrayList<>();

        String comando = "SELECT * FROM cliente";

        try {
            conexion.conectar();
            Statement statement = conexion.getConexion().createStatement();
            ResultSet rs = conexion.consulta(statement, comando);

            while (rs.next()){
                cliente cliente = new cliente(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidoP"),
                        rs.getString("apellidoM"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clientes;
    }

    public void registrarCliente(cliente cliente){
        Conexion conexion = Conexion.getInstance();

        String comando = "INSERT INTO cliente VALUES( "+  cliente.id() + "," + "'" +  cliente.nombre() + "'"
                + "," + "'" +cliente.apelllidoP() + "'" + "," + "'" + cliente.apellidoM() + "'"  + ")";

        try {
            conexion.conectar();
            Statement statement = conexion.getConexion().createStatement();
            conexion.ejecutar(statement, comando);
            JOptionPane.showMessageDialog(null,"Cliente registrado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al introducir en Cliente");
            throw new RuntimeException(e);
        }
    }

    public boolean consultaIDClientes(int idCliente){
        boolean verificador = false;
        Conexion conexion = Conexion.getInstance();
        ArrayList<Integer> ides = new ArrayList<>();

        String comando = "SELECT id FROM cliente";

        try {
            conexion.conectar();
            Statement statement = conexion.getConexion().createStatement();
            ResultSet rs = conexion.consulta(statement, comando);

            while (rs.next()){
                int id = rs.getInt("id");
                ides.add(id);
            }

            for (int i = 0; i < ides.size(); i++) {
                if (idCliente == ides.get(i)){
                    verificador = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return verificador;
    }

    public void eliminarCliente(int id){
        Conexion conexion = Conexion.getInstance();

        String comando =  "delete from cliente where id = "+ id;

        try {
            conexion.conectar();
            Statement statement = conexion.getConexion().createStatement();
            conexion.ejecutar(statement, comando);
            JOptionPane.showMessageDialog(null,"Cliente Eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al introducir en Cliente");
            throw new RuntimeException(e);
        }
    }
}
