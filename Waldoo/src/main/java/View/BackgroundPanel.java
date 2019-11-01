/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Gloriana
 */
public class BackgroundPanel extends javax.swing.JPanel{
    
    protected String imagePath;
    
    
    public BackgroundPanel(String imagePath){
        this.imagePath = imagePath;
    }
    
    public void setImagePath(String path){
        imagePath = path;
    }
    
    public String getImagePath(){
        return imagePath;
    }
    
    public void cambiarFondo(String path){
        setImagePath(path);
        this.revalidate();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        ImageIcon icon = new javax.swing.ImageIcon(imagePath);
        Image image = icon.getImage();
        
        super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
    }
}
