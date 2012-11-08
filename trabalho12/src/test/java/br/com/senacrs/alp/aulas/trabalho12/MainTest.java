package br.com.senacrs.alp.aulas.trabalho12;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void testCaminhoNulo(){
		String[] argumento;
		
		argumento = new String[1];
		argumento[0] = null;
		
		try{
			Main.main(argumento);
			Assert.fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCaminhoInvalido(){
		String esperado = null;
		String obtido = null;
		String path = null;
		
		path = "Caminho_Invalido";
		esperado = "ERRO";
		
		obtido = Main.getPath(path);
		
		Assert.assertEquals(esperado, obtido);
	}
}
