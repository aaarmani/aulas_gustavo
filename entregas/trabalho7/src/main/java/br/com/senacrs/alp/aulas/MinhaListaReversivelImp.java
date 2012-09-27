package br.com.senacrs.alp.aulas;

import br.com.senacrs.alp.aulas.Nodo;

public class MinhaListaReversivelImp<Tipo> implements MinhaListaReversivel<Tipo> {
	private Nodo<Tipo> inicio = null;
	private Nodo<Tipo> fim = null;
	
	public MinhaListaReversivelImp(){
		this.inicio = new Nodo<Tipo>(null);
		this.fim = new Nodo<Tipo>(null);
		
		inicio.setProximo(fim);
		fim.setAnterior(inicio);
	}
	
	protected Nodo<Tipo> getInicio(){
		return inicio;
	}
	
	protected Nodo<Tipo> getFim(){
		return fim;
	}
	
	@Override
	public void sufixar(Tipo valor) {
		Nodo<Tipo> fim = null;
		Nodo<Tipo> sufixo = null;
		Nodo<Tipo> novoSufixo = null;

		fim = getFim();
		sufixo = fim.getAnterior();
		novoSufixo = new Nodo<Tipo>(valor);
		
		sufixo.setProximo(novoSufixo);
		novoSufixo.setAnterior(sufixo);
		novoSufixo.setProximo(fim);
		fim.setAnterior(novoSufixo);
	}

	@Override
	public void prefixar(Tipo valor) {
		Nodo<Tipo> inicio = null;
		Nodo<Tipo> prefixo = null;
		Nodo<Tipo> novoPrefixo = null;
		
		inicio = getInicio();
		prefixo = inicio.getProximo();
		novoPrefixo = new Nodo<Tipo>(valor);
		
		prefixo.setAnterior(novoPrefixo);
		novoPrefixo.setAnterior(inicio);
		novoPrefixo.setProximo(prefixo);
		inicio.setProximo(novoPrefixo);
	}

	@Override
	public Tipo buscar(int posicao) {		
		Nodo<Tipo> resultado = null;
		
		verificarPosicaoParaBuscar(posicao);
		resultado = buscarNodo(posicao);
		
		return resultado.getValor();
	}
	
	private Nodo<Tipo> buscarNodo(int posicao){
		int tamanho = tamanho();
		Nodo<Tipo> resultado;
		
		if((tamanho / 2) >= posicao){
			resultado = buscarDoInicio(posicao);
		}
		else{
			resultado = buscarDoFim(posicao);
		}
		return resultado;
	}

	private Nodo<Tipo> buscarDoInicio(int posicao) {
		Nodo<Tipo> resultado = getInicio();

		for (int i = -1; i < posicao; i++) {
			resultado = resultado.getProximo();
		}
		return resultado;
	}

	private Nodo<Tipo> buscarDoFim(int posicao) {
		Nodo<Tipo> resultado = getFim();

		for (int i = tamanho(); i > posicao; i--){
			resultado = resultado.getAnterior();
		}
		return resultado;
	}
	
	@Override
	public void inserir(int posicao, Tipo valor) {
		Nodo<Tipo> anterior = null;
		Nodo<Tipo> proximo = null;
		Nodo<Tipo> nodo = null;
		
		verificarPosicaoParaInserir(posicao);
		anterior = buscarNodo(posicao - 1);
		proximo = anterior.getProximo();
		nodo = new Nodo<Tipo>(valor);
		
		nodo.setAnterior(anterior);
		nodo.setProximo(proximo);
		anterior.setProximo(nodo);
		proximo.setAnterior(nodo);
	}

	@Override
	public Tipo remover(int posicao) {
		Nodo<Tipo> anterior = null;
		Nodo<Tipo> nodo = null;
		Nodo<Tipo> proximo = null;
		Tipo resultado;
		
		verificarPosicaoParaBuscar(posicao);
		anterior = buscarNodo(posicao -1);
		nodo = anterior.getProximo();
		proximo = nodo.getProximo();
		anterior.setProximo(proximo);
		proximo.setAnterior(anterior);
		
		resultado = nodo.getValor();
		return resultado;
	}

	@Override
	public int tamanho() {
		Nodo<Tipo> nodo = null;
		Nodo<Tipo> inicio = null;
		Nodo<Tipo> fim = null;
		int resultado = 0;
		
		inicio = getInicio();
		fim = getFim();
		nodo = inicio.getProximo();
		
		while(!nodo.equals(fim)){
			nodo = nodo.getProximo();
			resultado++;
		}
		
		return resultado;
	}
	
	@Override
	public void reverter() {
		Nodo<Tipo> aux = null;
		Nodo<Tipo> anterior = null;
		Nodo<Tipo> proximo = null;
		Nodo<Tipo> inicio = null;
		Nodo<Tipo> fim = null;
		int tamanho = this.tamanho();
		
		inicio = getInicio();
		fim = getFim();
		
		if(tamanho > 0){		
			aux = inicio.getProximo();

			for(int i = 0;  i < tamanho; i++){
				//altera ponteiro dos nodos internos 
				anterior = aux.getAnterior();
				proximo = aux.getProximo();
				
				aux.setAnterior(proximo);
				aux.setProximo(anterior);

				aux = aux.getAnterior(); //pegará o proximo pq foi invertido
			}
			
			//aponta para o primeiro elemento invertido
			aux = inicio.getProximo();
			aux.setProximo(fim); //o primeiro.proximo aponta pro fim depois da inversao
			aux = fim.getAnterior();
			aux.setAnterior(inicio); //ultimo.ant aponta pro inicio
			
			fim.setAnterior(inicio.getProximo());
			fim.setProximo(null);
			inicio.setAnterior(null);
			inicio.setProximo(aux);
		}
	}
	
	private void verificarPosicaoParaInserir(int posicao) {
		
		int posicaoMaxima = 0;

		posicaoMaxima = this.tamanho();
		verificarPosicao(posicao, posicaoMaxima);
	}

private void verificarPosicaoParaBuscar(int posicao) {
		
		int posicaoMaxima = 0;

		posicaoMaxima = this.tamanho() - 1;
		verificarPosicao(posicao, posicaoMaxima);
	}

	private void verificarPosicao(int posicao, int posicaoMaxima) {
		
		boolean posicaoValida = false;

		posicaoValida = posicaoDentroDeLimitesValidos(posicao, posicaoMaxima); 
		if (!posicaoValida) {
			throw new IndexOutOfBoundsException();
		}
	}

	private boolean posicaoDentroDeLimitesValidos(int posicao, int posicaoMaxima) {
		
		boolean resultado = false;
		
		resultado = (posicao >= 0) && (posicao <= posicaoMaxima);
		
		return resultado;
	}
	
	@Override
	public String toString() {
		
		String resultado = null;
		Nodo<Tipo> nodo = null;
		
		resultado = this.getClass().getSimpleName() +  ":";
		nodo = this.inicio;
		while (nodo.getProximo() != null) {
			nodo = nodo.getProximo();
			resultado += nodo;
		}

		return resultado;
	}

}
