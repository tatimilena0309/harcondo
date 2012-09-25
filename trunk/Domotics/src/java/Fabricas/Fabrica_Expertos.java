/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas;

import Ambientes.Experto_Ambiente;
import Experto.Experto;
import Mensajes.Experto_Mensajes;
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

        Sensores, Ambiente, Mensajes
    }

    public Experto getExperto(expertos expertoNombre) {
        switch (expertoNombre) {
            case Sensores:
                return new Experto_Sensor();
            case Ambiente:
                return new Experto_Ambiente();
            case Mensajes:
                return new Experto_Mensajes();
            default:
                return null;

        }
    }
    
    
}
