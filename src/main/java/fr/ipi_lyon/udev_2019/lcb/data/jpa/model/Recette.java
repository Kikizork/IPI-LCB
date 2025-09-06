package fr.ipi_lyon.udev_2019.lcb.data.jpa.model;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="recette")
public class Recette {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_recette")
	private Long id;
	
	@Column(name="lib_recette")
	private String lib;
	
	@Column(name="id_utilisateur")
	private Long idUtilisateur;
	
	@Column(name="instruction_recette")
	private String instruction;		
		
	@Column(name="nbr_personne")
	private Integer nbrPersonne;
	
	@Column(name="url_recette")
	private String urlRecette;
	
	@OneToMany(mappedBy = "recette")
	private List<ListeIngredients> listeIngredients;

	@Column(name="image")
	private String image;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLib() {
		return lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public Integer getNbrPersonne() {
		return nbrPersonne;
	} 

	public void setNbrPersonne(Integer nbrPersonne) {
		this.nbrPersonne = nbrPersonne;
	}

	public String getUrlRecette() {
		return urlRecette;
	}

	public void setUrlRecette(String urlRecette) {
		this.urlRecette = urlRecette;
	}
	
	public List<ListeIngredients> getListeIngredients() {
		return listeIngredients;
	}

	public void setListeIngredients(List<ListeIngredients> listeIngredients) {
		this.listeIngredients = listeIngredients;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Recette() {
		
	}

	public Recette(Long id, String lib, Long idUtilisateur, String instruction, Integer nbrPersonne, String urlRecette,
			List<ListeIngredients> listeIngredients, String image) {
		super();
		this.id = id;
		this.lib = lib;
		this.idUtilisateur = idUtilisateur;
		this.instruction = instruction;
		this.nbrPersonne = nbrPersonne;
		this.urlRecette = urlRecette;
		this.listeIngredients = listeIngredients;
		this.image = image;
	}

	

}



