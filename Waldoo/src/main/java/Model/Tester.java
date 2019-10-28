/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Escenario;

/**
 *
 * @author maryp
 */
public class Tester {
    private Escenario escenario;
    private int oportunidades;
    
    public Tester(int pOportunidades, Escenario pEscenario){
        this.oportunidades=pOportunidades;
        this.escenario=pEscenario;
    }

    public Escenario getEscenario() {
        return escenario;
    }

    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }

    public int getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(int oportunidades) {
        this.oportunidades = oportunidades;
    }
    public boolean isFamilyWaldo(String Nombre){
        switch(Nombre){
            case "Waldo":
            case "Wenda":
            case "Woof":
            case "Odlaw":
            case "Barbablanca":
                return true;
            default: 
                this.oportunidades--;
                 return false;
        }
    }
    
}
