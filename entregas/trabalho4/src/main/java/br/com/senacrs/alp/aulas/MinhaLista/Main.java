package br.com.senacrs.alp.aulas.MinhaLista;

public class Main {
	
	public static void main(String[] args) {
		/*MinhaListaImp<String> lista1 = new MinhaListaImp<String>();
		
		System.out.println("Tamanho Inicial = " + lista1.tamanho());
		
		lista1.sufixar("Inicio");
		System.out.println("Tamanho Inicial = " + lista1.tamanho());
		System.out.println("Primeiro teste de nodo = " + lista1.buscar(0));
		lista1.prefixar("NovoInicio");
		lista1.sufixar("terceiro elemento");
		lista1.inserir(2, "quarto elemento");
		lista1.remover(1);
		
		for(int i = 0; i < lista1.tamanho(); i++){
			System.out.println("Nodo "+ i + " = " + lista1.buscar(i));
		}*/
		
		MinhaPilhaImp<String> pilha = new MinhaPilhaImp();
		
		pilha.push("Indice1");
		pilha.push("Indice2");
		pilha.push("Indice3");
		pilha.push("Indice4");
		pilha.push("Indice5");
		
		System.out.println("POP - " + pilha.pop());
		System.out.println("POP - " + pilha.pop());
		System.out.println("POP - " + pilha.pop());
		System.out.println("POP - " + pilha.pop());
		System.out.println("POP - " + pilha.pop());
		
		
	}
}
