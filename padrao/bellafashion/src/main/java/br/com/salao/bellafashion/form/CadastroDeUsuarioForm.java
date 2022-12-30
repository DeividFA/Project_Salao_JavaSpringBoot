package br.com.salao.bellafashion.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.salao.bellafashion.model.Usuario;

public class CadastroDeUsuarioForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String senhaAcesso;
	@NotBlank 
	private String confirmacaoSenha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenhaAcesso() {
		return senhaAcesso;
	}

	public void setSenhaAcesso(String senhaAcesso) {
		this.senhaAcesso = senhaAcesso;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Usuario toUser() {
		
		Usuario usuario = new Usuario();

		usuario.setNome(getNome());
		usuario.setEmail(getEmail());
		usuario.setSenha(new BCryptPasswordEncoder().encode(getSenhaAcesso()));

		return usuario;		
	}
	

}
