package dao;

import java.util.List;

import campeonato.Time;

public interface TimeDAO {
	public List<Time> listarTodosTimes();
	public Time verTimePorCodigo(int codigo);
	public void salvarTime(Time time);
	public void deletarTime(Time time);
	public void atualizarTime(Time time);
}
