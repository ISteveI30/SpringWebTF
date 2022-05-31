package pe.edu.upc.uhelp.controller;

import java.util.List;
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

import pe.edu.upc.uhelp.entities.Modalidad;
import pe.edu.upc.uhelp.serviceinterface.IModalidadService;

@Controller
@RequestMapping("/modalidades")
public class ModalidadController {
	@Autowired
	private IModalidadService modService;
	List<Modalidad> lstModalidades;

	@GetMapping("/registro")
	public String newModalidad(Model model) {
		model.addAttribute("modalidad", new Modalidad());
		return "modalidad/registroModalidad";
	}

	@PostMapping("/guardar")
	public String saveModalidad(@Valid Modalidad modalidad, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "modalidad/registroModalidad";
		} else {
			modService.insert(modalidad);
			model.addAttribute("mensaje", "Se registró correctamente la modalidad!");
			return "redirect:/modalidades/registro";
		}
	}

	@GetMapping("/listar")
	public String listModalidad(Model model) {
		try {
			model.addAttribute("lstmodalidades", modService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/modalidad/listModalidad";
	}

	@RequestMapping("/editar/{id}")
	public String UpdateModalidad(@PathVariable("id")int id, Model model) {
		try {
		Optional<Modalidad> modalidad=modService.findModalidad(id);
		model.addAttribute("modalidad", modalidad.get());
		} catch (Exception e) {
		model.addAttribute("error", e.getMessage());
		}
		return "modalidad/updateModalidad";
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String deleteModalidad(@PathVariable("id") int id, Model model) {
		try {
			if (id > 0) {
				modService.delete(id);
				model.addAttribute("lstmodalidades", modService.list());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "redirect:/modalidades/listar";
	}
	@PostMapping("/modificar")
	public String updateModalidad(Modalidad modalidad) {
		modService.update(modalidad);
		return "redirect:/modalidades/listar";
	}
}
