/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnvioCorreos;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Ejemplo de envio de correo simple con JavaMail
 *
 * @author Chuidiang
 *
 */
/*
public class EnviarMail{
/**
 * main de prueba
 * @param args Se ignoran.
 */
/* public static void main(String[] args)
{
try
{
// Propiedades de la conexión
Properties props = new Properties();
props.setProperty("mail.smtp.host", "smtp.gmail.com");
props.setProperty("mail.smtp.starttls.enable", "true");
props.setProperty("mail.smtp.port", "587");
props.setProperty("mail.smtp.user", "eduardomauriz@gmail.com");
props.setProperty("mail.smtp.auth", "true");

// Preparamos la sesion
Session session = Session.getDefaultInstance(props);
session.setDebug(true);

// Construimos el mensaje
MimeMessage message = new MimeMessage(session);
message.setFrom(new InternetAddress("eduardomauriz@gmail.com"));
message.addRecipient(
Message.RecipientType.TO,
new InternetAddress("eduardomauriz@gmail.com"));
message.setSubject("Hola");
message.setText(
"Mensajito con Java Mail" + "de los buenos." + "poque si");

// Lo enviamos.
Transport t = session.getTransport("smtp");
t.connect("eduardomauriz@gmail.com", "30298400");
t.sendMessage(message, message.getAllRecipients());

// Cierre.
t.close();
}
catch (Exception e)
{
e.printStackTrace();
}
}
}*/
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


        // prop.put("mail.smtp.host", host);
        /*Esta línea es la que indica al API que debe autenticarse*/
        //prop.put("mail.smtp.auth", "true");

        /*Añadir esta linea si queremos ver una salida detallada del programa*/
//prop.put("mail.debug", "true");

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