/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FlyweightEscenarioFactory;
import View.ViewFindWaldo;
import java.awt.Button;
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
    
    public static int clickCount = 0;
    public static int clickCount2 = 0;
    public static String imagen;
    
    public ControllerFindWaldo(ViewFindWaldo pVista){
        this.vista = pVista;
        this.flyweight = flyweight;
        this.vista.jButton1.addActionListener(this);
        this.vista.jButton2.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(e.getSource()==this.vista.jButton1){
            System.out.println("agregar imagen");
            try {
                agregarImagen();
            } catch (IOException ex) {
                Logger.getLogger(ControladorVentanaAgregarAtaque.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(e.getSource()==this.vista.jButton2){
            System.out.println("crear");
            createImage();
        }
    }
    
    public void createImage(){
        JLabel imagenAtaque = new JLabel();
        imagenAtaque.setIcon(new javax.swing.ImageIcon(imagen));
        imagenAtaque.setMaximumSize(new java.awt.Dimension(80,32767));
        imagenAtaque.setMinimumSize(new java.awt.Dimension(80,80));
        imagenAtaque.setPreferredSize(new java.awt.Dimension(80,80));
        vista.jPanel1.add(imagenAtaque);
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
