/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnvioCorreos;

/**
 *
 * @author eduardo
 */
public class Enviador {

    public static void main(String[] args) {

        Cartero cartero = new Cartero();
        cartero.sendEmail();

       // if (SMTPConfig.sendMail("Asunto del Mensaje", " Cuerpo del Mensaje.", "destino@gmail.com")) {
//
  //          System.out.println("envío Correcto");

    //    } else {
      //      System.out.println("envío Fallido");
        //}

    }
}
