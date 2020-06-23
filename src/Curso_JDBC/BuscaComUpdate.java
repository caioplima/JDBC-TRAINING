package Curso_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BuscaComUpdate {
	public static void main(String[] args) throws SQLException {

		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe o código da pessoa: ");
		int cod = entrada.nextInt();

		String selectSQL = "Select codigo, nome FROM pessoas WHERE codigo = ?";
		String updateSQL = "UPDATE pessoas SET nome = ? WHERE codigo = ?";

		Connection conexao = FabricaConexao.getConexao();

		PreparedStatement stmt = conexao.prepareStatement(selectSQL);
		stmt.setInt(1, cod);
		ResultSet r = stmt.executeQuery();

		if (r.next()) {
			Pessoa p = new Pessoa(r.getInt(1), r.getString(2));

			System.out.println("O Nome atual é: " + p.getNome());
			entrada.nextLine();

			System.out.println("Informe o novo nome: ");
			String novoNome = entrada.nextLine();

			stmt.close();

			stmt = conexao.prepareStatement(updateSQL);
			stmt.setString(1, novoNome);
			stmt.setInt(2, cod);
			stmt.execute();

			System.out.println("Pessoa alterada com Sucesso!");

		} else {
			System.out.println("Pessoa não encontrada!");
		}
		conexao.close();
		entrada.close();
	}
}
