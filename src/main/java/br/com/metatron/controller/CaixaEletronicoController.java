package br.com.metatron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CaixaEletronicoController {
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}

}
