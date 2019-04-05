package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import campeonato.Time;

public class TimeImpl implements TimeDAO{

	@Override
	public List<Time> listarTodosTimes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Time verTimePorCodigo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarTime(Time time) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO time VALUES (?,?,?)";
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setInt(1, time.getCod());
				preparedStatement.setString(2, time.getNome());
				preparedStatement.setString(3, time.getDatafundacao());
				int resultado = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void deletarTime(Time time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarTime(Time time) {
		// TODO Auto-generated method stub
		
	}

}
