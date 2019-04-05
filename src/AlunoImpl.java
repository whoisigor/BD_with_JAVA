import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AlunoImpl implements AlunoDAO{

	public List<Aluno> listarTodosAlunos(){
		return null;
	}
	public Aluno verAlunoPorMatricula(String matricula){
		return null;
	}
	public void salvarAluno(Aluno aluno){
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO aluno"
					+ "(matricula, nome, endereco) VALUES"
					+ "(?,?,?)";
				
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setString(1, aluno.getMatricula());
				preparedStatement.setString(2, aluno.getNome());
				preparedStatement.setString(3, aluno.getEndereco());
				int resultado = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void deletarAluno(Aluno aluno){}
	public void atualizarAluno(Aluno aluno){}

}
