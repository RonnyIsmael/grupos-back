package com.grupos.back.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.grupos.back.model.Usuario;
import com.grupos.back.repository.UsuarioRepository;
@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email)
		.orElseThrow(()->new UsernameNotFoundException("El usuario con email "+ email + " no existe."));
		
		return new UserDetailsImpl(usuario);
	}
	
}
