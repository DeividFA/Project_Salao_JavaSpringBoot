package br.com.salao.bellafashion.model.padroes;

public enum EstadoCivil {

	SOLTEIRO("Solteiro(a)"), CASADO("Casado(a)"), DIVORCIADO("Divorciado(a)"), VIUVO("Viuvo(a)");

	private final String status;
	
	EstadoCivil(String status){
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

}
