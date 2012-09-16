package br.com.senacrs.alp.aulas.MinhaLista;

public interface MinhaPilha <Tipo extends Object>{
	
	void push(Tipo valor);
	
	Tipo pop();

}
