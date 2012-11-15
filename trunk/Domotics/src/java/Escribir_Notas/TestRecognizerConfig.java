/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Escribir_Notas;

import java.util.Locale;

import javax.speech.Central;

import javax.speech.EngineList;

import javax.speech.recognition.RecognizerModeDesc;

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
public class TestRecognizerConfig {

    public static void main(String[] args) {

        try {
            Central.registerEngineCentral("com.cloudgarden.speech.CGEngineCentral");
            RecognizerModeDesc desc =
                    new RecognizerModeDesc(Locale.US, Boolean.TRUE);
            EngineList el = Central.availableRecognizers(desc);

            if (el.size() < 1) {
                System.out.println("Recognition Engine is not available");
                System.exit(1);
            } else {
                System.out.println("Recognition Engine is available");
                System.exit(1);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
