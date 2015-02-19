package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.Demande;
import dao.DemandeId;
import dao.Partenariat;
import dao.Pays;
import dao.Secteur;
import dao.Entreprise;
import service.DemandeMetier;
import service.EntrepriseMetier;
import service.PartenariatMetier;
import service.PaysMetier;
import service.SecteurMetier;
import service.UtilisateurMetier;

@Controller
public class UserController {

		@Autowired
		
		PaysMetier serivcePays;
		@Autowired
		SecteurMetier serviceSecteur;
	    @Autowired
	    UtilisateurMetier serviceUtilisateur;
	    @Autowired
		EntrepriseMetier serviceEntreprise;
	    @Autowired
	    DemandeMetier serviceDemande;
	    @Autowired
	    PartenariatMetier servicePartenariat;
	 
	    
	    @RequestMapping(value="/PosterDemande")
	    public String PosterDemande(Model model,HttpSession session)
	    {
	    	List<Secteur> SurSecteurs = (List<Secteur>) serviceSecteur.getAllSurSecteurs();
			List<Secteur> SousSecteurs = (List<Secteur>) serviceSecteur.getAllSecteurs();
	        List<Partenariat> partenariats = (List<Partenariat>) servicePartenariat.getAllPartenariats();
	        
	        model.addAttribute("SurSecteurs", SurSecteurs);
			model.addAttribute("SousSecteurs", SousSecteurs);
			model.addAttribute("Partenariats", partenariats);
			
	    	return "PosterDemande";
	    }
	    
	    @RequestMapping(value="/ValiderDemandeUtilisateur")
	    public String ValiderDemandeUtilisateur(Model model
	    					  ,HttpSession session
	    					  ,Demande demande
	    					  ,@RequestParam String idSecteur
	    				      ,@RequestParam String idPartenariat)
	    {
	    	try{
				 
				String ok = session.getAttribute("idUtilisateur").toString();
				
		    	demande.setValide(false);
		    	Entreprise e = serviceEntreprise.getEntreprisebyIdUser(Integer.parseInt(session.getAttribute("idUtilisateur").toString()));
		    	DemandeId id = new DemandeId(e.getIdEntreprise(),Integer.parseInt(idSecteur),Integer.parseInt(idPartenariat));
		    	demande.setId(id);
		    	
		    	Date date = new Date();
			    SimpleDateFormat dateFormat;
			    dateFormat = new SimpleDateFormat("MMMMM - yyyy");
				demande.setDate(dateFormat.format(date));
				
		    	serviceDemande.AjouterDemande(demande);
		    	model.addAttribute("mail","Votre Compte");
		    	return "End";
		    	
		    	
		    }catch(Exception e)
	    	{
	    		session.invalidate();
	        	
	            List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
	            model.addAttribute("demandes", demandes);
	            
	        	return "index";
	    	}
	    }
	  
	    
	    @RequestMapping(value="/MonProfile")
	    public String MonProfile(Model model,HttpSession session)
	    {
	    	return "MonProfile";
	    }
	    
	    @RequestMapping(value="/SupprimerUserDemande")
	    public String SupprimerUserDemande(Model model
	    								  ,HttpSession session
	    								  ,@RequestParam String idEntreprise
	    								  ,@RequestParam String idSecteur
	    								  ,@RequestParam String idPartenariat)
	    {
	    	
	    	try{
				 
				String ok = session.getAttribute("idUtilisateur").toString();
				
		    	DemandeId idDemande = new DemandeId(Integer.parseInt(idEntreprise),Integer.parseInt(idSecteur),Integer.parseInt(idPartenariat));
		    	serviceDemande.SupprimerDemande(idDemande);
		    	
		    	List<Demande> demandes = (List<Demande>) serviceUtilisateur.getAllDemandes(Integer.parseInt(session.getAttribute("idUtilisateur").toString()));
				model.addAttribute("demandes", demandes);
				
		    	return "espaceUser";
		    	
	    	
	    }catch(Exception e)
    	{
    		session.invalidate();
        	
            List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
            model.addAttribute("demandes", demandes);
            
        	return "index";
    	}
	    }
	    
	    
}
