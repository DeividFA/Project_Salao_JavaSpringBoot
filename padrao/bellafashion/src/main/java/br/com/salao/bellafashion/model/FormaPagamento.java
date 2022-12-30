package br.com.salao.bellafashion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FormaPagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeFormaPagamento;
	private String abrevFormaPagamento;
	private String operadora;
	private Float taxaFormaPagamento;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeFormaPagamento() {
		return nomeFormaPagamento;
	}
	public void setNomeFormaPagamento(String nomeFormaPagamento) {
		this.nomeFormaPagamento = nomeFormaPagamento;
	}
	public String getAbrevFormaPagamento() {
		return abrevFormaPagamento;
	}
	public void setAbrevFormaPagamento(String abrevFormaPagamento) {
		this.abrevFormaPagamento = abrevFormaPagamento;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public Float getTaxaFormaPagamento() {
		return taxaFormaPagamento;
	}
	public void setTaxaFormaPagamento(Float taxaFormaPagamento) {
		this.taxaFormaPagamento = taxaFormaPagamento;
	}
	
	

}
