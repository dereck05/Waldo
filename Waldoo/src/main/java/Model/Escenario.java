/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Personaje;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author maryp
 */
public class Escenario implements IContainer  {
    private String imagen;
    private ArrayList<Personaje> personajes;

    public Escenario() {
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    @Override
    public IIterator<Personaje> createIterator() {
        return new TreeEscenarioIterator();
    }
    private class TreeEscenarioIterator implements IIterator<Personaje> {
        private LinkedList<Personaje> list = new LinkedList<Personaje>();                    
        private int index = 0;   
        
        public TreeEscenarioIterator() {                        
            add(Escenario.this);                    
        }
        
        public void add(Escenario escenario) {
              for (Personaje personaje: escenario.getPersonajes()){
                   //El 20 es el ancho de la ventana
                    personaje.setX((int) Math.floor(Math.random()*20));
                    personaje.setY((int) Math.floor(Math.random()*20));
                    list.add(personaje);
              }
        }                                
        
        @Override                    
        public boolean hasNext() {                        
            if (list.isEmpty()) {                            
                return false;                        
            }
            return index < list.size();
        }
        
        @Override                    
        public Personaje next() {                        
            if (!hasNext()) {                            
                throw new RuntimeException("No hay más elementos");                        
            }
            return list.get(index++);                    
        }                
    }                            
    
    
}
