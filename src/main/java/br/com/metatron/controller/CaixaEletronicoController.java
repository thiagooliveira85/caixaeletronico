package br.com.metatron.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.metatron.business.CalculadoraDeNotas;
import br.com.metatron.model.ItemNota;

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
		
		Double dbValor = Double.parseDouble(valor);
		
		List<ItemNota> notas = new CalculadoraDeNotas().getNotas(dbValor);
		
		ModelAndView model = new ModelAndView("index");
		model.addObject("listaItens", notas);
		
		return model;
	}

}
