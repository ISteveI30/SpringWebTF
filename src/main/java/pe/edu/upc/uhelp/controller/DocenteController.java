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

import pe.edu.upc.uhelp.entities.Docente;
import pe.edu.upc.uhelp.serviceinterface.IDocenteService;

@Controller
@RequestMapping("/docentes")
public class DocenteController {
	
	@Autowired
	private IDocenteService docService;

	@PostMapping("/guardar")
	public String saveDocente(@Valid Docente docente, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "docente/frmDocente";
		} else {
			docService.insert(docente);
			model.addAttribute("mensaje", "Se registró correctamente la modalidad!");
			model.addAttribute("lstdocentes", docService.list());
			return "redirect:/docentes/listar";		}
	}

	@GetMapping("/listar")
	public String listDocente(Model model) {
		try {
			model.addAttribute("docente",new Docente());
			model.addAttribute("lstdocentes", docService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/docente/frmDocente";
	}

	@RequestMapping("/editar/{id}")
	public String UpdateDocente(@PathVariable("id")int id, Model model) {
		try {
		Optional<Docente> docente=docService.findDocente(id);
		model.addAttribute("d", docente.get());
		} catch (Exception e) {
		model.addAttribute("error", e.getMessage());
		}
		return "docente/docenteUpdate";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String deleteDocente(@PathVariable("id") int id, Model model) {
		try {
			if (id > 0) {
				docService.delete(id);
				model.addAttribute("lstdocentes", docService.list());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "redirect:/docentes/listar";
	}
	
	@PostMapping("/modificar")
	public String updateDocente(Model model,Docente docente) {
		docService.update(docente);
		model.addAttribute("lstdocentes", docService.list());
		return "redirect:/docentes/listar";
	}
}
