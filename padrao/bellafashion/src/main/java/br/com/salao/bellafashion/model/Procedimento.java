package br.com.salao.bellafashion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Procedimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeProcedimento;
	private Float valorProcedimento;
	private Float porcentagemSalao;
	private Float porcentagemPessoa;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeProcedimento() {
		return nomeProcedimento;
	}
	public void setNomeProcedimento(String nomeProcedimento) {
		this.nomeProcedimento = nomeProcedimento;
	}
	public Float getValorProcedimento() {
		return valorProcedimento;
	}
	public void setValorProcedimento(Float valorProcedimento) {
		this.valorProcedimento = valorProcedimento;
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
	@Override
	public String toString() {
		return "Procedimento [id=" + id + ", nomeProcedimento=" + nomeProcedimento + ", valorProcedimento="
				+ valorProcedimento + ", porcentagemSalao=" + porcentagemSalao + ", porcentagemPessoa="
				+ porcentagemPessoa + "]";
	}
	
	

}
