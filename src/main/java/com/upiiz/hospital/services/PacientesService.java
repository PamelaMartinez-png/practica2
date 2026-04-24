package com.upiiz.hospital.services;
import com.upiiz.hospital.entities.PacientesEntity;
import java.util.List;

public interface PacientesService {

    List<PacientesEntity> listarPacientes();
    PacientesEntity guardarPacientes(PacientesEntity pacientes);
    PacientesEntity obtenerPacientesPorId(Long id);
    PacientesEntity actualizarPacientes(PacientesEntity pacientes);
    void eliminarPaciente(Long id);
}
