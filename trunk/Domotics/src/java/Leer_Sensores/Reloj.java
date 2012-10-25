/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Leer_Sensores;

/**
 *
 * @author eduardo
 */
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reloj {

    public Reloj() {
        // Modificar el tiempo de delay en milisegundos
        Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                // Aqui ejecuta la accion
                System.out.println("Hola mundo");
            }
        });
        timer.start();

    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Reloj reloj = new Reloj();
            }
        });

    }
}