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
import pe.edu.upc.uhelp.serviceinterface.EstudianteService;

@Controller
@RequestMapping("/")
public class FrontController {

	@Autowired
	private EstudianteService studentService;
	
	@GetMapping({"/login", "/"})
	public String login(/*@RequestParam(value = "error", required = false) String error,*/
			/*@RequestParam(value = "logout", required = false) String logout, Model model,*/ Principal principal
			/*,RedirectAttributes flash*/,HttpSession session
			/*@RequestParam String username,@RequestParam String password*/) {
		if (principal != null) {
			System.out.println("Se logueo correctamente");
			System.out.println("Nombre: "+principal.getName());
			//System.out.println("Username: "+username);
			//System.out.println("Contraseña: "+password);
			
			var aux = studentService.usuarioSession(principal.getName());
			Optional<Estudiante> obj = studentService.findEstudiante(aux.getStudent().getIdEstudiante());
			System.out.println("Datos del usuario");
			
			System.out.println("id: " + obj.get().getIdEstudiante());
			System.out.println("Nombre: " + aux.getNombre());
			System.out.println("apellido: " + aux.getApellido());
			System.out.println("correo: " + aux.getCorreo());
			
			session.setAttribute("idStudent", obj.get().getIdEstudiante());
			//System.out.println("Id: "+principal.getClass());
			//System.out.println("Nombre del usuario: "+user.getEstudiante().getNombre()+user.getEstudiante().getApellido());
			return "redirect:/inicio";
		}

	/*	if (error != null) {
			model.addAttribute("error",
					"Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
		}
*/
	/*	if (logout != null) {
			model.addAttribute("success", "Ha cerrado sesión con éxito!");
		}*/
		return "login";
	}
	
	@GetMapping("/perfil") // guardar el inicio y / para el login
	public String pefil(Principal principal, Model model) {
		var aux = studentService.usuarioSession(principal.getName());
		System.out.println("Datos del usuario");
		System.out.println("Nombre: " + aux.getNombre());
		System.out.println("apellido: " + aux.getApellido());
		System.out.println("password: " + aux.getPassword());
		System.out.println("correo: " + aux.getCorreo());
		model.addAttribute("nombre", aux.getNombre());
		model.addAttribute("apellido", aux.getApellido());
		model.addAttribute("correo", aux.getCorreo());
		return "/perfil/perfil";
	}
	
	@GetMapping("/inicio")
	public String inicio() {
		return "/inicio";
	}
}
