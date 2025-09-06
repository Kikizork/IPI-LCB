package fr.ipi_lyon.udev_2019.lcb.data.jpa.model;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="utilisateur")
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_utilisateur")
	private Long idUtilisateur;
	
	private String pseudo;
	
	private String mail;
	
	@Column(name="mot_de_passe", nullable = false)
	private String motDePasse;
	
	private String prenom;
	
	private String nom;

	@OneToMany
	@JoinColumn( name = "id_utilisateur")
	List<Recette> recette; 
	
	@OneToMany
	@JoinTable(name = "Liste_Favoris",
    	joinColumns = @JoinColumn(name = "id_utilisateur"), 
    	inverseJoinColumns = @JoinColumn(name = "id_recette"))
	List<Recette> recetteFavoris;
	
	
	
	
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Recette> getRecette() {
		return recette;
	}

	public void setRecette(List<Recette> recette) {
		this.recette = recette;
	}

	
	public List<Recette> getRecetteFavoris() {
		return recetteFavoris;
	}

	public void setRecetteFavoris(List<Recette> recetteFavoris) {
		this.recetteFavoris = recetteFavoris;
	}

	

	public Utilisateur() {
		
	}

	public Utilisateur(Long idUtilisateur, String pseudo, String mail, String motDePasse, String prenom, String nom,
			List<Recette> recette, List<Recette> recetteFavoris) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.pseudo = pseudo;
		this.mail = mail;
		this.motDePasse = motDePasse;
		this.prenom = prenom;
		this.nom = nom;
		this.recette = recette;
		this.recetteFavoris = recetteFavoris;
	}

	

	

	

	

	
}
