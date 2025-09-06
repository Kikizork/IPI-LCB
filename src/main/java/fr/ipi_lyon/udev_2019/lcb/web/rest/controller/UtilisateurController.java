package fr.ipi_lyon.udev_2019.lcb.web.rest.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.Recette;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.Utilisateur;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.repository.RecetteRepository;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.repository.UtilisateurRepository;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private RecetteRepository recetteRepository;
	
	@RequestMapping("/all")
	@ResponseBody
	private List<Utilisateur> SearchAll() {
		return (List<Utilisateur>) utilisateurRepository.findAll();
	}
	
	
	
	@RequestMapping("/connexion")
    @ResponseBody
    public Utilisateur connexion(@RequestHeader("mail") String mail, @RequestHeader("password") String password){
        Utilisateur u = utilisateurRepository.findByMail(mail);
        if(u.getMotDePasse().equals(password)){
            return u;
        }
        return null;
    }
	
	
	@RequestMapping("/verifFavoris")
	@ResponseBody
	public Utilisateur verificationFavoris(@RequestHeader("mail")String mail) {
		Utilisateur u = utilisateurRepository.findByMail(mail);
		return u;
	}
	
	// Crée un nouvel utilisateur
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public void nouvelUtilisateur (
			@RequestHeader ("pseudo") String pseudo, 
			@RequestHeader ("mail") String mail, 
			@RequestHeader ("motDePasse") String motDePasse, 
			@RequestHeader ("prenom") String prenom, 
			@RequestHeader ("nom") String nom){
    	Utilisateur nouvelUtilisateur = new Utilisateur(null, pseudo, mail, motDePasse, prenom, nom, null, null);
    	utilisateurRepository.save(nouvelUtilisateur);
		
	}
	
	
	// enregistre un favori si il n'existe pas déjà/ supprime le favori si il existe 
	@RequestMapping(value = "/enregFavoris", method = RequestMethod.PUT)
	@ResponseBody
	@Transactional
	public void addFavoris (@RequestHeader("mail")String mail, @RequestHeader("idRec")Long id){
		Utilisateur u =utilisateurRepository.findByMail(mail);
		Recette r= recetteRepository.findByIdEquals(id);
		List<Recette> listeFavoris = u.getRecetteFavoris();	
		if(listeFavoris.contains(r)) {
			listeFavoris.remove(r);
			u.setRecetteFavoris(listeFavoris);
			utilisateurRepository.save(u);
		}
		else {
		listeFavoris.add(r);
		u.setRecetteFavoris(listeFavoris);
		utilisateurRepository.save(u);
		}
	}
	
	
	// Vérifie si la recette en question est un favori et retour vrai /faux
	@RequestMapping(value= "/checkFavoris", method = RequestMethod.GET)
	@ResponseBody
	public String checkSiFavoris (@RequestHeader("mail")String mail, @RequestHeader("idRec")Long id) {
		
		Utilisateur u=utilisateurRepository.findByMail(mail);
		Recette r =recetteRepository.findByIdEquals(id);
		List<Recette> listeFavoris = u.getRecetteFavoris();	
		if(listeFavoris.contains(r)) {
			return "Vrai";			
		}
		else {
		
			return "Faux";
		}
	}
}

