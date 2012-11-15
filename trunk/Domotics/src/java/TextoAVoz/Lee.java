/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextoAVoz;

import javax.speech.*;

import javax.speech.synthesis.*;

import java.util.*;

/**
 *
 * @author edu
 */

/*
 * esta clase recibe una cadena de caracteres com argumento y dice con voz esa cadena como salida
 * 
 */

public class Lee {

    public static void main(String[] args) {

        try {



            String say = args[0];



            SynthesizerModeDesc required = new SynthesizerModeDesc();

            required.setLocale(Locale.ROOT);



            Voice voice = new Voice("kevin16", Voice.GENDER_MALE, Voice.GENDER_MALE, null);



            required.addVoice(voice);



            Synthesizer synth = Central.createSynthesizer(null);



            synth.allocate();

            synth.resume();



            synth.speakPlainText(say, null);



            synth.waitEngineState(Synthesizer.QUEUE_EMPTY);

            synth.deallocate();



        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
