/**
 * 
 */
package br.com.iesp.ipc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iesp.ipc.models.Usuario;
import br.com.iesp.ipc.repositories.UsuarioRepository;

/**
 * @author Cayo Hollanda (http://www.github.com/cayohollanda)
 * @project desenvolvimento
 */

@Service("usuarioService")
public class UsuarioService implements Serializable {

	@Autowired
	private UsuarioRepository repository;
	
	// Método de editar também usará o de salvar.
	public Usuario save(Usuario usuario) {
		return this.repository.save(usuario);
	}
	
	public List<Usuario> findAll() {
		return this.repository.findAll();
	}
	
	public void remove(Long id) {
		this.repository.deleteById(id);
	}
	
	public Usuario getOne(Long id) {
		return this.repository.getOne(id);
	}
	
}
