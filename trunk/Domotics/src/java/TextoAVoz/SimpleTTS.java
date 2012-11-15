/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextoAVoz;

import com.sun.speech.freetts.audio.AudioPlayer;
//import com.sun.speech.freetts.audio.JavaClipAudioPlayer;
//import com.sun.speech.freetts.audio.MultiFileAudioPlayer;
import com.sun.speech.freetts.audio.NullAudioPlayer;
//import com.sun.speech.freetts.audio.RawFileAudioPlayer;
import com.sun.speech.freetts.audio.SingleFileAudioPlayer;
//import java.io.*;
//import java.net.URL;
//import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import com.sun.speech.freetts.Voice;


import com.sun.speech.freetts.VoiceManager;
//import com.sun.speech.freetts.audio.JavaClipAudioPlayer;

/**
 *
 * @author eduu
 */
public class SimpleTTS {

    /**
     *
     * FreeTTS
     * requiere en el CLASSPATH: cmu_time_awb.jar, cmu_us_kal.jar, cmudict04.jar, cmulex.jar, cmutimelex.jar,
     * en_us.jar, freets.jar, jsapi.jar
     *
     * @author jose
     * @version 0.0.0.1
     * @since JDK 1.5 / Eclipse Callisto
     */
    Voice voice = null;

    public SimpleTTS(String voiceName) throws Exception {
        VoiceManager voiceManager = VoiceManager.getInstance();
        this.voice = voiceManager.getVoice(voiceName);
        if (this.voice == null) {
            System.out.println("La lista de voces disponibles es:");
            listAllVoices();
            throw new Exception("No se encuentra la voz llamada: " + voiceName + ". Por favor selecciona una voz diferente.");
        }
        this.voice.allocate();
    }
//----

    public void speak(String text) throws Exception {
        this.voice.speak(text);
    }
//----

    public void toFile(String filename, String text) throws Exception {
        javax.sound.sampled.AudioFileFormat.Type type = getAudioType(filename);
        AudioPlayer audioPlayer = null;
        if (audioPlayer == null) {
            audioPlayer = new NullAudioPlayer();
        }
        audioPlayer = new SingleFileAudioPlayer(getBasename(filename), type);
        System.out.println("audioPlayer " + audioPlayer);
        this.voice.setAudioPlayer(audioPlayer);
        this.voice.speak(text);
        audioPlayer.close();
    }
//----

    public void close() throws Exception {
        this.voice.deallocate();
    }
//----

    public static void listAllVoices() {
        System.out.println();
        System.out.println("All voices available:");
        VoiceManager voiceManager = VoiceManager.getInstance();
        System.out.println("voiceManager:" + voiceManager);
        Voice[] voices = voiceManager.getVoices();
        for (int i = 0; i < voices.length; i++) {
            System.out.println(" " + voices[i].getName()
                    + " (" + voices[i].getDomain() + " domain)");
        }
    }
//----

    public static javax.sound.sampled.AudioFileFormat.Type getAudioType(String file) {
        javax.sound.sampled.AudioFileFormat.Type types[] = AudioSystem.getAudioFileTypes();
        String extension = getExtension(file);
        for (int i = 0; i < types.length; i++) {
            if (types[i].getExtension().equals(extension)) {
                return types[i];
            }
        }
        return null;
    }
//----

    public static String getExtension(String path) {
        int index = path.lastIndexOf(".");
        if (index == -1) {
            return null;
        } else {
            return path.substring(index + 1);
        }
    }
//----

    public static String getBasename(String path) {
        int index = path.lastIndexOf(".");
        if (index == -1) {
            return path;
        } else {
            return path.substring(0, index);
        }
    }
//----

    static public void main(String[] args) throws Exception {
        try {
            
            String hora = args[0];
// Instanciamos para usar la voz "kevin16"
            SimpleTTS voz = new SimpleTTS("kevin16");
// Reproduce por el altavoz
//while (true)
//{
            voz.speak(hora);
            //voz.speak("Juan es malo");
//}
            //voz.speak("La hora es 20 con 32 minutos");
// Graba un fichero de audio con el contenido en el directorio
            voz.toFile("ttsdemo.wav", "La hora es 8 con 35 minutos");
// Podriamos reproducir este fichero desde consola: $ mplayer ttsdemo.wav
// Cerramos
            voz.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//----
}
//end of class SimpleTTS