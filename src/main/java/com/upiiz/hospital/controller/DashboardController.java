package com.upiiz.hospital.controller;
import com.upiiz.hospital.entities.MedicosEntity;
import com.upiiz.hospital.services.MedicoService;
import com.upiiz.hospital.entities.PacientesEntity;
import com.upiiz.hospital.services.PacientesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class DashboardController {

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PacientesService pacienteService;
    // Agrega HttpSession como parámetro del método:
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        model.addAttribute("totalMedicos", medicoService.listarMedicos().size());
        model.addAttribute("totalPacientes", pacienteService.listarPacientes().size());
        model.addAttribute("usuario", session.getAttribute("usuarioLogueado"));
        return "Estadisticas";
    }
}
