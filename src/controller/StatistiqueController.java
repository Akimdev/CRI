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
public class StatistiqueController {

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
	 
	    
	    
		
		@RequestMapping(value="/Statistique")
		public String Statistique(Model model,HttpSession session)
		{
			
			try{
				 
				String ok = session.getAttribute("idUtilisateur").toString();
			    
			  return "stats/Statistique";
			   }catch(Exception e)
				{
					session.invalidate();
			    	
			        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
			        model.addAttribute("demandes", demandes);
			        
			    	return "public/index";
				}
			  
		}
		
	    
	    
	    
	    @RequestMapping(value="/StatDemandesParPays")
	    public String StatDemandesParPays(Model model,HttpSession session)
	    {
	    	try{
		        String ok = session.getAttribute("idUtilisateur").toString();
		    	return "stats/StatDemandesParPays";
	    	}catch(Exception e)
	    	{
	    		session.invalidate();
	        	
	            List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
	            model.addAttribute("demandes", demandes);
	            
	        	return "public/index";
	    	}
	    }
	   
	    @RequestMapping(value="/StatDemandesParSecteur")
	    public String StatDemandesParSecteur(Model model,HttpSession session)
	    {
	      	try{
		        String ok = session.getAttribute("idUtilisateur").toString(); 
		        return "stats/StatDemandesParSecteur";
		    }catch(Exception e)
	    	{
	    		session.invalidate();
	        	
	            List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
	            model.addAttribute("demandes", demandes);
	            
	        	return "public/index";
	    	}
	    }
	    
	    @RequestMapping(value="/StatDemandesParSousSecteur")
	    public String StatDemandesParSousSecteur(Model model,HttpSession session,@RequestParam String SurSecteur)
	    {
	      	try{
		        String ok = session.getAttribute("idUtilisateur").toString();
		        
		    	List<Secteur> SurSecteurs = (List<Secteur>) serviceSecteur.getAllSurSecteurs();
		    	String param;
		    	
		    	if(SurSecteur.equals("a"))
		    		param="";
		    	else
		    		param =  "?SurSecteur="+SurSecteur;
		    	
		    	model.addAttribute("param",param);
		    	model.addAttribute("SurSecteurs", SurSecteurs);
		    	return "stats/StatDemandesParSousSecteur";
		    	
	        }catch(Exception e)
	    	{
	    		session.invalidate();
	        	
	            List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
	            model.addAttribute("demandes", demandes);
	            
	        	return "public/index";
	    	}
	    }
	    
	    
	    @RequestMapping(value="/StatDemandesParAnnee")
	    public String StatDemandesParAnnee(Model model,HttpSession session)
	    {
	        
	    	try{
			        String ok = session.getAttribute("idUtilisateur").toString();
			        return "stats/StatDemandesParAnnee";
				    	
			    }catch(Exception e)
		    	{
		    		session.invalidate();
		        	
		            List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
		            model.addAttribute("demandes", demandes);
		            
		        	return "public/index";
		    	}
	    }
	    
	    
	    
	    
}
