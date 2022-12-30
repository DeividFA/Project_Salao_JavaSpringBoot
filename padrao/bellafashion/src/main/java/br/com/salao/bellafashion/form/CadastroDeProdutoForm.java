package br.com.salao.bellafashion.form;

import br.com.salao.bellafashion.Util.FuncoesUteis;
import br.com.salao.bellafashion.model.Produto;

public class CadastroDeProdutoForm {

	private Integer id;
	private String nomeProduto;
	private String valorProduto;
	private String porcentagemSalao;
	private String porcentagemPessoa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(String valorProduto) {
		this.valorProduto = valorProduto;
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

	public Produto toProduto() {

		Produto produto = new Produto();

		produto.setNomeProduto(getNomeProduto());

		produto.setValorProduto(Float.parseFloat(FuncoesUteis.trocaVirgulaPonto(getValorProduto())));
		produto.setPorcentagemPessoa(Float.parseFloat(FuncoesUteis.trocaVirgulaPonto(getPorcentagemPessoa())));
		produto.setPorcentagemSalao(100 - Float.parseFloat(FuncoesUteis.trocaVirgulaPonto(getPorcentagemPessoa())));

		return produto;
	}

}
