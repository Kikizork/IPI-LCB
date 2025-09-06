package fr.ipi_lyon.udev_2019.lcb.data.jpa.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_ingredient")
	private Long idIngredient;
	
	@Column(name="alim_nom_fr")
	private String alimNom;
	
	@Column(name="Energie")
	private Integer energie;
	
	@Column(name="Eau")
	private Double eau;
	
	@Column(name="Proteines")
	private Double proteines;
	
	@Column(name="Glucides")
	private Double glucides;
	
	@Column(name="Lipides")
	private Double lipides;
	
	@Column(name="Sucres")
	private Double sucres;
	
	@Column(name="Amidon")
	private Double amidon;
	
	@Column(name="Fibres_alimentaires")
	private Double fibresAlimentaires;
	
	@Column(name="Cholesterol")
	private Double cholosterol;
	
	@Column(name="sel")
	private Double sel;
	
	@Column(name="Calcium")
	private Double calcium;
	
	@Column(name="Fer")
	private Double fer;
	
	@Column(name="Iode")
	private Double iode;
	
	@Column(name="Beta_Carotene")
	private Integer betaCarotene;
	
	@Column(name="VitamineD")
	private Double vitamineD;
	
	@Column(name="VitamineE")
	private Double vitamineE;
	
	@Column(name="VitamineC")
	private Double vitamineC;
	
	@Column(name="VitamineB1")
	private Double vitamineB1;
	
	@Column(name="VitamineB12")
	private Double vitamineB12;

	public Long getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(Long idIngredient) {
		this.idIngredient = idIngredient;
	}

	public String getAlimNom() {
		return alimNom;
	}

	public void setAlimNom(String alimNom) {
		this.alimNom = alimNom;
	}

	public Integer getEnergie() {
		return energie;
	}

	public void setEnergie(Integer energie) {
		this.energie = energie;
	}

	public Double getEau() {
		return eau;
	}

	public void setEau(Double eau) {
		this.eau = eau;
	}

	public Double getProteines() {
		return proteines;
	}

	public void setProteines(Double proteines) {
		this.proteines = proteines;
	}

	public Double getGlucides() {
		return glucides;
	}

	public void setGlucides(Double glucides) {
		this.glucides = glucides;
	}

	public Double getLipides() {
		return lipides;
	}

	public void setLipides(Double lipides) {
		this.lipides = lipides;
	}

	public Double getSucres() {
		return sucres;
	}

	public void setSucres(Double sucres) {
		this.sucres = sucres;
	}

	public Double getAmidon() {
		return amidon;
	}

	public void setAmidon(Double amidon) {
		this.amidon = amidon;
	}

	public Double getFibresAlimentaires() {
		return fibresAlimentaires;
	}

	public void setFibresAlimentaires(Double fibresAlimentaires) {
		this.fibresAlimentaires = fibresAlimentaires;
	}

	public Double getCholosterol() {
		return cholosterol;
	}

	public void setCholosterol(Double cholosterol) {
		this.cholosterol = cholosterol;
	}

	public Double getSel() {
		return sel;
	}

	public void setSel(Double sel) {
		this.sel = sel;
	}

	public Double getCalcium() {
		return calcium;
	}

	public void setCalcium(Double calcium) {
		this.calcium = calcium;
	}

	public Double getFer() {
		return fer;
	}

	public void setFer(Double fer) {
		this.fer = fer;
	}

	public Double getIode() {
		return iode;
	}

	public void setIode(Double iode) {
		this.iode = iode;
	}

	public Integer getBetaCarotene() {
		return betaCarotene;
	}

	public void setBetaCarotene(Integer betaCarotene) {
		this.betaCarotene = betaCarotene;
	}

	public Double getVitamineD() {
		return vitamineD;
	}

	public void setVitamineD(Double vitamineD) {
		this.vitamineD = vitamineD;
	}

	public Double getVitamineE() {
		return vitamineE;
	}

	public void setVitamineE(Double vitamineE) {
		this.vitamineE = vitamineE;
	}

	public Double getVitamineC() {
		return vitamineC;
	}

	public void setVitamineC(Double vitamineC) {
		this.vitamineC = vitamineC;
	}

	public Double getVitamineB1() {
		return vitamineB1;
	}

	public void setVitamineB1(Double vitamineB1) {
		this.vitamineB1 = vitamineB1;
	}

	public Double getVitamineB12() {
		return vitamineB12;
	}

	public void setVitamineB12(Double vitamineB12) {
		this.vitamineB12 = vitamineB12;
	}

	public Ingredient() {
		
	}
	public Ingredient(Long idIngredient, String alimNom, Integer energie, Double eau, Double proteines, Double glucides,
			Double lipides, Double sucres, Double amidon, Double fibresAlimentaires, Double cholosterol, Double sel,
			Double calcium, Double fer, Double iode, Integer betaCarotene, Double vitamineD, Double vitamineE,
			Double vitamineC, Double vitamineB1, Double vitamineB12) {
		super();
		this.idIngredient = idIngredient;
		this.alimNom = alimNom;
		this.energie = energie;
		this.eau = eau;
		this.proteines = proteines;
		this.glucides = glucides;
		this.lipides = lipides;
		this.sucres = sucres;
		this.amidon = amidon;
		this.fibresAlimentaires = fibresAlimentaires;
		this.cholosterol = cholosterol;
		this.sel = sel;
		this.calcium = calcium;
		this.fer = fer;
		this.iode = iode;
		this.betaCarotene = betaCarotene;
		this.vitamineD = vitamineD;
		this.vitamineE = vitamineE;
		this.vitamineC = vitamineC;
		this.vitamineB1 = vitamineB1;
		this.vitamineB12 = vitamineB12;
	}

	
	

	

	
}
