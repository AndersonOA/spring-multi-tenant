/**
 * 
 */
package br.com.makersweb.multitenancy.aspect;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import br.com.makersweb.multitenancy.handler.TenancyInterceptor;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public class TenancyAspect {
	
	@Autowired
	private EntityManager manager;
	
	public void definirTenant() {
		String tenantId = TenancyInterceptor.getTenantId();
		if (!StringUtils.isEmpty(tenantId)) {
			manager.unwrap(Session.class).enableFilter("tenant").setParameter("id", tenantId);
		}
	}

}
