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
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "SELECT * FROM time WHERE cod=" + codigo;
				preparedStatement = conn.prepareStatement(selectTableSQL);
				ResultSet rs = preparedStatement.executeQuery();
				if (rs != null && rs.next()) {
		             Time time = new Time(rs.getInt("cod"),rs.getString("nome"),rs.getString("data_fundacao"));
		             rs.close();
			         conn.close();
			         return time;
		         }
				rs.close();
		        conn.close();
				return null;         
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "DELETE FROM time WHERE cod=" + time.getCod();
				preparedStatement = conn.prepareStatement(selectTableSQL);
				preparedStatement.executeUpdate();
			    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizarTime(Time time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Time> verTimesVencedores() {
		List<Time> vencedores = new ArrayList<Time>();
		Time vencedor;
		int timeA, timeB;
		String resultado;
		String[] extrairResultado = new String[2];
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "SELECT * FROM jogo";
				preparedStatement = conn.prepareStatement(selectTableSQL);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) { // ENQUANTO EXISTIR O PROXIMO
		             Jogo jogo = new Jogo(rs.getInt("cod"),rs.getInt("timea_cod"),rs.getInt("timeb_cod"),rs.getString("resultado"));
		             extrairResultado = rs.getString("resultado").split("x");
		             timeA = Integer.parseInt(extrairResultado[0]);
		             timeB = Integer.parseInt(extrairResultado[1]);
		             if(timeA >= timeB) { /* Caso: A == B o time A é considerado vencedor do JOGO*/
		            	 selectTableSQL = "SELECT * FROM time where cod=" + rs.getInt("timea_cod");
		             }else {
		            	 selectTableSQL = "SELECT * FROM time where cod=" + rs.getInt("timeb_cod");
		             }
	            	 preparedStatement = conn.prepareStatement(selectTableSQL);
	 				 ResultSet win = preparedStatement.executeQuery();
	 				if(win != null & win.next()) {
	 					if(timeA > timeB){
	 						vencedor = new Time(win.getInt("cod"),win.getString("nome"),win.getString("data_fundacao"));
	 						vencedores.add(vencedor);
			 			}else {
			 				vencedor = new Time(win.getInt("cod"),win.getString("nome"),win.getString("data_fundacao"));
	 						vencedores.add(vencedor);
			 			}
	 				} 
				}
		         rs.close();
		         conn.close();
		         return vencedores;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
