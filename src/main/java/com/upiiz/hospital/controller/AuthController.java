package com.upiiz.hospital.controller;

import com.upiiz.hospital.entities.MedicosEntity;
import com.upiiz.hospital.entities.PacientesEntity;
import com.upiiz.hospital.services.EmailService;
import com.upiiz.hospital.services.MedicoService;
import com.upiiz.hospital.services.PacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private MedicoService medicoService; // Necesitas inyectar estos
    @Autowired
    private PacientesService pacientesService;
    //De las plantillas busacar la carpeta css,js y plugins
//http://localhost:8080/auth/login
// http://localhost:8080/auth/register

    @GetMapping("/login")
    public String login() {
        return "login";

    }

   @PostMapping("/login")
   public String processlogin(@RequestParam String username,
                       @RequestParam String password,
                       @RequestParam String rol,
                              HttpSession session,
                              RedirectAttributes redirectAttributes) {
       boolean encontrado = false;
//
//
//       System.out.println("Intento de login: " + username + " como " + rol);

//       session.setAttribute("usuarioLogueado", username); // ← agrega esto
//       session.setAttribute("rolUsuario", rol);

       // Si es doctor lo mandas al dashboard principal
//       if ("DOCTOR".equals(rol)) {
//           return "redirect:/dashboard";
//       } else {
//           // Si es paciente, lo mandas a su lista de consultas
//           return "redirect:/pacientes";
//       }

       if ("DOCTOR".equals(rol)) {
           List<MedicosEntity> medicos = medicoService.listarMedicos();
           encontrado = medicos.stream()
                   .anyMatch(m -> m.getNombre().equalsIgnoreCase(username)
                           || m.getMatricula().equalsIgnoreCase(username));
       } else {
           List<PacientesEntity> pacientes = pacientesService.listarPacientes();
           encontrado = pacientes.stream()
                   .anyMatch(p -> p.getNombre().equalsIgnoreCase(username)
                           || p.getDni().equalsIgnoreCase(username));
       }

       if (!encontrado) {
           redirectAttributes.addFlashAttribute("error", "Usuario o contraseña incorrectos");
           return "redirect:/auth/login";
       }
       session.setAttribute("usuarioLogueado", username);
       session.setAttribute("rolUsuario", rol);

       return "DOCTOR".equals(rol) ? "redirect:/dashboard" : "redirect:/pacientes";
   }
    @GetMapping("/register")
    public String register() {
        return "register";
    }
@PostMapping("/register")
    public String processregister(@RequestParam String nombre,
                           @RequestParam String email,
                           @RequestParam String rol,
                           @RequestParam String password,
                           @RequestParam(required = false) String cpassword){

//    System.out.println("Nuevo registro: " + nombre + " con rol " + rol);
        if ("DOCTOR".equals(rol)) {
            MedicosEntity nuevoMedico = new MedicosEntity();
            nuevoMedico.setNombre(nombre);
            nuevoMedico.setEspecialidad("General");        // ← valor por defecto
            nuevoMedico.setMatricula(email);
//            nuevoMedico.setMatricula(email); // Usamos el email como matrícula temporal
            medicoService.guardarMedico(nuevoMedico);
        } else {
            PacientesEntity nuevoPaciente = new PacientesEntity();
            nuevoPaciente.setNombre(nombre);
            nuevoPaciente.setDni(email);
            nuevoPaciente.setFecha(java.time.LocalDate.of(2000, 1, 1));
            pacientesService.guardarPacientes(nuevoPaciente);
        }
    // Después de registrar, lo mandamos al login para que entre
    return "redirect:/auth/login";
}

    @GetMapping("/forgot")
    public String forgot(){

        return "forgot-password";
    }

//    @PostMapping("/forgot")
//    public String processForgot(@RequestParam String email,
//                                RedirectAttributes redirectAttributes) {
//        // Buscar si existe como médico o paciente
//        boolean existe = medicoService.listarMedicos().stream()
//                .anyMatch(m -> m.getMatricula().equalsIgnoreCase(email))
//                || pacientesService.listarPacientes().stream()
//                .anyMatch(p -> p.getDni().equalsIgnoreCase(email));
//
//        if (existe) {
//            redirectAttributes.addFlashAttribute("success",
//                    "Si tu cuenta existe, recibirás instrucciones en breve. Intenta iniciar sesión.");
//        } else {
//            redirectAttributes.addFlashAttribute("error",
//                    "No encontramos una cuenta con ese correo.");
//        }
//        return "redirect:/auth/forgot";
//    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // destruye toda la sesión
        return "redirect:/auth/login";
    }



    @PostMapping("/forgot")
    public String processForgot(@RequestParam String email,
                                RedirectAttributes redirectAttributes) {
        boolean existe = medicoService.listarMedicos().stream()
                .anyMatch(m -> m.getMatricula().equalsIgnoreCase(email))
                || pacientesService.listarPacientes().stream()
                .anyMatch(p -> p.getDni().equalsIgnoreCase(email));

        if (existe) {
            try {
                emailService.enviarCorreo(
                        email,
                        "Recuperación de contraseña - Hospital UPIIZ",
                        "Hola,\n\nRecibimos una solicitud para recuperar tu contraseña.\n" +
                                "Tu usuario registrado es: " + email + "\n\n" +
                                "Si no solicitaste esto, ignora este mensaje.\n\n" +
                                "— Hospital UPIIZ"
                );
                redirectAttributes.addFlashAttribute("success",
                        "Te enviamos un correo con instrucciones. Revisa tu bandeja.");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("error",
                        "Error al enviar el correo. Intenta más tarde.");
            }
        } else {
            redirectAttributes.addFlashAttribute("error",
                    "No encontramos una cuenta con ese correo.");
        }
        return "redirect:/auth/forgot";
    }


}
