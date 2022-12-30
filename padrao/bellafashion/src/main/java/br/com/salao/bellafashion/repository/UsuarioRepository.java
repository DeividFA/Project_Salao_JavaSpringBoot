package br.com.salao.bellafashion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.salao.bellafashion.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByNome(String email);
	


}
