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
@Table(name="groupe_ingredients")
public class GroupeIngredient {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_grp_ingredient")
	private Integer id;
	
	@Column(name="lib_grp_ingredient")
	private String lib;

	@OneToMany
	@JoinColumn(name="id_grp_ingredient")
	List <SousGroupeIngredient> sousGroupeIngredient;
	
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
	

	public List<SousGroupeIngredient> getSousGroupeIngredient() {
		return sousGroupeIngredient;
	}

	public void setSousGroupeIngredient(List<SousGroupeIngredient> sousGroupeIngredient) {
		this.sousGroupeIngredient = sousGroupeIngredient;
	}

	public GroupeIngredient() {
		
	}

	public GroupeIngredient(Integer id, String lib, List<SousGroupeIngredient> sousGroupeIngredient) {
		super();
		this.id = id;
		this.lib = lib;
		this.sousGroupeIngredient = sousGroupeIngredient;
	}	
		
}
