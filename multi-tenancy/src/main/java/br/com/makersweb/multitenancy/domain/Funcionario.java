/**
 * 
 */
package br.com.makersweb.multitenancy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import br.com.makersweb.multitenancy.handler.TenancyInterceptor;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@Entity
@Table(name = "tb_funcionario")
@FilterDef(name = "tenant", parameters = { @ParamDef(name = "id", type = "string") })
@Filter(name = "tenant", condition = "tenant_id = :id")
public class Funcionario extends DefaultDomain implements Serializable {

	private static final long serialVersionUID = 9107183922052983702L;

	private String nome;

	@Column(name = "tenant_id")
	private String tenantId;

	public Funcionario() {

	}

	public Funcionario(String nome) {
		this.nome = nome;
	}

	public Funcionario(String nome, String tenantId) {
		this(nome);
		this.tenantId = tenantId;
	}

	@PrePersist
	@PreUpdate
	private void tenantId() {
		String tenantId = TenancyInterceptor.getTenantId();
		if (tenantId != null) {
			this.tenantId = tenantId;
		}
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * @param tenantId
	 *            the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
