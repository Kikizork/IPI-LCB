package fr.ipi_lyon.udev_2019.lcb.web.rest.controller;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import java.nio.charset.Charset;
import java.sql.* ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.Ingredient;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.ListeIngredients;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.Recette;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.model.Utilisateur;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.repository.IngredientRepository;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.repository.ListeIngredientsRepository;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.repository.RecetteRepository;
import fr.ipi_lyon.udev_2019.lcb.data.jpa.repository.UtilisateurRepository;

@Controller
@RequestMapping("/recette")
public class RecetteController {

	@Autowired
	private RecetteRepository recetteRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private ListeIngredientsRepository listeIngredientsRepository;
	
	
	
	
	
	
	@RequestMapping("/all")
	@ResponseBody
	private List<Recette> SearchAll() {
		return (List<Recette>) recetteRepository.findAll();
	}
	
	// Retourne les recettes crée par un user donné. Prend en header les sessions storage token
	@RequestMapping("/userRecette")
	@ResponseBody
	private List<Recette> SearchByUser(@RequestHeader("mail") String mail, @RequestHeader("password") String password){		
		Utilisateur u = utilisateurRepository.findByMail(mail);
		return u.getRecette();
	}
	// Retourne les favoris likés par un user donné. Prend en header les sessions storage token
	@RequestMapping("/userFavoris")
	@ResponseBody
	private List<Recette> SearchByUserFavoris(@RequestHeader("mail") String mail, @RequestHeader("password") String password){		
		Utilisateur u = utilisateurRepository.findByMail(mail);
		System.out.println(u);
		return u.getRecetteFavoris();
	}
	
	// Recherche une recette par libellé
	@RequestMapping("/search")
	@ResponseBody
	private List<Recette> SearchRecette(@RequestHeader("lib") String lib){		
		return recetteRepository.findByLibContaining(lib);	
	}
	
	// Va chercher les 3 recettes les plus anciennes en base de donnée et les affiches sur la page d'acceuil
	@RequestMapping("/homePageRecette")
	@ResponseBody
	private List<Recette> homePageRecette(){
		return recetteRepository.findByIdBefore(4l);
	}
	
	
	// retourne la page recette.html sur une requete url de type localhost/recette?id={id}
	@RequestMapping(value="", method = RequestMethod.GET)
	private String DisplayRecette(@RequestParam(value= "id", required=true)String id) {
		return "recette.html";
	}
	
	// retourne la recette correspondant à l'url mise en header
	@RequestMapping("/geturl")
	@ResponseBody
	private Recette SearchRecetteByUrl(@RequestHeader("adresse")String adresse) {
		return recetteRepository.findByUrlRecetteEquals(adresse);
	}
	
	
	// Fonction usine à gaz :
	// 1/ Récupère en header le session storage de l'user, le nom de recette, le nbr de personne, le champ description, 
	// une array d'id ingredient, une array de quantité, une url d'image.
	// 2/ Crée une nouvelle recette et l'insère en base de donnée via JPA
	// 3/ Insére un par un les ingredients correspondant dans la table liste_ingredient via JPQL
@RequestMapping(value = "/nouv_recette", method = RequestMethod.POST)
    @ResponseBody
    public void nouvelleRecette(
    		@RequestHeader("mail") String mail, 
    		@RequestHeader("lib") String lib, 
            @RequestHeader("nbrPer") Integer nbr, 
            @RequestHeader("description") String description, 
            @RequestHeader("listIngr") Integer[] listIngr,
            @RequestHeader("listQuant") Integer[] listQuant,
            @RequestHeader("image") String image){



        Utilisateur u = utilisateurRepository.findByMail(mail);
        Long id = u.getIdUtilisateur();
        
        String url = concatUrl(lib);
        //CREER ET ENREGISTRER L'OBJET LISTE INGREDIENT ASSOCIE A LA RECETTE 
        
         Recette nouvelleRecette = new Recette(null, lib, id, description, nbr,url,null,image);
        recetteRepository.save(nouvelleRecette);
        
       Recette thisRecette= recetteRepository.findByUrlRecetteEquals(url);
       Long idThisRecette = thisRecette.getId();
       
        for (int i=0; i < listIngr.length; i++) {
        	
        	listeIngredientsRepository.insertWithQuerys((long)listIngr[i], idThisRecette, listQuant[i]);
        	
        }
        
		}    
    
	
	
	// 	Fonction prennant en paramètre le lib d'une recette et générant une bonne url avec un chiffre de 0 à 999999 pour saler 
	public String concatUrl(String lib){
		String url="http://localhost:8080/recette?id=";
		String salt= generateString();
		url= url.concat(salt);
		return url;
	}
	
	// Crée une string aléatoire d'Hexa decimal pour "saler" l'url
	public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        uuid.replace("-", "");
        return uuid;    
    }
	

}
