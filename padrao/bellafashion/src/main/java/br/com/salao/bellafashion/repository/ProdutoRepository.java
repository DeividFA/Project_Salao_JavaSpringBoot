package br.com.salao.bellafashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.salao.bellafashion.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
