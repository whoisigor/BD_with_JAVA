import java.util.List;

public interface AlunoDAO {
	
	public List<Aluno> listarTodosAlunos();
	public Aluno verAlunoPorMatricula(String matricula);
	public void salvarAluno(Aluno aluno);
	public void deletarAluno(Aluno aluno);
	public void atualizarAluno(Aluno aluno);

}


