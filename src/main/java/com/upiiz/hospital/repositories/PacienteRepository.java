package com.upiiz.hospital.repositories;

import com.upiiz.hospital.entities.PacientesEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends ListCrudRepository<PacientesEntity, Long> {
}



