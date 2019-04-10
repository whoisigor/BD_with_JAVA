package campeonato;

public class Jogador {
	private int cod;
	private int time_cod;
	private String nome;
	private int idade;
	
	
	public Jogador() { }
	
	public Jogador (int cod, int time_cod, String nome, int idade) {
		this.cod = cod;
		this.setTime_cod(time_cod);
		this.setNome(nome);
		this.setIdade(idade);
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getTime_cod() {
		return time_cod;
	}

	public void setTime_cod(int time_cod) {
		this.time_cod = time_cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String toString() {
		return "|      " + getCod() + "      |     " + getTime_cod() + "    |    " + getIdade() + "    |    " + getNome(); 
	}
	
	

}
