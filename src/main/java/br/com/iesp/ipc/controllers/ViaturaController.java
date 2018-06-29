package br.com.iesp.ipc.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.iesp.ipc.enums.TipoViaturaEnum;
import br.com.iesp.ipc.models.Viatura;
import br.com.iesp.ipc.services.ViaturaService;

@Controller
@RequestMapping("/viaturas")
public class ViaturaController {

	@Autowired
	private ViaturaService service;

	@GetMapping("listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("cadastro/Cadastro-de-Viaturas");
		Viatura viatura = new Viatura();
		
		List<Viatura> viaturas = service.findAll();
		
		mv.addObject("tipoViaturas", Arrays.asList(TipoViaturaEnum.values()));
		mv.addObject("viatura", viatura);
		mv.addObject("viaturas", viaturas);
		
		return mv;
	}

	@GetMapping("cadastro")
	public ModelAndView adicionar(Viatura viatura) {
		
		ModelAndView mv = new ModelAndView("cadastro/Cadastro-de-Viaturas");
		mv.addObject("viatura", viatura);
		mv.addObject("tipoViaturas", Arrays.asList(TipoViaturaEnum.values()));
		return mv;
	}

	@PostMapping("salvar")
	public ModelAndView salvar(@Valid Viatura viatura, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return adicionar(viatura);
		}
		
		service.save(viatura);
		
		attributes.addFlashAttribute("mensagem", "Viatura salva com sucesso");
		return listar();
	}

	@GetMapping("deletar/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		service.remove(id);
		return listar();
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
	
		Viatura viatura = this.service.findOne(id);
		return adicionar(viatura);
	
	}

}
