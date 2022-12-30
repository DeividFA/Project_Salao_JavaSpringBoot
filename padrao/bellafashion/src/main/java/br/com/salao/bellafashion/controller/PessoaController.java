package br.com.salao.bellafashion.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.salao.bellafashion.config.validacao.ValidacaoDePessoa;
import br.com.salao.bellafashion.form.CadastroDePessoasForm;
import br.com.salao.bellafashion.model.Pessoa;
import br.com.salao.bellafashion.model.padroes.Genero;
import br.com.salao.bellafashion.repository.PessoaRepository;

@Controller
@RequestMapping("pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ValidacaoDePessoa validacao;
	

	
	@GetMapping
	public String pessoas(CadastroDePessoasForm cadastro) {
		cadastro.setCliente(true);
		cadastro.setSexo(Genero.F);
		return "pessoas";
	}
	
	@PostMapping
	public String novaPessoa( @Valid CadastroDePessoasForm cadastro, BindingResult result) {
		
		validacao.validate(cadastro, result);
		
		if (result.hasErrors()) {
			return "pessoas";
		}   
		
		Pessoa pessoa = cadastro.toPessoa();
		pessoaRepository.save(pessoa);
		return "bemvindo";
	
	}


}
