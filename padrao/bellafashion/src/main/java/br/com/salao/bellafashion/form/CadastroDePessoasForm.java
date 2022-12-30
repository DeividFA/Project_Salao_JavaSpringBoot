package br.com.salao.bellafashion.form;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import br.com.salao.bellafashion.model.Contato;
import br.com.salao.bellafashion.model.Endereco;
import br.com.salao.bellafashion.model.Pessoa;
import br.com.salao.bellafashion.model.padroes.EstadoCivil;
import br.com.salao.bellafashion.model.padroes.Genero;
import br.com.salao.bellafashion.model.padroes.TipoPessoa;

public class CadastroDePessoasForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String nomePessoa;
	private List<TipoPessoa> tipoPessoa = new ArrayList<>();
	@NotNull
	private EstadoCivil estadoCivil;
	private Genero sexo;
	private Boolean cliente;
	private Boolean funcionario;
	private Boolean fornecedor;
		
	private String telefone;
	private String email;
	@DateTimeFormat( fallbackPatterns ="dd/MM/yyyy")
	private String dtNasc;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String cep;
	private String estado;
	
	private Endereco endereco = new Endereco();
	private Contato contato = new Contato() ;
	
	
	private String Observacao;

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public List<TipoPessoa> getTipoPessoa() {

		if (getCliente()) {
			this.tipoPessoa.add(TipoPessoa.CLIENTE);
		}
		if (getFornecedor()) {
			this.tipoPessoa.add(TipoPessoa.FORNECEDOR);
		}
		if (getFuncionario()) {
			this.tipoPessoa.add(TipoPessoa.FUNCIONARIO);
		}

		return tipoPessoa;
	}

	public void setTipoPessoa(List<TipoPessoa> tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	
	public Genero getSexo() {
		return sexo;
	}

	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		this.endereco.setCep       (getCep()   );
		this.endereco.setBairro    (getBairro());
		this.endereco.setLogradouro(getRua()   );
		this.endereco.setNumero    (getNumero());
		this.endereco.setCidade    (getCidade());
		this.endereco.setUf        (getEstado());
		
		
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		this.contato.setCelular(getTelefone());
		this.contato.setEmail(getEmail());		
		return contato;
	}

	public void setContato(Contato contato) {
				
		this.contato = contato;
	}

	public String getObservacao() {
		return Observacao;
	}

	public void setObservacao(String observacao) {
		Observacao = observacao;
	}

	public Boolean getCliente() {
		return cliente;
	}

	public void setCliente(Boolean cliente) {
		this.cliente = cliente;
	}

	public Boolean getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Boolean funcionario) {
		this.funcionario = funcionario;
	}

	public Boolean getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Boolean fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public List<Contato> listContato (){
		List<Contato> lista = new ArrayList<Contato>();
		lista.add(getContato());		
		return lista;
	}
	
	public List<Endereco> listEndereco(){
		List<Endereco> lista = new ArrayList<>();
		lista.add(getEndereco());		
		return lista;
	}
	
	public Blob Obs (String obs) {
		
	
	try {
		return new SerialBlob(obs.getBytes());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
		
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Pessoa toPessoa()  {

		Pessoa pessoa = new Pessoa();
		
		
		pessoa.setNomePessoa(getNomePessoa());
		
    	
    	try {
			pessoa.setDataNascimento( (new SimpleDateFormat("dd/MM/yyyy")).parse(dtNasc));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		pessoa.setTipoPessoa(getTipoPessoa());
		pessoa.setSexo(getSexo());
		pessoa.setEstadoCivil(getEstadoCivil());
		pessoa.setContato(listContato());
		pessoa.setEndereco(listEndereco());
		pessoa.setObservacao(Obs(getObservacao()));

		return pessoa;

	}

}
