/**
 * 
 */
package br.com.iesp.ipc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iesp.ipc.models.Usuario;

/**
 * @author Cayo Hollanda (http://www.github.com/cayohollanda)
 * @project desenvolvimento
 * @author eddymar
 */

@Transactional(readOnly = false)
@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByNomeUsuario(String nome);
	
	Usuario findBySenhaUsuario(String senha);
	
	@Modifying
	@Query("update Usuario u set u.senhaUsuario = ?1 where u.id = ?2")
	void setFixedSenhaUsuarioFor(String  novaSenha, Long id);
}
