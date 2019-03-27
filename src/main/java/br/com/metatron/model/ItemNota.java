package br.com.metatron.model;

public class ItemNota {
	
	private Integer quantidade;
	private Nota nota;
	
	public ItemNota(Integer quantidade, Nota nota) {
		this.quantidade = quantidade;
		this.nota = nota;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}
	
}
