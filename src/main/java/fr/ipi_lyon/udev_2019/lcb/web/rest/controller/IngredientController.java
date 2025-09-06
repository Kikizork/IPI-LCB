package fr.ipi_lyon.udev_2019.lcb.web.rest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.Ingredient;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.repository.IngredientRepository;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	
	@RequestMapping("/all")
	@ResponseBody
	private List<Ingredient> SearchAll() {
		return (List<Ingredient>) ingredientRepository.findAll();
	}
	
	// retourne un ingredient correspondant au nom inputé en header
	@RequestMapping("/unique")
	@ResponseBody
	private Ingredient SearchOne(@RequestHeader("nomIngredient") String nomIngredient) {
		return ingredientRepository.findByAlimNom(nomIngredient);
	}
	
}


