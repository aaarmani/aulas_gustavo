package br.com.senacrs.alp.aulas.MinhaLista;

public class Main {
	
	public static void main(String[] args) {
		MinhaLista<String> lista = new MinhaListaImp<String>("Inicio");
		MinhaLista<Integer> lista2 = new MinhaListaImp<Integer>(Integer.valueOf(0));
		
		System.out.println(lista.tamanho());
		System.out.println(lista.buscar(0));
		
		lista.prefixar("novoPrimeiro");
		lista.sufixar("segundo");
		System.out.println(lista.tamanho());
		
		System.out.println(lista.buscar(0));
	}
}
