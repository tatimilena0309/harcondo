/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnvioCorreos;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.catalina.ha.backend.Sender;

/**
 * Ejemplo de envio de correo simple con JavaMail
 *
 * @author Chuidiang
 *
 */
public class Cartero {

    
    private final Properties properties = new Properties();
    private String password;
    private Session session;

    private void init() {
        // Nombre del host de correo, es smtp.gmail.com
        properties.put("mail.smtp.host", "eduardomauriz.gmail.com");
       // TLS si está disponible
        properties.put("mail.smtp.starttls.enable", "true");
        // Puerto de gmail para envio de correos
        properties.put("mail.smtp.port", 587);
        // Nombre del usuario
        properties.put("mail.smtp.mail.sender", "eduardomauriz@gmail.com");
        // Si requiere o no usuario y password para conectarse.
        properties.put("mail.smtp.user", "usuario");
        properties.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(properties);
        session.setDebug(true);//esta linea es para mostrar que hace al enviar el correo, pero no es necesaria
        
        
//props.setProperty("mail.smtp.host", "smtp.gmail.com");
//props.setProperty("mail.smtp.starttls.enable", "true");
//props.setProperty("mail.smtp.port","587");
//props.setProperty("mail.smtp.user", "ejemplo@gmail.com");
//props.setProperty("mail.smtp.auth", "true");

    }

    public void sendEmail() {

        init();
        try {
            MimeMessage message = new MimeMessage(session);
 //                      message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));new InternetAddress("ejemplo@gmail.com")
            message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("eduardomauriz@gmail.com"));
            message.setSubject("Esto es un correo de Prueba");
            message.setText("Mensajito enviado con javamail, funciona!!!");
            
            //enviamos el correo con la clase transport
            Transport t = session.getTransport("smtp");
            t.connect("eduardomauriz@gmail.com", "30298400");
            //t.connect((String) properties.get("mail.smtp.user"), "password");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        } catch (MessagingException me) {
            //Aqui se deberia o mostrar un mensaje de error o en lugar  
            //de no hacer nada con la excepcion, lanzarla para que el modulo  
            //superior la capture y avise al usuario con un popup, por ejemplo.  
            return;
        }

    }
    
    
     
}


/**
     * main de prueba
     * @param args Se ignoran.
     */
   /* public static void main(String[] args) {
        
        try {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "eduardomauriz@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/


/*public class Cartero {*/
