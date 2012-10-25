/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Leer_Sensores;

import Adaptador_Sensores.Suscriptor_Sensores;
import Experto.Experto;
import Negocio.Ambiente;
import Negocio.Sensor;

/**
 *
 * @author eduu
 */
public class Experto_Leer_Sensores extends Experto {

    Suscriptor_Sensores suscriptor = Suscriptor_Sensores.getInstancia();

    public void confirmar(Ambiente ambiente, Sensor sensor) {

        suscriptor.notificar(ambiente, sensor);

    }

    public void leer_sensor() { //este método tiene que recibir los datos del usb para saber
        // que sensor es el que se activa y devuelve sensor y ambiente, y luego llamar al 
        //metodo confirmar para hacer uso del observador
    }
}
