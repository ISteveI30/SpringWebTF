package pe.edu.upc.uhelp.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.uhelp.entities.Estudiante;
import pe.edu.upc.uhelp.serviceinterface.AcademiaService;
import pe.edu.upc.uhelp.serviceinterface.EstudianteService;

@Controller
@RequestMapping("/")
public class FrontController {

	@Autowired
	private EstudianteService studentService;
	@Autowired
	private AcademiaService academyService;

	@GetMapping({ "/login", "/" })
	public String login(/* @RequestParam(value = "error", required = false) String error, */
			/*
			 * @RequestParam(value = "logout", required = false) String logout, Model model,
			 */ Principal principal
	/* ,RedirectAttributes flash */
	/* @RequestParam String username,@RequestParam String password */) {
		if (principal != null) {
			System.out.println("Se logueo correctamente");
			System.out.println("Nombre: " + principal.getName());
			// System.out.println("Username: "+username);
			// System.out.println("Contraseña: "+password);
			// System.out.println("Id: "+principal.getClass());
			// System.out.println("Nombre del usuario:
			// "+user.getEstudiante().getNombre()+user.getEstudiante().getApellido());
			return "redirect:/inicio";
		}

		/*
		 * if (error != null) { model.addAttribute("error",
		 * "Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!"
		 * ); }
		 */
		/*
		 * if (logout != null) { model.addAttribute("success",
		 * "Ha cerrado sesión con éxito!"); }
		 */
		return "login";
	}

	@GetMapping("/perfil") // guardar el inicio y / para el login
	public String pefil(Principal principal, Model model, HttpSession session) {

		var aux = studentService.usuarioSession(principal.getName());
		Optional<Estudiante> obj = studentService.findEstudiante(aux.getStudent().getIdEstudiante());
		System.out.println("Datos del usuario");

		System.out.println("id: " + obj.get().getIdEstudiante());
		System.out.println("Nombre: " + aux.getNombre());
		System.out.println("apellido: " + aux.getApellido());
		System.out.println("correo: " + aux.getCorreo());

		session.setAttribute("idStudent", obj.get().getIdEstudiante());

		model.addAttribute("nombre", aux.getNombre());
		model.addAttribute("apellido", aux.getApellido());
		model.addAttribute("correo", aux.getCorreo());
		return "/perfil/perfil";
	}

	@GetMapping("/perfilAcademy") // guardar el inicio y / para el login
	public String pefilAcademia(Principal principal, Model model, HttpSession session) {
		var aux = academyService.usuarioSession(principal.getName());
		System.out.println("Datos del usuario");
		System.out.println("Nombre: " + aux.getNombre());
		System.out.println("Telefono: " + aux.getTelefono());
		System.out.println("correo: " + aux.getCorreo());
		System.out.println("Sedes: " + aux.getSedes());

		model.addAttribute("nombre", aux.getNombre());
		model.addAttribute("telefono", aux.getTelefono());
		model.addAttribute("correo", aux.getCorreo());
		model.addAttribute("sedes", aux.getSedes());
		return "/perfil/perfilAcademy";
	}

	@GetMapping("/inicio")
	public String inicio() {
		return "/inicio";
	}
}
