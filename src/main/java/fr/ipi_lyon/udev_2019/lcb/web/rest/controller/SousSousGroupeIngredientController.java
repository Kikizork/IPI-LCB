package fr.ipi_lyon.udev_2019.lcb.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.SousSousGroupeIngredient;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.repository.SousSousGroupeIngredientRepository;

@Controller
@RequestMapping("/soussousgroupe")
public class SousSousGroupeIngredientController {

	@Autowired
	private SousSousGroupeIngredientRepository sousSousGroupeIngredientRepository;
	
	@RequestMapping("/all")
	@ResponseBody
	private List<SousSousGroupeIngredient> SearchAll() {
		return (List<SousSousGroupeIngredient>) sousSousGroupeIngredientRepository.findAll();
	}
}
