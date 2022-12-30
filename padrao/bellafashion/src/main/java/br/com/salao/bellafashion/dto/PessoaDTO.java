package br.com.salao.bellafashion.dto;

import java.sql.Blob;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import br.com.salao.bellafashion.model.padroes.TipoPessoa;

public class PessoaDTO {
	
	private Integer id;
	
	@NotEmpty @NotBlank
	private String nomePessoa;
	private TipoPessoa tipoPessoa;
	private EnderecoDTO endereco;
	private ContatoDTO contato;
	private Blob Observacao;
	
	
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	public Integer getId() {
		return id;
	}
	public ContatoDTO getContato() {
		return contato;
	}
	public void setContato(ContatoDTO contato) {
		this.contato = contato;
	}
	public Blob getObservacao() {
		return Observacao;
	}
	public void setObservacao(Blob observacao) {
		Observacao = observacao;
	}
	
	

}
