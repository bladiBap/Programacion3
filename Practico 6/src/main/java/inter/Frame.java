package inter;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Frame extends JFrame {
    private Panel panelT;

    private static final org.apache.log4j.Logger logger = Logger.getRootLogger();

    public Frame (){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setVisible(true);
        setLocationRelativeTo(null);
        cargarComponentes();

    }

    public void cargarComponentes (){
        setPreferredSize(this.getSize());

        JMenuBar bar = new JMenuBar();
        this.setJMenuBar(bar);
        JMenu menu = new JMenu("Opciones");
        bar.add(menu);
        JMenuItem itemArchivo = new JMenuItem("Cargar Archivo");
        JMenuItem itemCarpeta = new JMenuItem("Crear Carpeta");

        itemArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Entroo");
                try {
                    menuArchivo_cargarTXT();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        itemCarpeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Entroo");
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la carpeta");
                logger.info("El nombre de la capeta es "+nombre);

                if (nombre.trim().equals("")){
                    JOptionPane.showMessageDialog(null,"No se aceptan solo espacios");
                }else {
                Carpeta nuevaCarpeta = new Carpeta();
                nuevaCarpeta.setNombre(nombre);
                nuevaCarpeta.setTamaño(1);
                nuevaCarpeta.codificarNombre();
                nuevaCarpeta.setTipo("Carpeta");
                panelT.insertarCarpeta(nuevaCarpeta);}
            }
        });

        menu.add(itemArchivo);
        menu.add(itemCarpeta);


        panelT = new Panel(this.getWidth(),this.getHeight());
        this.getContentPane().add(panelT);
        this.pack();



    }

    protected void menuArchivo_cargarTXT() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        int respuesta = fileChooser.showOpenDialog(null);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File Archivo = new File(fileChooser.getSelectedFile().getPath());
            Archivo v = new Archivo();
            v.setTipo(encontrarExtension(Archivo.getName()));
            v.setNombre(encontrarNombre(Archivo.getName()));
            v.setTamaño(Archivo.length());
            v.codificarNombre();
            //v.setDireccion();

            File Archivo2 = new File(panelT.getConfi().getDirectorioBase()+"\\"+v.getNombreCode());
            v.setDireccion(Archivo2.getPath());
            try{
                FileUtils.copyFile(Archivo,Archivo2);
            }catch (Exception e){

            }




            panelT.insertarArchivo(v);

        }
    }

    public String encontrarExtension (String ex){
        for (int i = 0 ; i<ex.length();i++){
            String letra = ex.substring(i,i+1);
            if (letra.equals(".")){
                String nombre = ex.substring(i+1,ex.length()+1-1);
                return nombre;
            }
        }
        return "no se encontro";
    }
    public String encontrarNombre (String ex){
        for (int i = 0 ; i<ex.length();i++){
            String letra = ex.substring(i,i+1);
            if (letra.equals(".")){
                String nombre = ex.substring(0,i);
                return nombre;
            }
        }

        return "no se encontro";
    }

}
