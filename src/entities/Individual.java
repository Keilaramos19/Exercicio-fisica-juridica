package entities;

public class Individual extends Contribuinte {
	private double despesasComSaude;

	public Individual(String nome, double rendaAnual,double despesasComSaude) {
		super(nome, rendaAnual);
		this.despesasComSaude = despesasComSaude;
	}

	public double getDespesasComSaude() {
		return despesasComSaude;
	}

	public void setDespesasComSaude(double despesasComSaude) {
		this.despesasComSaude = despesasComSaude;
	}

	@Override
	public double imposto() {
		if (getRendaAnual()<20000.0) {
			return getRendaAnual()*0.15-despesasComSaude*0.5 ;
		}
		else {
			return getRendaAnual()*0.25-despesasComSaude*0.5 ;
			
		}
	}
}
	
	

	
	


