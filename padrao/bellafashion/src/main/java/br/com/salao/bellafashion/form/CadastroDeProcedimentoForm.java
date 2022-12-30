package br.com.salao.bellafashion.form;

import br.com.salao.bellafashion.Util.FuncoesUteis;
import br.com.salao.bellafashion.model.Procedimento;

public class CadastroDeProcedimentoForm {

	private Integer id;
	private String nomeProcedimento;
	private String valorProcedimento;
	private String porcentagemSalao;
	private String porcentagemPessoa;

	public Integer getId() {
		System.out.println(id + "id proce");
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProcedimento() {
		return nomeProcedimento;
	}

	public void setNomeProcedimento(String nomeProcedimento) {
		this.nomeProcedimento = nomeProcedimento;
	}

	public String getValorProcedimento() {

		return valorProcedimento;
	}

	public void setValorProcedimento(String valorProcedimento) {
		this.valorProcedimento = valorProcedimento;
	}

	public String getPorcentagemSalao() {
		return porcentagemSalao;
	}

	public void setPorcentagemSalao(String porcentagemSalao) {
		this.porcentagemSalao = porcentagemSalao;
	}

	public String getPorcentagemPessoa() {
		return porcentagemPessoa;
	}

	public void setPorcentagemPessoa(String porcentagemPessoa) {
		this.porcentagemPessoa = porcentagemPessoa;
	}


	public Procedimento toProcedimento() {

		Procedimento procedimento = new Procedimento();

		procedimento.setNomeProcedimento(getNomeProcedimento());

		procedimento.setValorProcedimento(Float.parseFloat(FuncoesUteis.trocaVirgulaPonto(getValorProcedimento())));
		procedimento.setPorcentagemPessoa(Float.parseFloat(FuncoesUteis.trocaVirgulaPonto(getPorcentagemPessoa())));
		procedimento.setPorcentagemSalao(100 - Float.parseFloat(FuncoesUteis.trocaVirgulaPonto(getPorcentagemPessoa())));

		return procedimento;
	}


}
