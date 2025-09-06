package fr.ipi_lyon.udev_2019.lcb.data.jpa.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.Recette;

@Repository
public interface RecetteRepository extends CrudRepository<Recette, Long>{

	
	
	List<Recette> findByLibContaining(String lib);
	
	
	List<Recette> findByIdBefore(Long id);
	
	
	Recette findByUrlRecetteEquals(String url);
	
	Recette findByIdEquals(Long id);
	
}
