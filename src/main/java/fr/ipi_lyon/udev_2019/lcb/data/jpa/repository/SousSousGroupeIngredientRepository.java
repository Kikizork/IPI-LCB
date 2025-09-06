package fr.ipi_lyon.udev_2019.lcb.data.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.SousSousGroupeIngredient;

@Repository
public interface SousSousGroupeIngredientRepository extends CrudRepository<SousSousGroupeIngredient, Integer>{

}
