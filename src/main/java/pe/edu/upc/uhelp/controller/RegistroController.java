package pe.edu.upc.uhelp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.uhelp.entities.Academia;
import pe.edu.upc.uhelp.entities.Estudiante;
import pe.edu.upc.uhelp.entities.Rol;
import pe.edu.upc.uhelp.entities.Sede;
import pe.edu.upc.uhelp.entities.Users;
import pe.edu.upc.uhelp.serviceinterface.AcademiaService;
import pe.edu.upc.uhelp.serviceinterface.EstudianteService;
import pe.edu.upc.uhelp.serviceinterface.ISedeService;
import pe.edu.upc.uhelp.serviceinterface.UserService;
import pe.edu.upc.uhelp.util.RegistroAux;

@Controller
@RequestMapping("/registros")
public class RegistroController {

	@Autowired
	private ISedeService sedeService;
	@Autowired
	private EstudianteService estudianteService;
	@Autowired
	private AcademiaService academiaService;
	/*@Autowired
	private RolService rolService;*/
	@Autowired
	private UserService userService;

	BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	
	@GetMapping("/seleccion")
	public String seleccion() {
		
		return "registro/seleccion";
	}
	@GetMapping("/estudiante")
	public String registroEstudiante(Model model) {
		model.addAttribute("e",new RegistroAux());
		return "registro/registroEstudiante";
	}
	@GetMapping("/academia")
	public String registroAcademia(Model model) {
		model.addAttribute("a",new RegistroAux());
		model.addAttribute("lstSedes",sedeService.list());
		return "registro/registroAcademia";
	}
	public void comprobarClase(RegistroAux aux) {
		System.out.println("-------Datos del Objeto------");
		System.out.println("apellido: "+aux.getApellido());
		System.out.println("correo: "+aux.getCorreo());
		//System.out.println("nickname: "+aux.getNickname());
		System.out.println("nombre: "+aux.getNombre());
		System.out.println("password: "+aux.getPassword());
		System.out.println("rol: "+aux.getRol());
		System.out.println("telefono: "+aux.getTelefono());
		System.out.println("id Sede: "+aux.getSede());
	}
	@PostMapping("/registroE")
	public String SaveEstudiante(RegistroAux aux , Model model) {
		comprobarClase(aux);
		var estudiante=new Estudiante();
		//var rol=new Rol();
		var user=new Users();
		estudiante.setNombre(aux.getNombre());
		estudiante.setApellido(aux.getApellido());
		estudiante.setCorreo(aux.getCorreo());
		/*Estudiante estudianteSave=estudianteService.insert(estudiante);
		Optional<Estudiante> optional=estudianteService.findEstudiante(estudianteSave.getIdEstudiante());
		Estudiante estudianteUser =optional.get();*/
		user.setEstudiante(estudiante);
		user.setAcademia(null);
		user.setPassword(bcpe.encode(aux.getPassword()));
		user.setUsername(aux.getCorreo());
		//user.setNickname(aux.getNickname());
		user.addRol("ROLE_STUDENT");
		//rol.setUser(user);
		estudianteService.insert(estudiante);
		userService.insert(user);
		//rolService.insert(rol);
		for(Rol rol:user.getRoles() ) {			
			System.out.println("rol: "+rol.getRol());
		}

		return "redirect:/";
	}
	/*
	 * id
	 * nombre
	 * correo
	 * telefono
	 * sede idSede
	 * one to one user
	 * password
	 * nickname
	 * rol ROLE_USER
	 * "ROLE_ACADEMY"*/
	@PostMapping("/registroA")
	public String SaveAcademia(RegistroAux aux , Model model) {
		comprobarClase(aux);
		
		var academia=new Academia();
		//var rol=new Rol();
		var user=new Users();	
		academia.setNombre(aux.getNombre());
		academia.setTelefono(aux.getTelefono());		
		academia.setCorreo(aux.getCorreo());
		Optional<Sede> sede=sedeService.listId(aux.getSede());
		academia.setSede(sede.get());
		user.setAcademia(academia);
		user.setEstudiante(null);
		user.setPassword(bcpe.encode(aux.getPassword()));
		user.setUsername(aux.getCorreo());
	//	user.setNickname(aux.getNickname());
		user.addRol("ROLE_ACADEMY");
		//rol.setUser(user);
		academiaService.insert(academia);
		userService.insert(user);
		//rolService.insert(rol);
		//var rol=new Rol();
		//var user=new Users();
		System.out.println("rol: "+user.getRoles());
		
		return "redirect:/";
	}
}
