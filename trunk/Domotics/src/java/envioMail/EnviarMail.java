/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package envioMail;

import Posicionamiento.Controlador_Posicionamiento;
import Reproductor.Reproductor;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class EnviarMail {

    public static void main(String[] args) {

        SendAuthentication.Send();

    }
}

class SendAuthentication {

     
    public static void Send() {

        Reproductor rep = new Reproductor();
        String host = "smtp.gmail.com";//Suponiendo que el servidor SMTPsea la propia máquina
        String from = "proyectosistemas2012@gmail.com";
        String to = "eduardomauriz@gmail.com";


        System.out.println("Prueba para enviar un mail..." + new java.util.Date());

        Properties prop = new Properties();
        prop.setProperty("mail.smtp.host", "smtp.gmail.com");
        prop.setProperty("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.smtp.port", "587");
        prop.setProperty("mail.smtp.user", "proyectosistemas2012@gmail.com");
        prop.setProperty("mail.smtp.auth", "true");



        try {

            SMTPAuthentication auth = new SMTPAuthentication();
            Session session = Session.getInstance(prop, auth);
            Message msg = getMessage(session, from, to);
            System.out.println("Enviando ...");



            Transport.send(msg);
            System.out.println("Mensaje enviado!");
            try {
                rep.loadFile("D:/sistema/locutor/Ambiente 1.mp3");//aca tengo que poner un archivo de audio que diga: El mensaje fue enviado a Hugo
            } catch (BasicPlayerException ex) {
                Logger.getLogger(Controlador_Posicionamiento.class.getName()).log(Level.SEVERE, null, ex);
            }
            rep.play();

        } catch (Exception e) {

            ExceptionManager.ManageException(e);

        }

    }

    private static MimeMessage getMessage(Session session, String from, String to) {

        try {

            MimeMessage msg = new MimeMessage(session);
            msg.setText("Hugo necesito ayuda por favor!");
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setFrom(new InternetAddress(from, "CLARITA"));
            return msg;

        } catch (java.io.UnsupportedEncodingException ex) {

            ExceptionManager.ManageException(ex);
            return null;

        } catch (MessagingException ex) {

            ExceptionManager.ManageException(ex);
            return null;

        }

    }
}

class SMTPAuthentication extends javax.mail.Authenticator {

    public PasswordAuthentication getPasswordAuthentication() {

        String username = "proyectosistemas2012@gmail.com";

        String password = "claritarobotina";

        return new PasswordAuthentication(username, password);

    }
}

class ExceptionManager {

    public static void ManageException(Exception e) {

        System.out.println("Se ha producido una exception");

        System.out.println(e.getMessage());

        e.printStackTrace(System.out);

    }
}