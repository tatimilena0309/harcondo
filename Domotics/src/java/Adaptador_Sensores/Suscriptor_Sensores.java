/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adaptador_Sensores;

import Negocio.Ambiente;
import Negocio.Sensor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduu
 */
public class Suscriptor_Sensores {
    
    
    private static Suscriptor_Sensores instancia;
    List<Observador_Sensores> observadores_agregados = new ArrayList<Observador_Sensores>();
    Observador_Sensores observador;

    public static Suscriptor_Sensores getInstancia() {
        if (instancia == null) {
            instancia = new Suscriptor_Sensores();
        }
        return instancia;
    }

 
    public void agregar_observador(Observador_Sensores observador){
        
        observadores_agregados.add(observador);
        
    }
    
    
    public void notificar(Ambiente ambiente, Sensor sensor){
        
        observador.notificarMovimiento();
        
    }
    
    
}
