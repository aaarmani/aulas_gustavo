package br.com.senacrs.alp.aulas.trabalho12;

import java.io.File;

public class Main {

	private static final String MSG_ERRO = "ERRO";

	public static void main(String[] args) {
		String path = args[0];
		String retornoGetPath;
		
		if (path == null) {
			throw new IllegalArgumentException();
		}

		retornoGetPath = getPath(path);
		
		if(!retornoGetPath.equals(MSG_ERRO)){
			trataArquivo(retornoGetPath);
		}
	}

	private static void trataArquivo(String retornoGetPath) {
		
		
	}

	public static String getPath(String path) {
		File arquivo = null;
		String fullPath = null;
		String separator = null;
		boolean fileOK = true;
		String retorno;

		separator = File.separator;
		fullPath = path.replaceAll("/", separator);
		
		arquivo = new File(fullPath);
		
		if(!arquivo.exists()){
			fileOK = false;
		}else if(!arquivo.isFile()){
			fileOK = false;
		}
		
		if(fileOK){
			retorno = fullPath;
		}else{
			retorno = MSG_ERRO;
		}
		
		return retorno;
	}

}
