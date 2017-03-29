/**
 * 
 */
package br.com.makersweb.multitenancy.service;

import java.util.List;

import br.com.makersweb.multitenancy.domain.Funcionario;
import br.com.makersweb.multitenancy.service.exception.BusinessException;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public interface IFuncionarioService {

	List<Funcionario> listar() throws BusinessException;

	Funcionario buscar(Long id) throws BusinessException;

	Funcionario salvar(Funcionario funcionario) throws BusinessException;

	Funcionario alterar(Funcionario funcionario) throws BusinessException;

	void deletar(Long id) throws BusinessException;

	void verificaExistencia(Funcionario funcionario) throws BusinessException;

	List<Funcionario> findByNomeStartingWith(String nome) throws BusinessException;

}
