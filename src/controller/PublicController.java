package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    	
        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
        model.addAttribute("demandes", demandes);
        
    	return "index";
    	
    }
    
    @RequestMapping(value="/Authentification")	
    public String Authentification(Model model, Utilisateur user , HttpSession session)
     {  
    try{
    	boolean found;
    	String page = "index";
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
							
							model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
							model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
							page="espaceAdmin";
							
						 }else if( user1.getProfile().equals("Directeur") )
						    {
							    List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes();
								model.addAttribute("demandes", demandes);
								
								
								session.setAttribute("idUtilisateur", user1.getIdUtilisateur());
								session.setAttribute("login", user1.getLogin());
								session.setAttribute("password", user1.getPassword());
								
							    page="espaceDirecteur";
							  
						    }else if( user1.getProfile().equals("Utilisateur") )
						       {
						    	  List<Demande> demandes = (List<Demande>) serviceUtilisateur.getAllDemandes(user1.getIdUtilisateur());
								  model.addAttribute("demandes", demandes);
								  
								  session.setAttribute("idUtilisateur", user1.getIdUtilisateur());
								  session.setAttribute("login", user1.getLogin());
								  session.setAttribute("password", user1.getPassword());
									
						    	  page="espaceUser";
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
	 							
	 							model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
	 							model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
	 							page="espaceAdmin";
	 							
	 						 }else if( user.getProfile().equals("Directeur") )
	 						    {
	 							    List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes();
	 								model.addAttribute("demandes", demandes);
	 								
	 								
	 								session.setAttribute("idUtilisateur", user.getIdUtilisateur());
	 								session.setAttribute("login", user.getLogin());
	 								session.setAttribute("password", user.getPassword());
	 								
	 							    page="espaceDirecteur";
	 							  
	 						    }else if( user.getProfile().equals("Utilisateur") )
	 						       {
	 						    	  List<Demande> demandes = (List<Demande>) serviceUtilisateur.getAllDemandes(user.getIdUtilisateur());
	 								  model.addAttribute("demandes", demandes);
	 								  
	 								  session.setAttribute("idUtilisateur", user.getIdUtilisateur());
	 								  session.setAttribute("login", user.getLogin());
	 								  session.setAttribute("password", user.getPassword());
	 									
	 						    	  page="espaceUser";
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
        	String page = "index";
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
							
							model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
							model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
							page="espaceAdmin";
							
						 }else if( user1.getProfile().equals("Directeur") )
						    {
							    List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes();
								model.addAttribute("demandes", demandes);
								
								
								session.setAttribute("idUtilisateur", user1.getIdUtilisateur());
								session.setAttribute("login", user1.getLogin());
								session.setAttribute("password", user1.getPassword());
								
							    page="espaceDirecteur";
							  
						    }else if( user1.getProfile().equals("Utilisateur") )
						       {
						    	  List<Demande> demandes = (List<Demande>) serviceUtilisateur.getAllDemandes(user1.getIdUtilisateur());
								  model.addAttribute("demandes", demandes);
								  
								  session.setAttribute("idUtilisateur", user1.getIdUtilisateur());
								  session.setAttribute("login", user1.getLogin());
								  session.setAttribute("password", user1.getPassword());
									
						    	  page="espaceUser";
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
    	        
    	    	return "index";
	 				
//    			}
 		        
 				
    		} 
    	}
       
     }
