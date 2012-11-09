/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Posicionamiento;

import Experto.Experto;
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
public class Experto_Posicionamiento extends Experto{
//public static void main (String[] args) {
    public void notificarMovimiento(Ambiente ambiente, Sensor sensor) {
  //    Ambiente ambiente = new Ambiente(); 
    //  ambiente.setNombre("1");
        Reproductor rep = new Reproductor();
        if (ambiente.getNombre().equals("1")) {

            try {
                rep.loadFile("D:/musica/Ambiente 1.mp3");
            } catch (BasicPlayerException ex) {
                Logger.getLogger(Controlador_Posicionamiento.class.getName()).log(Level.SEVERE, null, ex);
            }
            rep.play();

        }
        if (ambiente.getNombre().equals("2")) {

            try {
                rep.loadFile("C:/Users/Edu/Desktop/ambiente2.mp3");
            } catch (BasicPlayerException ex) {
                Logger.getLogger(Controlador_Posicionamiento.class.getName()).log(Level.SEVERE, null, ex);
            }
            rep.play();

        }
        if (ambiente.getNombre().equals("3")) {

            try {
                rep.loadFile("C:/Users/Edu/Desktop/ambiente3.mp3");
            } catch (BasicPlayerException ex) {
                Logger.getLogger(Controlador_Posicionamiento.class.getName()).log(Level.SEVERE, null, ex);
            }
            rep.play();

        }
        if (ambiente.getNombre().equals("4")) {

            try {
                rep.loadFile("C:/Users/Edu/Desktop/ambiente4.mp3");
            } catch (BasicPlayerException ex) {
                Logger.getLogger(Controlador_Posicionamiento.class.getName()).log(Level.SEVERE, null, ex);
            }
            rep.play();

        }
        if (ambiente.getNombre().equals("5")) {

            try {
                rep.loadFile("C:/Users/Edu/Desktop/ambiente5.mp3");
            } catch (BasicPlayerException ex) {
                Logger.getLogger(Controlador_Posicionamiento.class.getName()).log(Level.SEVERE, null, ex);
            }
            rep.play();

        }
        
        
        
    }
    
    
    
    
}
