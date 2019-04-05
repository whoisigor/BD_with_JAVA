import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProvedorConexao {

	private static Connection conn = null;

	public static Connection getConnection() throws SQLException {
		if (conn == null || conn.isClosed()) {
			conn = criarNovaConexao();
		}
		return conn;
	}
	
	private static Connection criarNovaConexao(){
		//ConexaoPostgres
		//String driver = "org.postgresql.Driver";
        //String user = "postgres";
        //String senha = "";
        //String url = "jdbc:postgresql://localhost:5432/ifrn";
	
		String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String senha = "rootadmin";
		String url = "jdbc:mysql://localhost:3306/ifrn_db";
		
			
			try {
				Class.forName(driver);
				Connection conn = (Connection) DriverManager.getConnection(url, user, senha);
				return conn;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		
	}
	

}
