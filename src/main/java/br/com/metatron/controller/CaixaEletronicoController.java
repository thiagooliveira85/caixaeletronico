package br.com.metatron.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.metatron.business.CalculadoraDeNotas;
import br.com.metatron.business.ListaDeNotas;
import br.com.metatron.model.ItemNota;

@Controller
public class CaixaEletronicoController {
	
	@Autowired
	private CalculadoraDeNotas calculadora;
	
	@PostConstruct
	private void init() {
		try {
			ListaDeNotas.carrega();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/sacar")
	public ModelAndView sacar(String valor) {
		
		ModelAndView model = new ModelAndView("index");
		
		try {
			
			Double dbValor = Double.parseDouble(valor);
			
			//List<ItemNota> notas = new CalculadoraDeNotas().getNotas(dbValor);
			List<ItemNota> notas = calculadora.getNotas(dbValor);
			
			model = new ModelAndView("index");
			model.addObject("listaItens", notas);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return model;
	}

}
