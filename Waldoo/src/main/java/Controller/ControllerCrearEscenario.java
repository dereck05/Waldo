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
import java.nio.charset.Charset;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author naty9
 */
public class ControllerCrearEscenario implements ActionListener{
    private ViewCrearEscenario vista;
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
        switch(e.getActionCommand()){
            case "Cargar Escenario":
               cargarEscenario();
                break;
            case "Jugar":
                crearJuego();
                break;
            default:
                JOptionPane.showMessageDialog(vista, "Opción no registrada");
                break;
        }
    }
    
    public void cargarEscenario(){
        pathEscenario = "clouds.png";
    }
    
    public void crearJuego(){
        String cantPersonajes = vista.jTextField1.getText().toString(); 
        byte[] array = new byte[7]; 
        new Random().nextBytes(array);
        String randomKey = new String(array, Charset.forName("UTF-8"));
        sfWaldo.crearEscenario(randomKey, pathEscenario, "PrincipalesWaldo", "SecundariosWaldo");
        System.out.println("Se ha creado");
        
    }
    
}
