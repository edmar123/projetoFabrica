package br.com.iesp.ipc.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iesp.ipc.models.Usuario;
import br.com.iesp.ipc.services.UsuarioService;

@Repository
@Transactional
public class ImplUserDetailsService implements UserDetailsService{
	@Autowired
	private UsuarioService service;

	@Override
	public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
		
		Usuario usuario = service.FindByNome(nomeUsuario);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");	
		}
		
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}
	
	

}
