package br.com.metatron.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

import br.com.metatron.model.Nota;

public class ListaDeNotas {
	
	private static List<Nota> notas = new ArrayList<Nota>();
	
	public static List<Nota> getNotas() {
		return notas;
	}
	
	public static void carrega() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		List<Nota> lstAux = new ArrayList<Nota>();
		
		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
		provider.addIncludeFilter(new AssignableTypeFilter(Nota.class));

		Set<BeanDefinition> components = provider.findCandidateComponents("br/com/metatron/model");
		for (BeanDefinition component : components){
		    Class<?> cls = Class.forName(component.getBeanClassName());
		    Nota newInstance = (Nota) cls.newInstance();
		    lstAux.add(newInstance);
		}
		
		Collections.sort(lstAux, new ComparadorDeNotas());
		
		notas.addAll(lstAux);
	}

}
