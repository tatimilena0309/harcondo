/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reproductor;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *
 * @author Edu
 */
public class Test {

    Reproductor reproduce = new Reproductor();

    public static void main(String[] args) throws BasicPlayerException {
        

        Reproductor rep = new Reproductor();
        rep.loadFile("C:/Users/Edu/Desktop/probando.mp3");
        rep.play();

    }
}
