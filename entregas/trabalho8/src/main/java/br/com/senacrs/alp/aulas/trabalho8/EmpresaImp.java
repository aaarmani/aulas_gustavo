package br.com.senacrs.alp.aulas.trabalho8;

import java.util.HashMap;
import java.util.Map;

public class EmpresaImp implements Empresa {
	private Map<String, Funcionario> mapFuncionarios = new HashMap<String, Funcionario>();
	
	public void adicionaFuncionario(Funcionario funcionario) {
		if(funcionario != null){
			mapFuncionarios.put(funcionario.getNome(), funcionario);
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	public Funcionario buscaFuncionario(String nome) {
		return mapFuncionarios.get(nome);
	}

	public int totalFolhaPgto() {
		int resultado = 0;
		
		for(Funcionario f: mapFuncionarios.values()){
			resultado += f.getSalario();
		}

		return resultado;
	}
	

}
