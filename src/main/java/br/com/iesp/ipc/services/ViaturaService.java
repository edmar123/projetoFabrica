package br.com.iesp.ipc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iesp.ipc.models.Viatura;
import br.com.iesp.ipc.repositories.ViaturaRepository;
@Service
public class ViaturaService {
	@Autowired
	private ViaturaRepository repository;
	
	// Método editar  utilizara esse método
	public Viatura save(Viatura viatura) {
		return this.repository.save(viatura);
	}
	
	public List<Viatura> findAll() {
		return this.repository.findAll();
	}
	
	public void remove(Long id) {
		this.repository.deleteById(id);
	}
	
	public Viatura findOne(Long id) {
		return this.repository.getOne(id);
	}
	
	
	
	
}
