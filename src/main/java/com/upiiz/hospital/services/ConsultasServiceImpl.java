package com.upiiz.hospital.services;
import com.upiiz.hospital.entities.ConsultasEntity;
import com.upiiz.hospital.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ConsultasServiceImpl implements ConsultasService {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public List<ConsultasEntity> listarConsultas() {
        return consultaRepository.findAll();
    }

    @Override
    public ConsultasEntity guardarConsultas(ConsultasEntity consultas) {
        return consultaRepository.save(consultas);
    }

    @Override
    public ConsultasEntity obtenerConsultasPorId(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    @Override
    public ConsultasEntity actualizarConsulta(ConsultasEntity consultas) {
        return consultaRepository.save(consultas);
    }

    @Override
    public void eliminarConsulta(Long id) {
        consultaRepository.deleteById(id);
    }
}
