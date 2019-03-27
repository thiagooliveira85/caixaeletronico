package br.com.metatron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.metatron.model.Cem;
import br.com.metatron.model.Cinquenta;
import br.com.metatron.model.Dez;
import br.com.metatron.model.ExibicaoTela;
import br.com.metatron.model.Item;
import br.com.metatron.model.Vinte;

@Controller
public class CaixaEletronicoController {
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/sacar")
	public ModelAndView sacar(String valor) {
		
		if (valor.equals("OUTRO"))
			return new ModelAndView("index");
		
		int intValor = Integer.parseInt(valor);
		System.out.println(intValor);
		
		ModelAndView model = new ModelAndView("index");
		
		ExibicaoTela exibicao = new ExibicaoTela();
		
		exibicao.addItens(new Item(5, new Cem()));
		exibicao.addItens(new Item(2, new Cinquenta()));
		exibicao.addItens(new Item(3, new Vinte()));
		exibicao.addItens(new Item(4, new Dez()));
				
		model.addObject("listaItens", exibicao.getItens());
		
		return model;
	}

}
