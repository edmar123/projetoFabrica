/**
 * 
 */
package br.com.iesp.ipc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.iesp.ipc.models.Usuario;
import br.com.iesp.ipc.services.UsuarioService;

/**
 * @author Cayo Hollanda (http://www.github.com/cayohollanda)
 *
 * @project desenvolvimento
 */

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	private final String CADASTRO_USUARIOS = "cadastro/usuarios";
	private final String LISTA_USUARIOS = "paginas/usuarios/lista";
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/cadastro")
	public ModelAndView enviarParaTelaDeCadastro(Usuario usuario) {
		ModelAndView mv = new ModelAndView(CADASTRO_USUARIOS);
		
		mv.addObject("usuario", usuario);
		
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Usuario usuario) {
		ModelAndView mv = new ModelAndView(LISTA_USUARIOS);
	
		this.usuarioService.save(usuario);
		
		List<Usuario> listaUsuarios = usuarioService.findAll();
		
		mv.addObject("listaUsuarios", listaUsuarios);
		
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		return new ModelAndView(LISTA_USUARIOS).addObject("listaUsuarios", this.usuarioService.findAll());
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable Long id) {
		this.usuarioService.remove(id);
		
		return new ModelAndView(LISTA_USUARIOS).addObject("listaUsuarios", this.usuarioService.findAll());
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Usuario usuario = this.usuarioService.getOne(id);
		
		if(usuario != null) {
			return new ModelAndView(CADASTRO_USUARIOS).addObject("usuario", usuario);
		} else {
			return new ModelAndView(LISTA_USUARIOS).addObject("listaUsuarios", this.usuarioService.findAll());
		}
	}
	
}
