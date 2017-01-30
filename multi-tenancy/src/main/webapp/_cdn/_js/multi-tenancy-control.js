/* 
 * Biblioteca de evendos jQuery do Painel MakersWeb Pro Content Manager
 * Created on : 30/07/2016, 17:14:28
 * Author     : Anderson O. Aristides
 */

//JQUERY START
$(function() {
	// Version API
	var VERSION = $('meta[name="makersweb_version"]').attr('content');
	
	// URL API
	var sAction = 'http://' + window.location.host + '/makersweb/none/api/' + VERSION + '/';
	
	// Coloca todos os formulários em AJAX mode e inicia LOAD ao submeter!
	$('form').not('.ajax_off').submit(function() {
		var form = $(this);
		var formName = form.attr('name');
		var callback = form.find('input[name="callback"]').val();
		var callback_action = form.find('input[name="callback_action"]').val();
		var typeForm = (callback_action === 'update' ? 'PUT' : 'POST');
		
		$.ajax({
			url : sAction + callback,
			data : JSON.stringify(form.serializeObject()),
			type : typeForm,
			contentType : "application/json",
			beforeSend : function() {
				form.find('.form_load').fadeIn('slow');
				$('.trigger_ajax').fadeOut('fast');
			},
			success : function(response) {
				console.clear();
				// REMOVE LOAD
				form.find('.form_load').fadeOut('slow',function() {
					console.log(response.message);
					// EXIBE CALLBACKS
					if (response.message) {
						var CallBackPresent = form.find('.callback_return');
						if (CallBackPresent.length) {
							CallBackPresent.html(TriggerMessage(response.message, response.typeError));
							$('.trigger_ajax').fadeIn('slow');
							if (response.typeError === 'success') {
								form.reset();
							}
						} else {
							Trigger(response.message, response.typeError)
							if (response.typeError === 'success') {
								form.reset();
							}
						}
					}
					
					//REDIRECIONA
                    if (response.redirect) {
                        window.setTimeout(function () {
                            window.location.href = response.redirect;
                        }, 500);
                    }
				});//form_load
			}
		});
		
		return false;
	});
	
	// Adiciona LoadGif ao lado do submit em todos os formulários do sistema
	// automaticamente
	$('form .btn').before('');

    //TRIGGER :: OCULTA ERROS AO CLICAR
	$('html').on('click', '.trigger_ajax, .trigger_modal', function() {
		$(this).fadeOut('slow', function() {
			$(this).remove();
		});
	});
	
});//jQuery

//############## MODAL MESSAGE
function Trigger(Message, ErrNo) {
	$('.trigger_ajax').fadeOut('fast', function() {
		$(this).remove();
	});
	
	var CssClass = (ErrNo == "info" ? 'trigger_info' : (ErrNo == "warning" ? 'trigger_alert' : (ErrNo == "error" ? 'trigger_error' : 'trigger_success')));

	$('body, .dashboard_main').before('<div class="trigger_modal"><div class="trigger trigger_ajax '+ CssClass + '">' + Message + '<span class="ajax_close"></span></div></div>');
	$('.trigger_ajax').fadeIn('slow');
	
	setTimeout(function () {
		$('.trigger_ajax').fadeOut('slow', function () {
			$(this).remove();
        });

        if ($('.trigger_ajax').length <= 1) {
        	TriggerClose();
        }
    }, (3000));
}

//############## MESSAGE
function TriggerMessage(Message, ErrNo) {
	var CssClass = (ErrNo == "info" ? 'trigger_info' : (ErrNo == "warning" ? 'trigger_alert' : (ErrNo == "error" ? 'trigger_error' : 'trigger_success')));
	
	return '<div class="trigger trigger_ajax '+ CssClass + '">' + Message + '<span class="ajax_close"></span></div>';
}

//FECHAR TRIGGER MODAL
function TriggerClose() {
    $('.trigger_ajax').fadeOut('fast', function () {
        $(this).remove();
    });
}

//############## SERIALIZE FORM JSON
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};

// Function Reset Criada para resetar os formularios nas modais
jQuery.fn.reset = function() {
	this.each(function() {
		if ($(this).is('form')) {
			var button = jQuery(jQuery('<input type="reset" />'));
			button.hide();
			$(this).append(button);
			button.click().remove();
		} else if ($(this).parent('form').size()) {
			var button = jQuery(jQuery('<input type="reset" />'));
			button.hide();
			$(this).parent('form').append(button);
			button.click().remove();
		} else if ($(this).find('form').size()) {
			$(this).find('form').each(function() {
				var button = jQuery(jQuery('<input type="reset" />'));
				button.hide();
				$(this).append(button);
				button.click().remove();
			});
		}
	});

	return this;
};