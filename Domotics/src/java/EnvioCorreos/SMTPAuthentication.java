/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnvioCorreos;

import javax.mail.PasswordAuthentication;

/**
 *
 * @author edu
 */
public class SMTPAuthentication extends javax.mail.Authenticator {

    @Override
    public PasswordAuthentication getPasswordAuthentication() {

        String username = "eduardomauriz@gmail.com";

        String password = "30298400";

        return new PasswordAuthentication(username, password);

    }
}