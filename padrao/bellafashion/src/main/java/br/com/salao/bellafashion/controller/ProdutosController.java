package br.com.salao.bellafashion.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.salao.bellafashion.config.validacao.ValidacaoDeProdutos;
import br.com.salao.bellafashion.form.CadastroDeProdutoForm;
import br.com.salao.bellafashion.model.Produto;
import br.com.salao.bellafashion.repository.ProdutoRepository;

@Controller
@RequestMapping("produtos")
public class ProdutosController  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ValidacaoDeProdutos validacao;


	
	@PostMapping
	public String cadastar(@Valid CadastroDeProdutoForm cadastro, BindingResult result) {
		
		validacao.validate(cadastro, result);
		
		if (result.hasErrors()) {
			return "produtos";
		}   
		
		Produto produto = cadastro.toProduto();
		System.out.println(produto.toString());
		
		produtoRepository.save(produto);
		return "redirect:/produtos";
	}
	
	@GetMapping
	public String listaProcedimentos(CadastroDeProdutoForm cadastro, Model model) {

		List<Produto> produto = produtoRepository.findAll();
		
		model.addAttribute("produto", produto);
		
		return "produtos";
	}
	






}
