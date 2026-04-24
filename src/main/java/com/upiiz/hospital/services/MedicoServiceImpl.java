package com.upiiz.hospital.services;
import com.upiiz.hospital.entities.MedicosEntity;
import com.upiiz.hospital.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MedicoServiceImpl implements MedicoService{
    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public List<MedicosEntity> listarMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public MedicosEntity guardarMedico(MedicosEntity medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public MedicosEntity obtenerMedicoPorId(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public MedicosEntity actualizarMedico(MedicosEntity medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public void eliminarMedico(Long id) {
        medicoRepository.deleteById(id);
    }
}
