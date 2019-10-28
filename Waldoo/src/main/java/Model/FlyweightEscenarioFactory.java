/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Escenario;
import java.util.HashMap;

/**
 *
 * @author maryp
 */
public class FlyweightEscenarioFactory {
    public static final HashMap<String,Escenario> escenarios=new HashMap<>();
    
   public static Escenario getEscenario(String key) {
      Escenario escenario = (Escenario)escenarios.get(key);

      if(escenario == null) {
         escenario = new Escenario();
         
         escenarios.put(key, escenario);
      }
      return escenario;
   }
}
