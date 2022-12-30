package br.com.salao.bellafashion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeProduto;
	private Float valorProduto;
	private Float porcentagemSalao;
	private Float porcentagemPessoa;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Float getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(Float valorProduto) {
		this.valorProduto = valorProduto;
	}
	public Float getPorcentagemSalao() {
		return porcentagemSalao;
	}
	public void setPorcentagemSalao(Float porcentagemSalao) {
		this.porcentagemSalao = porcentagemSalao;
	}
	public Float getPorcentagemPessoa() {
		return porcentagemPessoa;
	}
	public void setPorcentagemPessoa(Float porcentagemPessoa) {
		this.porcentagemPessoa = porcentagemPessoa;
	}
	
	

}
