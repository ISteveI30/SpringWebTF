package pe.edu.upc.uhelp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.uhelp.serviceinterface.ICarreraService;
import pe.edu.upc.uhelp.serviceinterface.IDocenteService;
import pe.edu.upc.uhelp.serviceinterface.IOrdenService;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

	@Autowired
	private ICarreraService carService;
	
	@Autowired
	private IOrdenService ordenService;
	
	@Autowired
	private IDocenteService docService;
	
	@RequestMapping("/reporte1")
	public String reporteAlex(Map<String,Object> model) {
		model.put("list", carService.QueryAlex() );
		return "reporte/Alex";
	}
	@RequestMapping("/reporte2")
	public String reporteJhon(Map<String,Object> model) {
		model.put("list", ordenService.QueryJhon());
		return "reporte/Jhon";
	}
	@RequestMapping("/reporte3")
	public String reporteLuis(Map<String,Object> model) {
		model.put("list", docService.QueryLuis());
		return "reporte/Luis";
	}
	@RequestMapping("/reporte4")
	public String Montototal(Map<String,Object> model) {
		model.put("list", ordenService.QueryMontototal());
		return "reporte/Steve";
	}
}
