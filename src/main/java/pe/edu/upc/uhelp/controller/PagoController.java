package pe.edu.upc.uhelp.controller;

import java.util.ArrayList;
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

import pe.edu.upc.uhelp.entities.Pago;
import pe.edu.upc.uhelp.serviceinterface.IPagoService;
import pe.edu.upc.uhelp.util.TipoPago;

@Controller
@RequestMapping("/pagos")
public class PagoController {

	@Autowired
	private IPagoService pagoService;
	List<Pago> lstPagos;

	/*DOCUMENTAR LOS CODIFICADO*/
	
	/*Esta clase sirve para cargar el select de Tipo pago*/
	public List<TipoPago> cargar() {
		List<TipoPago> lstPagos = new ArrayList<TipoPago>();
		/*la clase tipo pago es una auxiliar que no esta en la db
		 * tiene como parametro el tipo de pago en el constructor*/
		lstPagos.add(new TipoPago("YAPE"));
		lstPagos.add(new TipoPago("Tarjeta"));
		lstPagos.add(new TipoPago("Presencial"));
		return lstPagos;
	}
	
	public void comprobarClase(Pago pago) {
		System.out.println(pago.getIdPago());
		System.out.println(pago.getNombre());
		System.out.println(pago.getNumeroTarjeta());
		System.out.println(pago.getCodigoTarjeta());
		System.out.println(pago.getCodigoPresencial());
	}

	@GetMapping("/select")
	public String newPago(Model model) {
		model.addAttribute("tipos", cargar());
		model.addAttribute("obj", new TipoPago());
		return "pago/selectPago";
	}

	@PostMapping("/registro")
	public String tempPago(TipoPago pago, Model model) {
		System.out.println(pago.getTipo());
		model.addAttribute("tipoPago", pago);
		model.addAttribute("tipos", cargar());
		model.addAttribute("pago", new Pago(pago.getTipo()));
		return "pago/registroPago";
	}

	@PostMapping("/guardar")
	public String savePago(@Valid Pago pago,BindingResult binRes,Model model) {
		System.out.println("Tipo de pago: "+pago.getNombre());
		if(binRes.hasErrors()) {
			return "pago/registroPago";	
		}else {
			switch (pago.getNombre()) {
			case "YAPE": {
				
				}
			case "Tarjeta": {
				pago.setCodigoPresencial("0");
				comprobarClase(pago);
				pagoService.insert(pago);
				}
			case "Presencial": {
	
				}
			}	
			
			model.addAttribute("mensaje","Se registró correctamente!!");
			return "redirect:/pagos/select";
		}		
	}

	@GetMapping("/listar")
	public String listPago(Model model) {
		try {
			TipoPago pago = new TipoPago("YAPE");
			model.addAttribute("pago", pago);
			model.addAttribute("lstpagos", pagoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "pago/listPago";
	}

	@RequestMapping("/editar/{id}")
	public String UpdatePago(@PathVariable("id") int id, Model model) {
		try {
			Optional<Pago> pago = pagoService.findPago(id);
			model.addAttribute("pago", pago.get());
			model.addAttribute("tipos", cargar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "pago/updatePago";
	}

	@RequestMapping("/eliminar/{id}")
	public String deletePago(@PathVariable("id") int id, Model model) {
		try {
			if (id > 0) {
				pagoService.delete(id);
				model.addAttribute("lstpagos", pagoService.list());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "redirect:/pagos/listar";
	}

	@PostMapping("/modificar")
	public String updatePago(Pago pago) {
		pagoService.update(pago);
		return "redirect:/pagos/listar";
	}
}
