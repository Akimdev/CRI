package controller;




import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.Demande;
import dao.Utilisateur;
import service.DemandeMetier;
import service.EntrepriseMetier;
import service.PartenariatMetier;
import service.PaysMetier;
import service.SecteurMetier;
import service.UtilisateurMetier;

@Controller
public class SecteurController {

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
    
    @RequestMapping(value="/ok")
    public String ok(Model model,HttpSession session)
    {

    	 try{
			 
			  String ok = session.getAttribute("idUtilisateur").toString();
			  return "ok";
			  
		    }catch(Exception e)
		 		{
		 			session.invalidate();
		 	    	
		 	        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
		 	        model.addAttribute("demandes", demandes);
		 	        
		 	    	return "index";
		 		}
    }
  
	



    

	
	

}
