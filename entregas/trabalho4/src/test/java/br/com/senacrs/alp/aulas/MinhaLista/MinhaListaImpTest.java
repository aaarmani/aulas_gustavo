package br.com.senacrs.alp.aulas.MinhaLista;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinhaListaImpTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinhaListaImp() {
		MinhaListaImp<String> obj = new MinhaListaImp<String>();
		Assert.assertTrue(obj != null);
	}


	@Test
	public void testSufixar() {
		MinhaListaImp<String> obj = new MinhaListaImp<String>();
		String esperado = "Fim";
		String resultado;
		
		obj.sufixar(esperado);
		resultado = getSufixo(obj);
		Assert.assertEquals(esperado, resultado);
		
	}

	private String getSufixo(MinhaListaImp<String> obj) {
		Nodo<String> nodo;
		nodo = obj.getInicio();
		
		while(nodo.getProximo() != null){
			nodo = nodo.getProximo();
		}
		
		return nodo.getValor();
	}

	@Test
	public void testPrefixar() {
		MinhaListaImp<String> obj = new MinhaListaImp<String>();
		String esperado1 = "inicio";
		String esperado2 = "NovoInicio";
		String resultado;
		String resultado2;
		Nodo<String> nodo;
		Nodo<String> inicio;
		
		obj.prefixar(esperado1);
		obj.prefixar(esperado2);
		
		inicio = obj.getInicio();
		nodo = inicio.getProximo();
		
		resultado = nodo.getValor();
		nodo = nodo.getProximo();
		resultado2 = nodo.getValor();
		
		Assert.assertEquals(esperado2, resultado);
		Assert.assertEquals(esperado1, resultado2);
	}

	@Test
	public void testBuscar() {
		Integer resultado;
		Integer[] valor = new Integer[3];
		valor[0] = 1;
		valor[1] = 2;
		valor[2] = 3;
		MinhaListaImp<Integer> obj = new MinhaListaImp<Integer>();
		
		for(int i = 0; i < 3; i++){
			obj.sufixar(valor[i]);
		}

		for(int i = 0; i < 3; i++){
			resultado = obj.buscar(i);
			Assert.assertEquals(valor[i], resultado);	
		}
	}

	@Test
	public void testInserir() {
		MinhaListaImp<String> obj = new MinhaListaImp<String>();
		String valor = "Meio";
		String resultado;
		
		obj.sufixar("Fim");
		obj.inserir(1, valor);
		
		resultado = obj.buscar(1);
		Assert.assertEquals(valor, resultado);
	}

	@Test
	public void testRemover() {
		MinhaListaImp<String> obj = new MinhaListaImp<String>();
		String valor = "Fim";
		String resultado;
		
		obj.sufixar("Meio");
		obj.sufixar(valor);
		obj.remover(0); //remove o Meio
		
		resultado = obj.buscar(0);
		Assert.assertEquals(valor, resultado);
	}

	@Test
	public void testTamanho() {
		final Integer qty = 5;
		Integer resultado;
		MinhaListaImp<Integer> obj = new MinhaListaImp<Integer>();
		
		for(int i = 0; i < qty; i++){
			obj.sufixar(i);
		}
		
		resultado = obj.tamanho();
		Assert.assertEquals(qty, resultado);
	}

}
