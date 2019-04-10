package campeonato;

public class Jogo {
	private int cod;
	private int timea_cod;
	private int timeb_cod;
	private String resultado;
	
	public Jogo () { }
	
	public Jogo (int cod, int timea_cod, int timeb_cod, String resultado) {
		this.cod = cod;
		this.timea_cod = timea_cod;
		this.timeb_cod = timeb_cod;
		this.resultado = resultado;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public int getTimea_cod() {
		return timea_cod;
	}
	
	public void setTimea_cod(int timea_cod) {
		this.timea_cod = timea_cod;
	}
	
	public int getTimeb_cod() {
		return timeb_cod;
	}
	
	public void setTimeb_cod(int timeb_cod) {
		this.timeb_cod = timeb_cod;
	}
	
	public String getResultado() {
		return resultado;
	}
	
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public String toString() {
		return "|     " + getCod() + "    |      " + getTimea_cod() + "     |      " + getTimeb_cod() + "     |    " + getResultado() + "    |";
	}
}
