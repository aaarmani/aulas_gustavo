package br.com.senacrs.alp.aulas.trabalho13;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class ListaDiretorio {
	private static final String PREFIXO_DIR = "d ";
	private static final String PREFIXO_FILE = "a ";
	private static final String PREFIXO_LIST = "list: ";
	private static final String PREFIXO_TOTAL = "total: ";

	public String[] listaConteudoDiretorio(String diretorio) {
		String caminho = null;
		String[] retorno = null;
		
		caminho = trataCaminho(diretorio);
		retorno = lsDiretorio(caminho);

		return retorno;
	}

	private String[] lsDiretorio(String caminho) {
		File fdDiretorio = null;
		List<File> lista = null;
		List<String> listaNomes = null;
		File[] fileArray = null;		
		ComparaArq comp = new ComparaArq();
		String[] retorno = null;

		fdDiretorio = abreDir(caminho);

		fileArray = fdDiretorio.listFiles();
		lista = new LinkedList<File>(Arrays.asList(fileArray));

		listaNomes = adicionaPrefixo(lista);
		Collections.sort(listaNomes, comp);
		adicionaCabecalho(listaNomes, caminho);
		
		retorno = new String[listaNomes.size()];
		for(int i = 0; i < retorno.length; i++) {
			retorno[i] = listaNomes.get(i);
		}

		return retorno;
	}
	

	private void adicionaCabecalho(List<String> listaNomes, String caminho) {
		int tamanho = 0;
		String linha1 = null;
		String linha2 = null;
		
		tamanho = listaNomes.size();
		
		linha1 = PREFIXO_LIST + caminho;
		linha2 = PREFIXO_TOTAL + tamanho;
		
		listaNomes.add(0, linha1);
		listaNomes.add(1, linha2);
	}

	private List<String> adicionaPrefixo(List<File> lista) {
		List<String> listaNomes = null;
		int tamanhoLstArq = 0;
		
		File file;
		
		tamanhoLstArq = lista.size();
		listaNomes = new LinkedList<String>();
		
		for(int i = 0; i < tamanhoLstArq; i++) {
			file = lista.get(i);
			String nome = null;	
			if(file.isDirectory()) {
				nome = PREFIXO_DIR + file.getName();
			} else if(file.isFile()) {
				nome = PREFIXO_FILE + file.getName();
			}
			
			if(nome != null) {
				listaNomes.add(nome);
			}
		}
		
		return listaNomes;
	}

	private File abreDir(String caminho) {
		File file = null;

		try {
			file = new File(caminho);
		} catch (NullPointerException e){
			throw new IllegalArgumentException(e);
		}

		if(!file.isDirectory()) {
			throw new IllegalArgumentException();
		}
		
		return file;
	}

	private String trataCaminho(String caminho) {
		String retorno = null;
		
		if(caminho == null) {
			throw new IllegalArgumentException();
		}
		if(caminho.isEmpty()) {
			throw new IllegalArgumentException();
		}
		retorno = caminho.replaceAll("/", File.separator);
		
		return retorno;
	}
}
