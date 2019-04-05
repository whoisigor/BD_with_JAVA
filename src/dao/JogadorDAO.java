package dao;
import campeonato.*;
import java.util.List;

public interface JogadorDAO {
	public List<Jogador> listarTodosJogadores();
	public Jogador verJogadorPorCodigo(int codigo);
	public void salvarJogador(Jogador jogador);
	public void deletarJogador(Jogador jogador);
	public void atualizarJogador(Jogador jogador);
}
