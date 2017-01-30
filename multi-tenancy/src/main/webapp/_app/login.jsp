<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/j_spring_security_check" var="loginUrl" />
<title>Bem-vindo(a) ao MakersWeb - Entrar!</title>
<div class="main_login">
	<div class="container">
		<div class="login_box">
			<img class="login_logo" alt="[MakersWeb]" title="MakersWeb" src="../_cdn/_img/logo.png" />
			<form class="login_form ajax_off" name="work_login" action="${loginUrl}" method="post">
				<div class="callback_return m_botton">
					<c:if test="${param.error ==  'invalid_user'}">
						<div class="trigger trigger_ajax trigger_alert">
							<b>Aviso:</b> Usuário inválido.<span class="ajax_close"></span>
						</div>
					</c:if>
				</div>
				
				<label class="label"> <span class="legend">Seu E-mail:</span>
					<input type="email" name="username" class="input" placeholder="E-mail:" required />
				</label> 
				<label class="label"> 
					<span class="legend">Sua Senha:</span>
					<input type="password" name="password" class="input" placeholder="Senha:" required />
				</label>
	
				<div class="label_50" style="margin-bottom: 10px;">
					<label class="label_check"> 
						<input type="checkbox" name="remember-me" /> 
						<span style="color: #666;">Lembrar!</span>
					</label> 
					<label class="label_check" style="margin-right: 0px; float: right;">
						<a href="recover.html" class="forgot_password">Esqueceu a senha ?</a>
					</label>
				</div>
	
				<img class="form_load none" style="float: right; margin-top: 3px; margin-left: 10px;" alt="Enviando Requisição!" title="Enviando Requisição!" src="../_cdn/_img/load.gif" />
				<button class="btn btn-lg btn_green fl_right" style="width: 100%;">Entrar!</button>
	
				<div class="clear"></div>
			</form>
		</div><!-- /login_box -->
	</div><!-- /container -->
	<div class="clear"></div>
</div><!-- /main_login -->