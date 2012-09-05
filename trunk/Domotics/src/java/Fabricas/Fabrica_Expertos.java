/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas;

import Experto.Experto;
import Sensores.Experto_Sensor;

/**
 *
 * @author eduardo
 */
public class Fabrica_Expertos {
    
    private static Fabrica_Expertos instancia;

    public static Fabrica_Expertos getInstancia() {
        if (instancia == null) {
            instancia = new Fabrica_Expertos();
        }
        return instancia;
    }

    public enum expertos {

        Sensores
    }

    public Experto getExperto(expertos expertoNombre) {
        switch (expertoNombre) {
            case Sensores:
                return new Experto_Sensor();
            default:
                return null;

        }
    }
    
    
}
