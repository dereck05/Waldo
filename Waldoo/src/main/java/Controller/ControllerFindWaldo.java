/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FlyweightEscenarioFactory;
import View.ViewFindWaldo;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author naty9
 */
public class ControllerFindWaldo implements ActionListener{
    private ViewFindWaldo vista;
    private FlyweightEscenarioFactory flyweight; 
    
    public ControllerFindWaldo(ViewFindWaldo pVista, FlyweightEscenarioFactory pFlyweight){
        this.vista = pVista;
        this.flyweight = pFlyweight;
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        iniciar();
    }
    
    public void iniciar(){
        
        /*follower.crearFollower(vista.txt_nombre.getText(), vista.txt_apellido1.getText(), vista.txt_apellido2.getText(), vista.txt_user.getText());
        Vista vds = new VistaFollower();   
        ControllerVistaFollower cvds = new ControllerVistaFollower(vds,follower);
        vds.setVisible(true);
        this.vista.setVisible(false);
        JOptionPane.showMessageDialog(vista, "Follower Creado!"); */
    }
    
    
}
