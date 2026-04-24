package com.upiiz.hospital.repositories;
import com.upiiz.hospital.entities.ConsultasEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ConsultaRepository extends ListCrudRepository<ConsultasEntity, Long> {
    }

