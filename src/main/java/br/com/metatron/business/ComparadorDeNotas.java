package br.com.metatron.business;

import java.util.Comparator;

import br.com.metatron.model.Nota;

public class ComparadorDeNotas implements Comparator<Nota> {

	@Override
	public int compare(Nota n1, Nota n2) {
		if (n1.getValor() < n2.getValor())
			return 1;
        else if (n1.getValor() > n2.getValor()) 
        	return -1;
        
		return 0;
	}

}
