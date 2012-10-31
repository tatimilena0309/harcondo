/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnvioCorreos;

/**
 *
 * @author edu
 */
public class ExceptionManager {
    
    public static void ManageException(Exception e) {

        System.out.println("Se ha producido una exception");

        System.out.println(e.getMessage());

        e.printStackTrace(System.out);

    }
    
}
