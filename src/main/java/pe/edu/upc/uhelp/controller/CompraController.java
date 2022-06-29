package pe.edu.upc.uhelp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.uhelp.entities.Curso;
import pe.edu.upc.uhelp.entities.DetalleOrden;
import pe.edu.upc.uhelp.entities.Orden;
import pe.edu.upc.uhelp.serviceinterface.ICursoService;

@Controller
@RequestMapping("/compras")
@Secured("ROLE_STUDENT")
public class CompraController {

	@Autowired
	private ICursoService cursoService;

	List<DetalleOrden> listOrden = new ArrayList<DetalleOrden>();
	Orden orden = new Orden();

	// @Secured("ROLE_USER")
	@GetMapping("/detalle/{id}")
	public String newDetalle(@PathVariable("id") int id, Model model) {
		var curso = new Curso();
		Optional<Curso> objCurso = cursoService.findCurso(id);
		curso = objCurso.get();
		model.addAttribute("c", curso);
		return "compra/detalleProducto";
	}

	// @Secured("ROLE_USER")
	@PostMapping("/listado")
	public String newListado(@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "cantidad", required = false) Integer cantidad, Model model) {
		var detalleOrden = new DetalleOrden();
		var curso = new Curso();
		double total = 0;
		Optional<Curso> optional = cursoService.findCurso(id);
		System.out.println("Curso elegido " + optional.get());
		System.out.println("Cantidad comprada " + cantidad);
		curso=optional.get();
		detalleOrden.setCantidad(cantidad);
		detalleOrden.setNombre(curso.getNombre());
		detalleOrden.setPrecio(curso.getPrecio());
		detalleOrden.setTotal(curso.getPrecio()*cantidad);
		detalleOrden.setCurso(curso);
		listOrden.add(detalleOrden);
		total=listOrden.stream().mapToDouble(dt->dt.getTotal()).sum();
		orden.setTotal(total);
		model.addAttribute("listOrden",listOrden);
		model.addAttribute("orden",orden);
		return "compra/listado";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCurso(@PathVariable("id") int id, Model model) {
		List<DetalleOrden> listAux = new ArrayList<DetalleOrden>();
		for (DetalleOrden detalleOrden : listOrden) {
			if(detalleOrden.getCurso().getIdCurso()!=id){
				listAux.add(detalleOrden);
			}
		}
		listOrden=listAux;
		double total = 0;
		total=listOrden.stream().mapToDouble(dt->dt.getTotal()).sum();
		orden.setTotal(total);
		model.addAttribute("listOrden",listOrden);
		model.addAttribute("orden",orden);
		return "compra/listado";
	}
	
}
