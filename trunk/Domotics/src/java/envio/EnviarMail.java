/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package envio;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EnviarMail {

    public static void main(String[] args) {

        SendAuthentication.Send();

    }
}

class SendAuthentication {

    public static void Send() {

        String host = "smtp.gmail.com";//Suponiendo que el servidor SMTPsea la propia máquina
        String from = "eduardomauriz@gmail.com";
        String to = "eduardomauriz@gmail.com";


        System.out.println("Prueba para enviar un mail..." + new java.util.Date());

        Properties prop = new Properties();
        prop.setProperty("mail.smtp.host", "smtp.gmail.com");
        prop.setProperty("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.smtp.port", "587");
        prop.setProperty("mail.smtp.user", "eduardomauriz@gmail.com");
        prop.setProperty("mail.smtp.auth", "true");



        try {

            SMTPAuthentication auth = new SMTPAuthentication();
            Session session = Session.getInstance(prop, auth);
            Message msg = getMessage(session, from, to);
            System.out.println("Enviando ...");



            Transport.send(msg);
            System.out.println("Mensaje enviado!");

        } catch (Exception e) {

            ExceptionManager.ManageException(e);

        }

    }

    private static MimeMessage getMessage(Session session, String from, String to) {

        try {

            MimeMessage msg = new MimeMessage(session);
            msg.setText("El mail desde java. Este mensaje a utilizado autenticacion en el servidor.");
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setFrom(new InternetAddress(from, "JavaMail en accion"));
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

        String username = "eduardomauriz@gmail.com";

        String password = "30298400";

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