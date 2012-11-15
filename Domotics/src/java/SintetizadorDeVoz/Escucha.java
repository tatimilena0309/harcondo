/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SintetizadorDeVoz;

import TextoAVoz.Lee;
import Posicionamiento.Controlador_Posicionamiento;
import Reproductor.Reproductor;
import TextoAVoz.SimpleTTS;
import envioMail.EnviarMail;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import javax.speech.*;

import javax.speech.recognition.*;

import java.io.FileReader;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *
 * @author eduardo
 */

/*esta clase lo que hace es recibir audio por el microfono y lo transforma en 
 * una salida de texto o tambien ejecuta alguna accion o tambien puede llamar
 * a la clase lee para recitar lo que se le pasa como texto
 * 
 * 
 */
public class Escucha extends ResultAdapter {

    static Recognizer recognizer;
    String gst;
    Process reproduce = null;

    @Override
    public void resultAccepted(ResultEvent re) {

        Reproductor rep = new Reproductor();
        try {

            Result res = (Result) (re.getSource());

            ResultToken tokens[] = res.getBestTokens();

            String args[] = new String[1];

            args[0] = "";

            for (int i = 0; i < tokens.length; i++) {// con este bucle pone la salida de lo que se dice en pantalla

                gst = tokens[i].getSpokenText();

                args[0] += gst + " ";

                System.out.print(gst + " ");

            }

            System.out.println();

            if (gst.equals("Escuchar Musica")) {

                try {
                    rep.loadFile("D:/sistema/locutor/tipomusica.mp3");//poner una voz que diga que tipo de música desea escuchar
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(Controlador_Posicionamiento.class.getName()).log(Level.SEVERE, null, ex);
                }
                rep.play();
            }
            if (gst.equals("Tecno")) {

                String cadena;
                File fichero = new File("D:/sistema/musica/tecno.M3U");
                cadena = fichero.getAbsolutePath();
                try {
                    Runtime rt = Runtime.getRuntime();
                    String[] callAndArgs = {"C:/Program Files/Windows Media Player/wmplayer.exe", cadena};
                    Process child = rt.exec(callAndArgs);
                } catch (Exception eee) {
                    System.out.println("hubo error");
                }


            }
            if (gst.equals("Instrumental")) {

                String cadena;
                File fichero = new File("D:/sistema/musica/instrumental.M3U");
                cadena = fichero.getAbsolutePath();
                try {
                    Runtime rt = Runtime.getRuntime();
                    String[] callAndArgs = {"C:/Program Files/Windows Media Player/wmplayer.exe", cadena};
                    Process child = rt.exec(callAndArgs);
                } catch (Exception eee) {
                    System.out.println("hubo error");
                }


            }

            if (gst.equals("Nacional")) {

                String cadena;
                File fichero = new File("D:/sistema/musica/nacional.M3U");
                cadena = fichero.getAbsolutePath();
                try {
                    Runtime rt = Runtime.getRuntime();
                    String[] callAndArgs = {"C:/Program Files/Windows Media Player/wmplayer.exe", cadena};
                    Process child = rt.exec(callAndArgs);
                } catch (Exception eee) {
                    System.out.println("hubo error");
                }


            }

            if (gst.equals("Cuarteto")) {

                String cadena;
                File fichero = new File("D:/sistema/musica/cuarteto.M3U");
                cadena = fichero.getAbsolutePath();
                try {
                    Runtime rt = Runtime.getRuntime();
                    String[] callAndArgs = {"C:/Program Files/Windows Media Player/wmplayer.exe", cadena};
                    Process child = rt.exec(callAndArgs);
                } catch (Exception eee) {
                    System.out.println("hubo error");
                }


            }

            if (gst.equals("Musica en linea")) {

                String cadena;
                cadena = "http://www.sonicomusica.com/ar/";
                System.out.println(cadena);
                try {
                    Runtime rt = Runtime.getRuntime();
                    String[] callAndArgs = {"C:/Users/eduu/AppData/Local/Google/Chrome/Application/chrome.exe", cadena};
                    Process child = rt.exec(callAndArgs);
                } catch (Exception eee) {
                    System.out.println("hubo error");
                }
            }
            
            if (gst.equals("Terminar Internet")) {

                 System.out.println("internet finalizado");
                TerminarProceso.terminarProceso("chrome");

            }

            if (gst.equals("Reproductor")) {//ejecuta el windows media player

                System.out.println("musica finalizada");
                reproduce = Runtime.getRuntime().exec("C:/Users/eduu/AppData/Local/Google/Chrome/Application/chrome.exe");

            }


            if (gst.equals("Cerrar")) {

                System.out.println("musica finalizada");
                TerminarProceso.terminarProceso("wmplayer");


            }



            if (gst.equals("Canario")) {

                try {
                    rep.loadFile("D:/sistema/musica/Ambiente 2.mp3");
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(Controlador_Posicionamiento.class.getName()).log(Level.SEVERE, null, ex);
                }
                rep.play();



            }



            if (gst.equals("nada")) {//ESTE ES EL MODELO DE PRUEBA DE REPRODUCCION DE MUSICA

                try {
                    rep.loadFile("D:/sistema/musica/bajofondo.mp3");
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(Controlador_Posicionamiento.class.getName()).log(Level.SEVERE, null, ex);
                }
                rep.play();

            }

            if (gst.equals("Hora")) {

                String tiempo = "";
                GregorianCalendar cal = new GregorianCalendar();
                int hora, minutos, segundos;
                hora = cal.get(Calendar.HOUR_OF_DAY);
                minutos = cal.get(Calendar.MINUTE);
                segundos = cal.get(Calendar.SECOND);

                /* System.out.print("Fecha: " + cal.getTime() + "\n"
                + " son las " + hora + " horas y " + minutos + " minutos" + "\n"
                + "\n Día: " + cal.get(Calendar.DAY_OF_MONTH)
                + " Mes: " + (cal.get(Calendar.MONTH) + 1)
                + " Año: " + cal.get(Calendar.YEAR) + "\n"
                + " NOTA: Se le suma 1 al mes porque enero corresponde al mes 0\n");*/
                tiempo = "son las " + hora + " horas y " + minutos + " minutos";
                args[0] = tiempo;
                //SimpleTTS.main(args);  // hace lo mismo que la line de abajo
                Lee.main(args); // hace lo mismo que la linea de arriba


            }



            if (gst.equals("Ayuda")) {

                //envía correo
                EnviarMail.main(args);

            }


            if (gst.equals("salir")) {

                recognizer.deallocate();

                args[0] = "Hasta la proxima Clarita";

                System.out.println(args[0]);

                //Lee.main(args);

                System.exit(0);

            } else {

                recognizer.suspend();

                //Lee.main(args);

                recognizer.resume();

            }

        } catch (Exception ex) {

            System.out.println("Ha ocurrido algo inesperado " + ex);

        }

    }

    public static void main(String args[]) {

        try {

            recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));

            recognizer.allocate();



            FileReader grammar1 = new FileReader("D:/SimpleGrammarES2.txt");



            RuleGrammar rg = recognizer.loadJSGF(grammar1);

            rg.setEnabled(true);



            recognizer.addResultListener(new Escucha());



            System.out.println("Empieze Dictado");

            recognizer.commitChanges();



            recognizer.requestFocus();

            recognizer.resume();

        } catch (Exception e) {

            System.out.println("Exception en " + e.toString());

            e.printStackTrace();

            System.exit(0);

        }

    }
}