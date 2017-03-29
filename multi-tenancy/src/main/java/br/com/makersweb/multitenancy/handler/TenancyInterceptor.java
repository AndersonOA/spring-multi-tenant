/**
 * 
 */
package br.com.makersweb.multitenancy.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public class TenancyInterceptor extends HandlerInterceptorAdapter {

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Map<String, Object> pathVars = (Map<String, Object>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		
		if (ObjectUtils.isEmpty(pathVars)) {
			return false;
		}

		if (pathVars.containsKey("tenantid")) {
			request.setAttribute("TENANT_ID", pathVars.get("tenantid"));
		}

		return true;
	}
	
	public static String getTenantId() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		
		if (requestAttributes != null) {
			return (String) requestAttributes.getAttribute("TENANT_ID", RequestAttributes.SCOPE_REQUEST);
		}
		
		return null;
	}

}
