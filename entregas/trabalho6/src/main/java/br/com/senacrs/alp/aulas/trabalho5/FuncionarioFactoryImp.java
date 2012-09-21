package br.com.senacrs.alp.aulas.trabalho5;

public class FuncionarioFactoryImp implements FuncionarioFactory {

	static private FuncionarioFactoryImp funcInstancia = null;
	
	@Override
	public Funcionario criaFuncionario(String nome, int salario) {
		
		if(nome == null){
			throw new IllegalArgumentException();
		}
		if(nome == ""){
			throw new IllegalArgumentException();
		}
		if(salario < 0){
			throw new IllegalArgumentException();
		}
		
		FuncionarioImp func = new FuncionarioImp(nome, salario);
		
		return func;
	}

	public static FuncionarioFactoryImp getInstancia(){
		if(funcInstancia == null){
			funcInstancia = new FuncionarioFactoryImp();
		}
		
		return funcInstancia;
	}
}
