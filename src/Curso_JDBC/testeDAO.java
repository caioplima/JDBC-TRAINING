package Curso_JDBC;

public class testeDAO {
	public static void main(String[] args) {
		DAO dao = new DAO();
		String sql = "INSERT INTO pessoas (nome, codigo) VALUES (?,?)";
		System.out.println(dao.incluir(sql, "João da Silva", 1001));
		dao.close();
	}
}
