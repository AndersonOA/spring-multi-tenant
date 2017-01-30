/**
 * 
 */
package br.com.makersweb.multitenancy.service;

import java.util.Map;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public interface IEmailSenderService {
	
	Boolean sendTestEmail(String email, Map<String, Object> data);

}
