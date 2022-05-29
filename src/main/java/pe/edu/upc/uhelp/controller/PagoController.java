package pe.edu.upc.uhelp.controller;

import java.util.List;
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

import pe.edu.upc.uhelp.entities.Pago;
import pe.edu.upc.uhelp.serviceinterface.IPagoService;

@Controller
@RequestMapping("/pagos")
public class PagoController {
	
	@Autowired
	private IPagoService pagoService;
	List<Pago> lstPagos;
	
	@GetMapping("/registro")
	public String newPago(Model model) {
		model.addAttribute("pago",new Pago());
		return "pago/registroPago";
	}
	@PostMapping("/guardar")
	public String savePago(@Valid Pago pago,BindingResult binRes,Model model) {
		if(binRes.hasErrors()) {
			return "pago/registroPago";	
		}else {
			pagoService.insert(pago);
			model.addAttribute("mensaje","Se registró correctamente!!");
			return "redirect:/pagos/registro";
		}		
	}
	@GetMapping("/listar")
	public String listPago(Model model) {
		try {
			model.addAttribute("lstpagos",pagoService.list());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "pago/listPago";
	}
	@RequestMapping("/editar/{id}")
	public String UpdatePago(@PathVariable("id")int id, Model model) {
		try {
			Optional<Pago> pago=pagoService.findPago(id);
			model.addAttribute("pago",pago.get());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "pago/updatePago";
	}
	@RequestMapping("/eliminar/{id}")
	public String deletePago(@PathVariable("id")int id, Model model) {
		try {
			if(id>0) {
				pagoService.delete(id);
				model.addAttribute("lstpagos",pagoService.list());
			}
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "redirect:/pagos/listar";
	}
	@PostMapping("/modificar")
	public String updatePago(Pago pago) {
			pagoService.update(pago);
			return "redirect:/pagos/listar";
	}
}
