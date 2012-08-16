package br.com.internacional.aula2;

public class Chefe extends Funcionario {
	Secretaria secretaria = new Secretaria();

	public Secretaria getSecretaria(){
		return secretaria;
	}
	
	public void setSecretaria(Secretaria secretaria){
		this.secretaria = secretaria;
	}
	
}
