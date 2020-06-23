package javaString;

public class testeString {
	public static void main(String[] args) {
		String nome = "Caio";
		String sobreNome = "Lima";
		String completo = (nome + " " + sobreNome);
		
		System.out.println(completo);
		
		System.out.println("Char na Posi��o 5: " + completo.charAt(5));
		System.out.println("Quantidade de caracteres: " + completo.length());
		System.out.println("Sem trim: " + completo);
		System.out.println("Com trim: " + completo.trim() );
		System.out.println("Caracteres ficam min�sculos: " + completo.toLowerCase());
		System.out.println("Caracteres ficam mai�sculos: " + completo.toUpperCase());
		System.out.println("Cont�m o caractere M? " + completo.contains("m"));
		System.out.println("Cont�m o caractere F? " + completo.contains("f"));
		System.out.println("Substituir caracteres Lima por Pitombeira: " + completo.replace("Lima", "Pitombeira"));
		System.out.println("Se os caracteres s�o iguais (Caio Lima): " + completo.equals("Caio Lima"));
		System.out.println("Se os caracteres s�o iguais (Caio Z�): " + completo.equals("Caio Z�"));
		System.out.println("Se os caracteres s�o iguais ignorando tamanho do caractere (CAIO LIMA)" + completo.equalsIgnoreCase("CAIO LIMA"));
		System.out.println("Ler os caracteres da posi��o (0 at� 4): " + completo.substring(0,4));
		
		
		StringBuilder meuNome = new StringBuilder(nome); 
		String mensagem = String.format("O cliente %s tem sobrenome %s", meuNome, sobreNome);
		System.out.println(mensagem);
		System.out.println("Adicionar String: " + meuNome.append(" Pitombeira"));
		StringBuilder inverter = meuNome.reverse();
		System.out.println("Meu nome invertido: " + inverter);
		StringBuilder inserir = meuNome.insert(0, "#");
		System.out.println("Nome depois de inserir # com insert: " + inserir);
		
		String test = "Jo�o da Silva";
		char[] charArray = test.toCharArray();

		for (char c : charArray) { 
		    System.out.print("["+ c+ "]");
		}
		
		System.out.println();
		String texto = "banana,ma��,laranja";

		String frutas[] = texto.split(",");
		System.out.println(frutas[0]);
		System.out.println(frutas[1]); 
		System.out.println(frutas[2]); 
		
		System.out.println("Beach ".concat("Park"));
		
		String replace = "Substituir \" por \\";
				System.out.println(replace);
				replace = replace.replaceAll("[\"]", "\\\"");
				System.out.println(replace);
				replace = replace.replace("\"", "\\");
				System.out.println(replace);
						
		
	}

}
