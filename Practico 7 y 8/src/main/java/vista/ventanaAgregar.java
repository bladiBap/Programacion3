package vista;

import dao.clienteDao;
import dao.compraDao;
import dao.productoDao;
import modelo.cliente;
import modelo.producto;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ventanaAgregar extends JFrame {

    private static final org.apache.log4j.Logger logger = Logger.getRootLogger();

    private JLabel tituloPRO = new JLabel("Productos");
    private JLabel tituloCLI = new JLabel("Clientes");
    private JLabel tituloCOM = new JLabel("Compras");

    private JPanel panelPro = new JPanel();
    private JPanel panelCli = new JPanel();
    private JPanel panelCom = new JPanel();

    private productoDao productos = new productoDao();
    private clienteDao clientes = new clienteDao();
    private compraDao compras = new compraDao();
    ////////////////////////////////////////////////////

    private JLabel idDeletePro = new JLabel("ID Borrar");
    private JLabel idAñadirPro = new JLabel("ID Añadir");
    private JLabel cantidadAñadirPro = new JLabel("Cantidad");
    private JLabel id = new JLabel("Codigo");
    private JLabel nombre = new JLabel("Nombre");
    private JLabel codigo = new JLabel("Codigo");
    private JLabel precio = new JLabel("Precio");
    private JLabel cantidad = new JLabel("Cantidad");
    private JLabel fechaVencimiento = new JLabel("Fecha de Vencimiento");
    private JTextField txtidDeletePro = new JTextField();

    private JTextField txtidAñadirPro = new JTextField();

    private JTextField txtcantidadPro = new JTextField();
    private JTextField txtId = new JTextField();
    private JTextField txtNombre = new JTextField();
    private JTextField txtCodigo = new JTextField();
    private JTextField txtPrecio = new JTextField();
    private JTextField txtCantidad = new JTextField();
    private JTextField txtFechaVencimiento = new JTextField();

    ///////////////////////////////////////////////

    private JLabel lbIdBorrarCliente = new JLabel("Id Borrar");
    private JTextField txtBorrarIdCliente = new JTextField();
    private JButton btnBorrarCliente = new JButton("Borrar");

    private JLabel idCliente = new JLabel("ID");
    private JLabel nombreCliente = new JLabel("Nombre");
    private JLabel apellidoP = new JLabel("Apellido P");
    private JLabel apellidoM = new JLabel("Apellido M");
    private JTextField txtIdClien = new JTextField();
    private JTextField txtNombreClien = new JTextField();
    private JTextField txtApellidoPClien = new JTextField();
    private JTextField txtApellidoMClien = new JTextField();

    ////////////////////////////////////////////
    private JLabel idClienteCompra = new JLabel("ID CLIENTE");
    private JLabel idProductoCompra = new JLabel("ID PRODUCTO-");
    private JTextField txtIdPCompra = new JTextField();
    private JTextField txtIdCCompra = new JTextField();
    /////////////////////////////////////////////
    private JButton registrarPROC = new JButton("REGISTRAR");
    private JButton registrarCLI = new JButton("REGISTRAR");
    private JButton registrarCOM = new JButton("REGISTRAR");
    private JButton volver = new JButton("VOLVER");
    private JButton limpiar = new JButton("LIMPIAR");
    private JButton borrarPro = new JButton("Borrar");
    private JButton añadirCantidad = new JButton("Añadir Cantidad");

    private JButton añadirCompra = new JButton("Añadir Compra");
    private JButton añadirCliente = new JButton("Añadir Cliente");
    private JButton añadirProducto = new JButton("Añadir Producto");


    public ventanaAgregar() {
        this.setLayout(null);
        setSize(680, 850);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);

        cargarComponentes();
    }

    private void cargarComponentes() {

        setLayout(null);

        tituloPRO.setBounds(170, 30, 300, 50);
        tituloPRO.setFont(new Font("Arial", Font.BOLD, 30));

        tituloCLI.setBounds(170, 30, 300, 50);
        tituloCLI.setFont(new Font("Arial", Font.BOLD, 30));

        tituloCOM.setBounds(170, 30, 300, 50);
        tituloCOM.setFont(new Font("Arial", Font.BOLD, 30));

        panelPro.setBounds(50, 30, 550, 620);
        panelPro.setBackground(Color.GRAY);
        panelPro.setBorder(new LineBorder(Color.BLACK));
        panelPro.setLayout(null);

        panelCli.setBounds(50, 50, 550, 600);
        panelCli.setBackground(Color.GRAY);
        panelCli.setBorder(new LineBorder(Color.BLACK));
        panelCli.setLayout(null);

        panelCom.setBounds(50, 50, 550, 600);
        panelCom.setBackground(Color.GRAY);
        panelCom.setBorder(new LineBorder(Color.BLACK));
        panelCom.setLayout(null);
        ///////////////////////
        id.setBounds(100, 100, 100, 30);
        txtId.setBounds(200, 100, 100, 30);
        nombre.setBounds(100, 150, 100, 30);
        txtNombre.setBounds(200, 150, 100, 30);
        codigo.setBounds(100, 200, 100, 30);
        txtCodigo.setBounds(200, 200, 100, 30);
        precio.setBounds(100, 250, 100, 30);
        txtPrecio.setBounds(200, 250, 100, 30);
        cantidad.setBounds(100, 300, 100, 30);
        txtCantidad.setBounds(200, 300, 100, 30);
        fechaVencimiento.setBounds(70, 350, 130, 30);
        txtFechaVencimiento.setBounds(200, 350, 100, 30);
        registrarPROC.setBounds(330, 100, 100, 30);
        idDeletePro.setBounds(100, 450, 100, 30);
        txtidDeletePro.setBounds(200, 450, 100, 30);
        borrarPro.setBounds(330, 450, 100, 30);
        idAñadirPro.setBounds(100, 500, 100, 30);
        txtidAñadirPro.setBounds(200, 500, 100, 30);
        cantidadAñadirPro.setBounds(100, 550, 100, 30);
        txtcantidadPro.setBounds(200, 550, 100, 30);
        añadirCantidad.setBounds(330, 500, 130, 30);
        ////////////////////////////
        idCliente.setBounds(100, 100, 100, 30);
        txtIdClien.setBounds(200, 100, 100, 30);
        nombreCliente.setBounds(100, 150, 100, 30);
        txtNombreClien.setBounds(200, 150, 100, 30);
        apellidoP.setBounds(100, 200, 100, 30);
        txtApellidoPClien.setBounds(200, 200, 100, 30);
        apellidoM.setBounds(100, 250, 100, 30);
        txtApellidoMClien.setBounds(200, 250, 100, 30);
        registrarCLI.setBounds(330, 100, 100, 30);
        lbIdBorrarCliente.setBounds(100, 330, 100, 30);
        txtBorrarIdCliente.setBounds(200, 330, 100, 30);
        btnBorrarCliente.setBounds(330, 330, 100, 30);
        ///////////////////////////
        idClienteCompra.setBounds(100, 100, 100, 30);
        txtIdCCompra.setBounds(200, 100, 100, 30);
        idProductoCompra.setBounds(100, 150, 100, 30);
        txtIdPCompra.setBounds(200, 150, 100, 30);
        registrarCOM.setBounds(330, 100, 100, 30);
        /////////////////////////
        volver.setBounds(90, 680, 100, 30);
        limpiar.setBounds(450, 680, 100, 30);
        /////////////////////////
        añadirProducto.setBounds(50, 720, 140, 30);
        añadirCompra.setBounds(250, 720, 140, 30);
        añadirCliente.setBounds(450, 720, 140, 30);


        panelPro.add(id);
        panelPro.add(txtId);
        panelPro.add(nombre);
        panelPro.add(txtNombre);
        panelPro.add(codigo);
        panelPro.add(txtCodigo);
        panelPro.add(precio);
        panelPro.add(txtPrecio);
        panelPro.add(cantidad);
        panelPro.add(txtCantidad);
        panelPro.add(fechaVencimiento);
        panelPro.add(txtFechaVencimiento);
        panelPro.add(registrarPROC);
        panelPro.add(borrarPro);
        panelPro.add(idDeletePro);
        panelPro.add(txtidDeletePro);
        panelPro.add(idAñadirPro);
        panelPro.add(txtidAñadirPro);
        panelPro.add(cantidadAñadirPro);
        panelPro.add(txtcantidadPro);
        panelPro.add(añadirCantidad);
        panelPro.add(tituloPRO);

        panelCli.add(idCliente);
        panelCli.add(txtIdClien);
        panelCli.add(nombreCliente);
        panelCli.add(txtNombreClien);
        panelCli.add(apellidoP);
        panelCli.add(txtApellidoPClien);
        panelCli.add(apellidoM);
        panelCli.add(txtApellidoMClien);
        panelCli.add(registrarCLI);
        panelCli.add(lbIdBorrarCliente);
        panelCli.add(txtBorrarIdCliente);
        panelCli.add(btnBorrarCliente);
        panelCli.add(tituloCLI);

        panelCom.add(idClienteCompra);
        panelCom.add(txtIdCCompra);
        panelCom.add(idProductoCompra);
        panelCom.add(txtIdPCompra);
        panelCom.add(registrarCOM);
        panelCom.add(tituloCOM);

        add(volver);
        add(limpiar);
        add(añadirCliente);
        add(añadirCompra);
        add(añadirProducto);
        add(panelPro);
        add(panelCli);
        add(panelCom);

        panelPro.setVisible(true);
        panelCom.setVisible(false);
        panelCli.setVisible(false);

        registrarPROC.addActionListener(e -> {

            if (txtId.getText().equals("") || txtNombre.getText().equals("") || txtCodigo.getText().equals("") || txtPrecio.getText().equals("") || txtCantidad.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese bien los datos");
            } else {
                int id = Integer.parseInt(txtId.getText());
                if (productos.consultaIDProductos(id) == true) {
                    JOptionPane.showMessageDialog(null, "ID Repetido");
                } else {
                    productos.registrarProducto(new producto(id, txtNombre.getText(), txtCodigo.getText(), Double.parseDouble(txtPrecio.getText()), Integer.parseInt(txtCantidad.getText()), txtFechaVencimiento.getText()));
                    logger.info("Se registro un Producto con el ID "+ id);
                }
            }
        });

        registrarCLI.addActionListener(e -> {
            if (txtIdClien.getText().equals("") || txtNombreClien.getText().equals("") || txtApellidoPClien.getText().equals("") || txtApellidoMClien.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese bien los datos");
            } else {
                int id = Integer.parseInt(txtIdClien.getText());
                if (clientes.consultaIDClientes(id) == true) {
                    JOptionPane.showMessageDialog(null, "ID Repetido");
                } else {
                    clientes.registrarCliente(new cliente(id, txtNombreClien.getText(), txtApellidoPClien.getText(), txtApellidoMClien.getText()));
                    logger.info("Se registro un cliente con el ID "+ id);
                }

            }
        });

        registrarCOM.addActionListener(e -> {
            if (txtIdPCompra.getText().equals("") || txtIdCCompra.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese bien los datos");
            } else {
                int idC = Integer.parseInt(txtIdCCompra.getText());
                int idP = Integer.parseInt(txtIdPCompra.getText());
                if (productos.consultaIDProductos(idP) == true && clientes.consultaIDClientes(idC) == true) {
                    if (productos.consultaCantidad(idP) > 0) {
                        compras.registrarCompra(idC, idP);
                        logger.info("Se registro una Compra con los ID Cliente "+ idC + " e ID Producto" +idP);
                        productos.actualizarCantidad(productos.consultaCantidad(idP), idP);
                    } else {
                        JOptionPane.showMessageDialog(null, "La CANTIDAD del producto es 0");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No existen los ID");
                }

            }

        });

        borrarPro.addActionListener(e -> {
            if (txtidDeletePro.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Rellene los campos");
            } else {
                int id = Integer.parseInt(txtidDeletePro.getText());
                if (productos.consultaIDProductos(id) == true) {
                    productos.eliminarProducto(id);
                    logger.info("Se elimino el producto con el ID "+ id);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe ese ID");
                }
            }
        });

        btnBorrarCliente.addActionListener(e -> {
            if (txtBorrarIdCliente.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Rellene los campos");
            } else {
                int id = Integer.parseInt(txtBorrarIdCliente.getText());
                if (clientes.consultaIDClientes(id) == true) {
                    clientes.eliminarCliente(id);
                    logger.info("Se elimino el cliente con el ID "+ id);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe ese ID");
                }
            }
        });
        añadirCantidad.addActionListener(e -> {
            if (txtidAñadirPro.getText().equals("") || txtcantidadPro.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Rellene los campos");
            } else {
                int id = Integer.parseInt(txtidAñadirPro.getText());
                int cantidad = Integer.parseInt(txtcantidadPro.getText());
                if (productos.consultaIDProductos(id) == true && cantidad > 0) {
                    int cantidadAnterior = productos.consultaCantidad(id);
                    cantidad += cantidadAnterior;
                    productos.aumentarCantidad(cantidad, id);
                    logger.info("Se añadio cantidad al producto con el ID "+ id+" con la cantidad de " +cantidad);
                } else {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos");
                }
            }
        });

        volver.addActionListener(e -> {

            ventana ventana = new ventana();
            this.dispose();
        });

        limpiar.addActionListener(e -> {

            logger.info("Se limpiaron todos los campos");

            txtId.setText("");
            txtNombre.setText("");
            txtCodigo.setText("");
            txtPrecio.setText("");
            txtCantidad.setText("");
            txtFechaVencimiento.setText("");

            txtcantidadPro.setText("");
            txtBorrarIdCliente.setText("");
            txtidDeletePro.setText("");
            txtIdCCompra.setText("");
            txtIdPCompra.setText("");
            txtidAñadirPro.setText("");
            txtApellidoMClien.setText("");
            txtNombreClien.setText("");
            txtApellidoPClien.setText("");
            txtIdClien.setText("");
        });

        añadirProducto.addActionListener(e -> {
            panelPro.setVisible(true);
            panelCom.setVisible(false);
            panelCli.setVisible(false);
        });
        añadirCliente.addActionListener(e -> {
            panelPro.setVisible(false);
            panelCom.setVisible(false);
            panelCli.setVisible(true);

        });
        añadirCompra.addActionListener(e -> {
            panelPro.setVisible(false);
            panelCom.setVisible(true);
            panelCli.setVisible(false);
        });

    }
}
