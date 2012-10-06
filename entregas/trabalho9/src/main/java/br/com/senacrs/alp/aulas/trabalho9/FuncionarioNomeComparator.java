package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Comparator;

public class FuncionarioNomeComparator implements Comparator<Funcionario> {

	@Override
	public int compare(Funcionario func1, Funcionario func2) {
		String nomeFunc1 = func1.getNome();
		String nomeFunc2 = func2.getNome();
		
		return nomeFunc1.compareToIgnoreCase(nomeFunc2);
	}

}
