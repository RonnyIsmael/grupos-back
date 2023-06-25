package com.grupos.back.Security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.grupos.back.model.Usuario;


public class UserDetailsImpl implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Usuario usuario;

	public UserDetailsImpl(Usuario usuario2) {
		usuario = usuario2;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return Collections.emptyList();
	}

	@Override
	public String getPassword() {
		return usuario.getPassword();
	}

	@Override
	public String getUsername() {
		return usuario.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getNombre() {
		return usuario.getNombre();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	
}
