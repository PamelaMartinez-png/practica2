package com.upiiz.hospital.services;
import com.upiiz.hospital.entities.MedicosEntity;
import java.util.List;

public interface MedicoService {
    List<MedicosEntity> listarMedicos();
    MedicosEntity guardarMedico(MedicosEntity medico);
    MedicosEntity obtenerMedicoPorId(Long id);
    MedicosEntity actualizarMedico(MedicosEntity medico);
    void eliminarMedico(Long id);
}
