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
import dao.Entreprise;
import dao.Partenariat;
import dao.Pays;
import dao.Secteur;
import dao.Utilisateur;
import service.DemandeMetier;
import service.EntrepriseMetier;
import service.PartenariatMetier;
import service.PaysMetier;
import service.SecteurMetier;
import service.UtilisateurMetier;

@Controller
public class PublicController {

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
    
    
    @RequestMapping(value="/index")
    public String Demarrage(Model model,HttpSession session)
    {   
        session.invalidate();
    	if(session.equals(null)) System.out.println("ok");
        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
        model.addAttribute("demandes", demandes);
        
    	return "public/index";
    	
    }
    
    @RequestMapping(value="/Authentification")	
    public String Authentification(Model model, Utilisateur user , HttpSession session)
     {  
    try{
    	boolean found;
    	String page = "public/index";
    	String erreur_msg = "";
    	try{
    			String idUtilisateur = session.getAttribute("idUtilisateur").toString();
    			Utilisateur user1 = serviceUtilisateur.getUtilisateurbyId(Integer.parseInt(idUtilisateur));
    		    found = serviceUtilisateur.TrouverUtilisateur(user1);
    		    
    		    if( found ) 
					{
						
						if( user1.getProfile().equals("Administrateur") )
						 {
							List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes();
							List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
							List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
							model.addAttribute("demandes", demandes);
							
							
							session.setAttribute("idUtilisateur", user1.getIdUtilisateur());
							session.setAttribute("login", user1.getLogin());
							session.setAttribute("password", user1.getPassword());
							
							session.setAttribute("nb_demandes_valides", demandes.size()-demandesInv.size());
							
							model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
							model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
							page="admin/espaceAdmin";
							
						 }else if( user1.getProfile().equals("Directeur") )
						    {
							    List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes();
								model.addAttribute("demandes", demandes);
								
								
								session.setAttribute("idUtilisateur", user1.getIdUtilisateur());
								session.setAttribute("login", user1.getLogin());
								session.setAttribute("password", user1.getPassword());
								
							    page="director/espaceDirecteur";
							  
						    }else if( user1.getProfile().equals("Utilisateur") )
						       {
						    	  List<Demande> demandes = (List<Demande>) serviceUtilisateur.getAllDemandes(user1.getIdUtilisateur());
								  model.addAttribute("demandes", demandes);
								  
								  session.setAttribute("idUtilisateur", user1.getIdUtilisateur());
								  session.setAttribute("login", user1.getLogin());
								  session.setAttribute("password", user1.getPassword());
									
						    	  page="user/espaceUser";
						       }
					}else{
						
						List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
						 
						model.addAttribute("demandes", demandes);
						
						erreur_msg = "Login ou Mot de passe invalide";
						
					}
					
					model.addAttribute("erreur_msg", erreur_msg); 
				
		      
		        
				return page;
				
    		
    		}catch(Exception e)
    		{
//    			if( sess = false ) 
//    			{
	    			found = serviceUtilisateur.TrouverUtilisateur(user);
	     		    
	     		    if( found ) 
	 					{
	 						
	 						if( user.getProfile().equals("Administrateur") )
	 						 {
	 							List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes();
	 							List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
	 							List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
	 							model.addAttribute("demandes", demandes);
	 							
	 							
	 							session.setAttribute("idUtilisateur", user.getIdUtilisateur());
	 							session.setAttribute("login", user.getLogin());
	 							session.setAttribute("password", user.getPassword());
	 							
	 							session.setAttribute("nb_demandes_valides", demandes.size()-demandesInv.size());
	 							
	 							model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
	 							model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
	 							page="admin/espaceAdmin";
	 							
	 						 }else if( user.getProfile().equals("Directeur") )
	 						    {
	 							    List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes();
	 								model.addAttribute("demandes", demandes);
	 								
	 								
	 								session.setAttribute("idUtilisateur", user.getIdUtilisateur());
	 								session.setAttribute("login", user.getLogin());
	 								session.setAttribute("password", user.getPassword());
	 								
	 							    page="director/espaceDirecteur";
	 							  
	 						    }else if( user.getProfile().equals("Utilisateur") )
	 						       {
	 						    	  List<Demande> demandes = (List<Demande>) serviceUtilisateur.getAllDemandes(user.getIdUtilisateur());
	 								  model.addAttribute("demandes", demandes);
	 								  
	 								  session.setAttribute("idUtilisateur", user.getIdUtilisateur());
	 								  session.setAttribute("login", user.getLogin());
	 								  session.setAttribute("password", user.getPassword());
	 									
	 						    	  page="user/espaceUser";
	 						       }
	 					}else{
	 						
	 						List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
	 						 
	 						model.addAttribute("demandes", demandes);
	 						
	 						erreur_msg = "Login ou Mot de passe invalide";
	 						
	 					}
	 					
	 					model.addAttribute("erreur_msg", erreur_msg); 
	 				
//    			}
 		        
 				return page;
    			
    		}
    	
    	}catch(Exception e1)
    	{
    		
    		boolean found;
        	String page = "public/index";
        	String erreur_msg = "";
    		
    		try{
    			String idUtilisateur = session.getAttribute("idUtilisateur").toString();
    			Utilisateur user1 = serviceUtilisateur.getUtilisateurbyId(Integer.parseInt(idUtilisateur));
    		    found = serviceUtilisateur.TrouverUtilisateur(user1);
    		    
    		    if( found ) 
					{
						
						if( user1.getProfile().equals("Administrateur") )
						 {
							List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes();
							List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
							List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
							model.addAttribute("demandes", demandes);
							
							
							session.setAttribute("idUtilisateur", user1.getIdUtilisateur());
							session.setAttribute("login", user1.getLogin());
							session.setAttribute("password", user1.getPassword());
							
							session.setAttribute("nb_demandes_valides", demandes.size()-demandesInv.size());
							
							model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
							model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
							page="admin/espaceAdmin";
							
						 }else if( user1.getProfile().equals("Directeur") )
						    {
							    List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes();
								model.addAttribute("demandes", demandes);
								
								
								session.setAttribute("idUtilisateur", user1.getIdUtilisateur());
								session.setAttribute("login", user1.getLogin());
								session.setAttribute("password", user1.getPassword());
								
							    page="director/espaceDirecteur";
							  
						    }else if( user1.getProfile().equals("Utilisateur") )
						       {
						    	  List<Demande> demandes = (List<Demande>) serviceUtilisateur.getAllDemandes(user1.getIdUtilisateur());
								  model.addAttribute("demandes", demandes);
								  
								  session.setAttribute("idUtilisateur", user1.getIdUtilisateur());
								  session.setAttribute("login", user1.getLogin());
								  session.setAttribute("password", user1.getPassword());
									
						    	  page="user/espaceUser";
						       }
					}else{
						
						List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
						 
						model.addAttribute("demandes", demandes);
						
						erreur_msg = "Login ou Mot de passe invalide";
						
					}
					
					model.addAttribute("erreur_msg", erreur_msg); 
				
		      
		        
				return page;
				
    		
    		}catch(Exception e)
    		{
//    			  session.invalidate();
    	    	
    	        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
    	        model.addAttribute("demandes", demandes);
    	        
    	    	return "public/index";
	 				
//    			}
 		        
 				
    		} 
    	}
       
     }
   
    
    
