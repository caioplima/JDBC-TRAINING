package listaTelefonica;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriandoTabelaPessoas_LF {
	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexaoListaTelefonica.getConexao();
		
		String sql = "CREATE TABLE pessoas ("
				+ "codigo SERIAL PRIMARY KEY,"
				+ "nome VARCHAR(80) NOT NULL,"
				+ "endereco VARCHAR(80) NOT NULL,"
				+ "telefone VARCHAR (12) NOT NULL)";
		 
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela criada com Sucesso!");
		conexao.close();
	}

}
