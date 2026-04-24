package com.upiiz.hospital.services;
import com.upiiz.hospital.entities.PacientesEntity;
import com.upiiz.hospital.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PacientesServiceImpl implements PacientesService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<PacientesEntity> listarPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public PacientesEntity guardarPacientes(PacientesEntity pacientes) {
        return pacienteRepository.save(pacientes);
    }

    @Override
    public PacientesEntity obtenerPacientesPorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public PacientesEntity actualizarPacientes(PacientesEntity pacientes) {
        return pacienteRepository.save(pacientes);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
