package com.upiiz.hospital.repositories;

import com.upiiz.hospital.entities.MedicosEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
@Repository
    public interface MedicoRepository extends ListCrudRepository<MedicosEntity, Long> {
    }



