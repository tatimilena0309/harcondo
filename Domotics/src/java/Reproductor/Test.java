/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reproductor;

import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *
 * @author Edu
 */
public class Test {

     Reproductor reproduce = new Reproductor();
     
    public Test() throws BasicPlayerException {
        
    //reproduce.loadFile("C:/Users/Edu/Desktop/probando.mp3");
    //reproduce.play();
         
    }
    
    
    
    public static void main(String[] args) throws BasicPlayerException {

        Reproductor rep = new Reproductor();
        rep.loadFile("C:/Users/Edu/Desktop/probando.mp3");
        rep.play();

    }
    
    
    
}
