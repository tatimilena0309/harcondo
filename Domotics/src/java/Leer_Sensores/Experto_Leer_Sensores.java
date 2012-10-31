/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Leer_Sensores;

import Adaptador_Sensores.Suscriptor_Sensores;
import Experto.Experto;
import Negocio.Ambiente;
import Negocio.Sensor;
import jPicUsb.iface;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import persistencia.Fachada_Persistencia;

/**
 *
 * @author eduu
 */
public class Experto_Leer_Sensores extends Experto {

    Suscriptor_Sensores suscriptor = Suscriptor_Sensores.getInstancia();

    public void confirmar(Ambiente ambiente, Sensor sensor) {

        suscriptor.notificar(ambiente, sensor);

    }

    public Sensor leer_sensor() { //este método tiene que recibir los datos del usb para saber
        // que sensor es el que se activa y devuelve sensor y ambiente, y luego llamar al 
        //metodo confirmar para hacer uso del observador

        iface.load();

        //Creamos un arreglo de bytes de tamaño 64
        byte[] out = new byte[64];
        //agregamos el comando 99 en el primer byte del arreglo
        out[0] = 99;
        //configuramos el vid_pid del dispositivo asi podemos usar las funciones "rapidas" de la interfaz
        iface.set_vidpid("vid_04d8&pid_000b");
        //configuramos la instancia del dispositivo asi podemos usar las funciones "rapidas" de la interfaz
        iface.set_instance(0);
        try {
            //iface.WriteRead(byte[] salida, int writeout, int readin, long timeoutmsec)
            //Parametro 1: arreglo de bytes con los datos a enviar (out)
            //Parametro 2: cantidad de bytes del arreglo que se enviaran via usb (1)
            //Parametro 3: cantidad de bytes que se esperan de respuesta via usb (6)
            //Parametro 4: tiempo maximo que se esperara al dispositivo en el envio y la recepcion (1 segundo)
            //Retorna: arreglo de bytes con la respuesta del dispositivo usb
            byte[] respuesta = iface.QWriteRead(out, 1, 6, 1000);

            //convertimos el arreglo de bytes recibido en una cadena con codificacion utf-8
            String data_in = new String(respuesta, "utf-8");
            //verificamos que se hallan recibido datos
            if (data_in.length() == 0) {
                System.out.println("No se recibieron datos\n");

            } else {
                System.out.println("Datos recibidos:\" " + "data_in");

            }

            //el de lectura solo, es:
            byte[] respuestaSensor = iface.QRead(6, 1000);
            ///String datosLeidos = new String(respuestaSensor, "uft-8");
            String datosLeidos = new String();
            if (respuestaSensor.length == 0) {
                System.out.println("No se recibieron datos del usb, no tiene sensores conectados\n");

            } else {
                System.out.println("Datos recibidos:" + datosLeidos + "\n");

            }

        } catch (Exception ex) {
            System.out.println("ERROR:" + ex.getMessage());
        }

        return null;

    }

    public Ambiente getAmbientes(Sensor sensor) {
        //Buscamos los sensores de la base de datos y los devolvemos
        List<Ambiente> listaAmbientes;
        Ambiente ambienteDevuelto = new Ambiente();

        listaAmbientes = Fachada_Persistencia.getInstance().getListaObjetos("Ambiente");
        
        for (Ambiente ambiente : listaAmbientes) {
            
            if (ambiente.getSensor().getId().equals(sensor.getId())) {
                
                ambienteDevuelto = ambiente;
                
            }else{
                ambienteDevuelto = null;
            }
        }

        return ambienteDevuelto;

    }
}
