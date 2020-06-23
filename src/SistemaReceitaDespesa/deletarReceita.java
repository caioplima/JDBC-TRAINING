package SistemaReceitaDespesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deletarReceita {
	public static void main(String[] args) throws SQLException {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe a descrição da Receita que deseja excluir: ");
		String desc = entrada.nextLine();

		Connection conexao = FabricaConexaoSistemaRD.getConexao();
		String sql = "DELETE FROM receita WHERE descricao = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, desc);

		int contador = stmt.executeUpdate();
		if (contador > 0) {
			System.out.println("Exclusão efetuada com sucesso!");
		} else {
			System.out.println("Nada feito!");
		}

		conexao.close();
		entrada.close();
	}
}
