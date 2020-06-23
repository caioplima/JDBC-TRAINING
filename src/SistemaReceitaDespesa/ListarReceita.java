package SistemaReceitaDespesa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListarReceita {
	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexaoSistemaRD.getConexao();
		String sql = "SELECT * FROM receita";

		java.sql.Statement stmt = conexao.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);

		List<ReceitaDespesa> receita = new ArrayList<>();

		while (resultado.next()) {
			String descricao = resultado.getString("descricao");
			int valor = resultado.getInt("valor");
			receita.add(new ReceitaDespesa(descricao, valor));
		}

		for (ReceitaDespesa r : receita) {
			System.out.println(r.getDescricaoReceita() + " ===> " + r.getValorReceita());
		}

		stmt.close();
		conexao.close();
}
}