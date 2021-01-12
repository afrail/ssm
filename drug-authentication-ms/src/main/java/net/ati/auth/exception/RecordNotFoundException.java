/**
 * 
 */
package net.ati.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Nayeemul
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String message) {
        super(message);
    }
}
