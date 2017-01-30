/**
 * 
 */
package br.com.makersweb.multitenancy.util;

/**
 *
 * @author anderson.aristides
 *
 */
public class ConstantesUtils {
	
	/**
	 * CONSTANTES GERAIS
	 */
	public final static String MAIL_ENCODING = "UTF-8";
	public final static String MAIL_SUBJECT = "MakersWeb";
	public final static String E_USER_NOTICE = "info";
	public final static String E_USER_WARNING = "warning";
	public final static String E_USER_ERROR = "error";
	public final static String E_USER_SUCESS = "success";
	public final static String EMAIL_REGEX = "[a-zA-Z0-9]+[a-zA-Z0-9_.-]+@{1}[a-zA-Z0-9_.-]*\\.+[a-z]{2,4}";
	public final static String CEP_URL_BASE = "http://viacep.com.br/ws/";
	public final static String URI_GOOGLE_MAPS = "http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=";
	public final static String USER_AGENT = "Mozilla/5.0";
	public final static String USER_ANONYMOUS = "anonymousUser";
	public final static String EMAIL_NOREPLY_SENDER = "noreplay@multi-tenancy.com.br";
	public final static String EMAIL_DEFAULT = "contato@multi-tenancy.com.br";
	
	public final static String GO_DASHBOARD = "dashboard";
	public final static String GO_LOGIN = "login";
	public static final String GO_RECOVER = "recover";
	public static final String GO_SIGNUP = "signup";
	public static final String GO_NEW_PASS = "newpass";
	public final static String GO_HOME = "home";
	public final static String GO_CREATE = "create";
	
	public final static String ROLE_ADMIN = "ROLE_ADMIN";
	public final static String ROLE_USER = "ROLE_USER";

}
