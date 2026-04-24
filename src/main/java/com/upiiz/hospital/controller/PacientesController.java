package com.upiiz.hospital.controller;

import com.upiiz.hospital.entities.PacientesEntity;
import com.upiiz.hospital.services.PacientesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    private PacientesService pacientesService;

    @GetMapping
    public String listar(Model model, HttpSession session) {
        model.addAttribute("pacientes", pacientesService.listarPacientes()); // minúscula!
        model.addAttribute("usuario", session.getAttribute("usuarioLogueado"));
        return "PacientesListado";
    }
    @GetMapping("/nuevo")
    public String formularioRegistro(Model model) {
        model.addAttribute("paciente", new PacientesEntity());
        return "PacientesFormulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("paciente") PacientesEntity pacientes) {
        pacientesService.guardarPacientes(pacientes);
        return "redirect:/pacientes";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("paciente", pacientesService.obtenerPacientesPorId(id));
        return "PacientesFormulario";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        pacientesService.eliminarPaciente(id);
        return "redirect:/pacientes";
    }
}
