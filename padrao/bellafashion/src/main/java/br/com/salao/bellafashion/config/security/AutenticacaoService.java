package br.com.salao.bellafashion.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.salao.bellafashion.form.LoginForm;
import br.com.salao.bellafashion.model.Usuario;
import br.com.salao.bellafashion.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = repository.findByNome(username);
		
		if (usuario.isPresent()) {
		
		
		
			return usuario.get();
			
		}
		throw new UsernameNotFoundException("Dados inválidos!");
		
	}

}
