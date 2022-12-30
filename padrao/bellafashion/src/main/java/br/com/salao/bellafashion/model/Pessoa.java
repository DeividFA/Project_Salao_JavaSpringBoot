package br.com.salao.bellafashion.model;


import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.salao.bellafashion.model.padroes.EstadoCivil;
import br.com.salao.bellafashion.model.padroes.Genero;
import br.com.salao.bellafashion.model.padroes.TipoPessoa;

@Entity
public class Pessoa {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomePessoa;	

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "TipoPessoa", joinColumns = @JoinColumn(name = "id"))
	@Enumerated(EnumType.STRING)
	private List<TipoPessoa> tipoPessoa;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Endereco> endereco;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Contato> contato;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 2)
	private Genero sexo;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
	private EstadoCivil estadoCivil;
	private Blob Observacao;
	
	private Date dataNascimento;
				
	
	public Pessoa() {
	}


	public String getNomePessoa() {
		return nomePessoa;
	}


	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}


	public List<TipoPessoa> getTipoPessoa() {
		return tipoPessoa;
	}


	public void setTipoPessoa(List<TipoPessoa> tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}


	public List<Endereco> getEndereco() {
		return endereco;
	}


	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}


	public List<Contato> getContato() {
		return contato;
	}



	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}


	public Blob getObservacao() {
		return Observacao;
	}


	public void setObservacao(Blob observacao) {
		Observacao = observacao;
	}


	public Integer getId() {
		return id;
	}


	@Override
	public String toString() {
		try {
			return "Pessoa [id=" + id + ", nomePessoa=" + nomePessoa + ", tipoPessoa=" + tipoPessoa + ", endereco="
					+ endereco + ", contato=" + contato + ", estadoCivil ="+ estadoCivil + ", sexo="+ sexo
					+", Observacao=" + Observacao (Observacao) + "]";
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomePessoa;
	}
	
	public String Observacao (Blob blob) throws SQLException, IOException {
		
		return  blob.toString();
	}


	public Genero getSexo() {
		return sexo;
	}


	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	



	
	

}
