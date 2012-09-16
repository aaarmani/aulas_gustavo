package br.com.senacrs.alp.aulas.MinhaLista;

public class Nodo <Tipo extends Object>{
	private Tipo valor;
	private Nodo<Tipo> proximo;
	
	public Nodo(Tipo valor) {
		this.valor = valor;
		this.proximo = null;
	}

	public Tipo getValor() {
		return valor;
	}
	
	public void setValor(Tipo valor) {
		this.valor = valor;
	}
	
	public Nodo<Tipo> getProximo() {
		return proximo;
	}
	
	public void setProximo(Nodo<Tipo> proximo) {
		this.proximo = proximo;
	}
	
}
