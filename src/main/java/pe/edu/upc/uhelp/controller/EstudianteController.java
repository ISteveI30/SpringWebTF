package pe.edu.upc.uhelp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.uhelp.entities.Curso;
import pe.edu.upc.uhelp.entities.Docente;
import pe.edu.upc.uhelp.entities.FavoritoCurso;
import pe.edu.upc.uhelp.entities.FavoritoDocente;
import pe.edu.upc.uhelp.serviceinterface.ICursoService;
import pe.edu.upc.uhelp.serviceinterface.IDocenteService;
import pe.edu.upc.uhelp.serviceinterface.IFavoritoCursoService;
import pe.edu.upc.uhelp.serviceinterface.IFavoritoDocenteService;
import pe.edu.upc.uhelp.serviceinterface.IPromocionService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	@Autowired
	private ICursoService cursoService;
	@Autowired
	private IDocenteService docService;
	@Autowired
	private IFavoritoCursoService favCurService;
	@Autowired
	private IFavoritoDocenteService favDocService;
	@Autowired
	private IPromocionService promService;

	@GetMapping("/cursoEstudiante")
	public String newCurso(Model model) {
		// model.addAttribute("curso",new FavoritoCurso());
		model.addAttribute("lstcursos", cursoService.list());
		return "curso/cursoEstudiante";
	}

	@GetMapping("/docenteEstudiante")
	public String newDocente(Model model) {
		model.addAttribute("lstdocente", docService.list());
		return "docente/docenteEstudiante";
	}

	@RequestMapping("/agregarC/{id}")
	public String saveCurso(@PathVariable("id") int id, Model model) {

		Optional<Curso> c = cursoService.findCurso(id);
		System.out.println("Curso elegido: " + c);
		var f = new FavoritoCurso();
		f.setCurso(c.get());
		favCurService.insert(f);
		//model.addAttribute("mensaje", "Se registró de manera correcta!!");
		//model.addAttribute("lstcursos", favCurService.list());
		return "redirect:/estudiantes/favorito";

	}

	@RequestMapping("/agregarD/{id}")
	public String saveDocente(@PathVariable("id") int id, Model model) {
		try {
			Optional<Docente> d = docService.findDocente(id);
			System.out.println("Docente elegido: " + d.get());
			var f = new FavoritoDocente();
			f.setDocente(d.get());
			favDocService.insert(f);
			//model.addAttribute("lista", favDocService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			System.out.println("Error al listar");
		}
		return "redirect:/estudiantes/favorito";

	}

	@GetMapping("/promocionEstudiante")
	public String newPromociones(Model model) {
		model.addAttribute("lstpromocion", promService.list());
		return "promocion/promocionEstudiante";
	}

	@GetMapping("/favorito")
	public String favorito(Model model) {
		model.addAttribute("lstcursos", favCurService.list());
		model.addAttribute("lista",favDocService.list());
		return "favorito/favorito";
	}
	
	/*
	 * @RequestMapping("/view/{id}") public String viewCurso(@PathVariable("id") int
	 * id, Model model) { try { Optional<Curso> curso = cursoService.findCurso(id);
	 * //Curso curso1=curso.get(); FavoritoCurso favorito =new
	 * FavoritoCurso(curso.get()); favCurService.insert(favorito);
	 * model.addAttribute("lstcursos", favCurService.list()); } catch (Exception e)
	 * { model.addAttribute("error", e.getMessage()); } return "curso/detalleCurso";
	 * }
	 */
}
