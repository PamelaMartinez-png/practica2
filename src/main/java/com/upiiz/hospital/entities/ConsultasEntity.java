package com.upiiz.hospital.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Table("consultas")
public class ConsultasEntity {

    @Id
    @Column("id_consulta")
    private Long id;

    @Column("id_medico")
    private Long idMedico;

    @Column("id_paciente")
    private Long idPaciente;

    @Column("fecha_consulta")
    private LocalDateTime fecha;

    private String diagnostico;


    public ConsultasEntity() {
    }

    public ConsultasEntity(Long id, Long idMedico, Long idPaciente, LocalDateTime fecha, String diagnostico) {
        this.id = id;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}




