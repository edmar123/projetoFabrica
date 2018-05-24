package br.com.iesp.ipc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.iesp.ipc.models.Viatura;
import br.com.iesp.ipc.services.ViaturaService;

@Controller
public class ViaturaController {
	
	@Autowired
	private ViaturaService service;
	
	@GetMapping("listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("listaViatura");
		List<Viatura> viaturas = service.findAll();
		
		mv.addObject("viaturas", viaturas);
		
		return mv;
	}
	@GetMapping("adicionar")
	public ModelAndView adicionar(Viatura viatura) {
		ModelAndView mv = new ModelAndView("cadastrarViatura");
		mv.addObject("viatura", viatura);
		return mv;
	}
	
	@GetMapping("salvar")
	public ModelAndView salvar(Viatura viatura) {
		service.save(viatura);
		return listar();
	}
	
	
}
