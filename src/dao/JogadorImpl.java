package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import campeonato.Jogador;
import campeonato.Jogo;

public class JogadorImpl implements JogadorDAO {

	@Override
	public List<Jogador> listarTodosJogadores() {
		List<Jogador> jogadores = new ArrayList<Jogador>();
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "SELECT * FROM jogador";
				preparedStatement = conn.prepareStatement(selectTableSQL);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) { // ENQUANTO EXISTIR O PROXIMO
		             // Criação do objeto Jogador
		             Jogador jogador = new Jogador();
		             jogador.setCod(rs.getInt("cod"));
		             jogador.setTime_cod(rs.getInt("time_cod"));
		             jogador.setNome(rs.getString("nome"));
		             jogador.setIdade(rs.getInt("idade"));             
		             // Adiciona o objeto a lista
		             jogadores.add(jogador);
		         }
		         rs.close();
		         conn.close(); // FECHANDO A INSTANCIA DO BANCO
		         return jogadores;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Jogador verJogadorPorCodigo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarJogador(Jogador jogador) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO jogador VALUES (?,?,?,?)";
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setInt(1, jogador.getCod());
				preparedStatement.setString(2, jogador.getNome());
				preparedStatement.setInt(3, jogador.getIdade());
				preparedStatement.setInt(4, jogador.getTime_cod());
				int resultado = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deletarJogador(Jogador jogador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarJogador(Jogador jogador) {
		// TODO Auto-generated method stub
		
	}

}
