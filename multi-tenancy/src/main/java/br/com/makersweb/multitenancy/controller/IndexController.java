/**
 * 
 */
package br.com.makersweb.multitenancy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.makersweb.multitenancy.util.ConstantesUtils;

/**
 *
 * @author anderson.aristides
 *
 */
@Controller
public class IndexController {
	
	@RequestMapping(value = "login.html")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView(ConstantesUtils.GO_LOGIN);
		return mav;
	}
	
	@RequestMapping(value = "recover.html")
	public ModelAndView recover() {
		ModelAndView mav = new ModelAndView(ConstantesUtils.GO_RECOVER);		
		return mav;
	}

}
