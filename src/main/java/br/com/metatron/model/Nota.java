package br.com.metatron.model;

public abstract class Nota {
	
	protected Double valor;
	protected String path;
	
	public Nota(Double valor, String path) {
		this.valor = valor;
		this.path = path;
	}

	public Double getValor() {
		return valor;
	}

	public String getPath() {
		return path;
	}

}
