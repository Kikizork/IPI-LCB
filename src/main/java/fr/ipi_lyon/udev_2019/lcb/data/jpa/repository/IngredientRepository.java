package fr.ipi_lyon.udev_2019.lcb.data.jpa.repository;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
	
	Ingredient findByAlimNom(String nom);
}
