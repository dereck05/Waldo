 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import Model.Escenario;
import Model.*;
import java.util.ArrayList;
//import Model.ISuperFactoryWaldo;

/**
 *
 * @author maryp
 */
public class SuperFactoryWaldo implements ISuperFactoryWaldo{
    
    @Override
    public Personaje crearPersonaje(Double x, Double y, String nombre, String imagen) {
        ISuperFactory modelo = new SuperFactory(); 
        Personaje personaje = modelo.createPersonaje(Boolean.TRUE, nombre, imagen, 0.0, 0.0, 0.0, 0.0, 0.0,0.0,x,y,new ArrayList<>(), "");
        System.out.println(personaje.getNombre());
        ObjetoInformacion objeto = new ObjetoInformacion(null,null,personaje,"PrincipalesWaldo");
        modelo.guardarInformacion(objeto);
        return personaje; 
    }

    @Override
    public Tester crearTester(Escenario escenario,int oportunidades) {
        return new Tester(oportunidades, escenario);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Escenario crearEscenario(String key,String image,String fileNamePrincipales, String fileNameSecundarios) {
        Json json = new Json();
        ArrayList<Personaje> personajesPrincipales = json.cargarJson(fileNamePrincipales);    
        Escenario escenario= FlyweightEscenarioFactory.getEscenario(key);
        escenario.setImagen(image);
        if((FlyweightEscenarioFactory.escenarios.get(key).getPersonajes()).isEmpty()){
               ArrayList<Personaje> personajesSecundarios = json.cargarJson(fileNameSecundarios);
               escenario.setPersonajes(personajesSecundarios);           
               FlyweightEscenarioFactory.escenarios.replace(key, escenario);
               
        }
        ArrayList<Personaje> personajesSinRandom = new ArrayList<Personaje>(personajesPrincipales);
        personajesSinRandom.addAll(escenario.getPersonajes());
        escenario.setPersonajes(personajesSinRandom);
        IIterator<Personaje>  personajeIterator = escenario.createIterator();
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();
        while(personajeIterator.hasNext()){
            Personaje p = personajeIterator.next();
            personajes.add(p);
        }
        return escenario;
       
    }
    
}
