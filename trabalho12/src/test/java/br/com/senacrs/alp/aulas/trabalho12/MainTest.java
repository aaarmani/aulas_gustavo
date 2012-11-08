package br.com.senacrs.alp.aulas.trabalho12;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
	private final static char SEPARATOR_CHAR = File.separatorChar;
	private final static String USER_DIR = System.getProperty("user.dir");
	private final static String PASTA_CONFIG = USER_DIR + SEPARATOR_CHAR +	"config";
	private final static String MSG_ERRO = "ERRO";
	

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
	
	@Test
	public void testCaminhoDiretorio(){
		String[] path = null;
		
		path = new String[1];
		path[0] = USER_DIR;
		
		try{
			Main.main(path);
			Assert.fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testConteudoOK(){
		String esperado = null;
		String obtido = null;
		String path = null;
		final String PORTA = "80";
		final String PASTA_HTML = "root_html";
		final String ARQUIVO_HTML = "index.html";
		final String ARQUIVO_CONFIG = "config.properties";

		
		path = PASTA_CONFIG + SEPARATOR_CHAR + ARQUIVO_CONFIG; 
		esperado = PORTA + ':'+ USER_DIR + SEPARATOR_CHAR + PASTA_HTML + SEPARATOR_CHAR + ARQUIVO_HTML;
		
		obtido = Main.getPath(path);
		Assert.assertEquals(esperado, obtido);
	}
	
	@Test
	public void testConteudoSemSeparador(){
		String esperado = null;
		String obtido = null;
		String path = null;
		
		esperado = MSG_ERRO;
		path = PASTA_CONFIG + SEPARATOR_CHAR +"config_sem_separador.properties";
		
		obtido = Main.getPath(path);
		Assert.assertEquals(esperado, obtido);
	}
	
	@Test
	public void testConteudoPortString(){
		String esperado = null;
		String obtido = null;
		String path = null;
		
		esperado = MSG_ERRO;
		path = PASTA_CONFIG + SEPARATOR_CHAR + "config_port_string.properties";
		
		obtido = Main.getPath(path);
		Assert.assertEquals(esperado, obtido);
	}
	
	
}
