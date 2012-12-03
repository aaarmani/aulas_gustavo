package br.com.senacrs.alp.aulas.trabalho13;

import java.util.Comparator;

public class ComparaArq implements Comparator<String> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

	@Override
	public int compare(String arg0, String arg1) {
		int		retorno = 0;
		char	chPrefixo0 = 0;
		char	chPrefixo1 = 0;
		String	str0 = null;
		String	str1 = null;
		
		chPrefixo0 = arg0.charAt(0);
		chPrefixo1 = arg1.charAt(0);
		
		if(chPrefixo0 != chPrefixo1) {
			retorno = chPrefixo0 > chPrefixo1 ? -1 : 1;
		} else {
			str0 = arg0.substring(2);
			str0 = str0.toLowerCase();
			
			str1 = arg1.substring(2);
			str1 = str1.toLowerCase();
			
			retorno = str0.compareTo(str1);
		}
		
		return retorno;
	}

}
