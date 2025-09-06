package fr.ipi_lyon.udev_2019.lcb.web.rest.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ipi_lyon.udev_2019.lcb.data.jpa.repository.ListeIngredientsRepository;

@Controller
@RequestMapping("/listeIngredient")
public class ListeIngredientsController {

	@Autowired
	private ListeIngredientsRepository listeIngredientRepository;
	
	
	
	
	
	
}
