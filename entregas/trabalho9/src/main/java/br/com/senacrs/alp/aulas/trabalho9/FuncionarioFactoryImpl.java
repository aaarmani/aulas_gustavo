package br.com.senacrs.alp.aulas.trabalho9;


public class FuncionarioFactoryImpl implements FuncionarioFactory {	

	static private FuncionarioFactoryImpl Instancia = new FuncionarioFactoryImpl();
	
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
		
		FuncionarioImpl func = new FuncionarioImpl(nome, salario);
		return func;
	}
	
	public static FuncionarioFactory getInstancia() {
		
		return Instancia;
	}
}
