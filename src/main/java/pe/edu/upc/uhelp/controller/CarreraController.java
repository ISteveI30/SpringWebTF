package pe.edu.upc.uhelp.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.uhelp.entities.Carrera;
import pe.edu.upc.uhelp.serviceinterface.ICarreraService;

public class CarreraController {
	@Autowired
	private ICarreraService carreraService;
	List<Carrera> lstCarreras;
	
	@GetMapping("/registro")
	public String newCarrera(Model model) {
		model.addAttribute("carrera",new Carrera());
		return "carrera/registroCarrera";
	}
	@PostMapping("/guardar")
	public String saveCarrera(@Valid Carrera carrera,BindingResult binRes,Model model) {
		if(binRes.hasErrors()) {
			return "carrera/registroCarrera";	
		}else {
			carreraService.insert(carrera);
			model.addAttribute("mensaje","Se registró de manera correcta!!");
			return "redirect:/carrera/registro";
		}		
	}
	@GetMapping("/listar")
	public String listCarrera(Model model) {
		try {
			model.addAttribute("lstcarreras",carreraService.list());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "carrera/listCarrera";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String deleteCarrera(@PathVariable("id")int id, Model model) {
		try {
			if(id>0) {
				carreraService.delete(id);
				model.addAttribute("lstcarreras",carreraService.list());
			}
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "redirect:/carreras/listar";
	}
	@PostMapping("/modificar")
	public String updateCarrera(Carrera carrera) {
			carreraService.update(carrera);
			return "redirect:/carreras/listar";
	}
}
