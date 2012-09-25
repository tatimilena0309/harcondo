/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reproductor;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *
 * @author Edu
 */
public class Reproductor {

    private BasicPlayer basicPlayer;

    public Reproductor() {
        basicPlayer = new BasicPlayer();
    }

    public void play() {
        try {
            basicPlayer.play();
        } catch (BasicPlayerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void loadFile(String ruta) throws BasicPlayerException {
        basicPlayer.open(new File(ruta));
    }
}