package fr.ipi_lyon.udev_2019.lcb.data.jpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.Ingredient;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.ListeIngredients;

@Repository
public class ListeIngredientsRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// Insert en JPQL un element dans la table liste_ingredient //
	@Transactional
	public void insertWithQuerys(Long listIngr,  Long idRec, int quantite) {
		entityManager.createNativeQuery("Insert into liste_ingredients (id_ingredient, id_recette, quantite) values (?,?,?)")
		.setParameter(1, listIngr)
		.setParameter(2, idRec)
		.setParameter(3, quantite)
		.executeUpdate();
	}
	
	
}