	@RequestMapping(value="/inscription")
	public String inscription(Model model,HttpSession session,@RequestParam String idEntreprise)
	{
        List<Secteur> SurSecteurs = (List<Secteur>) serviceSecteur.getAllSurSecteurs();
		List<Secteur> SousSecteurs = (List<Secteur>) serviceSecteur.getAllSecteurs(SurSecteurs.get(0).getIdSecteur().toString());
		List<Pays> pays = (List<Pays>) serivcePays.getAllPays();
        List<Partenariat> partenariats = (List<Partenariat>) servicePartenariat.getAllPartenariats();
        
        model.addAttribute("idEntreprise", idEntreprise);
        model.addAttribute("SurSecteurs", SurSecteurs);
		model.addAttribute("SousSecteurs", SousSecteurs);
		model.addAttribute("Pays",pays);
		model.addAttribute("Partenariats", partenariats);
		
		return "public/inscription";
	}

	
	
	
	
	
	
	
	@RequestMapping(value="/PlusDetails")
	public String PlusDetails(Model model
							  ,HttpSession session
							  ,@RequestParam String idEntreprise)
	{
        
		List<Secteur> SurSecteurs = (List<Secteur>) serviceSecteur.getAllSurSecteurs();
		List<Secteur> SousSecteurs = (List<Secteur>) serviceSecteur.getAllSecteurs();
		List<Pays> pays = (List<Pays>) serivcePays.getAllPays();
        List<Partenariat> partenariats = (List<Partenariat>) servicePartenariat.getAllPartenariats();
        
        model.addAttribute("SurSecteurs", SurSecteurs);
		model.addAttribute("SousSecteurs", SousSecteurs);
		model.addAttribute("Pays",pays);
		model.addAttribute("Partenariats", partenariats);
		
		return "public/PlusDetails";
	}
    
	
	@RequestMapping(value="/AjouterEntreprise")
	public String AjouterEntreprise(Model model
								   ,HttpSession session
								   ,Entreprise entreprise
								   ,@RequestParam String idPays
								   ,@RequestParam String idSecteur)
	{
		System.out.println("1111111");
		Pays p = serivcePays.getPaysbyId(Integer.parseInt(idPays));
		Secteur s = serviceSecteur.getSecteurbyId(Integer.parseInt(idSecteur));
		System.out.println("2222222");
		entreprise.setPays(p);	
		entreprise.setSecteur(s);
		entreprise.setValide(false);
		serviceEntreprise.AjouterEntreprise(entreprise);
		System.out.println("33333333");

		model.addAttribute("mail", entreprise.getEmailContact());
		
		return "public/End";
	}
	
	
	
