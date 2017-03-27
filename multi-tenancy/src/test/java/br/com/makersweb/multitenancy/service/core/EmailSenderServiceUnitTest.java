/**
 * 
 */
package br.com.makersweb.multitenancy.service.core;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.makersweb.multitenancy.service.IEmailSenderService;
import br.com.makersweb.multitenancy.service.exception.BusinessException;
import br.com.makersweb.multitenancy.util.ConstantesUtils;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:multi-tenancy-services-test-context.xml")
@Transactional(rollbackFor = Exception.class)
public class EmailSenderServiceUnitTest {
	
	@Autowired
	private IEmailSenderService emailSenderService;

	@Ignore
	@Test
	public void sentRegisterEmailTest() throws BusinessException {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("name", "Anderson O. Aristides");
		data.put("subject", "Teste E-mail");
		Boolean sendEmail = this.emailSenderService.sendTestEmail(ConstantesUtils.EMAIL_DEFAULT, data);
		Assert.assertTrue(sendEmail);
	}

}
