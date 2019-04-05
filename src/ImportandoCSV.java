import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.ReadOnlyFileSystemException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ImportandoCSV {

	public static void main(String[] args) {
		ImportandoCSV obj = new ImportandoCSV();
		try {
			obj.importarCSVParaBanco();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} 

	public void importarCSVParaBanco() throws ClassNotFoundException {

		AlunoDAO alunoDao = new AlunoImpl();

		String arquivoCSV = "alunos.txt";
		File file = null;
		String linha = "";
		String csvDivisor = ";";
		try {

			BufferedReader br = new BufferedReader(new FileReader(arquivoCSV));
			ArrayList<String> lines = new ArrayList<>();
			String line = null;
			Iterator it = lines.iterator();

			while ((line = br.readLine()) != null) {

				String[] dadosAluno = line.split(csvDivisor);
				Aluno a = new Aluno(dadosAluno[1], dadosAluno[2], dadosAluno[3]);
				alunoDao.salvarAluno(a);
				System.out.println("importanto aluno: " + a.toString());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