	@RequestMapping(value="/AjoutpublicDemande")
	public String AjoutUtilisateur(Model model
									,HttpSession session
									,Entreprise entreprise
									,Demande demande
									,@RequestParam String idPays
									,@RequestParam String idSecteur
									,@RequestParam String idPartenariat
									,@RequestParam String idSecteurDemande
									,@RequestParam String descriptionDemande
									,@RequestParam String engagement
									)
	{
		
		
        Pays p = serivcePays.getPaysbyId(Integer.parseInt(idPays));
		Secteur s = serviceSecteur.getSecteurbyId(Integer.parseInt(idSecteur));
		
		entreprise.setPays(p);	
		entreprise.setSecteur(s);
		serviceEntreprise.AjouterEntreprise(entreprise);

		   
			List<Entreprise> entreprises = (List<Entreprise>) serviceEntreprise.getAllEntreprise();
			Secteur SecteurDemande = serviceSecteur.getSecteurbyId(Integer.parseInt(idSecteurDemande));			
			DemandeId idDemande = new DemandeId(entreprises.get(entreprises.size()-1).getIdEntreprise(),Integer.parseInt(idSecteurDemande),Integer.parseInt(idPartenariat));
			demande.setId(idDemande);
			demande.setEntreprise(entreprises.get(entreprises.size()-1));
			demande.setSecteur(SecteurDemande);
			
			Date date = new Date();
		    SimpleDateFormat dateFormat;
		    dateFormat = new SimpleDateFormat("MMMMM - yyyy");
		    
			demande.setDate(dateFormat.format(date));
	        demande.setDescription(descriptionDemande);
			demande.setEngagement(engagement);
			demande.setValide(false);
			
			Partenariat partenariat =servicePartenariat.getPartenariatbyId(Integer.parseInt(idPartenariat));				
			
			
			demande.setPartenariat(partenariat);
			serviceDemande.AjouterDemande(demande);
			
		
		
	    
		
		model.addAttribute("mail", entreprise.getEmailContact());
		
		return "public/End";
	}

	
	@RequestMapping(value="/FilterDemandesValides")
	public String FilterDemandes(Model model
								,HttpSession session
								,@RequestParam String date
								,@RequestParam String nomPays
								,@RequestParam String designiationSecteurE
								,@RequestParam String descriptionEntreprise
								,@RequestParam String designiationSecteurD
								,@RequestParam String designiationPartenariat
								,@RequestParam String descriptionDemande
								,@RequestParam String engagement)
	{
		
//		String code="";
		    System.out.println("kkkkkkkkkkkk   "+nomPays+"   ,   "+designiationSecteurE);
	        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes(date, nomPays, designiationSecteurE, descriptionEntreprise, designiationSecteurD, designiationPartenariat, descriptionDemande, engagement); 	
	        model.addAttribute("demandes", demandes);
		    

	        
          
//	      String varClass ;
//	 
//	  
//          
//          for( int i = 0 ; i<demandes.size() ; i++ )
//          {
//	            if(i%2==0)
//	        	{
//	        	   varClass = "error";
//	            }else{
//	            	varClass = "success";
//	            }
//        
//	         code +=  "<tr class='"+varClass+"'> ";
//             code +=  "<form action='PlusDetails.aspx'>";
//             code +=  "<input type='hidden' name='idEntreprise' value='"+demandes.get(i).getEntreprise().getIdEntreprise()+"'>";
//             code +=  "<td><button type='submit' style='text-align:right;margin:7px;' class='btn btn-info'>+</button></td>";
//	         code +=  "</form>";
//	         code +=  "<td>"+demandes.get(i).getDate()+"</td>";
//             code +=  "<td>"+demandes.get(i).getEntreprise().getPays().getNomPays()+"</td>";
//             code +=  "<td>"+demandes.get(i).getEntreprise().getSecteur().getDesigniation()+"</td>";
//             code +=  "<td>"+demandes.get(i).getDescription()+"</td>";
//             code +=  "<td>"+demandes.get(i).getSecteur().getDesigniation()+"</td>";
//             code +=  "<td>"+demandes.get(i).getPartenariat().getDesigniation()+"</td>";
//             code +=  "<td>"+demandes.get(i).getDescription()+"</td>";
//             code +=  "<td>"+demandes.get(i).getEngagement()+"</td>";
//            	 
//             code +=   "</tr>";
//
//           
//          }
//		
//          code += "</table>";
//model.addAttribute("demandes", code);
	        
	        
	        
		return "public/filterDemande";
	}
	
	
	
	
	
