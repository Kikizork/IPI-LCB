package fr.ipi_lyon.udev_2019.lcb.data.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class ListeIngredients {
	
	@EmbeddedId
	ListeIngredientsRecette id;
	
	@ManyToOne
	@MapsId("id_ingredient")
	@JoinColumn(name = "id_ingredient")
	Ingredient ingredient;
	
	@ManyToOne
	@MapsId("id_recette")
	@JoinColumn(name= "id_recette")
	Recette recette;

	private Integer quantite;
	
	public void setId(ListeIngredientsRecette id) {
		this.id = id;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}


	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	
	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public ListeIngredients() {
		
	}

	public ListeIngredients(Ingredient ingredient, Recette recette, Integer quantite) {
		super();
		this.ingredient = ingredient;
		this.recette = recette;
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "ListeIngredients [id=" + id + ", ingredient=" + ingredient + ", recette=" + recette + ", quantite="
				+ quantite + "]";
	}
	
	

	
	
}

@Embeddable
class ListeIngredientsRecette implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = "id_ingredient")
	Long idIngredient;
	
	
	@Column(name = "id_recette")
	Long idRecette;


	public Long getIdIngredient() {
		return idIngredient;
	}


	public void setIdIngredient(Long idIngredient) {
		this.idIngredient = idIngredient;
	}


	public Long getIdRecette() {
		return idRecette;
	}


	public void setIdRecette(Long idRecette) {
		this.idRecette = idRecette;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public ListeIngredientsRecette() {
		
	}
	public ListeIngredientsRecette(Long idIngredient, Long idRecette) {
		super();
		this.idIngredient = idIngredient;
		this.idRecette = idRecette;
	}

	
}

