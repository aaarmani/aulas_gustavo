package br.com.senacrs.alp.aulas.MinhaLista;

import static org.junit.Assert.*;
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
		try{
		MinhaListaImp<Object> obj = new MinhaListaImp<Object>(null);
		}catch(IllegalArgumentException e){
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testSufixar() {
		MinhaListaImp<String> obj = new MinhaListaImp<String>("Inicio");
		String esperado = "NovoInicio";
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
		MinhaListaImp<String> obj = new MinhaListaImp<String>("Inicio");
		String esperado = "NovoInicio";
		String resultado;
		Nodo<String> nodo;
		
		obj.prefixar(esperado);
		
		nodo = obj.getInicio();
		resultado = nodo.getValor();
		
		Assert.assertEquals(esperado, resultado);
	}

	@Test
	public void testBuscar() {
		Integer resultado;
		Integer[] valor = new Integer[3];
		valor[0] = 1;
		valor[1] = 2;
		valor[2] = 3;
		MinhaListaImp<Integer> obj = new MinhaListaImp<Integer>(valor[0]);
		
		for(int i = 1; i < 3; i++){
			obj.sufixar(valor[i]);
		}

		for(int i = 0; i < 3; i++){
			resultado = obj.buscar(i);
			Assert.assertEquals(valor[i], resultado);	
		}
	}

	@Test
	public void testInserir() {
		MinhaListaImp<String> obj = new MinhaListaImp<String>("Inicio");
		String valor = "Meio";
		String resultado;
		
		obj.sufixar("Fim");
		obj.inserir(1, valor);
		
		resultado = obj.buscar(1);
		Assert.assertEquals(valor, resultado);
	}

	@Test
	public void testRemover() {
		MinhaListaImp<String> obj = new MinhaListaImp<String>("Inicio");
		String valor = "Fim";
		String resultado;
		
		obj.sufixar("Meio");
		obj.sufixar(valor);
		obj.remover(1); //remove o Meio
		
		resultado = obj.buscar(1);
		Assert.assertEquals(valor, resultado);
	}

	@Test
	public void testTamanho() {
		final Integer qty = 5;
		Integer resultado;
		MinhaListaImp<Integer> obj = new MinhaListaImp<Integer>(0);
		
		for(int i = 1; i < qty; i++){
			obj.sufixar(i);
		}
		
		resultado = obj.tamanho();
		
		Assert.assertEquals(qty, resultado);
	}

}
