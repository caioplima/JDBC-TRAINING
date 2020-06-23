package SistemaReceitaDespesa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListarDespesa {
	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexaoSistemaRD.getConexao();
		String sql = "SELECT * FROM despesa";

		java.sql.Statement stmt = conexao.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);
		
		//System.out.println(resultado);

		List<ReceitaDespesa> despesa = new ArrayList<>();

		while (resultado.next()) {
			String descricao = resultado.getString("descricao");
			int valor = resultado.getInt("valor");
			
			
			System.out.println(descricao + " ===> " + valor);
			despesa.add(new ReceitaDespesa(descricao, valor));
		}

	
		stmt.close();
		conexao.close();
}
}
