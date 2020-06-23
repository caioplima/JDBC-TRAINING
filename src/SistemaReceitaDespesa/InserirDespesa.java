package SistemaReceitaDespesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirDespesa {
	public static void main(String[] args) throws SQLException {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Informe a descrição da Receita: ");
		String descD = entrada.nextLine();

		System.out.println("Informe o valor de: " + descD);
		int valorD = entrada.nextInt();

		Connection conexao = FabricaConexaoSistemaRD.getConexao();
		String sql = "INSERT INTO despesa (descricao, valor) VALUES (?, ?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, descD);
		stmt.setInt(2, valorD);
		stmt.execute();

		System.out.println("Descrição e valor de nova Despesa inserido com sucesso!");
		entrada.close();
	}
}

