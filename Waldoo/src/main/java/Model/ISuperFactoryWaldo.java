/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Escenario;
import Model.Personaje;
import java.util.ArrayList;

/**
 *
 * @author maryp
 */
public interface ISuperFactoryWaldo {
    public void crearPersonaje(int x, int y, String nombre, String imagen);
    public Tester crearTester(Escenario escenario,int oportunidades);
    public Escenario crearEscenario(String key, String image);
}
