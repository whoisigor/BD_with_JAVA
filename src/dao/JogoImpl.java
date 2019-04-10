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

public class JogoImpl implements JogoDAO {

	@Override
	public List<Jogo> listarTodosJogos() {
		List<Jogo> jogos = new ArrayList<Jogo>();
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "SELECT * FROM jogo";
				preparedStatement = conn.prepareStatement(selectTableSQL);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) { // ENQUANTO EXISTIR O PROXIMO
		             // Criando objeto
		             Jogo jogo = new Jogo();
		             jogo.setCod(rs.getInt("cod"));
		             jogo.setTimea_cod(rs.getInt("timea_cod"));
		             jogo.setTimeb_cod(rs.getInt("timeb_cod"));
		             jogo.setResultado(rs.getString("resultado"));		             
		             // Adiciona o objeto a lista
		             jogos.add(jogo);
		         }
		         rs.close();
		         conn.close();
		         return jogos;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Jogo verJogoPorCodigo(int codigo) {
		return null;
	}

	@Override
	public void salvarJogo(Jogo jogo) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO jogo VALUES (?,?,?,?)";
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setInt(1, jogo.getCod());
				preparedStatement.setInt(2, jogo.getTimea_cod());
				preparedStatement.setInt(3, jogo.getTimeb_cod());
				preparedStatement.setString(4, jogo.getResultado());
				int resultado = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deletarJogo(Jogo jogo) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String deleteRowSQL = "DELETE FROM jogo WHERE cod = " + jogo.getCod();
				preparedStatement = conn.prepareStatement(deleteRowSQL);
				int resultado = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizarJogo(Jogo jogo) {
		// TODO Auto-generated method stub
		
	}
	
}
