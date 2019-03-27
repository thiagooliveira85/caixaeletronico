package br.com.metatron.model;

import java.util.ArrayList;
import java.util.List;

public class ExibicaoTela {
	
	private List<Item> itens;

	public ExibicaoTela() {
		itens = new ArrayList<>();
	}

	public List<Item> getItens() {
		return itens;
	}
	
	public void addItens(Item item) {
		itens.add(item);
	}

}
