package com.upiiz.hospital.controller;
import com.upiiz.hospital.entities.MedicosEntity;
import com.upiiz.hospital.services.MedicoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/medicos")
public class MedicosController {
    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public String listar(Model model, HttpSession session) {
        model.addAttribute("medicos", medicoService.listarMedicos());
        model.addAttribute("usuario", session.getAttribute("usuarioLogueado"));
        return "MedicosListado";
    }
    @GetMapping("/nuevo")
    public String formularioRegistro(Model model, HttpSession session) {
        model.addAttribute("usuario", session.getAttribute("usuarioLogueado"));
        return "MedicosFormulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("medico") MedicosEntity medico) {
        medicoService.guardarMedico(medico);
        return "redirect:/medicos";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("medico", medicoService.obtenerMedicoPorId(id));
        return "MedicosFormulario";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        medicoService.eliminarMedico(id);
        return "redirect:/medicos";
    }
}
