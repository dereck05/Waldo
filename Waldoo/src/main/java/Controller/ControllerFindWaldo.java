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
    
    public static String imagen;
    
    public static int clickCount = 0;
    public static int clickWaldo = 0;
    public static int clickWanda = 0;
    public static int clickWoof = 0;
    public static int clickOdlaw = 0;
    public static int clickBarbablanca = 0;
    
    
    public ControllerFindWaldo(ViewFindWaldo pVista, SuperFactoryWaldo pSfWaldo){
        this.vista = pVista;
        this.flyweight = flyweight;
        this.vista.jButton1.addActionListener(this);
        this.vista.jButton2.addActionListener(this);
        this.sfWaldo = pSfWaldo;
   
        //BackgroundPanel newPanel = new BackgroundPanel();
        vista.setFondo("src\\\\main\\\\resources\\\\Clouds.png");
        
        /*newPanel.setLayout(null);
        newPanel.add(vista.jLabel2);
        newPanel.add(vista.jLabelCont);
        newPanel.add(vista.jButton1);
        newPanel.add(vista.jButton2);
        newPanel.add(vista.jLabelFondo);
        newPanel.add(vista.jLabelWaldo);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(vista.getContentPane());
        
        vista.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );
        vista.pack();
        
        vista.getContentPane().remove(vista.jPanel1);
        vista.getContentPane().add(newPanel);
        
        vista.validate();*/
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(clickWaldo > 0 && clickWanda > 0 && clickWoof > 0 && clickOdlaw > 0 && clickBarbablanca > 0){
            JOptionPane.showMessageDialog(vista, "Felicidades ha ganado!");
        }
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
        Personaje pWaldo = sfWaldo.crearPersonaje(10.0, 10.0, "Waldo","src\\main\\resources\\Imagenes\\waldo.png");
        Personaje pWenda = sfWaldo.crearPersonaje(40.0, 40.0, "Wenda","src\\main\\resources\\Imagenes\\wenda.png");
        Personaje pWoof = sfWaldo.crearPersonaje(60.0, 60.0, "Woof","src\\main\\resources\\Imagenes\\woof.png");
        Personaje pOdlaw = sfWaldo.crearPersonaje(80.0, 80.0, "Odlaw","src\\main\\resources\\Imagenes\\odlaw.png");    
        Personaje pBarbablanca = sfWaldo.crearPersonaje(100.0, 100.0, "Barbablanca","src\\main\\resources\\Imagenes\\whitebear.png");
        
        vista.jLabelWaldo.setIcon(new javax.swing.ImageIcon(pWaldo.getImage()));
        vista.jLabelWanda.setIcon(new javax.swing.ImageIcon(pWenda.getImage()));
        vista.jLabelWoof.setIcon(new javax.swing.ImageIcon(pWoof.getImage()));
        vista.jLabelOdlaw.setIcon(new javax.swing.ImageIcon(pWoof.getImage()));
        vista.jLabelBarbablanca.setIcon(new javax.swing.ImageIcon(pWoof.getImage()));
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
            ImageIO.write(bi, "png", new File("src\\main\\resources\\Imagenes"+fileToSave.getName()));
            String path = "src\\main\\resources\\Imagenes"+fileToSave.getName();
             this.imagen = path;      
        }
    }
    
    
   /* public void iniciar(){
        vista.jLabelFondo.addMouseListener(new MouseAdapter(){
            public void jLabelFondoMouseClicked(MouseEvent e) {
                clickPrueba++;
                vista.jLabelCont.setText(Integer.toString(clickPrueba));
                System.out.println("Prueba:" + Integer.toString(clickPrueba));
                //lblPanel.setText(Integer.toString(clickCount));
            }
        }); 

        
    }*/

    
    
}
