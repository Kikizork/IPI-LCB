package fr.ipi_lyon.udev_2019.lcb.data.jpa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ss_ss_groupe_ingredients")
public class SousSousGroupeIngredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_ss_ss_grp_ingredient")
	private Integer id;
	
	@Column(name="lib_ss_ss_grp_ingredient")
	private String lib;
	
	
	@OneToMany
	@JoinColumn(name="id_ss_ss_groupe_ingredient")
	List<Ingredient> ingredients;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLib() {
		return lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

	
	
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public SousSousGroupeIngredient() {
		
	}

	public SousSousGroupeIngredient(Integer id, String lib, Integer idSsGrp, List<Ingredient> ingredients) {
		super();
		this.id = id;
		this.lib = lib;
		this.ingredients = ingredients;
	}

	

	
	
	
	
	
	
}
