package pe.edu.upc.uhelp.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.uhelp.entities.Curso;
import pe.edu.upc.uhelp.serviceinterface.ICarreraService;
import pe.edu.upc.uhelp.serviceinterface.ICursoService;
import pe.edu.upc.uhelp.serviceinterface.IModalidadService;

/*aquí se añade las direcciones y vistas de cada método*/
@Controller
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private ICursoService cursoService;
	@Autowired
	private ICarreraService carreraService;
	@Autowired
	private IModalidadService modalidadService;
	/*
	@GetMapping("/registro")
	public String newCurso(Model model) {
		model.addAttribute("curso",new Curso());
		model.addAttribute("lstcarreras",carreraService.list());
		model.addAttribute("lstmodalidades",modalidadService.list());
		return "curso/registroCurso";
	}*/
	@PostMapping("/guardar")
	public String saveCurso(@Valid Curso curso,BindingResult binRes,Model model) {
		if(binRes.hasErrors()) {
			return "curso/frmCurso";	
		}else {
			cursoService.insert(curso);
			model.addAttribute("mensaje","Se registró de manera correcta!!");
			model.addAttribute("lstcursos",cursoService.list());
			return "redirect:/cursos/listar";
		}		
	}
	@GetMapping("/listar")
	public String listCurso(Model model) {
		try {
			model.addAttribute("curso",new Curso());
			model.addAttribute("lstcursos",cursoService.list());
			model.addAttribute("lstcarreras",carreraService.list());
			model.addAttribute("lstmodalidades",modalidadService.list());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "curso/frmCurso";
	}
	@RequestMapping("/editar/{id}")
	public String editarCurso(@PathVariable("id")int id, Model model) {
		try {
		Optional<Curso> curso=cursoService.findCurso(id);
		model.addAttribute("c", curso.get());
		model.addAttribute("lstcarreras",carreraService.list());
		model.addAttribute("lstmodalidades",modalidadService.list());
		} catch (Exception e) {
		model.addAttribute("error", e.getMessage());
		}
		return "curso/updateCurso";
	}
	@RequestMapping("/eliminar/{id}")
	public String deleteCurso(@PathVariable("id")int id, Model model) {
		try {
			if(id>0) {
				cursoService.delete(id);
				model.addAttribute("lstcursos",cursoService.list());
			}
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "redirect:/cursos/listar";
	}
	@PostMapping("/modificar")
	public String updateCurso(Curso curso,Model model) {
		cursoService.update(curso);
		model.addAttribute("lstcursos",cursoService.list());
		model.addAttribute("lstcarreras",carreraService.list());
		model.addAttribute("lstmodalidades",modalidadService.list());
			return "redirect:/cursos/listar";
	}
	
}
