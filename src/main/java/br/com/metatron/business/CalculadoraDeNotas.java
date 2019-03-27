package br.com.metatron.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.metatron.model.ItemNota;
import br.com.metatron.model.Nota;

@Service
public class CalculadoraDeNotas {
	
	public List<ItemNota> getNotas(Double valor) {
		
		List<ItemNota> itens = new ArrayList<>();
		
		int valorSacado = valor.intValue();
		
		for (Nota nota : ListaDeNotas.getNotas()) {
			
			int divisora 	= nota.getValor().intValue();
			int qtdNotas 	= valorSacado / divisora;
			
			if (qtdNotas != 0)
				itens.add(new ItemNota(qtdNotas, nota));
			
			int resto = valorSacado % divisora;
			
			if (resto == 0)
				break;
			
			if (resto < ultimoItemDaLista(ListaDeNotas.getNotas()))
				throw new IllegalArgumentException("Valor informado não pode ser sacado");
			
			valorSacado = resto;
		
		}
		
		return itens;
	}
	
	
	private static int ultimoItemDaLista(List<Nota> notas) {
		return notas.get(notas.size() - 1).getValor().intValue();
	}

}
