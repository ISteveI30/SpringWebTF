package pe.edu.upc.uhelp.controller;

import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.uhelp.entities.Sede;
import pe.edu.upc.uhelp.serviceinterface.ISedeService;

@Controller
@RequestMapping("/sedes")
public class SedeController {

	@Autowired
	private ISedeService sedService;

	@GetMapping("/nuevo")
	public String newSede(Model model) {
		model.addAttribute("s", new Sede());
		return "sede/frmRegistroSede";
	}

	@PostMapping("/guardar")
	public String savePerson(@Valid Sede sed, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "sede/frmRegistroSede";
		} else {
			sedService.insert(sed);
			model.addAttribute("mensaje", "Se registro correctamente!!");
			model.addAttribute("listaSedes", sedService.list());
			return "redirect:/sedes/nuevo";
		}

	}
	
	@GetMapping("/listar")
	public String listSede(Model model) {
		try {
			model.addAttribute("listaSedes", sedService.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "/sede/frmListaSede";
	}
	
	@RequestMapping("/eliminar")
	public String deleteSede(Map<String, Object> model, @RequestParam (value="id")Integer id) {
		
		try {
			if (id!=null && id>0) {
				sedService.delete(id);//Elimina
				model.put("listaSedes", sedService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "/sede/frmListaSede";
	}
	
	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable("id") int id, Model model) {
		
		Optional<Sede>objSed=sedService.listId(id);
		model.addAttribute("sed",objSed.get());
		return "sede/frmActualizaSede";
	}
	
	@PostMapping("/modificar")
	public String updateSede(Sede se) {
		sedService.update(se);
		return"redirect:/sedes/listar";
	}
	
}
