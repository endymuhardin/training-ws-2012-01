/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.banking.domain;

/**
 *
 * @author endy
 */
public class RekeningDiblokirException extends RuntimeException {

    public RekeningDiblokirException(Throwable cause) {
        super(cause);
    }

    public RekeningDiblokirException(String message, Throwable cause) {
        super(message, cause);
    }

    public RekeningDiblokirException(String message) {
        super(message);
    }

    public RekeningDiblokirException() {
    }
    
}
