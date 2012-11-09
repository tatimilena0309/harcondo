/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebaTalking;

import Posicionamiento.Controlador_Posicionamiento;
import Reproductor.Reproductor;
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
public class Escucha extends ResultAdapter {

    static Recognizer recognizer;
    String gst;

    @Override
    public void resultAccepted(ResultEvent re) {

        Reproductor rep = new Reproductor();
        try {

            Result res = (Result) (re.getSource());

            ResultToken tokens[] = res.getBestTokens();

            String args[] = new String[1];

            args[0] = "";

            for (int i = 0; i < tokens.length; i++) {

                gst = tokens[i].getSpokenText();

                args[0] += gst + " ";

                System.out.print(gst + " ");

            }

            System.out.println();

            if (gst.equals("Musica")) {

                try {
                    rep.loadFile("D:/musica/bajofondo.mp3");
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(Controlador_Posicionamiento.class.getName()).log(Level.SEVERE, null, ex);
                }
                rep.play();

            }

            if (gst.equals("Hora")) {

                GregorianCalendar cal = new GregorianCalendar();
                int hora, minutos, segundos;
                hora = cal.get(Calendar.HOUR_OF_DAY);
                minutos = cal.get(Calendar.MINUTE);
                segundos = cal.get(Calendar.SECOND);
                System.out.print("Fecha: " + cal.getTime() + "\n"
                        + " son las " + hora + " horas y " + minutos + " minutos" + "\n"
                        + "\n Día: " + cal.get(Calendar.DAY_OF_MONTH)
                        + " Mes: " + (cal.get(Calendar.MONTH) + 1)
                        + " Año: " + cal.get(Calendar.YEAR) + "\n"
                        + " NOTA: Se le suma 1 al mes porque enero corresponde al mes 0\n");

                //habria que poner la otra libreria que es de texto a voz para reproducir cadena de caracteres
            }


            if (gst.equals("Reproductor")) {//ejecuta el windows media player, habria que probar que reprodujera un play list

                Process p = null;
                try {
                    /* directorio/ejecutable es el path del ejecutable y un nombre */
                    p = Runtime.getRuntime().exec("C:/Archivos de programa/Windows Media Player/mplayer2.exe");
                } catch (Exception e) {
                    /* Se lanza una excepción si no se encuentra en ejecutable o el fichero no es ejecutable. */
                }
                
                p.destroy();//se cierra el proceso, yo pondria que si la persona dice: terminar musica, se ponga el p.destroy()

            }

            if (gst.equals("salir")) {

                recognizer.deallocate();

                args[0] = "Hasta la proxima Cmop!";

                System.out.println(args[0]);

                Lee.main(args);

                System.exit(0);

            } else {

                recognizer.suspend();

                Lee.main(args);

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