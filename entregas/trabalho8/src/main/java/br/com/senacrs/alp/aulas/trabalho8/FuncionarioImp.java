package br.com.senacrs.alp.aulas.trabalho8;

public class FuncionarioImp implements Funcionario {
	private String nome = null;
	private int salario = 0;
	
	public FuncionarioImp() {
		setNome(null);
		setSalario(0);
	}
	
	public FuncionarioImp(String nome, int salario){
		this.setNome(nome);
		this.setSalario(salario);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
}
