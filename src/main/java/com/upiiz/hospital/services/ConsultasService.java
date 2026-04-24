package com.upiiz.hospital.services;

import com.upiiz.hospital.entities.ConsultasEntity;

import java.util.List;

public interface ConsultasService {
    List<ConsultasEntity> listarConsultas();
    ConsultasEntity guardarConsultas(ConsultasEntity consultas);
    ConsultasEntity obtenerConsultasPorId(Long id);
    ConsultasEntity actualizarConsulta(ConsultasEntity consultas);
    void eliminarConsulta(Long id);
}
