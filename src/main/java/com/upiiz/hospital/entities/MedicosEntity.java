package com.upiiz.hospital.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("medicos")
    public class MedicosEntity {

        @Id
        @Column("id_medico")
        private Long id;

        private String nombre;
        private String especialidad;
        private String matricula;


        public MedicosEntity() {
        }

     public MedicosEntity(Long id, String nombre, String especialidad, String matricula) {
         this.id = id;
         this.nombre = nombre;
         this.especialidad = especialidad;
         this.matricula = matricula;
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

     public String getEspecialidad() {
         return especialidad;
     }

     public void setEspecialidad(String especialidad) {
         this.especialidad = especialidad;
     }

     public String getMatricula() {
         return matricula;
     }

     public void setMatricula(String matricula) {
         this.matricula = matricula;
     }
 }







