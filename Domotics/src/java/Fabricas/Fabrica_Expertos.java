/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas;

import Ambientes.Experto_Ambiente;
import EnvioCorreos.Experto_Correos;
import Experto.Experto;
import Leer_Sensores.Experto_Leer_Sensores;
import Mensajes.Experto_Mensajes;
import Posicionamiento.Experto_Posicionamiento;
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

        Sensores, Ambiente, Mensajes,Posicionamiento, Leer_Sensores, Correos}

    public Experto getExperto(expertos expertoNombre) {
        switch (expertoNombre) {
            case Sensores:
                return new Experto_Sensor();
            case Ambiente:
                return new Experto_Ambiente();
            case Mensajes:
                return new Experto_Mensajes();
            case Leer_Sensores:
                return new Experto_Leer_Sensores();
            case Correos:
                return new Experto_Correos();
            case Posicionamiento:
                return new Experto_Posicionamiento();
            default:
                return null;

        }
    }
    
    
}
