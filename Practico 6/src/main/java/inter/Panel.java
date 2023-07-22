package inter;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {

    private static final org.apache.log4j.Logger logger = Logger.getRootLogger();

    private Configuracion confi = Configuracion.getInstance();
    private Arbol<ArchivoCarpeta> arbol = new Arbol<>();

    private Carpeta carpetaActual = new Carpeta("direc");
    private int anchoTabla;
    private int altoTabla;
    private String datos[] = new String[4];
    private JScrollPane scroll;
    private JTable tabla;
    private DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JButton botonAtras = new JButton("<---");
    private JLabel labelDireccion = new JLabel("direc");

    public Panel(int ancho, int alto) {

        confi.setDirectorioBase("D:\\Universidad NUR\\SEMESTRE 3\\PROGRAMACION 3\\practico6\\repositorio");

        carpetaActual.setNombreCode("1");
        arbol.insertar(carpetaActual, "1", null);
        this.altoTabla = alto;
        this.anchoTabla = ancho;
        setVisible(true);
        añadirComponentes();

    }

    public void añadirComponentes() {
        setLayout(null);
        botonAtras.setBounds(2, 3, 70, 30);

        labelDireccion.setOpaque(true);
        labelDireccion.setBounds(150, 5, 300, 30);
        labelDireccion.setBackground(Color.RED);
        add(labelDireccion);
        add(botonAtras);


        //setLayout(null);
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Tamaño");
        modeloTabla.addColumn("NombreCrip");


        tabla = new JTable(modeloTabla);
        scroll = new JScrollPane(tabla);
        //JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(0, 50, anchoTabla - 15, altoTabla - 150);
        add(scroll);
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    System.out.println("aaaaaa");
                    int fila = tabla.getSelectedRow();
                    if (modeloTabla.getValueAt(fila, 1) == "Carpeta") {
                        String s = (String) modeloTabla.getValueAt(fila, 3);
                        Arbol.Nodo<ArchivoCarpeta> nodo = arbol.buscar(s);
                        Lista<Arbol.Nodo<ArchivoCarpeta>> listaNodos = nodo.getHijos();
                        carpetaActual = (Carpeta) nodo.getContenido();
                        labelDireccion.setText(labelDireccion.getText() + "/" + carpetaActual.getNombre());
                        repintarTabla(listaNodos);
                    } else {
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                        int respuesta = fileChooser.showOpenDialog(null);
                        if (respuesta == JFileChooser.APPROVE_OPTION) {
                            String s = (String) modeloTabla.getValueAt(fila, 3);
                            System.out.println(s+" aaaaaa");
                            Arbol.Nodo<ArchivoCarpeta> nodo = arbol.buscar(s);
                            Archivo archivo = (Archivo) nodo.getContenido();



                            File Archivo = new File(archivo.getDireccion());
                            File Archivo2 = new File(fileChooser.getSelectedFile().getPath()+"/"+archivo.getNombre()+"."+archivo.getTipo());

                            try{
                                FileUtils.copyFile(Archivo,Archivo2);
                            }catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }


                        }
                    }
                }
            }
        });
        botonAtras.addActionListener(e -> {
            if (labelDireccion.getText().equals("direc")) {

            } else {
                String direccion = labelDireccion.getText();
                actualizarDirectorio(direccion);
                carpetaActual = carpetaActual.getPadre();
                Arbol.Nodo<ArchivoCarpeta> nodo = arbol.buscar(carpetaActual.getNombreCode());
                Lista<Arbol.Nodo<ArchivoCarpeta>> listaNodos = nodo.getHijos();
                repintarTabla(listaNodos);
            }
        });
    }

    public void insertarCarpeta(Carpeta c) {

        c.setPadre(carpetaActual);

        datos[0] = c.getNombre();
        datos[1] = c.getTipo();
        datos[2] = String.valueOf(c.getTamaño());
        datos[3] = c.getNombreCode();
        arbol.insertar(c, c.getNombreCode() + "", carpetaActual.getNombreCode());

        modeloTabla.addRow(datos);

    }

    public void insertarArchivo(Archivo a) {
        arbol.insertar(a,a.getNombreCode(), carpetaActual.getNombreCode());
        datos[0] = a.getNombre();
        datos[1] = a.getTipo();
        datos[2] = String.valueOf(a.getTamaño())+" "+a.getTipoNombre();
        datos[3] = a.getNombreCode();
        modeloTabla.addRow(datos);
    }

    public void repintarTabla(Lista<Arbol.Nodo<ArchivoCarpeta>> nodos) {

        modeloTabla.setRowCount(0);

        for (Arbol.Nodo<ArchivoCarpeta> hijo : nodos) {
            if (hijo.getContenido() instanceof Carpeta) {
                datos[0] = hijo.getContenido().getNombre();
                datos[1] = ((Carpeta) hijo.getContenido()).getTipo();
                datos[2] = String.valueOf(hijo.getContenido().getTamaño());
                datos[3] = hijo.getContenido().getNombreCode();
                modeloTabla.addRow(datos);
            } else {
                datos[0] = hijo.getContenido().getNombre();
                datos[1] = ((Archivo) hijo.getContenido()).getTipo();
                datos[2] = String.valueOf(hijo.getContenido().getTamaño());
                datos[3] = hijo.getContenido().getNombreCode();

                modeloTabla.addRow(datos);
            }
        }
        scroll.updateUI();

    }



    public void actualizarDirectorio(String direc) {
        for (int i = direc.length(); i > 0; i--) {
            String letra = direc.substring(i - 1, i);
            System.out.println(letra + "");
            if(letra.equals("/")){
                labelDireccion.setText(direc.substring(0,i-1));
                break;

            }

        }
    }

    public Configuracion getConfi() {
        return confi;
    }

    public void setConfi(Configuracion confi) {
        this.confi = confi;
    }
}