package br.com.iesp.ipc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iesp.ipc.models.ChecklistViatura;
import br.com.iesp.ipc.repositories.ChecklistViaturaRepository;

@Service
public class ChecklistViaturaService  {
	@Autowired
	private ChecklistViaturaRepository repository;
	
	// Método editar e salvar utilizarao esse método
	public ChecklistViatura save(ChecklistViatura checklistViatura) {
		return this.repository.save(checklistViatura);
	}
	
	public List<ChecklistViatura> findAll() {
		return this.repository.findAll();
	}
	
	public void remove(Long id) {
		this.repository.deleteById(id);
	}
	
	







	
}
