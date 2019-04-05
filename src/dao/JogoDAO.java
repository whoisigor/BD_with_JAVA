package dao;

import java.util.List;

import campeonato.Jogo;

public interface JogoDAO {
	
	public List<Jogo> listarTodosJogos();
	public Jogo verJogoPorCodigo(int codigo);
	public void salvarJogo(Jogo jogo);
	public void deletarJogo(Jogo jogo);
	public void atualizarJogo(Jogo jogo);

}
