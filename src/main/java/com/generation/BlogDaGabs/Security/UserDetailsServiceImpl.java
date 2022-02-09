package com.generation.BlogDaGabs.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.BlogDaGabs.Model.Usuario;
import com.generation.BlogDaGabs.Repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private @Autowired 
	UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Usuario> optional = repository.findByUsuario(username);

		if (optional.isPresent()) {
			return new UserDetailsImpl (optional.get());
		} else {
			throw new UsernameNotFoundException("Usuario não existe");
		}
	}

}