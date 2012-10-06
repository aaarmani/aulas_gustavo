package br.com.senacrs.alp.aulas.trabalho9;

public class FuncionarioImpl implements Funcionario {
	private String nome = null;
	private int salario = 0;
	
	public FuncionarioImpl(String nome, int salario){
		this.nome = nome;
		this.salario = salario;
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}

	@Override
	public int getSalario() {
		return this.salario;
	}
	
	public void setSalario(int salario){
		this.salario = salario;
	}

}
