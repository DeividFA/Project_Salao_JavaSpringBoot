package br.com.salao.bellafashion.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dtRealizou; //data em que o procedimento foi realizado
	@ManyToOne
	private Procedimento procedimentoRealizado; 
	private String nomeProcedimento;
	private String nomeProcedimentoAtual;
	
	@ManyToMany
	private List<FormaPagamento> formaPagamento;
	
	//Pessoa que Realizou o procedimento
	private Integer idColaborador; // não pode ser nulo
	private String nomeColaborador; // não pode ser nulo
	
	
	//Pessoa que recebeu o procediemnto
	private Integer idCliente; // este pode ser nulo
	private String nomeCliente; //precisa conter algum nome
	
	private Float valorPgAtendimento;
	
	private Float porcentagemColaborador;
	private Float porcentagemSalao;
	private Float valorReceberColaborador;
	private Float valorReceberSalao;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDtRealizou() {
		return dtRealizou;
	}
	public void setDtRealizou(Date dtRealizou) {
		this.dtRealizou = dtRealizou;
	}
	public Procedimento getProcedimentoRealizado() {
		return procedimentoRealizado;
	}
	public void setProcedimentoRealizado(Procedimento procedimentoRealizado) {
		this.procedimentoRealizado = procedimentoRealizado;
	}
	
	
	
	public String getNomeProcedimento() {
		return nomeProcedimento;
	}
	public void setNomeProcedimento(String nomeProcedimento) {
		this.nomeProcedimento = nomeProcedimento;
	}
	public String getNomeProcedimentoAtual() {
		return nomeProcedimentoAtual;
	}
	public void setNomeProcedimentoAtual(String nomeProcedimentoAtual) {
		this.nomeProcedimentoAtual = nomeProcedimentoAtual;
	}
	public List<FormaPagamento> getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(List<FormaPagamento> formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Integer getIdColaborador() {
		return idColaborador;
	}
	public void setIdColaborador(Integer idColaborador) {
		this.idColaborador = idColaborador;
	}
	public String getNomeColaborador() {
		return nomeColaborador;
	}
	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Float getValorPgAtendimento() {
		return valorPgAtendimento;
	}
	public void setValorPgAtendimento(Float valorPgAtendimento) {
		this.valorPgAtendimento = valorPgAtendimento;
	}
	public Float getPorcentagemColaborador() {
		return porcentagemColaborador;
	}
	public void setPorcentagemColaborador(Float porcentagemColaborador) {
		this.porcentagemColaborador = porcentagemColaborador;
	}
	public Float getPorcentagemSalao() {
		return porcentagemSalao;
	}
	public void setPorcentagemSalao(Float porcentagemSalao) {
		this.porcentagemSalao = porcentagemSalao;
	}
	public Float getValorReceberColaborador() {
		return valorReceberColaborador;
	}
	public void setValorReceberColaborador(Float valorReceberColaborador) {
		this.valorReceberColaborador = valorReceberColaborador;
	}
	public Float getValorReceberSalao() {
		return valorReceberSalao;
	}
	public void setValorReceberSalao(Float valorReceberSalao) {
		this.valorReceberSalao = valorReceberSalao;
	}
	
	
	
	
	
	

}
