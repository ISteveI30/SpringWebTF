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

import pe.edu.upc.uhelp.entities.Promocion;
import pe.edu.upc.uhelp.serviceinterface.ICursoService;
import pe.edu.upc.uhelp.serviceinterface.IDocenteService;
import pe.edu.upc.uhelp.serviceinterface.IPromocionService;

@Controller
@RequestMapping("/promociones")
public class PromocionController {

	@Autowired
	private IPromocionService promService;
	@Autowired
	private IDocenteService docService;
	@Autowired
	private ICursoService cursoService;
	
	@PostMapping("/guardar")
	public String savePromocion(@Valid Promocion promocion,BindingResult binRes,Model model) {
		if(binRes.hasErrors()) {
			return "promocion/frmPromocion";	
		}else {
			System.out.println("dato guardado"+promocion.getTitulo());
			promService.insert(promocion);
			model.addAttribute("mensaje","Se registró de manera correcta!!");
			model.addAttribute("lstPromocion",promService.list());
			return "redirect:/promociones/listar";
		}		
	}
	@GetMapping("/listar")
	public String listPromocion(Model model) {
		try {
			model.addAttribute("promocion",new Promocion());
			model.addAttribute("lstdocentes",docService.list());
			model.addAttribute("lstcursos",cursoService.list());				
			model.addAttribute("lstPromocion",promService.list());
			/*if(docService.list().isEmpty()) {
				System.out.println("La lista esta vacia");
				for (Docente element : docService.list()) {
					
				}
			}*/
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "promocion/frmPromocion";
	}
	@RequestMapping("/editar/{id}")
	public String editarPromocion(@PathVariable("id")int id, Model model) {
		try {
		Optional<Promocion> promocion=promService.findPromocion(id);
		model.addAttribute("p", promocion.get());
		model.addAttribute("lstDocente",docService.list());
		model.addAttribute("lstCursos",cursoService.list());
		} catch (Exception e) {
		model.addAttribute("error", e.getMessage());
		}
		return "promocion/updatePromocion";
	}
	@RequestMapping("/eliminar/{id}")
	public String deletePromocion(@PathVariable("id")int id, Model model) {
		try {
			if(id>0) {
				promService.delete(id);
				model.addAttribute("lstPromocion",promService.list());
			}
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "redirect:/promociones/listar";
	}
	@PostMapping("/modificar")
	public String updatePromocion(Promocion promocion,Model model) {
		promService.update(promocion);
		model.addAttribute("lstDocente",docService.list());
		model.addAttribute("lstCursos",cursoService.list());
		model.addAttribute("lstPromocion",promService.list());
			return "redirect:/promociones/listar";
	}
	
}
