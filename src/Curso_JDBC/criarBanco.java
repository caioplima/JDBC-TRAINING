package Curso_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class criarBanco {
	public static void main(String[] args) throws SQLException {
		
		//Com o throws, se acontecer alguma exceção a conexão é abortada.
		final String url = "jdbc:postgresql://localhost:5432/";
		final String usuario = "postgres";
		final String senha = "250888";
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		
		Statement stmt = conexao.createStatement();
		stmt.execute("CREATE DATABASE ListaTelefonica");
		System.out.println("Banco criado com sucesso!");
		
		conexao.close();
	}
}
