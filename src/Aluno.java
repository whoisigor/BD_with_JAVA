

public class Aluno {
	
	String matricula;
	String nome;
	String endereco;
	
	public Aluno(String matricula, String nome, String endereco) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getMatricula() + " - " + getNome();
	}
	
	

}
