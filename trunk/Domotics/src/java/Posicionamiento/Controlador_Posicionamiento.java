/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Posicionamiento;

import Adaptador_Sensores.Observador_Sensores;
import Controlador.Controlador;
import Fabricas.Fabrica_Expertos;
import Negocio.Ambiente;
import Negocio.Sensor;
import Reproductor.Reproductor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *
 * @author eduu
 */
public class Controlador_Posicionamiento extends Controlador implements Observador_Sensores {

    Experto_Posicionamiento experto;

    public Controlador_Posicionamiento() {

        experto = (Experto_Posicionamiento) Fabrica_Expertos.getInstancia().getExperto(Fabrica_Expertos.expertos.Posicionamiento);


    }

    public void notificarMovimiento(Ambiente ambiente, Sensor sensor) {
        //debo saber cual es el ambiente en el que esta entrando y buscar el mensaje que se carga
        
       // experto.notificarMovimiento(ambiente, sensor);
        
    }
}
