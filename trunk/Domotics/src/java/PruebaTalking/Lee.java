/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebaTalking;
import javax.speech.*;

import javax.speech.synthesis.*;

import java.util.*;
/**
 *
 * @author edu
 */
public class Lee {
    


 public static void main(String[] args) {

 try {

 

 String say=args[0];

 

 SynthesizerModeDesc required = new SynthesizerModeDesc();

 required.setLocale(Locale.ROOT);

 

 Voice voice=new Voice(null, Voice.GENDER_FEMALE, Voice.GENDER_FEMALE, null);



 required.addVoice(voice);

 

 Synthesizer synth = Central.createSynthesizer(null);

 

 synth.allocate();

 synth.resume();

 

 synth.speakPlainText(say,null);

 

 synth.waitEngineState(Synthesizer.QUEUE_EMPTY);

 synth.deallocate();

 

 } catch (Exception e) {

 e.printStackTrace();

 }

 }

}
