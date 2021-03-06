package br.com.senacrs.alp.aulas.MinhaLista;

public class MinhaListaImp<Tipo> implements MinhaLista<Tipo> {
	
	private Nodo<Tipo> inicio = null;
	
	public MinhaListaImp(){
			this.inicio = new Nodo<Tipo>(null);
	}
	
	public void sufixar(Tipo valor) {
		Nodo<Tipo> ultimo = buscarUltimoNodo();
		Nodo<Tipo> novoUltimo = new Nodo<Tipo>(valor);
		ultimo.setProximo(novoUltimo);
	}

	private Nodo<Tipo> buscarUltimoNodo() {
		int tamanho = tamanho();
		Nodo<Tipo> resultado = buscarNodo(tamanho);
		return resultado;
	}

	private Nodo<Tipo> buscarNodo(int posicao) {
		Nodo<Tipo> resultado = getInicio();
		
		for(int i = 0; i < posicao; i++){
			resultado = resultado.getProximo();
		}
		
		return resultado;
	}

	public void prefixar(Tipo valor) {
		Nodo<Tipo> nodo = new Nodo<Tipo>(valor);
		Nodo<Tipo> inicio = getInicio();
		Nodo<Tipo> inicioReal = inicio.getProximo();
		
		nodo.setProximo(inicioReal);
		inicio.setProximo(nodo);
	}

	private Nodo<Tipo> buscarPrimeiroNodo() {
		
		Nodo<Tipo> resultado = getInicio();

		return resultado;
	}

	public Tipo buscar(int posicao) {
		
		Nodo<Tipo> nodo = buscarNodo(posicao + 1);
		
		return nodo.getValor();
	}

	public void inserir(int posicao, Tipo valor) {
		Nodo<Tipo> anterior = buscarNodo(posicao);
		Nodo<Tipo> proximo = anterior.getProximo();
		Nodo<Tipo> nodo = new Nodo<Tipo>(valor);
		
		anterior.setProximo(nodo);
		nodo.setProximo(proximo);
	}

	public Tipo remover(int posicao) {
		Nodo<Tipo> anterior = buscarNodo(posicao);
		Nodo<Tipo> nodo = anterior.getProximo();
		Nodo<Tipo> proximo = nodo.getProximo();
		
		anterior.setProximo(proximo);
		return nodo.getValor();
	}

	public int tamanho() {
		Nodo<Tipo> nodo = getInicio();
		int resultado = 0;
		
		while(nodo.getProximo() != null){
			nodo = nodo.getProximo();
			resultado++;
		}
		return resultado;
	}

	protected Nodo<Tipo> getInicio() {
		return inicio;
	}

	protected void setInicio(Nodo<Tipo> inicio) {
		this.inicio.setProximo(inicio);
	}

}
