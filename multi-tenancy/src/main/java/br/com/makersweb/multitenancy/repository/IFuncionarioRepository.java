/**
 * 
 */
package br.com.makersweb.multitenancy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.makersweb.multitenancy.domain.Funcionario;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long> {

	List<Funcionario> findByNomeStartingWith(String nome);

}