	@RequestMapping(value="/SousSecteurs")
	public String SousSecteurs(Model model
							   ,HttpSession session
							   ,@RequestParam String idSecteur)
	{
		
		List<Secteur> secteurs = serviceSecteur.getAllSecteurs(idSecteur);
		
		String code = "<select class='form-control'  name='idSecteur'> ";
		
		for( int i=0 ; i < secteurs.size() ; i++)
		{
			code += "<option value='"+secteurs.get(i).getIdSecteur()+"'>"+secteurs.get(i).getDesigniation()+"</option>";
		}
		
		code += "</select>";
		
		model.addAttribute("SousSecteurs",code);
		
		
		return "public/SousSecteurs";
	}
	
	
	
	@RequestMapping(value="/SousSecteursDemande")
	public String SousSecteursDemande(Model model
							   ,HttpSession session
							   ,@RequestParam String idSecteur)
	{
		
		List<Secteur> secteurs = serviceSecteur.getAllSecteurs(idSecteur);
		
		String code = "<select class='form-control'  name='idSecteurDemande'> ";
		
		for( int i=0 ; i < secteurs.size() ; i++)
		{
			code += "<option value='"+secteurs.get(i).getIdSecteur()+"'>"+secteurs.get(i).getDesigniation()+"</option>";
		}
		
		code += "</select>";
		
		model.addAttribute("SousSecteurs",code);
		
		
		return "public/SousSecteurs";
	}
	
	
	
	@RequestMapping(value="/NousContacter")
	public String NousContacter(Model model,HttpSession session)
	{
//		String idUtilisateur = session.getAttribute("idUtilisateur").toString();
//		Utilisateur user1 = serviceUtilisateur.getUtilisateurbyId(Integer.parseInt(idUtilisateur));
//		
//		if(user1.getProfile().equals("Utilisateur"))
//			return "user/NousContacter";
//		else
			return "public/NousContacter";
	}
	

}
