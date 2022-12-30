package br.com.salao.bellafashion.form;

import br.com.salao.bellafashion.Util.FuncoesUteis;
import br.com.salao.bellafashion.model.FormaPagamento;

public class CadastroDeFormaPagamentoForm {

	private Integer id;
	private String nomeFormaPagamento;
	private String abrevFormaPagamento;
	private String operadora;
	private String taxaFormaPagamento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFormaPagamento() {
		return nomeFormaPagamento;
	}

	public void setNomeFormaPagamento(String nomeFormaPagamento) {
		this.nomeFormaPagamento = nomeFormaPagamento;
	}

	public String getAbrevFormaPagamento() {
		return abrevFormaPagamento;
	}

	public void setAbrevFormaPagamento(String abrevFormaPagamento) {
		this.abrevFormaPagamento = abrevFormaPagamento;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getTaxaFormaPagamento() {
		return taxaFormaPagamento;
	}

	public void setTaxaFormaPagamento(String taxaFormaPagamento) {
		this.taxaFormaPagamento = taxaFormaPagamento;
	}

	public FormaPagamento toFormaPagamento() {

		FormaPagamento fpgto = new FormaPagamento();
		
		fpgto.setNomeFormaPagamento(nomeFormaPagamento);
		fpgto.setAbrevFormaPagamento(abrevFormaPagamento);
		fpgto.setOperadora(operadora);
		fpgto.setTaxaFormaPagamento(Float.parseFloat(FuncoesUteis.trocaVirgulaPonto(getTaxaFormaPagamento())));

		return fpgto;
	}

}
