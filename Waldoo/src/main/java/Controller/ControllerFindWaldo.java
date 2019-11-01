/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FlyweightEscenarioFactory;
import Model.Personaje;
import Model.SuperFactoryWaldo;
import View.BackgroundPanel;
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
import java.util.Random;
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
public class ControllerFindWaldo{
    public ViewFindWaldo vista;
    public FlyweightEscenarioFactory flyweight; 
    public SuperFactoryWaldo sfWaldo;
    
    public static String imagen;
    
    public static int clickCount = 0;
    public static int clickWaldo = 0;
    public static int clickWanda = 0;
    public static int clickWoof = 0;
    public static int clickOdlaw = 0;
    public static int clickBarbablanca = 0;
    
    public static File dir = new File("src\\main\\resources\\Imagenes");
    public static File[] files = dir.listFiles();

    
    public int cantPersonajesRandom = 0;
    
    public ControllerFindWaldo(ViewFindWaldo pVista, SuperFactoryWaldo pSfWaldo, int cantPersonajes){
        this.vista = pVista;
        this.flyweight = flyweight;
        this.sfWaldo = pSfWaldo;
        this.cantPersonajesRandom = cantPersonajes;
        
        inicio();
        
    }
    
    public void setCantPersonajesExtra(int cantidad){
        cantPersonajesRandom = cantidad;
    }

    public void inicio(){
        Personaje pWaldo = sfWaldo.crearPersonaje(10.0, 10.0, "Waldo","src\\main\\resources\\Principales\\waldo.png");
        Personaje pWenda = sfWaldo.crearPersonaje(40.0, 40.0, "Wenda","src\\main\\resources\\Principales\\wenda.png");
        Personaje pWoof = sfWaldo.crearPersonaje(60.0, 60.0, "Woof","src\\main\\resources\\Principales\\woof.png");
        Personaje pOdlaw = sfWaldo.crearPersonaje(80.0, 80.0, "Odlaw","src\\main\\resources\\Principales\\odlaw.png");    
        Personaje pBarbablanca = sfWaldo.crearPersonaje(100.0, 100.0, "Barbablanca","src\\main\\resources\\Principales\\whitebeard.png");
        
        
        //Escalar
        ImageIcon imgWaldo = new javax.swing.ImageIcon(pWaldo.getImage());
        ImageIcon imgWenda = new javax.swing.ImageIcon(pWenda.getImage());
        ImageIcon imgWoof = new javax.swing.ImageIcon(pWoof.getImage());
        ImageIcon imgOdlaw = new javax.swing.ImageIcon(pOdlaw.getImage());
        ImageIcon imgBarbablanca = new javax.swing.ImageIcon(pBarbablanca.getImage());
        
        vista.jLabelWaldo.setSize(100, 120);
        vista.jLabelWanda.setSize(60, 100);
        vista.jLabelWoof.setSize(100, 50);
        vista.jLabelOdlaw.setSize(100, 120);
        vista.jLabelBarbablanca.setSize(100, 120);
        
        Random r = new Random();
        
        vista.jLabelWaldo.setLocation(Math.abs(r.nextInt()) % vista.newPanel.getWidth()-80, Math.abs(r.nextInt()) % vista.newPanel.getHeight()-80);
        vista.jLabelWanda.setLocation(Math.abs(r.nextInt()) % vista.newPanel.getWidth()-80, Math.abs(r.nextInt()) % vista.newPanel.getHeight()-80);
        vista.jLabelWoof.setLocation(Math.abs(r.nextInt()) % vista.newPanel.getWidth()-80, Math.abs(r.nextInt()) % vista.newPanel.getHeight()-80);
        vista.jLabelOdlaw.setLocation(Math.abs(r.nextInt()) % vista.newPanel.getWidth()-80, Math.abs(r.nextInt()) % vista.newPanel.getHeight()-80);
        vista.jLabelBarbablanca.setLocation(Math.abs(r.nextInt()) % vista.newPanel.getWidth()-80, Math.abs(r.nextInt()) % vista.newPanel.getHeight()-80);
        
        System.out.println(cantPersonajesRandom);
        //cantPersonajesRandom = 20;
        for(int i = 0; i < cantPersonajesRandom ; i++){
            System.out.println("i");
            
            int index = Math.abs(r.nextInt(files.length-1));
            ImageIcon imgI = new javax.swing.ImageIcon(files[index].getAbsolutePath());
            JLabel lbl = new JLabel();
            lbl.setSize(90,150);
            
            
            Image img = imgI.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
            imgI = new ImageIcon(img, imgWaldo.getDescription());
            lbl.setIcon(imgI);
            
            
            lbl.setLocation(Math.abs(r.nextInt()) % vista.newPanel.getWidth()-80, Math.abs(r.nextInt()) % vista.newPanel.getHeight()-80);
            
            
            vista.newPanel.add(lbl);
            
            
        }
        
        
        Image scaledWaldo = imgWaldo.getImage().getScaledInstance(vista.jLabelWaldo.getWidth(), vista.jLabelWaldo.getHeight(), Image.SCALE_SMOOTH);
        imgWaldo = new ImageIcon(scaledWaldo, imgWaldo.getDescription());
        
        Image scaledWenda = imgWenda.getImage().getScaledInstance(vista.jLabelWanda.getWidth(), vista.jLabelWanda.getHeight(), Image.SCALE_SMOOTH);
        imgWenda = new ImageIcon(scaledWenda, imgWenda.getDescription());
        
        Image scaledWoof = imgWoof.getImage().getScaledInstance(vista.jLabelWoof.getWidth(), vista.jLabelWoof.getHeight(), Image.SCALE_SMOOTH);
        imgWoof = new ImageIcon(scaledWoof, imgWoof.getDescription());
        
        Image scaledOdlaw = imgOdlaw.getImage().getScaledInstance(vista.jLabelOdlaw.getWidth(), vista.jLabelOdlaw.getHeight(), Image.SCALE_SMOOTH);
        imgOdlaw = new ImageIcon(scaledOdlaw, imgOdlaw.getDescription());
        
        Image scaledBarbablanca = imgBarbablanca.getImage().getScaledInstance(vista.jLabelBarbablanca.getWidth(), vista.jLabelBarbablanca.getHeight(), Image.SCALE_SMOOTH);
        imgBarbablanca = new ImageIcon(scaledBarbablanca, imgBarbablanca.getDescription());
        
        vista.jLabelWaldo.setIcon(imgWaldo);
        vista.jLabelWanda.setIcon(imgWenda);
        vista.jLabelWoof.setIcon(imgWoof);   
        vista.jLabelOdlaw.setIcon(imgOdlaw);
        vista.jLabelBarbablanca.setIcon(imgBarbablanca);
        
        
        
        vista.revalidate();
        vista.repaint();
    }
    
    public void createImage(){
        
        vista.newPanel.setLayout(null);
        
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
        vista.newPanel.add(imagenAtaque);
        
        //Refresca la ventana
        vista.newPanel.revalidate();
        vista.newPanel.repaint();
        
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
            ImageIO.write(bi, "png", new File("src\\main\\resources\\Imagenes\\"+fileToSave.getName()));
            String path = "src\\main\\resources\\Imagenes\\"+fileToSave.getName();
             this.imagen = path;      
        }
    } 
}
