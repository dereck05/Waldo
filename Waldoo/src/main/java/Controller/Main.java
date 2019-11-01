/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//import View.Menu;

import Model.SuperFactoryWaldo;
import View.ViewFindWaldo;
import javax.swing.JFrame;

/**
 *
 * @author naty9
 */
public class Main {
    public static void main(String args[]){
        SuperFactoryWaldo sf = new SuperFactoryWaldo();
        ViewFindWaldo vista = new ViewFindWaldo();
        ControllerFindWaldo c = new ControllerFindWaldo(vista,sf);
        c.vista.setVisible(true);
        c.vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
