/**
 * 
 */
package br.com.iesp.ipc.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import br.com.iesp.ipc.enums.TipoUsuarioEnum;
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

	private final String CADASTRO_USUARIOS = "cadastro/Cadastro-de-Usuarios";
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/cadastro")
	public ModelAndView enviarParaTelaDeCadastro(Usuario usuario) {
		ModelAndView mv = new ModelAndView(CADASTRO_USUARIOS);
		mv.addObject("usuario", usuario);
		mv.addObject("tipoUsuarios", Arrays.asList(TipoUsuarioEnum.values()));
		
		return mv;
	}
	
	@GetMapping("/alteracao")
	public ModelAndView enviarParaTelaDeAlteracao(Usuario usuario) {
		ModelAndView mv = new ModelAndView("cadastro/Editar-Usuarios");
		
		mv.addObject("usuario", usuario);
		mv.addObject("tipoUsuarios", Arrays.asList(TipoUsuarioEnum.values()));
		
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes msnSucesso) {
		ModelAndView mv = new ModelAndView("redirect:/usuarios/cadastro");
		if (result.hasErrors()) {
			return enviarParaTelaDeCadastro(usuario);
		}
		
		usuario.setSenhaUsuario(new BCryptPasswordEncoder().encode(usuario.getSenhaUsuario()));
		
		this.usuarioService.save(usuario);
		
		msnSucesso.addFlashAttribute("mensagem", "usuário salvo com sucesso");
		
		return listar();
	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView(CADASTRO_USUARIOS);
		Usuario usuario = new Usuario();
		List<Usuario> usuarios = this.usuarioService.findAll();
		
		mv.addObject("usuario", usuario);
		mv.addObject("tipoUsuarios", Arrays.asList(TipoUsuarioEnum.values()));
		mv.addObject("listaUsuarios", usuarios);
		return mv;
	}
	
	@GetMapping("excluir/{id}")
	public void excluir(@PathVariable Long id) {
		this.usuarioService.remove(id);
		
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		
		Usuario usuario = this.usuarioService.getOne(id);
		return enviarParaTelaDeAlteracao(usuario);
		
	}
	
	//Recupera usuario Logado
	@GetMapping("alterarSenha")
	public ModelAndView alterarSenha(Usuario usuario) {
		
		ModelAndView mv = new  ModelAndView("paginas/usuarios/alterar-Senha");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nomeUsuario = auth.getName();

		 usuario = usuarioService.FindByNome(nomeUsuario);
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	//salva alteracao de senha de usuario logado
	@PostMapping("salvarSenhaAlterada")
	public ModelAndView salvar(@Valid Usuario usuario, RedirectAttributes attributes) {
		ModelAndView mv = new  ModelAndView("paginas/usuarios/alterar-Senha");
		Usuario user = usuarioService.getOne(usuario.getId());
		
		if (BCrypt.checkpw(usuario.getSenhaUsuario(), user.getSenhaUsuario())) {
			if (!usuario.getNovaSenha().isEmpty() && !usuario.getConfirmaSenha().isEmpty()) {
				if (usuario.getNovaSenha().equals(usuario.getConfirmaSenha())) {
					usuario.setSenhaUsuario(usuario.getConfirmaSenha());
					usuario.setSenhaUsuario(new BCryptPasswordEncoder().encode(usuario.getSenhaUsuario()));
					//repository.save(usuario);
					usuarioService.updateSennha(usuario.getSenhaUsuario(), user.getId());
					attributes.addFlashAttribute("mensagem", "senha alterada com sucesso");
	
					return listar();
				}
			}

			
			attributes.addFlashAttribute("mensagem", "insira uma nova senha");

			return mv;
		}
		
		attributes.addFlashAttribute("mensagem", "senha incorreta");

		return mv;		
	}
	

	
	
	
}
