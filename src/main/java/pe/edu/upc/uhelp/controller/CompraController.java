package pe.edu.upc.uhelp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.uhelp.entities.Curso;
import pe.edu.upc.uhelp.serviceinterface.ICursoService;

@Controller
@RequestMapping("/compras")
@Secured("ROLE_STUDENT")
public class CompraController {
	
	@Autowired
	private ICursoService cursoService;
	
	//@Secured("ROLE_USER")
	@GetMapping("/detalle/{id}")
	public String newDetalle(@PathVariable("id")int id, Model model) {
		var curso=new Curso();
		Optional<Curso> objCurso=cursoService.findCurso(id);
		curso=objCurso.get();
		model.addAttribute("c",curso);
		return "compra/detalleProducto";
	}
	//@Secured("ROLE_USER")
	@GetMapping("/listado")
	public String newListado(Model model) {
		//model.addAttribute("carrera",new Carrera());
		return "compra/listado";
	}
}
