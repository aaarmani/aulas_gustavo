package br.com.senacrs.alp.aulas.trabalho5;

import br.com.senacrs.alp.aulas.MinhaListaImp;

public class EmpresaImp implements Empresa {
	private MinhaListaImp<Funcionario> listaFunc = null;

	public EmpresaImp(){
		 listaFunc = new MinhaListaImp<Funcionario>();
	}
	
	public void adicionaFuncionario(Funcionario funcionario) {
		if(funcionario != null){
			listaFunc.sufixar(funcionario);
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	public int totalFolhaPgto() {
		FuncionarioImp funcionario = null;
		int totalPgto = 0;
		int totalFunc;
		
		totalFunc = listaFunc.tamanho();
		
		for(int i = 0; i < totalFunc; i++){
			funcionario = (FuncionarioImp) listaFunc.buscar(i);
			totalPgto += funcionario.getSalario();
		}
		
		return totalPgto;
	}



	public Funcionario buscaFuncionario(String nome) {
		FuncionarioImp funcionario = null;
		String nomeFunc;
		int totalFunc = listaFunc.tamanho();
		
		for(int i = 0; i < totalFunc; i++){
			funcionario = (FuncionarioImp) listaFunc.buscar(i);
			nomeFunc = funcionario.getNome();
			
			if(nomeFunc.equalsIgnoreCase(nome)){
				return funcionario;
			}
		}
				
		return null;
	}

}
