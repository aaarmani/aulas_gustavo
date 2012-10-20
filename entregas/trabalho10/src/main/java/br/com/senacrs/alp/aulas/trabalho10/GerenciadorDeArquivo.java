package br.com.senacrs.alp.aulas.trabalho10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class GerenciadorDeArquivo {
	File file = null;
	
	public GerenciadorDeArquivo(String nomeArquivo) {

		if(nomeArquivo == null){
			throw new IllegalArgumentException();
		}
		
		file = new File(nomeArquivo);
		
		if(file.isDirectory()){
			throw new IllegalArgumentException();
		}
	}

	public String[] lerArquivo() {
		BufferedReader br = null;
		List<String> lista = new LinkedList<String>();
		String strLinha;
		
		if(!file.exists()){
			throw new IllegalArgumentException();
		}
		
		try{
			br = new BufferedReader(new FileReader(file));
			
			try {
				strLinha = br.readLine();
				while(strLinha != null){
					lista.add(strLinha);
					strLinha = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}catch (IOException e) {
		       System.err.println("Error: " + e);
	    }finally{
	    	try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		
		String strArray[] = new String[lista.size()];
		
		for(int i = 0; i < lista.size(); i++){
			strArray[i] = lista.get(i);
		}
		
		return strArray;
	}

	public String[] lerArquivoComSubstituicao(String lido, String retornado) {
		BufferedReader br = null;
		List<String> lista = new LinkedList<String>();
		String strLinha;
		String novaLinha;
		
		if(!file.exists()){
			throw new IllegalArgumentException();
		}
		
		try{
			br = new BufferedReader(new FileReader(file));
			
			try {
				strLinha = br.readLine();
				while(strLinha != null){
					
					if(strLinha.contains(lido))
					{
						novaLinha = strLinha.substring(0, strLinha.indexOf(lido)) +
								retornado +
								strLinha.substring(strLinha.indexOf(lido) + lido.length());
						strLinha = novaLinha;
					}
					lista.add(strLinha);
					strLinha = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}catch (IOException e) {
		       System.err.println("Error: " + e);
	    }finally{
	    	try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		
		String strArray[] = new String[lista.size()];
		
		for(int i = 0; i < lista.size(); i++){
			strArray[i] = lista.get(i);
		}
		
		return strArray;
	}

	public void escreverArquivo(String[] conteudo) {
		BufferedWriter bw = null;
					
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			bw = new BufferedWriter(new FileWriter(file));
			
			for(int i = 0; i < conteudo.length; i++){
				bw.write(conteudo[i]);
				bw.newLine();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
