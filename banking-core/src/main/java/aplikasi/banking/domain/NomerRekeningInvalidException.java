/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.banking.domain;

/**
 *
 * @author endy
 */
public class NomerRekeningInvalidException extends RuntimeException {

    public NomerRekeningInvalidException(Throwable cause) {
        super(cause);
    }

    public NomerRekeningInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public NomerRekeningInvalidException(String message) {
        super(message);
    }

    public NomerRekeningInvalidException() {
    }
    
}
