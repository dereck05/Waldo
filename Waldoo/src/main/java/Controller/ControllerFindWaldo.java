/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FlyweightEscenarioFactory;
import Model.Personaje;
import Model.SuperFactoryWaldo;
import View.ViewFindWaldo;
import java.awt.Button;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author naty9
 */
public class ControllerFindWaldo implements ActionListener{
    public ViewFindWaldo vista;
    public FlyweightEscenarioFactory flyweight; 
    public SuperFactoryWaldo sfWaldo;
    
    public static int clickCount = 0;
    public static int clickCount2 = 0;
    public static String imagen;
    
    
    public ControllerFindWaldo(ViewFindWaldo pVista, SuperFactoryWaldo pSfWaldo){
        this.vista = pVista;
        this.flyweight = flyweight;
        this.vista.jButton1.addActionListener(this);
        this.vista.jButton2.addActionListener(this);
        this.sfWaldo = pSfWaldo;
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //inicio();
        String s = e.getActionCommand();
        if(e.getSource()==this.vista.jButton1){
            System.out.println("agregar imagen");
            try {
                inicio();
                agregarImagen();
            } catch (IOException ex) {
                Logger.getLogger(ControladorVentanaAgregarAtaque.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(e.getSource()==this.vista.jButton2){
            System.out.println("crear");
            createImage();
        }
    }
    
    public void inicio(){
        Personaje pWaldo = sfWaldo.crearPersonaje(10.0, 10.0, "Waldo","rosa.png");
        //Personaje pWenda = sfWaldo.crearPersonaje(40.0, 40.0, "Wenda","src\\main\\resources\\Imagenes\\bubbles.png");
        //Personaje pWoof = sfWaldo.crearPersonaje(60.0, 60.0, "Woof","src\\main\\resources\\Imagenes\\gary.png");
        //Personaje pOdlaw = sfWaldo.crearPersonaje(80.0, 80.0, "Odlaw","src\\main\\resources\\Imagenes\\elmo.png");    
        //Personaje pBarbablanca = sfWaldo.crearPersonaje(100.0, 100.0, "Barbablanca","src\\main\\resources\\Imagenes\\panda.png");
        
        vista.jLabelWaldo.setIcon(new javax.swing.ImageIcon(pWaldo.getImage()));
    }
    
    public void createImage(){
        
        vista.jPanel1.setLayout(null);
        
        JLabel imagenAtaque = new JLabel();
        ImageIcon icon = new javax.swing.ImageIcon(imagen);
        
        
        
        imagenAtaque.setMaximumSize(new java.awt.Dimension(80,32767));
        imagenAtaque.setMinimumSize(new java.awt.Dimension(80,80));
        imagenAtaque.setPreferredSize(new java.awt.Dimension(80,80));
        
        //Tamaño de la imagen
        imagenAtaque.setSize(80, 80);
        
        
        //Escala la imagen al tamaño 
        Image image= icon.getImage().getScaledInstance(imagenAtaque.getWidth(), imagenAtaque.getHeight(), Image.SCALE_SMOOTH);
        
        //Lo pasa de image a icon otra vez
        icon = new ImageIcon(image, icon.getDescription());
        //Le asigna el icon al label
        imagenAtaque.setIcon(icon);
        
        //Pone las coordenadas
        imagenAtaque.setLocation(600, 50); //Esto se debe hacer random entre 0 y width y 0 y height
        vista.jPanel1.add(imagenAtaque);
        
        //Refresca la ventana
        vista.jPanel1.revalidate();
        vista.jPanel1.repaint();
        
    }
    
    public void agregarImagen() throws IOException{
        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");   
        int userSelection = fileChooser.showSaveDialog(parentFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            //System.out.println(fileToSave.getAbsolutePath());
            File file  = new File(fileToSave.getAbsolutePath());
            BufferedImage bi = ImageIO.read(file);
            ImageIO.write(bi, "png", new File("src\\main\\resources\\Imagenes"+fileToSave.getName()));
            String path = "src\\main\\resources\\Imagenes"+fileToSave.getName();
             this.imagen = path;      
        }
    }
    
    
    public void iniciar(){
        vista.jLabelFondo.addMouseListener(new MouseAdapter(){
            public void jLabelFondoMouseClicked(MouseEvent e) {
                clickCount++;
                vista.jLabelCont.setText(Integer.toString(clickCount));
                System.out.println(Integer.toString(clickCount));
                //lblPanel.setText(Integer.toString(clickCount));
            }
        }); 
        
        
        
    }

    
    
}
