package fr.ipi_lyon.udev_2019.lcb.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.GroupeIngredient;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.repository.GroupeIngredientRepository;

@Controller
@RequestMapping("groupe")
public class GroupeIngredientController {

	@Autowired
	private GroupeIngredientRepository groupeIngredientRepository;
	
	@RequestMapping("/all")
	@ResponseBody
	private List<GroupeIngredient> SearchAll() {
		return (List<GroupeIngredient>) groupeIngredientRepository.findAll();
	}
}
