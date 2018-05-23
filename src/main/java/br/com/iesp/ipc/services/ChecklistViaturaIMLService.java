package br.com.iesp.ipc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iesp.ipc.models.ChecklistViaturaIML;
import br.com.iesp.ipc.repositories.ChecklistViaturaIMLRepository;

@Service
public class ChecklistViaturaIMLService  {
	@Autowired
	private ChecklistViaturaIMLRepository repository;
	
	// Método editar e salvar utilizarao esse método
	public ChecklistViaturaIML save(ChecklistViaturaIML checklistViaturaIML) {
		return this.repository.save(checklistViaturaIML);
	}
	
	public List<ChecklistViaturaIML> findAll() {
		return this.repository.findAll();
	}
	
	public void remove(Long id) {
		this.repository.deleteById(id);
	}
	
	







	
}
