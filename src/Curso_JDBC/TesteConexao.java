package Curso_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
	public static void main(String[] args) throws SQLException {
		
		//Com o throws, se acontecer alguma exce��o a conex�o � abortada.
		final String url = "jdbc:postgresql://localhost:5432/";
		final String usuario = "postgres";
		final String senha = "250888";
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		
		System.out.println("Conex�o efetuada com sucesso!");
		conexao.close();
		
		
	}
}
