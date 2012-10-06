package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EmpresaImpl implements Empresa {
	private Map<String, Funcionario> mapFunc = new HashMap<String, Funcionario>();
	
	@Override
	public void adicionaFuncionario(Funcionario funcionario) {
		if(funcionario != null){
			mapFunc.put(funcionario.getNome(), funcionario);
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public Funcionario buscaFuncionario(String nome) {
		return mapFunc.get(nome);
	}

	@Override
	public int totalFolhaPgto() {
		int resultado = 0;
		
		for(Funcionario f: mapFunc.values()){
			resultado += f.getSalario();
		}
		return resultado;
	}

	@Override
	public List<Funcionario> ordemCrescenteSalario() {
		FuncionarioSalarioCresComparator funcComp = new FuncionarioSalarioCresComparator();
		List<Funcionario> listaAux = new LinkedList<Funcionario>(mapFunc.values());
		
		Collections.sort(listaAux, funcComp);
		
		return listaAux;
	}

	@Override
	public List<Funcionario> ordemDecrescenteSalario() {
		FuncionarioSalarioDecComparator funcComp = new FuncionarioSalarioDecComparator();
		List<Funcionario> listaAux = new LinkedList<Funcionario>(mapFunc.values());
		
		Collections.sort(listaAux, funcComp);
		
		return listaAux;
	}

	@Override
	public List<Funcionario> ordemAlfabetica() {
		FuncionarioNomeComparator funcComp = new FuncionarioNomeComparator();
		List<Funcionario> listaAux = new LinkedList<Funcionario>(mapFunc.values());
		
		Collections.sort(listaAux, funcComp);
		
		return listaAux;
	}
}
