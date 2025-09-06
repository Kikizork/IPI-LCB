package fr.ipi_lyon.udev_2019.lcb.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.SousGroupeIngredient;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.repository.SousGroupeIngredientRepository;

@Controller
@RequestMapping("/sousgroupe")
public class SousGroupeIngredientController {

	@Autowired
	private SousGroupeIngredientRepository sousGroupeIngredientRepository;
	
	@RequestMapping("/all")
	@ResponseBody
	private List<SousGroupeIngredient> SearchAll() {
		return (List<SousGroupeIngredient>) sousGroupeIngredientRepository.findAll();
	}
}
