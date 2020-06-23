package SistemaReceitaDespesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalSistemaRD {
	private static Scanner entrada;

	public static void main(String[] args) throws SQLException {
		System.out.println(" *** SISTEMA DE RECEITAS E DESPESAS ***");
		System.out.println();
		System.out.println("1- LISTAR RECEITAS E DESPESAS");
		System.out.println("2- LISTAR RECEITAS");
		System.out.println("3- LISTAR DESPESAS");
		System.out.println("4- INSERIR RECEITA");
		System.out.println("5- INSERIR DESPESA");
		System.out.println("6- DELETAR RECEITA");
		System.out.println("7- DELETAR DESPESA");
		System.out.println();
		entrada = new Scanner(System.in);
		System.out.println("SELECIONE UMA DAS OPÇÕES ACIMA: ");
		String num = entrada.nextLine();

		switch (num) {
		case "1": {
			System.out.println();
			System.out.println(" *** RECEITAS ***");
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

			System.out.println("----------------------------------------------------------");
			System.out.println(" *** DESPESAS *** ");
			String sqld = "SELECT * FROM despesa";

			java.sql.Statement stmt2 = conexao.createStatement();
			ResultSet resultado2 = stmt2.executeQuery(sqld);

			List<ReceitaDespesa> despesa = new ArrayList<>();

			while (resultado2.next()) {
				String descricao = resultado2.getString("descricao");
				int valor = resultado2.getInt("valor");
				despesa.add(new ReceitaDespesa(descricao, valor));
				System.out.println(descricao + " ===> " + valor);
			}

			
			stmt.close();
			stmt2.close();
			conexao.close();
			break;
		}

		case "2": {
			System.out.println(" *** RECEITAS *** ");
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

			break;
		}

		case "3": {
			System.out.println(" *** DESPESAS *** ");
			String sqld = "SELECT * FROM despesa";
			Connection conexao = FabricaConexaoSistemaRD.getConexao();

			java.sql.Statement stmt2 = conexao.createStatement();
			ResultSet resultado2 = stmt2.executeQuery(sqld);

			List<ReceitaDespesa> despesa = new ArrayList<>();

			while (resultado2.next()) {
				String descricao = resultado2.getString("descricao");
				int valor = resultado2.getInt("valor");
				despesa.add(new ReceitaDespesa(descricao, valor));
				System.out.println(descricao + " ===> " + valor);
			}

			
			stmt2.close();
			conexao.close();

			break;
		}

		case "4": {
			Scanner entrada2 = new Scanner(System.in);

			System.out.println("Informe a descrição da Receita: ");
			String descR = entrada2.nextLine();

			System.out.println("Informe o valor de: " + descR);
			int valorR = entrada2.nextInt();

			Connection conexao = FabricaConexaoSistemaRD.getConexao();
			String sql = "INSERT INTO receita (descricao, valor) VALUES (?, ?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, descR);
			stmt.setInt(2, valorR);
			stmt.execute();

			System.out.println("Descrição e valor de nova Receita inserido com sucesso!");
			entrada2.close();
			break;
		}

		case "5": {
			Scanner entrada3 = new Scanner(System.in);

			System.out.println("Informe a descrição da Despesa: ");
			String descD = entrada3.nextLine();

			System.out.println("Informe o valor de: " + descD);
			int valorD = entrada3.nextInt();

			Connection conexao = FabricaConexaoSistemaRD.getConexao();
			String sql = "INSERT INTO despesa (descricao, valor) VALUES (?, ?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, descD);
			stmt.setInt(2, valorD);
			stmt.execute();

			System.out.println("Descrição e valor de nova Despesa inserido com sucesso!");
			entrada3.close();

			break;
		}

		case "6": {
			Scanner entrada4 = new Scanner(System.in);
			System.out.println("Informe a descrição da Receita que deseja excluir: ");
			String desc = entrada4.nextLine();

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
			entrada4.close();

			break;
		}

		case "7": {
			Scanner entrada5 = new Scanner(System.in);
			System.out.println("Informe a descrição da Despesa que deseja excluir: ");
			String desc = entrada5.nextLine();

			Connection conexao = FabricaConexaoSistemaRD.getConexao();
			String sql = "DELETE FROM despesa WHERE descricao = ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, desc);

			int contador = stmt.executeUpdate();
			if (contador > 0) {
				System.out.println("Exclusão efetuada com sucesso!");
			} else {
				System.out.println("Nada feito!");
			}

			conexao.close();
			entrada5.close();

			break;
		}

		default: {
			System.out.println("*** OPÇÃO INVÁLIDA! ***");

		}
		}
	}
}
