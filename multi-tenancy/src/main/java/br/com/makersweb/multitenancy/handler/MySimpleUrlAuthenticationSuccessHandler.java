/**
 * 
 */
package br.com.makersweb.multitenancy.handler;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import br.com.makersweb.multitenancy.util.ConstantesUtils;

/**
 *
 * @author anderson.aristides
 *
 */
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

		if (roles.contains(ConstantesUtils.ROLE_ADMIN)) {
			response.sendRedirect("./plain/dashboard.html");
		} else if (roles.contains(ConstantesUtils.ROLE_USER)) {
			response.sendRedirect("./page/dashboard.html");
		} else {
			response.sendRedirect("./plain/forbiden.html");
		}
	}

}
