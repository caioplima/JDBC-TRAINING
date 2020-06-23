package listaTelefonica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaTelefoneListaTelefonica {
	public static void main(String[] args) throws SQLException {

		Scanner entrada = new Scanner(System.in);

		Connection conexao = FabricaConexaoListaTelefonica.getConexao();
		String sql = "SELECT * FROM pessoas WHERE telefone LIKE ?";

		System.out.println("Informe o telefone que deseja buscar: ");
		String tel = entrada.nextLine();

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, "%" + tel + "%");
		ResultSet resultado = stmt.executeQuery();

		List<PessoaLista> pessoas = new ArrayList<>();
		int contador = 0;

		while (resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			String endereco = resultado.getString("endereco");
			String telefone = resultado.getString("telefone");
			pessoas.add(new PessoaLista(codigo, nome, endereco, telefone));
			contador++;
		}

		if (contador > 0) {
			for (PessoaLista p : pessoas) {
				System.out.println();
				System.out.println("C�digo: " + p.getCodigo());
				System.out.println("Nome: " + p.getNome());
				System.out.println("Endereco: " + p.getEndereco());
				System.out.println("Telefone: " + p.getTelefone());
				System.out.println("------------------------------------------------------------");
			}
			System.out.println();
			System.out.println(" *** CONSULTA ENCERRADA ***");
		} else {
			System.out.println();
			System.out.println("Telefone n�o encontrado!");
			System.out.println();
			System.out.println(" *** CONSULTA ENCERRADA ***");
		}

		entrada.close();
		stmt.close();
		conexao.close();
	}

}
