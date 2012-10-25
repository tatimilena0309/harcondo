/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Leer_Sensores;

import jPicUsb.iface;

/**
 *
 * @author eduardo
 */
public class leer_Pic {
    
    
    
    public String leerPic(){
        
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
                System.out.println("Datos recibidos \n");
            }
            
            //el de lectura solo, es:
            byte[]respuestaSensor = iface.QRead(6, 1000);
            ///String datosLeidos = new String(respuestaSensor, "uft-8");
            String datosLeidos = new String();
            if (respuestaSensor.length ==0) {
                System.out.println("No se recibieron datos del usb, no tene sensores conectados\n");
            } else {
                System.out.println("Datos recibidos proveniente del puerto: " + " Habitación: "  + "\n");
            }
            
        } catch (Exception ex) {
            System.out.println("ERROR:" + ex.getMessage());
        }
        
    return null;    
    }
    
}
