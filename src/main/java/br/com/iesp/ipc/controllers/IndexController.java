package br.com.iesp.ipc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
	
	@GetMapping("/")
	public String telaInicial() {
		return "Tela-Principal";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login/tela-login";
	}

}
