package campeonato;

public class Time {
	private int cod;
	private String nome;
	private String datafundacao;
	
	public Time(int cod, String nome, String datafundacao) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.datafundacao = datafundacao;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDatafundacao() {
		return datafundacao;
	}
	public void setDatafundacao(String datafundacao) {
		this.datafundacao = datafundacao;
	}
	
	
}
