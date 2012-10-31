/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Leer_Sensores;

import Controlador.Controlador;
import Fabricas.Fabrica_Expertos;
import Negocio.Ambiente;
import Negocio.Sensor;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

import java.util.TimerTask;

/**
 *
 * @author eduu
 */
public class Controlador_Leer_Sensores extends Controlador {

    Experto_Leer_Sensores experto;
    leer_Pic leePic;
    public int segundos; // manejar el valor del contador
    public boolean frozen; // manejar el estado del contador TIMER AUTOMATICO -- True Detenido | False Corriendo

    public Controlador_Leer_Sensores() {

        experto = (Experto_Leer_Sensores) Fabrica_Expertos.getInstancia().getExperto(Fabrica_Expertos.expertos.Leer_Sensores);

    }

    public void leerSensor() {

        Sensor sensorDevuelto = experto.leer_sensor();
        //busco el ambiente asociado al sensor, y luego llamo al metodo confirmar del experto
        //y le paso el sensor y el ambiente
        Ambiente ambienteEncontrado = experto.getAmbientes(sensorDevuelto);
        
        if (ambienteEncontrado == null) {
            //mensaje
            //no se encontró ambiente para ese sensor
            
        }else{
            
            experto.confirmar(ambienteEncontrado, sensorDevuelto);
        }
        

    }
}
    /*    
     public void Reloj() {


     }

     // clase interna que representa una tarea, se puede crear varias tareas y asignarle al timer luego
     class MiTarea extends TimerTask {

     public void run() {
     segundos++;
     System.out.println(segundos);
     // aqui se puede escribir el codigo de la tarea que necesitamos ejecutar
     }// end run()
     }// end SincronizacionAutomatica
     }

     public void Start(int pSeg) throws Exception {
     frozen = false;
     // le asignamos una tarea al timer
     timer.schedule(new MiTarea(), 0, pSeg * 1000 * 60);
     }// end Start

     public void Stop() {
     System.out.println("Stop");
     frozen = true;
     }// end Stop

     public void Reset() {
     System.out.println("Reset");
     frozen = true;
     segundos = 0;
     }// end Reset*/
    /*
     * 
     Timer timer = new Timer(1000, new ActionListener() {

     public void actionPerformed(ActionEvent arg0) {
     // Aqui ejecuta la accion
     //debe leer el pic para ver si hay algún puerto con valor = 1. esto significa que hay alguien en la 
     //habitación
     String puerto = leePic.leerPic();
     if ("0".equals(puerto)) {//ningún sensor se activa

     Reloj reloj = new Reloj();
     } else {

     //tengo que pasar el ambiente y el sensor obtenido de la variable "puerto"
     experto.confirmar(null, null);

     }

     }
     });
     timer.start();

     */
