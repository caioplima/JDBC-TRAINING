package SistemaReceitaDespesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirReceita {
public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe a descrição da Receita: ");
		String descR = entrada.nextLine();
		
		System.out.println("Informe o valor de: " + descR);
		int valorR = entrada.nextInt();
		
		
		Connection conexao = FabricaConexaoSistemaRD.getConexao();
		String sql = "INSERT INTO receita (descricao, valor) VALUES (?, ?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, descR);
		stmt.setInt(2, valorR);
		stmt.execute();
		
	    System.out.println("Descrição e valor de nova Receita inserido com sucesso!");
		entrada.close();
		
	}
}
