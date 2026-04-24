package com.upiiz.hospital.controller;

import com.upiiz.hospital.entities.ConsultasEntity;
import com.upiiz.hospital.services.ConsultasService;
import com.upiiz.hospital.services.MedicoService;
import com.upiiz.hospital.services.PacientesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/consultas")
public class ConsultasController {

    @Autowired
    private ConsultasService consultasService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PacientesService pacientesService;

    // 1. Listado de Consultas
    @GetMapping
    public String listar(Model model, HttpSession session) {
        model.addAttribute("consultas", consultasService.listarConsultas());
        model.addAttribute("usuario", session.getAttribute("usuarioLogueado"));
        return "ConsultasListado";
    }

    // 2. Formulario para nueva consulta
    @GetMapping("/nuevo")
    public String formulario(Model model, HttpSession session) {
        model.addAttribute("consulta", new ConsultasEntity());
        model.addAttribute("medicos", medicoService.listarMedicos());
        model.addAttribute("pacientes", pacientesService.listarPacientes());
        model.addAttribute("usuario", session.getAttribute("usuarioLogueado"));
        return "ConsultasFormulario";
    }

    // 3. Guardar consulta
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("consulta") ConsultasEntity consulta) {
        consultasService.guardarConsultas(consulta);
        return "redirect:/consultas";
    }

    // 4. Editar consulta
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, HttpSession session) {
        model.addAttribute("consulta", consultasService.obtenerConsultasPorId(id));
        model.addAttribute("medicos", medicoService.listarMedicos());
        model.addAttribute("pacientes", pacientesService.listarPacientes());
        model.addAttribute("usuario", session.getAttribute("usuarioLogueado"));
        return "ConsultasFormulario";
    }

    // 5. Eliminar consulta
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        consultasService.eliminarConsulta(id);
        return "redirect:/consultas";
    }
}
