/**
 * 
 */
package br.com.makersweb.multitenancy.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.multitenancy.domain.Funcionario;
import br.com.makersweb.multitenancy.service.IFuncionarioService;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@RestController
@RequestMapping("${multi.tenancy.api}/{tenantid}")
public class FuncionarioResources {
	
	@Autowired
	private IFuncionarioService funcionarioService;
	
	@RequestMapping(value = "/funcionarios", method = RequestMethod.GET)
	public ResponseEntity<?> filtrar(String nome) {
		return ResponseEntity.ok(funcionarioService.findByNomeStartingWith(nome != null ? nome : "%"));
	}
	
	@RequestMapping(value = "/funcionarios", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody String nome) {
		funcionarioService.salvar(new Funcionario(nome));
		return ResponseEntity.ok().build();
	}

}
