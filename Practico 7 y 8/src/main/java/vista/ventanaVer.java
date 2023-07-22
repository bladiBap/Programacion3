package vista;

import dao.clienteDao;
import dao.compraDao;
import dao.productoDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ventanaVer extends JFrame {


    private  productoDao productos = new productoDao();

    private clienteDao clientes = new clienteDao();

    private compraDao compras = new compraDao();

    private JLabel titulo = new JLabel("Lista de Productos");

    private JTable tablaP = new JTable();
    private JScrollPane scrollP;
    private DefaultTableModel modeloTablaP = new DefaultTableModel();

    private JTable tablaCL = new JTable();
    private JScrollPane scrollCL;
    private DefaultTableModel modeloTablaCL = new DefaultTableModel();

    private JTable tablaCO = new JTable();
    private JScrollPane scrollCO;
    private DefaultTableModel modeloTablaCO = new DefaultTableModel();

    private JButton botonVolver = new JButton("Volver");
    private JPanel panelProduc = new JPanel();
    private JPanel panelCliente = new JPanel();
    private JPanel panelCompra = new JPanel();
    private JButton btonCliente = new JButton("Clientes");
    private JButton btonCompra = new JButton("Compras");

    private JButton btonProducto = new JButton("Productos");

    public ventanaVer() {
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setVisible(true);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cargarComponentes();
        rellenarTablaProducto();
        rellenarTablaCliente();
        rellenarTablaCompra();
    }

    private void cargarComponentes() {
        setLayout(null);

        panelProduc.setBounds(50,100,890,700);
        panelProduc.setBackground(Color.GRAY);
        panelProduc.setLayout(null);

        panelCompra.setBounds(50,100,890,700);
        panelCompra.setBackground(Color.GRAY);
        panelCompra.setLayout(null);

        panelCliente.setBounds(50,100,890,700);
        panelCliente.setBackground(Color.GRAY);
        panelCliente.setLayout(null);

        modeloTablaP.addColumn("id");
        modeloTablaP.addColumn("nombre");
        modeloTablaP.addColumn("codigo");
        modeloTablaP.addColumn("precio");
        modeloTablaP.addColumn("cantidad");
        modeloTablaP.addColumn("fechaVencimiento");

        modeloTablaCL.addColumn("ID");
        modeloTablaCL.addColumn("Nombre");
        modeloTablaCL.addColumn("Apellido P");
        modeloTablaCL.addColumn("Apellido M");

        modeloTablaCO.addColumn("ID Cliente");
        modeloTablaCO.addColumn("Nombre Cliente");
        modeloTablaCO.addColumn("ID Producto");
        modeloTablaCO.addColumn("Nombre Producto");
        //modeloTablaCO.addColumn("Cantidad");


        tablaP.setModel(modeloTablaP);
        scrollP = new JScrollPane(tablaP);
        scrollP.setBounds(50,50,800,600);

        tablaCL.setModel(modeloTablaCL);
        scrollCL = new JScrollPane(tablaCL);
        scrollCL.setBounds(50,50,800,600);

        tablaCO.setModel(modeloTablaCO);
        scrollCO = new JScrollPane(tablaCO);
        scrollCO.setBounds(50,50,800,600);

        botonVolver.setBounds(200,850,100,40);
        btonCompra.setBounds(350,850,100,40);
        btonCliente.setBounds(500,850,100,40);
        btonProducto.setBounds(650,850,100,40);

        titulo.setBounds(370,30,300,50);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));

        botonVolver.addActionListener(e -> {
            ventana ventana = new ventana();
            this.dispose();
        });

        btonCliente.addActionListener( e -> {

            panelCompra.setVisible(false);
            panelCliente.setVisible(true);
            panelProduc.setVisible(false);
            titulo.setText("Lista de Clientes");

        });

        btonCompra.addActionListener(e -> {

            panelCompra.setVisible(true);
            panelCliente.setVisible(false);
            panelProduc.setVisible(false);
            titulo.setText("Lista de Compras");
        });

        btonProducto.addActionListener(e -> {

            panelCompra.setVisible(false);
            panelCliente.setVisible(false);
            panelProduc.setVisible(true);
            titulo.setText("Lista de Productos");
        });

        panelProduc.add(scrollP);
        panelCliente.add(scrollCL);
        panelCompra.add(scrollCO);
        add(botonVolver);
        add(panelProduc);
        add(panelCompra);
        add(panelCliente);
        add(titulo);
        add(btonCliente);
        add(btonCompra);
        add(btonProducto);
        panelCliente.setVisible(false);
        panelCompra.setVisible(false);
        panelProduc.setVisible(true);
    }

    public void rellenarTablaProducto(){
        modeloTablaP.setRowCount(0);
        for (modelo.producto producto: productos.getProductos()) {
            modeloTablaP.addRow(producto.getDatos());
        }
    }

    public void rellenarTablaCliente(){
        modeloTablaCL.setRowCount(0);
        for (modelo.cliente cliente: clientes.getClientes()) {
            modeloTablaCL.addRow(cliente.getDatos());
        }
    }

    public void rellenarTablaCompra(){
        modeloTablaCO.setRowCount(0);
        for (modelo.compra compra: compras.getCompras()) {
            modeloTablaCO.addRow(compra.getDatos());
        }
    }

}
