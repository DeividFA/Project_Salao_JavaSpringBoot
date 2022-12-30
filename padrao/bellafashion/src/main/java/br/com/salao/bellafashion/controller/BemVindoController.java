package br.com.salao.bellafashion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class BemVindoController {
	
	
	@GetMapping("bemvindo")
	public String bemVindo() {
		return "bemvindo";
	}

}
