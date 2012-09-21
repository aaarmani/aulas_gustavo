package br.com.senacrs.alp.aulas.trabalho5;

import java.util.LinkedList;
import java.util.List;

import br.com.senacrs.alp.aulas.MinhaLista;

public class MinhaListaListImp<Tipo> implements MinhaLista<Tipo> {
	List<Tipo> lista = new LinkedList<Tipo>();
	
	public void sufixar(Tipo valor) {
		lista.add(valor);
	}

	public void prefixar(Tipo valor) {
		lista.add(0, valor);
	}

	public Tipo buscar(int posicao) {
		return lista.get(posicao);
	}

	public void inserir(int posicao, Tipo valor) {
		lista.add(posicao, valor);
	}

	public Tipo remover(int posicao) {
		return lista.remove(posicao);
	}

	public int tamanho() {
		return lista.size();
	}

}
