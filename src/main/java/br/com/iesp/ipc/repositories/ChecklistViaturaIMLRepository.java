package br.com.iesp.ipc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.iesp.ipc.models.ChecklistViaturaIML;
@Repository("checklistViaturaIMLRepository")
public interface ChecklistViaturaIMLRepository extends JpaRepository<ChecklistViaturaIML, Long> {

}
