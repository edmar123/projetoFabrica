package br.com.iesp.ipc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.iesp.ipc.models.Viatura;
@Repository("viaturaRepository")
public interface ViaturaRepository extends JpaRepository<Viatura, Long> {
	Viatura findByPlaca(String placa);
}
