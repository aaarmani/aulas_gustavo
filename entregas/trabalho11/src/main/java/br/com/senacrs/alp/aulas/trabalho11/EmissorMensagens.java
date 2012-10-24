package br.com.senacrs.alp.aulas.trabalho11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmissorMensagens {
	File fileMsg = null;
	Map<String, String> mapMsg= new HashMap<String, String>();
	
	
	public EmissorMensagens(String nomeArquivo) {
		
		if(nomeArquivo == null){
			throw new IllegalArgumentException();
		}
		
		fileMsg = new File(nomeArquivo);
		
		if(fileMsg.isDirectory()){
			throw new IllegalArgumentException();
		} else if(!fileMsg.exists()){
			throw new IllegalArgumentException();
		}
	
		//try{
			if(ImpotarMsg() != 0){
				throw new IllegalArgumentException();
			}
		/*}catch(){
			throw new IllegalArgumentException();
		}*/
		
	}

	private int ImpotarMsg() {
		int resultado = 0;
		String linha;
		BufferedReader reader = null;
		
		try {
			reader = bufReaderOpen();
			linha = reader.readLine();

			while(linha != null){
				if((resultado = verificaIntegridade(linha)) != 0){
					break;
				}
				
				populaMap(linha);
				linha = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}

	private void populaMap(String linha) {
		String chave;
		String frase;
		
		chave = linha.substring(0, linha.indexOf(" = "));
		frase = linha.substring(linha.indexOf(" = ") + 3);		
		
		chave = chave.trim();
		frase = frase.trim();
		mapMsg.put(chave, frase);
	}

	private int verificaIntegridade(String linha) {
		int retorno = 0;
		int index;		
		
		//verrifica ocorrencia do " = " entre chave e gargumento
		if((index = linha.indexOf(" = ")) == -1){
			retorno = -1;
		}
		
		//não possui chave
		if(index == 0){
			retorno =  -2;
		}
		
		//se contem mais que um '='
		if(linha.indexOf('=', index + 3) != -1){
			retorno = -3;
		}
		
		//se nao contem argumento apos o =
		if(linha.substring(index + 3) == null){
			retorno  = -4;
		}
		
		return retorno;
	}

	private BufferedReader bufReaderOpen() {
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(fileMsg));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}/*finally{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		return reader;
	}

	public String formatarMensagem(String chave, Object... argumentos) {
		String mapArg;
		String msg;
		
		mapArg = mapMsg.get(chave);

		if(mapArg == null){
			throw new IllegalArgumentException();
		}
		
		msg = String.format(mapArg, argumentos);
		return msg;
	}
}
