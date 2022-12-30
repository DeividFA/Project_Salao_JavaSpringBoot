package br.com.salao.bellafashion.controller;


import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.salao.bellafashion.config.validacao.ValidacaoDeUsuario;
import br.com.salao.bellafashion.form.CadastroDeUsuarioForm;
import br.com.salao.bellafashion.model.Usuario;
import br.com.salao.bellafashion.repository.UsuarioRepository;

@Controller
@RequestMapping("cadastrodeusuario")
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioRepository usuariorepository;
	
	
	
	@Autowired
	private	ValidacaoDeUsuario validacao;
	
	@GetMapping
	public String cadastrodeusuario(CadastroDeUsuarioForm cadastro) {
		return "cadastrodeusuario";
	}
	
	@PostMapping
	public String novoUsuario( @Valid CadastroDeUsuarioForm cadastro, BindingResult result) {
		validacao.validate(cadastro, result);
		
		if (result.hasErrors()) {
			return "cadastrodeusuario";
		}   
		
		Usuario user = cadastro.toUser();
	
		
		System.out.println(user.getNome());
		usuariorepository.save(user);
		return "bemvindo";
	}
	
	

}
