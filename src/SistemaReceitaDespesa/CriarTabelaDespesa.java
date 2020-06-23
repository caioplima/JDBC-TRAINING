package SistemaReceitaDespesa;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaDespesa {
	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexaoSistemaRD.getConexao();
		
		String sql = "CREATE TABLE Despesa ("
				+ "descricao VARCHAR(30) NOT NULL,"
				+ "valor int NOT NULL CONSTRAINT chk_valor CHECK (valor>0))";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela criada com Sucesso!");
		conexao.close();
	}
}
