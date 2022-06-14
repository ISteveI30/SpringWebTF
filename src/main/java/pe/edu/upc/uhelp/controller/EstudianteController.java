package pe.edu.upc.uhelp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.uhelp.entities.Curso;
import pe.edu.upc.uhelp.entities.Pago;
import pe.edu.upc.uhelp.serviceinterface.ICursoService;
import pe.edu.upc.uhelp.serviceinterface.IDocenteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	@Autowired
	private ICursoService cursoService;
	@Autowired
	private IDocenteService docService;
	
	@GetMapping("/cursoEstudiante")
	public String newCurso(Model model) {
		model.addAttribute("lstcursos",cursoService.list());
		return "curso/cursoEstudiante";
	}
	@GetMapping("/docenteEstudiante")
	public String newDocente(Model model) {
		model.addAttribute("lstdocente",docService.list());
		return "docente/docenteEstudiante";
	}
	@RequestMapping("/view/{id}")
	public String viewCurso(@PathVariable("id") int id, Model model) {
		try {
			Optional<Curso> curso = cursoService.findCurso(id);
			model.addAttribute("curso", curso.get());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "curso/detalleCurso";
	}
}
