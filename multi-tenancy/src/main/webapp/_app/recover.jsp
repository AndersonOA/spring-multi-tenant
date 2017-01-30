<title>Bem-vindo(a) ao MakersWeb - Recuperar Senha!</title>
<div class="main_login">
	<div class="container">
		<div class="login_box">
			<img class="login_logo radius" alt="[MakersWeb]" title="MakersWeb" src="../_cdn/_img/logo.png"/>
			<form class="login_form" name="work_reset" action="" method="post" enctype="multipart/form-data">
				<div class="trigger trigger_info m_botton">Informeu seu <b>e-mail</b> abaixo. Voc� receber� uma link para recuperar sua senha!</div>
				<div class="callback_return m_botton"></div>
		        <input type="hidden" name="callback" value="usuario/recuperar">

	          	<label class="label">
	            	<span class="legend">Seu E-mail:</span>
	              	<input type="email" name="email" value="" placeholder="E-mail:" required/>
	          	</label>
	
	            <img class="form_load none" style="float: right; margin-top: 3px; margin-left: 10px;" alt="Enviando Requisi��o!" title="Enviando Requisi��o!" src="../_cdn/_img/load.gif"/>
	            <button class="btn btn_green fl_right">Obter Nova Senha!</button>
	            <div class="clear"></div>
			</form>
			<p class="login_link"><a href="login.html">&larrhk; Logar-se!</a></p>
		</div><!-- /login_box -->
	</div><!-- /container -->
	<div class="clear"></div>
</div><!-- /main_login -->