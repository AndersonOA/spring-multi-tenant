/**
 * 
 */
package br.com.makersweb.multitenancy.message;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public class MakersMessage {

	@Autowired
	private MessageSource messageSource;

	public MakersMessage(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public String message(String message, Object... params) {
		return messageSource.getMessage(message, params, Locale.getDefault());
	}
	
	public String message(String message) {
		return messageSource.getMessage(message, null, Locale.getDefault());
	}

}
