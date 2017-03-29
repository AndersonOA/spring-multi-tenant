/**
 * 
 */
package br.com.makersweb.multitenancy.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.multitenancy.domain.Funcionario;
import br.com.makersweb.multitenancy.response.DefaultResponse;
import br.com.makersweb.multitenancy.service.IFuncionarioService;
import br.com.makersweb.multitenancy.service.exception.BusinessException;

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
	
	@RequestMapping(value = "/funcionarios/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		DefaultResponse response = new DefaultResponse();
		
		try {
			return ResponseEntity.ok(funcionarioService.buscar(id));
		} catch (BusinessException e) {
			response.setError(true);
			response.setMessage(e.getMessage());
		}
		
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/funcionarios", method = RequestMethod.GET)
	public ResponseEntity<?> filtrar(String nome) {
		DefaultResponse response = new DefaultResponse();
		try {
			return ResponseEntity.ok(funcionarioService.findByNomeStartingWith(nome != null ? nome : "%"));
		} catch (BusinessException e) {
			response.setError(true);
			response.setMessage(e.getMessage());
		}
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/funcionarios", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody String nome) {
		funcionarioService.salvar(new Funcionario(nome));
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/funcionarios/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
		DefaultResponse response = new DefaultResponse();
		try {
			funcionarioService.deletar(id);
		} catch (BusinessException e) {
			response.setError(true);
			response.setMessage(e.getMessage());
		}
		
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/funcionarios", method = RequestMethod.PUT)
	public ResponseEntity<?> alterar(@RequestBody Funcionario funcionario) {
		DefaultResponse response = new DefaultResponse();
		try {
			funcionarioService.alterar(funcionario);
		} catch (BusinessException e) {
			response.setError(true);
			response.setMessage(e.getMessage());
		}
		
		return ResponseEntity.ok(response);
	}

}
