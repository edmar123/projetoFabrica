package br.com.iesp.ipc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.iesp.ipc.models.ChecklistViatura;
@Repository("checklistViaturaRepository")
public interface ChecklistViaturaRepository extends JpaRepository<ChecklistViatura, Long> {

}
