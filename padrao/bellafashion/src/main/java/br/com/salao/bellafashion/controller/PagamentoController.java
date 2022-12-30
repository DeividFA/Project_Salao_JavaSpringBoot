package br.com.salao.bellafashion.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.salao.bellafashion.config.validacao.ValidacaoDeFormaPagamento;
import br.com.salao.bellafashion.form.CadastroDeFormaPagamentoForm;
import br.com.salao.bellafashion.model.FormaPagamento;
import br.com.salao.bellafashion.repository.FormaPagamentoRepository;



@Controller
@RequestMapping("formasdepagamento")
public class PagamentoController {
	
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Autowired
	private ValidacaoDeFormaPagamento validacao;

	

	
	@PostMapping
	public String cadastar(@Valid CadastroDeFormaPagamentoForm cadastro, BindingResult result) {
		
		validacao.validate(cadastro, result);
		
		if (result.hasErrors()) {
			
			return "formasdepagamento";
		}   
		
		FormaPagamento formaPagamento = cadastro.toFormaPagamento();
		System.out.println(formaPagamento.toString());
		
		formaPagamentoRepository.save(formaPagamento);
		return "redirect:/formasdepagamento";
	}
	
	@GetMapping
	public String listaProcedimentos(CadastroDeFormaPagamentoForm cadastro, Model model) {
		
		List<FormaPagamento> formaPagamento = formaPagamentoRepository.findAll();
		
		model.addAttribute("formaPagamento", formaPagamento);
		
		return "formasdepagamento";
	}
	

}
