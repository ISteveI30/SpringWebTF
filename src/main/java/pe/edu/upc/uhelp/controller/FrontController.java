package pe.edu.upc.uhelp.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.uhelp.entities.Users;

@Controller
@RequestMapping("/")
public class FrontController {

	@GetMapping({"/login", "/"})
	public String login(/*@RequestParam(value = "error", required = false) String error,*/
			/*@RequestParam(value = "logout", required = false) String logout, Model model,*/ Principal principal
			/*,RedirectAttributes flash*/,Users user) {
		if (principal != null) {
			System.out.println("Se logueo correctamente");
			System.out.println("Nombre: "+principal.getName());
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
	@GetMapping("/inicio")
	public String inicio() {
		return "/inicio";
	}
}
