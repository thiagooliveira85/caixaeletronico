package br.com.metatron.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.com.metatron.controller.CaixaEletronicoController;

@SpringBootApplication
@ComponentScan(basePackageClasses=CaixaEletronicoController.class)
public class Configuracao {
	
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}

}
