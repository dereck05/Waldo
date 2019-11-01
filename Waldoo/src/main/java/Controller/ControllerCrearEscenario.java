/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FlyweightEscenarioFactory;
import Model.SuperFactoryWaldo;
import View.ViewCrearEscenario;
import View.ViewFindWaldo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author naty9
 */
public class ControllerCrearEscenario implements ActionListener{
    public ViewCrearEscenario vista;
    private SuperFactoryWaldo sfWaldo;
    private String pathEscenario;
        
    public ControllerCrearEscenario(ViewCrearEscenario pVista, SuperFactoryWaldo pSfWaldo){
        this.vista = pVista;
        this.sfWaldo = pSfWaldo;
        this.vista.jBtnJugar.addActionListener(this);
        this.vista.jBtnCargarEscenario.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.vista.jBtnCargarEscenario){
            try {
                cargarEscenario();
            } catch (IOException ex) {
                Logger.getLogger(ControllerCrearEscenario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(e.getSource()==this.vista.jBtnJugar) {
            crearJuego();
        } else{
            vista.avisarOpcionInvalida();
        }
        
    }
    
    public void cargarEscenario() throws IOException{
        pathEscenario = "src\\main\\resources\\Clouds.png";
        
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
            
            pathEscenario = path;
        }
        
        
        
    }
    
    public void crearJuego(){
        String cantPersonajes = vista.jTextField1.getText().toString(); 
        byte[] array = new byte[7]; 
        new Random().nextBytes(array);
        String randomKey = new String(array, Charset.forName("UTF-8"));
        //sfWaldo.crearEscenario(randomKey, pathEscenario, "PrincipalesWaldo", "SecundariosWaldo");
        System.out.println("Se ha creado");
        
        
        ViewFindWaldo ventana = new ViewFindWaldo();
        ventana.setFondo(pathEscenario);
        ControllerFindWaldo c = new ControllerFindWaldo(ventana,sfWaldo);
        c.setCantPersonajesExtra(Integer.parseInt(cantPersonajes));
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setVisible(false);
        
    }
    
}
