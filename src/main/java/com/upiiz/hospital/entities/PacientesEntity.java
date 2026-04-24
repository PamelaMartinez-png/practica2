package com.upiiz.hospital.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;
@Table("pacientes")
public class PacientesEntity {

    @Id
    @Column("id_paciente")
    private Long id;

    private String nombre;
    private String dni;
    @Column("fecha_nacimiento")
    private LocalDate fecha;

    public PacientesEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public PacientesEntity(Long id, String nombre, String dni, LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.fecha = fecha;
    }
}



