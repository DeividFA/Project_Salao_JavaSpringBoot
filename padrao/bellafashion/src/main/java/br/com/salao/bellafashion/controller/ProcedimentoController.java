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

import br.com.salao.bellafashion.config.validacao.ValidacaoDeProcedimento;
import br.com.salao.bellafashion.form.CadastroDeProcedimentoForm;
import br.com.salao.bellafashion.model.Procedimento;
import br.com.salao.bellafashion.repository.ProcedimentoRepository;



@Controller
@RequestMapping("procedimentos")
public class ProcedimentoController {
	
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	@Autowired
	private ValidacaoDeProcedimento validacao;
//
//	@GetMapping
//	public String procedimentos(CadastroDeProcedimentoForm cadastro) {
//		return "procedimentos";
//	}
	
	@PostMapping
	public String cadastar(@Valid CadastroDeProcedimentoForm cadastro, BindingResult result) {
		
		validacao.validate(cadastro, result);
		
		if (result.hasErrors()) {
			return "procedimentos";
		}   
		
		Procedimento procedimento = cadastro.toProcedimento();
		System.out.println(procedimento.toString());
		
		procedimentoRepository.save(procedimento);
		return "redirect:/procedimentos";
	}
	
	@GetMapping
	public String listaProcedimentos(CadastroDeProcedimentoForm cadastro, Model model) {

		List<Procedimento> procedimentos = procedimentoRepository.findAll();
		
		model.addAttribute("procedimento", procedimentos);
		
		return "procedimentos";
	}
	

}
