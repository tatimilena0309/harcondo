/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnvioCorreos;

import Experto.Experto;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author edu
 */
public class Experto_Correos extends Experto{
    
    
    public static void Send(String origen, String destino, String Asunto, String mensaje) {

        String host = "smtp.gmail.com";//Suponiendo que el servidor SMTPsea la propia máquina
        String from = origen;
        String to = destino;


        System.out.println("Prueba para enviar un mail..." + new java.util.Date());

        Properties prop = new Properties();
        prop.setProperty("mail.smtp.host", "smtp.gmail.com");
        prop.setProperty("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.smtp.port", "587");
        prop.setProperty("mail.smtp.user", origen);
        prop.setProperty("mail.smtp.auth", "true");



        try {

            SMTPAuthentication auth = new SMTPAuthentication();
            Session session = Session.getInstance(prop, auth);
            Message msg = getMessage(session, from, to, Asunto);
            System.out.println("Enviando ...");



            Transport.send(msg);
            System.out.println("Mensaje enviado!");

        } catch (Exception e) {

            ExceptionManager.ManageException(e);

        }

    }

    private static MimeMessage getMessage(Session session, String from, String to, String asunto) {

        try {

            MimeMessage msg = new MimeMessage(session);
            msg.setText(asunto);
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setFrom(new InternetAddress(from, "Clarita"));
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
