package br.com.salao.bellafashion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.salao.bellafashion.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	
     List<Pessoa> findAll();


	//@Query("select p from Pedido p join p.user u where u.username = :username")
	
	@Query(value = "select * "
			+ " from pessoa p "
			+ " inner join tipo_pessoa t on p.id = t.id "
			+ " where t.tipo_pessoa = 'FUNCIONARIO'",
			
			nativeQuery = true)
	List<Pessoa> findByPessoaAndFuncionario();

	

}
