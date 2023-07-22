package Practico4;


import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VentanaTable extends JFrame {
    private JTable tabla;
    private Lista <Persona> listaPersonas = new Lista<>();
    private static final org.apache.log4j.Logger logger = Logger.getRootLogger();
    private DefaultTableModel modeloTabla = new DefaultTableModel();

    public VentanaTable() {
        setTitle("Practico4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 800);
        setLocationRelativeTo(null);
        añadirComponentes();
        setVisible(true);

    }


    public void añadirComponentes() {

        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Edad");
        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(0, 0, 10, 60);
        add(scroll);
        this.pack();
        JMenuBar bar = new JMenuBar();
        this.setJMenuBar(bar);

        JMenu menu = new JMenu("Buscador");
        JMenu menu2 = new JMenu("Borrar");
        bar.add(menu);
        bar.add(menu2);

        JMenuItem item = new JMenuItem("Cargar TEXTO");
        JMenuItem itemBorrar = new JMenuItem("Eliminar");

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuArchivo_cargarTXT();
            }
        });

        itemBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(itemBorrar)) {
                    VentanaEliminar v = new VentanaEliminar(listaPersonas,modeloTabla);
                    logger.info("Nuevo tamañooooo: " + listaPersonas.tamano());
                    logger.info("Listaaa tablaaaaaa: "+listaPersonas);

                }

            }
        });

        menu2.add(itemBorrar);
        menu.add(item);
    }

    protected void menuArchivo_cargarTXT() {
        JFileChooser fileChooser = new JFileChooser();
        int respuesta = fileChooser.showOpenDialog(null);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            String expresionReg = "^\\s*[A-z]+\\s+[A-z]+\\s+[0-9]{2}\\s*$";
            try {
                File Archivo = new File(fileChooser.getSelectedFile().getPath());
                Scanner lector = new Scanner(Archivo);
                while (lector.hasNext()) {
                    String letras = lector.nextLine();

                    if (letras.matches(expresionReg)) {
                        letras = letras.trim();
                        String auxLetras = letras.replaceAll("\\s+"," ");
                        String[] split = auxLetras.split(" ");
                        Persona personaX = new Persona(split[0], split[1], Integer.parseInt(split[2]));
                        listaPersonas.adicionar(personaX);
                        logger.info("Ingreso: "+letras);
                        logger.info("Tamaño: " + listaPersonas.tamano());
                    } else {
                        logger.info("No se escribio :  " + letras);
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        rellenarTable();


    }

    public void rellenarTable(){
        for (int i = 0; i < listaPersonas.tamano(); i++) {
            String [] aux = {listaPersonas.obtener(i).getNombre(),listaPersonas.obtener(i).getApellido(),listaPersonas.obtener(i).getEdad()+""};
            modeloTabla.addRow(aux);
        }
    }

}
