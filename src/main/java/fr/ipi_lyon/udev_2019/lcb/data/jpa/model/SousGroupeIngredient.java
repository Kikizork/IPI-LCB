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
@Table(name="ss_groupe_ingredients")
public class SousGroupeIngredient {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_ss_grp_ingredient")
	private Integer id;
	
	@Column(name="lib_ss_grp_ingredient")
	private String lib;
	
	@OneToMany
	@JoinColumn(name="id_ss_grp_ingredient")
	List <SousSousGroupeIngredient> sousSousGroupeIngredient;
	
	
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

	

	public List<SousSousGroupeIngredient> getSousSousGroupeIngredient() {
		return sousSousGroupeIngredient;
	}

	public void setSousSousGroupeIngredient(List<SousSousGroupeIngredient> sousSousGroupeIngredient) {
		this.sousSousGroupeIngredient = sousSousGroupeIngredient;
	}

	public SousGroupeIngredient() {
		
	}
	public SousGroupeIngredient(Integer id, String lib, String idGrp,
			List<SousSousGroupeIngredient> sousSousGroupeIngredient) {
		super();
		this.id = id;
		this.lib = lib;
		this.sousSousGroupeIngredient = sousSousGroupeIngredient;
	}

	
	
	
}
