package br.com.senacrs.alp.aulas.trabalho12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class Main {

	private static final String MSG_ERRO = "ERRO";

	public static void main(String[] args) {
		String path = args[0];
		String retornoGetPath;
		File file= null;
		
		if (path == null) {
			throw new IllegalArgumentException();
		}
		
		try{
			file = new File(path);
		} catch (NullPointerException e) {
			throw new IllegalArgumentException(e);
		}
		
		if (!file.isFile()) {
			throw new IllegalArgumentException();
		}

		retornoGetPath = getPath(path);
		System.out.println(retornoGetPath);
	}

	public static String getPath(String path) {
		File arquivo = null;
		String configPath = null;
		String separator = null;
		boolean fileOK = true;
		String retorno = null;

		separator = File.separator;
		configPath = path.replaceAll("/", separator);

		arquivo = new File(configPath);

		if(!arquivo.exists()){
			fileOK = false;
		}else if(!arquivo.isFile()){
			fileOK = false;
		}
		
		if(fileOK){
			retorno = trataArquivo(configPath);
			if(retorno == null)
				retorno = MSG_ERRO;
		}
		
		return retorno;
	}

	private static String trataArquivo(String retornoGetPath) {
		File file = new File(retornoGetPath);
		String root = null;
		String linha = null;
		String retorno = null;
		Integer porta = 0;
		BufferedReader br = null;

		try {
			 br = new BufferedReader(new FileReader(file));

			try {
				linha = br.readLine();
				root = getRoot(linha);
				
				if(root != null) {
					
					linha = br.readLine();
					porta = getPorta(linha);
					
					if(porta != -1) {
						retorno = porta.toString() + ':' + root;
						
					} else {
						retorno = MSG_ERRO;
					}
				} else {
					System.out.println("RootErro");
					retorno = MSG_ERRO;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return retorno;
	}

	private static int getPorta(String linha) {
		int index = 0;
		String porta = null;
		Integer retornoPorta = -1; 
		
		index = linha.indexOf("port");
		if(index != -1){
			index = linha.indexOf('=');
			if(index != -1){
				index++;
				porta = linha.substring(index);
				porta = porta.trim();
				System.out.println(porta);
				try{
					retornoPorta = Integer.parseInt(porta);
					System.out.println(retornoPorta);
				} catch (NumberFormatException e) {
					retornoPorta = -1;
				}
			}
		}
		
		System.out.println(retornoPorta);
		return retornoPorta;
	}

	private static String getRoot(String linha) {
		int index = 0;
		String root = null; 
		File file;
		File file2 = null;
		
		index = linha.indexOf("root_dir");
		
		if(index != -1) {
			index = linha.indexOf('=');
			
			if(index != -1){
				index++;
				root = linha.substring(index);
				root = root.trim();
			}
			
			file = new File(root);
			
			if(file.isDirectory()){
				root = root.substring(root.indexOf(File.separatorChar) + 1);
				root = System.getProperty("user.dir") + File.separatorChar + root + File.separatorChar + "index.html";
				System.out.println(root);
				file2 = new File(root);
				if(!file2.isFile())
					root = null;
			}
		}
		
		
		return root;
	}
	
}
