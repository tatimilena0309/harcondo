/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas;

import Ambientes.Controlador_Ambiente;
import Controlador.Controlador;
import Sensores.Controlador_Sensor;

/**
 *
 * @author LEO
 */
public class Fabrica_Controladores {
    
    
      private static Fabrica_Controladores instancia;

    public static Fabrica_Controladores getInstancia() {
        if (instancia == null) {
            instancia = new Fabrica_Controladores();
        }
        return instancia;
    }

    public enum controladores {

        Sensores, Ambiente
    }

    public Controlador getControlador (controladores controladorNombre) {
        switch (controladorNombre) {
            case Sensores:
                return new Controlador_Sensor();
            case Ambiente:
                return new Controlador_Ambiente();
            default:
                return null;

        }
    }
    
}
