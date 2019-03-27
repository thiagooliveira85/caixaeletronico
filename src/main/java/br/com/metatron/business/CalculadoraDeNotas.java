package br.com.metatron.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import br.com.metatron.model.Cem;
import br.com.metatron.model.Cinquenta;
import br.com.metatron.model.Dez;
import br.com.metatron.model.ItemNota;
import br.com.metatron.model.Vinte;
import br.com.metatron.model.Nota;

public class CalculadoraDeNotas {
	
	public List<Nota> notas;
	
	public CalculadoraDeNotas() {
		notas = new ArrayList<>();
		notas.add(new Cem());
		notas.add(new Cinquenta());
		notas.add(new Vinte());
		notas.add(new Dez());
	}
	
	public List<ItemNota> getNotas(Double valor) {
		
		List<ItemNota> itens = new ArrayList<>();
		
		int valorSacado = valor.intValue();
		
		for (Nota nota : notas) {
			
			int divisora 	= nota.getValor().intValue();
			int qtdNotas 	= valorSacado / divisora;
			
			if (qtdNotas != 0)
				itens.add(new ItemNota(qtdNotas, nota));
			
			int resto = valorSacado % divisora;
			
			if (resto == 0)
				break;
			
			if (resto < ultimoItemDaLista(notas))
				throw new IllegalArgumentException("Valor informado não pode ser sacado");
			
			valorSacado = resto;
		
		}
		
		return itens;
	}
	
	
	private static int ultimoItemDaLista(List<Nota> notas) {
		return notas.get(notas.size() - 1).getValor().intValue();
	}

}
