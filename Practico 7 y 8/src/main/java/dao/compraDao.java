package dao;

import modelo.Conexion;
import modelo.cliente;
import modelo.compra;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class compraDao extends AbstractDAO <compra>{
    @Override
    public compra get(int id) {
        return null;
    }

    public ArrayList<compra> getCompras(){
        Conexion conexion = Conexion.getInstance();
        ArrayList<compra> compras = new ArrayList<>();

        String comando = "select cl.id as IdCliente,cl.nombre as NombreCliente, p.id as IdProducto, p.nombre as NombreProducto from compra c join cliente cl on c.idC = cl.id join producto p on c.idP = p.id order by cl.nombre";

        try {
            conexion.conectar();
            Statement statement = conexion.getConexion().createStatement();
            ResultSet rs = conexion.consulta(statement, comando);

            while (rs.next()){
                compra compra = new compra(rs.getInt("IdCliente"),
                        rs.getString("NombreCliente"),
                        rs.getInt("IdProducto"),
                        rs.getString("NombreProducto"));
                compras.add(compra);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return compras;
    }

    public void registrarCompra(int idC, int idP){
        Conexion conexion = Conexion.getInstance();

        String comando = "INSERT INTO compra VALUES( "+  idP + "," + "'" + idC + "'"
               +  ")";

        try {
            conexion.conectar();
            Statement statement = conexion.getConexion().createStatement();
            conexion.ejecutar(statement, comando);
            JOptionPane.showMessageDialog(null,"Compra registrada");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al introducir en Compra");
            throw new RuntimeException(e);
        }
    }


}
