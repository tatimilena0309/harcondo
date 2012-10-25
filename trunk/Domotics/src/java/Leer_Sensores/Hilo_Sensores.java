/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Leer_Sensores;

import java.lang.*;
import java.io.*;

/**
 *
 * @author eduardo
 */
public class Hilo_Sensores extends Thread{
    
    Controlador_Leer_Sensores controlador;
    public Hilo_Sensores() {
        super();
    }
    @Override
    public void run() {
        
        controlador.leerSensor();//si recibe un 0, se duerme durante 10 segundos y vuelve a correr
                                //si recibe un 1, busca cual es el sensor que se disparó y se vuelve a dormir 10 segundos
        
        
        
        
        //        sleep((long)(Math.random() * 2500));
        
    }
    
       
}

