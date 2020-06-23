package SistemaReceitaDespesa;

public class ReceitaDespesa {
	private String descricaoReceita;
	private int valorReceita;
	
	private String descricaoDespesa;
	private int valorDespesa;
	
	public ReceitaDespesa(String descricaoReceita, int valorReceita) {
		super();
		this.descricaoReceita = descricaoReceita;
		this.valorReceita = valorReceita;
	}

	public String getDescricaoReceita() {
		return descricaoReceita;
	}

	public void setDescricaoReceita(String descricaoReceita) {
		this.descricaoReceita = descricaoReceita;
	}

	public int getValorReceita() {
		return valorReceita;
	}

	public void setValorReceita(int valorReceita) {
		this.valorReceita = valorReceita;
	}

	public String getDescricaoDespesa() {
		return descricaoDespesa;
	}

	public void setDescricaoDespesa(String descricaoDespesa) {
		this.descricaoDespesa = descricaoDespesa;
	}

	public int getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(int valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

		
	
}