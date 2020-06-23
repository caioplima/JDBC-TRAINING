package listaTelefonica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CriandoNovaPessoa_LF {
	public static void main(String[] args) throws SQLException {
		
	Scanner entrada = new Scanner(System.in);
	
	System.out.println("Informe o nome: ");
	String nome = entrada.nextLine();
	System.out.println("Informe o endereço: ");
	String end = entrada.nextLine();
	System.out.println("Informe o telefone: ");
	String tel = entrada.nextLine();
	
	Connection conexao = FabricaConexaoListaTelefonica.getConexao();
	String sql = "INSERT INTO pessoas (nome,endereco,telefone) VALUES (?,?,?)";
	PreparedStatement stmt = conexao.prepareStatement(sql);
	stmt.setString(1, nome);
	stmt.setString(2, end);
	stmt.setString(3, tel);
	stmt.execute();
	
    System.out.println("Pessoa incuída com Sucesso!");
	entrada.close();
	}
}
