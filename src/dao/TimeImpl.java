package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import campeonato.Jogo;
import campeonato.Time;

public class TimeImpl implements TimeDAO{

	@Override
	public List<Time> listarTodosTimes() {
		List<Time> times = new ArrayList<Time>();
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "SELECT * FROM time";
				preparedStatement = conn.prepareStatement(selectTableSQL);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) { // ENQUANTO EXISTIR O PROXIMO
		             // Criando objeto
		             Time time = new Time();
		             time.setCod(rs.getInt("cod"));
		             time.setNome(rs.getString("nome"));
		             time.setDatafundacao(rs.getString("data_fundacao"));           
		             // Adiciona o objeto a lista
		             times.add(time);
		         }
		         rs.close();
		         conn.close();
		         return times;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
