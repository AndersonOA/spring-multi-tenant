/**
 * 
 */
package br.com.makersweb.multitenancy.service.core;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import br.com.makersweb.multitenancy.domain.Funcionario;
import br.com.makersweb.multitenancy.message.MakersMessage;
import br.com.makersweb.multitenancy.repository.IFuncionarioRepository;
import br.com.makersweb.multitenancy.service.IFuncionarioService;
import br.com.makersweb.multitenancy.service.exception.BusinessException;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@Service
@EnableTransactionManagement
public class FuncionarioService implements IFuncionarioService {

	private static final Logger _logger = LogManager.getLogger(FuncionarioService.class);

	@Autowired
	private IFuncionarioRepository funcionarioRepository;

	@Autowired
	private MessageSource messageSource;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public List<Funcionario> listar() throws BusinessException {
		_logger.info("Iniciou método listar funcionario...");

		List<Funcionario> funcionarios = funcionarioRepository.findAll();

		if (CollectionUtils.isEmpty(funcionarios)) {
			throw new BusinessException(new MakersMessage(messageSource)
					.message("br.com.makersweb.multitenancy.text.nao.encontrado", "Funcionário"));
		}

		return funcionarios;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Funcionario buscar(Long id) throws BusinessException {
		_logger.info("Iniciou método buscar funcionario...");

		Funcionario funcionario = funcionarioRepository.findOne(id);

		if (ObjectUtils.isEmpty(funcionario)) {
			throw new BusinessException(new MakersMessage(messageSource)
					.message("br.com.makersweb.multitenancy.text.nao.encontrado", "Funcionário"));
		}

		return funcionario;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Funcionario salvar(Funcionario funcionario) throws BusinessException {
		_logger.info("Iniciou método salvar funcionario...");

		if (ObjectUtils.isEmpty(funcionario)) {
			throw new BusinessException(
					new MakersMessage(messageSource).message("br.com.makersweb.multitenancy.text.campos.obrigatorio"));
		}

		return funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Funcionario alterar(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void deletar(Long id) throws EmptyResultDataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void verificaExistencia(Funcionario funcionario) throws BusinessException {
		buscar(funcionario.getId());
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public List<Funcionario> findByNomeStartingWith(String nome) throws BusinessException {
		_logger.info("Iniciou método buscar findByNomeStartingWith...");

		List<Funcionario> funcionarios = funcionarioRepository.findByNomeStartingWith(nome);

		if (CollectionUtils.isEmpty(funcionarios)) {
			throw new BusinessException(new MakersMessage(messageSource)
					.message("br.com.makersweb.multitenancy.text.nao.encontrado", "Funcionário"));
		}

		return funcionarios;
	}

}
