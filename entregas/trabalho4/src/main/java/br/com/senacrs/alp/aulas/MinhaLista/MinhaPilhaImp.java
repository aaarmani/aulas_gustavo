package br.com.senacrs.alp.aulas.MinhaLista;

public class MinhaPilhaImp<Tipo> implements MinhaPilha<Tipo> {
	
	private MinhaListaImp<Tipo> lista = null;
	
	public MinhaPilhaImp(){
		lista = new MinhaListaImp<Tipo>();
	}

	public void push(Tipo valor) {
		lista.prefixar(valor);
	}

	public Tipo pop() {
		return lista.remover(0);
	}
}