//    @RequestMapping(value="/Authentification")	
//    public String Authentification(Model model, Utilisateur user , HttpSession session)
//	{
//		
//		String page ="index";
//        String erreur_msg = "";
//        boolean found = false;
//        
//	    try{
//		    		
//					Utilisateur user1 = new Utilisateur();
//					user1.setLogin(session.getAttribute("login").toString());
//					user1.setPassword(session.getAttribute("password").toString());
//					
//					found = serviceUtilisateur.TrouverUtilisateur(user1);
//			         
//					 
//					 
//					 
//					 
//					if( found ) 
//					{
//						
//						if( user1.getProfile().equals("Administrateur") )
//						 {
//							List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes();
//							List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
//							List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
//							model.addAttribute("demandes", demandes);
//							
//							
//							session.setAttribute("idUtilisateur", user1.getIdUtilisateur());
//							session.setAttribute("login", user1.getLogin());
//							session.setAttribute("password", user1.getPassword());
//							
//							model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
//							model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
//							page="espaceAdmin";
//							
//						 }else if( user1.getProfile().equals("Directeur") )
//						    {
//							    List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes();
//								model.addAttribute("demandes", demandes);
//								
//								
//								session.setAttribute("idUtilisateur", user1.getIdUtilisateur());
//								session.setAttribute("login", user1.getLogin());
//								session.setAttribute("password", user1.getPassword());
//								
//							    page="espaceDirecteur";
//							  
//						    }else if( user1.getProfile().equals("Utilisateur") )
//						       {
//						    	  List<Demande> demandes = (List<Demande>) serviceUtilisateur.getAllDemandes(user1.getIdUtilisateur());
//								  model.addAttribute("demandes", demandes);
//								  
//								  session.setAttribute("idUtilisateur", user1.getIdUtilisateur());
//								  session.setAttribute("login", user1.getLogin());
//								  session.setAttribute("password", user1.getPassword());
//									
//						    	  page="espaceUser";
//						       }
//					}else{
//						
//						List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
//						 
//						model.addAttribute("demandes", demandes);
//						session.setAttribute("idUtilisateur", user1.getIdUtilisateur());
//						session.setAttribute("login", user1.getLogin());
//						
//						erreur_msg = "Login ou Mot de passe invalide";
//						
//					}
//					
//					model.addAttribute("erreur_msg", erreur_msg); 
//				
//		      
//		        
//				return page;
//				
//		    }catch(Exception e)
//		    {
//		    	    	
//		    	try{
//    	 
//				 found = serviceUtilisateur.TrouverUtilisateur(user);
//		         
//				 
//					if( found ) 
//					{
//						
//						
//						if( user.getProfile().equals("Administrateur") )
//						 {
//							List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes();
//							List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
//							List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
//							model.addAttribute("demandes", demandes);
//							
//							
//							session.setAttribute("idUtilisateur", user.getIdUtilisateur());
//							session.setAttribute("login", user.getLogin());
//							session.setAttribute("password", user.getPassword());
//							
//							model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
//							model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
//							page="espaceAdmin";
//							
//						 }else if( user.getProfile().equals("Directeur") )
//						    {
//							    List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes();
//								model.addAttribute("demandes", demandes);
//								
//								
//								session.setAttribute("idUtilisateur", user.getIdUtilisateur());
//								session.setAttribute("login", user.getLogin());
//								session.setAttribute("password", user.getPassword());
//								
//							    page="espaceDirecteur";
//							  
//						    }else if( user.getProfile().equals("Utilisateur") )
//						       {
//						    	    List<Demande> demandes = (List<Demande>) serviceUtilisateur.getAllDemandes(user.getIdUtilisateur());
//									model.addAttribute("demandes", demandes);
//									
//									
//									session.setAttribute("idUtilisateur", user.getIdUtilisateur());
//									session.setAttribute("login", user.getLogin());
//									session.setAttribute("password", user.getPassword());
//									
//						    	    page="espaceUser";
//						       }
//					}else{
//						
//						List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
//						 
//						model.addAttribute("demandes", demandes);
//						session.setAttribute("idUtilisateur", user.getIdUtilisateur());
//						session.setAttribute("login", user.getLogin());
//						
//						erreur_msg = "Login ou Mot de passe invalide";
//						
//					}
//					
//					model.addAttribute("erreur_msg", erreur_msg); 
//				
//		        }catch( IllegalStateException e1  )
//		        {
//		        	System.out.println("IllegalStateException");
//		        	List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();	   	
//		            model.addAttribute("demandes", demandes);
//		            
//		            return "index";
//		            
//		        }catch( NullPointerException e2)
//		        {
//		        	System.out.println("NullPointerException");
//		        	List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();	   	
//		            model.addAttribute("demandes", demandes);
//		            
//		            return "index";
//		        }
//		        
//				return page;
//		
//             }
//			
//	}

    
    
    
    
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
		
		return "inscription";
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
		
		return "PlusDetails";
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
		
		return "End";
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
		
		return "End";
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
		
		String code ;
		    
	        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes(date, nomPays, designiationSecteurE, descriptionEntreprise, designiationSecteurD, designiationPartenariat, descriptionDemande, engagement); 	
	        model.addAttribute("demandes", demandes);
		    
//	      code =   "<table class='table table-striped'>";
//		  code +=  "<tr>";
//          code +=  "<form action='FilterDemandes.aspx' method='post' >";
//          code += "<th><button type='submit' style='text-align:right;margin:7px;' class='btn btn-info'>+</button></th>";
//          code += "<th><div id='input_container'><input type='text' id='date' name='date' Placeholder='Date de la demande'  ><img src='img/loope.png' id='input_img'></input></div></th>";
//          code += "<th><input type='text' id='nomPays' name='nomPays' Placeholder='Pays de l'entreprise'  style='max-width:122px;' /></th>";
//		  code += "<th><input type='text' id='designiationSecteurE' name='designiationSecteurE' Placeholder='Secteur d'activité' style='max-width:110px' /></th>";
//          code += "<th><input type='text' id='descriptionEntreprise' name='descriptionEntreprise' onkeyup='load()' Placeholder='Présentation de l'entreprise' style='max-width:200px;'/ ></th>";
//          code += "<th><input type='text' id='designiationSecteurD' name='designiationSecteurD' Placeholder='Secteur objet de partenariat' style='max-width:180px' /></th>";
//          code += "<th><input type='text' id='designiationPartenariat' name='designiationPartenariat' Placeholder='Partenaire recherché'  style='max-width:130px;'/></th>";                                    
//          code += "<th><input type='text' id='descriptionDemande' name='descriptionDemande' Placeholder='Description de la demande'  style='max-width:200px;'/></th>";
//		  code += "<th><input type='text' id='engagement' name='engagement' Placeholder='Engagement' style='max-width:90px' /></th>";
//          code += "</form>";
//            
//          code += "</tr>" ;
//	        
//          
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
          
          model.addAttribute("demandes", demandes);
		return "index";
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
		
		
		return "SousSecteurs";
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
		
		
		return "SousSecteurs";
	}
	
	
	
	@RequestMapping(value="/NousContacter")
	public String NousContacter(Model model,HttpSession session)
	{
		
		
		
		return "NousContacter";
	}
	
	
	@RequestMapping(value="/Statistique")
	public String Statistique(Model model,HttpSession session)
	{
		
		try{
			 
			String ok = session.getAttribute("idUtilisateur").toString();
		
		  return "Statistique";
		   }catch(Exception e)
			{
				session.invalidate();
		    	
		        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
		        model.addAttribute("demandes", demandes);
		        
		    	return "index";
			}
		  
	}
	
}
