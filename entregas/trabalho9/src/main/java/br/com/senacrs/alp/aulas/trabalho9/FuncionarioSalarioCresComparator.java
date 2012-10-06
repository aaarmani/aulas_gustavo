package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Comparator;


public class FuncionarioSalarioCresComparator implements Comparator<Funcionario> {

	@Override
	public int compare(Funcionario func1, Funcionario func2) {
		int resultado = 0;
		
		resultado = func1.getSalario() - func2.getSalario();
		
		if(resultado > 0){
			resultado = 1;
		}
		else if(resultado < 0){
			resultado = -1;
		}
		
		return resultado;
	}
	
}
