package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;
import javax.mail.internet.MimeMessage;
import org.hibernate.exception.ConstraintViolationException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.Demande;
import dao.DemandeId;
import dao.Entreprise;
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
public class AdminController {

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
    @Autowired
    private JavaMailSender mailSender;
    
    @RequestMapping(value="/DemandesEntreprises")
    public String DemandesEntreprises(Model model
			   ,HttpSession session)
    {
    	try{
    		String ok = session.getAttribute("idUtilisateur").toString();
    		
	    	List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
	    	List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
			 
			model.addAttribute("entreprises", entreprisesInv);
			model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
			model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
			
	    	return "DemandesEntreprises";
	    	
	    }catch(Exception e)
		{
			session.invalidate();
	    	
	        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
	        model.addAttribute("demandes", demandes);
	        
	    	return "index";
		}
    	
//    	return serviceEntreprise.DemandesEntreprises(model,session);
    }
    
    
    
    @RequestMapping(value="/DemandesDePartenariat")
    public String DemandesDePartenariat(Model model
			   ,HttpSession session)
    {
    	
    	try{
    		String ok = session.getAttribute("idUtilisateur").toString();
    		
	    	List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
	    	List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
	    	
			model.addAttribute("demandes", demandesInv);
			model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
			model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
			
	    	return "espaceAdmin";
	    	
	    }catch(Exception e)
	  		{
	  			session.invalidate();
	  	    	
	  	        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
	  	        model.addAttribute("demandes", demandes);
	  	        
	  	    	return "index";
	  		}
    
//		return DemandesDePartenariat(model ,session);
    
    }
    
    
    
    
    
    
	@RequestMapping(value="/SupprimerDemande")
	public String SupprimerDemande(Model model
								   ,HttpSession session
								   ,@RequestParam String idEntreprise
								   ,@RequestParam String idSecteur
								   ,@RequestParam String idPartenariat)
	{
		try{
    		String ok = session.getAttribute("idUtilisateur").toString();
    		
			DemandeId demandeId = new DemandeId(Integer.parseInt(idEntreprise),Integer.parseInt(idSecteur),Integer.parseInt(idPartenariat));
			Entreprise e = serviceEntreprise.getEntreprisebyId(Integer.parseInt(idEntreprise));
			System.out.print("Avant Suppression");
			serviceDemande.SupprimerDemande(demandeId);
			System.out.print("Apres Suppression");
			if( !e.isValide() )
			{
				serviceEntreprise.SupprimerEntreprise(Integer.parseInt(idEntreprise));
			}
			
			List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
	    	List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
	    	List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes(); 
	    	
			model.addAttribute("demandes", demandes);
			model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
			model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
			
			return "espaceAdmin";
			
		   }catch(Exception e)
	  		{
	  			session.invalidate();
	  	    	
	  	        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
	  	        model.addAttribute("demandes", demandes);
	  	        
	  	    	return "index";
	  		}
		
//		return SupprimerDemande(model,session,idEntreprise,idSecteur,idPartenariat);
		
	}
	

	@RequestMapping(value="/ValiderDemande")
	public String ValiderDemande(Model model
								,HttpSession session
								,@RequestParam String password
								,@RequestParam String profile
								,@RequestParam String idEntreprise
								,@RequestParam String idSecteur
								,@RequestParam String idPartenariat
								,@RequestParam String nomEntreprise
								,@RequestParam String descriptionEntreprise
								,@RequestParam String webEntreprise
								,@RequestParam String nomContact
								,@RequestParam String prenomContact
								,@RequestParam String emailContact
								,@RequestParam String descriptionDemande)
	{
		try{
    		String ok = session.getAttribute("idUtilisateur").toString();
    		
			System.out.println("111");
			Entreprise entreprise =  serviceEntreprise.getEntreprisebyId(Integer.parseInt(idEntreprise));
			System.out.println("222");
			if( !entreprise.isValide() )
			{
				entreprise.setNomEntreprise(nomEntreprise);
				entreprise.setDescription(descriptionEntreprise);
				entreprise.setWebEntreprise(webEntreprise);
				entreprise.setNomContact(nomContact);
				entreprise.setPrenomContact(prenomContact);
				entreprise.setEmailContact(emailContact);
				entreprise.setValide(true);
			
	
				Utilisateur SurUser = serviceUtilisateur.getUtilisateurbyId(Integer.parseInt(session.getAttribute("idUtilisateur").toString()));
				Utilisateur user = new Utilisateur(SurUser,emailContact,password,nomEntreprise,"Entreprise",profile);
				user.setFonction(entreprise.getFonctionContact());
				serviceUtilisateur.AjouterUtilisateur(user);
				List<Utilisateur> u = serviceUtilisateur.getAllUtilisateurs();
				
				entreprise.setUtilisateur(u.get(u.size()-1));
	
			
				serviceEntreprise.ModifierEntreprise(entreprise);
			}
	
			DemandeId idDemande = new DemandeId(Integer.parseInt(idEntreprise),Integer.parseInt(idSecteur),Integer.parseInt(idPartenariat));
			System.out.println("333");
			Demande demande = serviceDemande.getDemandebyId(idDemande);
			System.out.println("444");
			demande.setDescription(descriptionDemande);
			demande.setValide(true);
			serviceDemande.ModifierDemande(demande);
			System.out.println("555");
			List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
	    	List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
	    	List<Demande> demandes = (List<Demande>) serviceDemande.getAllDemandes();
	    	
			model.addAttribute("demandes", demandes);
			model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
			model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
			
			return "espaceAdmin";
		
	   }catch(Exception e)
 		{
 			session.invalidate();
 	    	
 	        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
 	        model.addAttribute("demandes", demandes);
 	        
 	    	return "index";
 		}
		
//		return ValiderDemande(model,session,password,profile,idEntreprise,idSecteur,idPartenariat,nomEntreprise,descriptionEntreprise,webEntreprise,nomContact,prenomContact,emailContact,descriptionDemande);
	}
	
	
	
	
	
	@RequestMapping(value="/SupprimerEntreprise")
	public String SupprimerEntreprise(Model model
								   ,HttpSession session
								   ,@RequestParam String idEntreprise)
	{
		try{
	    		String ok = session.getAttribute("idUtilisateur").toString();
		    		
				serviceEntreprise.SupprimerEntreprise(Integer.parseInt(idEntreprise));
				
				List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
		    	List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
		    	
				model.addAttribute("entreprises", entreprisesInv);
				model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
				model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
				
				return "DemandesEntreprises";
				
		   }catch(Exception e)
	 		{
	 			session.invalidate();
	 	    	
	 	        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
	 	        model.addAttribute("demandes", demandes);
	 	        
	 	    	return "index";
	 		}
//		return SupprimerEntreprise(model,session,idEntreprise);
	}
	

	@RequestMapping(value="/ValiderEntreprise")
	public String ValiderEntreprise(Model model
								,HttpSession session
								,@RequestParam String password
								,@RequestParam String profile
								,@RequestParam String idEntreprise
								,@RequestParam String nomEntreprise
								,@RequestParam String adresseEntreprise
								,@RequestParam String villeEntreprise
								,@RequestParam String description
								,@RequestParam String webEntreprise
								,@RequestParam String nomContact
								,@RequestParam String prenomContact
								,@RequestParam String fonctionContact
								,@RequestParam String emailContact
								,@RequestParam String telContact
								,@RequestParam String faxContact)
	{
		
		try{
	    		String ok = session.getAttribute("idUtilisateur").toString();
	    		
				Entreprise entreprise = serviceEntreprise.getEntreprisebyId(Integer.parseInt(idEntreprise));
				entreprise.setNomEntreprise(nomEntreprise);
				entreprise.setAdresseEntreprise(adresseEntreprise);
				entreprise.setVilleEntreprise(villeEntreprise);
				entreprise.setDescription(description);
				entreprise.setWebEntreprise(webEntreprise);
				entreprise.setNomContact(prenomContact);
				entreprise.setPrenomContact(prenomContact);
				entreprise.setFonctionContact(fonctionContact);
				entreprise.setEmailContact(emailContact);
				entreprise.setTelContact(telContact);
				entreprise.setFaxContact(faxContact);
				entreprise.setValide(true);
				
				Utilisateur SurUser = serviceUtilisateur.getUtilisateurbyId(Integer.parseInt(session.getAttribute("idUtilisateur").toString()));
				Utilisateur user = new Utilisateur(SurUser,emailContact,password,nomEntreprise,"Entreprise",profile);
				user.setFonction(fonctionContact);
				serviceUtilisateur.AjouterUtilisateur(user);
				List<Utilisateur> u = serviceUtilisateur.getAllUtilisateurs();
				
				entreprise.setUtilisateur(u.get(u.size()-1));
				
				
//				
//				serviceEntreprise.ModifierEntreprise(entreprise);
//				final String email = emailContact;
//				final String pass = password;
//			      mailSender.send(new MimeMessagePreparator() {
//				@Override
//	            public void prepare(MimeMessage mimeMessage) throws Exception {
//	                MimeMessageHelper messageHelper = new MimeMessageHelper(
//	                        mimeMessage, true, "UTF-8");
//	                messageHelper.setTo(email);
//	                messageHelper.setSubject("Comfirmation");
//	                messageHelper.setText("Votre login est votre email, et votre mot de passe et '"+pass+"'");
//	                 
//	                }
//			      });
				
				SimpleMailMessage mailMessage = new SimpleMailMessage();

				mailMessage.setTo("saifiothmane@gmail.com");
				mailMessage.setSubject("This is the test message for testing gmail smtp server using spring mail");
				mailMessage.setFrom("saifipgm@gmail.com");
				mailMessage.setText("This is the test message for testing gmail smtp server using spring mail. \n" +
				        "Thanks \n Regards \n Saurabh ");
				mailSender.send(mailMessage);
			
				List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
		    	List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
		    	
				model.addAttribute("entreprises", entreprisesInv);
				model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
				model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
				
				return "DemandesEntreprises";
		
	   }catch(Exception e)
	 		{
	 			session.invalidate();
	 	    	
	 	        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
	 	        model.addAttribute("demandes", demandes);
	 	        
	 	    	return "index";
	 		}
//		return ValiderEntreprise(model,session,idEntreprise,nomEntreprise,descriptionEntreprise,webEntreprise,nomContact,prenomContact,emailContact);
	}
	
	
	
	@RequestMapping(value="/FilterDemandesInv")
	public String FilterDemandes(Model model
								,HttpSession session
								,@RequestParam String date
								,@RequestParam String nomEntreprise
								,@RequestParam String nomPays
								,@RequestParam String designiationSecteurE
								,@RequestParam String descriptionEntreprise
								,@RequestParam String siteWeb
								,@RequestParam String nomContact
								,@RequestParam String prenomContact
								,@RequestParam String emailContact
								,@RequestParam String designiationSecteurD
								,@RequestParam String designiationPartenariat
								,@RequestParam String descriptionDemande
								,@RequestParam String engagement)
	{
		
		try{
	    		String ok = session.getAttribute("idUtilisateur").toString();
	    		
		        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes(date, nomEntreprise, nomPays, designiationSecteurE, descriptionEntreprise, siteWeb, nomContact, prenomContact, emailContact, designiationSecteurD, designiationPartenariat, descriptionDemande, engagement);	
		        model.addAttribute("demandes", demandes);
		        
				List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
		    	List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
		    	
			
				model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
				model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
		        
		        return "espaceAdmin";
		        
		  }catch(Exception e)
	 		{
	 			session.invalidate();
	 	    	
	 	        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
	 	        model.addAttribute("demandes", demandes);
	 	        
	 	    	return "index";
	 		}
//	        return FilterDemandes(model,session,date,nomEntreprise,nomPays,designiationSecteurE,descriptionEntreprise,siteWeb,nomContact,prenomContact,emailContact,designiationSecteurD,designiationPartenariat,descriptionDemande,engagement);
	        
	}
    
    
	@RequestMapping(value="/FilterEntreprisesInv")
	public String FilterEntreprisesInv(Model model,
			 HttpSession session,
			 @RequestParam String nomEntreprise,
			 @RequestParam String nomPays, 
			 @RequestParam String villeEntreprise,
			 @RequestParam String secteur, 
			 @RequestParam String description,
			 @RequestParam String adresseEntreprise,
			 @RequestParam String siteWeb, 
			 @RequestParam String registre, 
			 @RequestParam String nomContact,
			 @RequestParam String prenomContact, 
			 @RequestParam String civilite, 
			 @RequestParam String fonction,
			 @RequestParam String emailContact, 
			 @RequestParam String fix, 
			 @RequestParam String fax)
	{
		
		try{
	    		String ok = session.getAttribute("idUtilisateur").toString();
		    		
				System.out.println("Controller"+villeEntreprise);
			 	List<Entreprise> entreprises = (List<Entreprise>) serviceEntreprise.getInValideEntreprise(nomEntreprise, nomPays, villeEntreprise, secteur, description,adresseEntreprise, siteWeb, registre, nomContact, prenomContact, civilite, fonction, emailContact, fix, fax);
		    	List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
		    	List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
		    	
				model.addAttribute("entreprises", entreprises);
				model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
				model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
				
		    	return "DemandesEntreprises";
    	
		  }catch(Exception e)
			{
				session.invalidate();
		    	
		        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
		        model.addAttribute("demandes", demandes);
		        
		    	return "index";
			}
		
//		return 	FilterEntreprisesInv(model,session,nomEntreprise,nomPays,villeEntreprise,secteur,description,adresseEntreprise,siteWeb,registre,nomContact,prenomContact,civilite,fonction,emailContact,fix,fax);
	}
	
	
	
	@RequestMapping(value="/GestionUtilisateurs")
	public String GestionUtilisateurs(Model model,HttpSession session )
	{
		try{
	    		String ok = session.getAttribute("idUtilisateur").toString();
	    		
				List<Utilisateur> utilisateurs = serviceUtilisateur.getAllUtilisateurs();
				model.addAttribute("utilisateurs", utilisateurs);
				
				return "GestionUtilisateurs";

		  }catch(Exception e)
			{
				session.invalidate();
		    	
		        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
		        model.addAttribute("demandes", demandes);
		        
		    	return "index";
			}
		
	}
	
	@RequestMapping(value="/SourceUtilisateur")
	public String SourceUtilisateur(Model model,HttpSession session,@RequestParam String idUtilisateur)
	{
		try{
    		String ok = session.getAttribute("idUtilisateur").toString();
    		
		    List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
			utilisateurs.add(serviceUtilisateur.getUtilisateurbyId(Integer.parseInt(idUtilisateur)));
			model.addAttribute("utilisateurs", utilisateurs);
			return "GestionUtilisateurs";
		

		  }catch(Exception e)
			{
				session.invalidate();
		    	
		        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
		        model.addAttribute("demandes", demandes);
		        
		    	return "index";
			}
		}
	
	
	@RequestMapping(value="/AjouterUtilisateur")
	public String AjouterUtilisateur(Model model,HttpSession session )
	{
		
		try{
    		String ok = session.getAttribute("idUtilisateur").toString();
    		
    		List<Utilisateur> utilisateurs = serviceUtilisateur.getAllUtilisateurs();
			model.addAttribute("utilisateurs", utilisateurs);
			
			return "AjouterUtilisateur";
			
		 }catch(Exception e)
			{
				session.invalidate();
		    	
		        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
		        model.addAttribute("demandes", demandes);
		        
		    	return "index";
			}
		
	}
	
	@RequestMapping(value="/ValiderUtilisateur")
	public String ValiderUtilisateur(Model model,HttpSession session,Utilisateur utilisateur )
	{
		try{
	    		String ok = session.getAttribute("idUtilisateur").toString();
	    		
				utilisateur.setUtilisateur( serviceUtilisateur.getUtilisateurbyId(Integer.parseInt(session.getAttribute("idUtilisateur").toString()))  );
				serviceUtilisateur.AjouterUtilisateur(utilisateur);
				List<Utilisateur> utilisateurs = serviceUtilisateur.getAllUtilisateurs();
				model.addAttribute("utilisateurs", utilisateurs);
				
				return "GestionUtilisateurs";
		
		 }catch(Exception e)
			{
				session.invalidate();
		    	
		        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
		        model.addAttribute("demandes", demandes);
		        
		    	return "index";
			}
	}
	
	@RequestMapping(value="/SupprimerUtilisateur")
	public String SupprimerUtilisateur(Model model,HttpSession session,@RequestParam String idUtilisateur )
	{
		try{
    		String ok = session.getAttribute("idUtilisateur").toString();
    		
			serviceUtilisateur.SupprimerUtilisateur(Integer.parseInt(idUtilisateur));
			List<Utilisateur> utilisateurs = serviceUtilisateur.getAllUtilisateurs();
			model.addAttribute("utilisateurs", utilisateurs);
			
			return "GestionUtilisateurs";
			
		 }catch(Exception e)
			{
				session.invalidate();
		    	
		        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
		        model.addAttribute("demandes", demandes);
		        
		    	return "index";
			}
	}
	
	
	@RequestMapping(value="/AjouterSecteur")
	public String AjouterSecteur(Model model,HttpSession session )
	{
		try{
    		String ok = session.getAttribute("idUtilisateur").toString();
    		
			List<Secteur> SurSecteurs = (List<Secteur>) serviceSecteur.getAllSurSecteurs();
			List<Secteur> SousSecteurs = (List<Secteur>) serviceSecteur.getAllSecteurs(SurSecteurs.get(0).getIdSecteur().toString()); 
			
			model.addAttribute("SurSecteurs", SurSecteurs);
			model.addAttribute("SousSecteurs", SousSecteurs);
			
			return "AjouterSecteur";
			
		 }catch(Exception e)
			{
				session.invalidate();
		    	
		        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
		        model.addAttribute("demandes", demandes);
		        
		    	return "index";
			}
	}
	
	@RequestMapping(value="/ValiderSecteur")
	public String ValiderSecteur(Model model,HttpSession session,Secteur secteur)
	{
		try{
			
    		String ok = session.getAttribute("idUtilisateur").toString();
    		
			serviceSecteur.AjouterSecteur(secteur);
			
			List<Secteur> SurSecteurs = (List<Secteur>) serviceSecteur.getAllSurSecteurs();
			  
			model.addAttribute("SurSecteurs", SurSecteurs);
			model.addAttribute("msgAjSect", "Secteur bien ajouté");
			
			return "AjouterSecteur";
			
		 }catch(Exception e)
			{
				session.invalidate();
		    	
		        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
		        model.addAttribute("demandes", demandes);
		        
		    	return "index";
			}
		
		
	}
	
	@RequestMapping(value="/ValiderSousSecteur")
	public String ValiderSousSecteur(Model model,HttpSession session,@RequestParam String idSurSecteur,Secteur secteur)
	{
		try{
			
    		String ok = session.getAttribute("idUtilisateur").toString();
			Secteur sur = serviceSecteur.getSecteurbyId(Integer.parseInt(idSurSecteur));
			secteur.setSecteur(sur);
			serviceSecteur.AjouterSecteur(secteur);
			
			List<Secteur> SurSecteurs = (List<Secteur>) serviceSecteur.getAllSurSecteurs();
			  
			model.addAttribute("SurSecteurs", SurSecteurs);
			model.addAttribute("msgAjSousSect", "Sous-secteur bien ajouté");
			
			return "AjouterSecteur";
		
		 }catch(Exception e)
			{
				session.invalidate();
		    	
		        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
		        model.addAttribute("demandes", demandes);
		        
		    	return "index";
			}
			
	}
	
	
	@SuppressWarnings("finally")
	@RequestMapping(value=("/SupprimerSecteur"))
	public String SupprimerSecteur(Model model,HttpSession session,@RequestParam String idSecteur)
	{
		try{
	 
			String ok = session.getAttribute("idUtilisateur").toString();
				try{
					serviceSecteur.SupprimerSecteur(Integer.parseInt(idSecteur));
					model.addAttribute("msgSupSect", "Sous-secteur bien supprimé");
				}catch(ConstraintViolationException e)
				{
					model.addAttribute("msgSupSect", "Vous ne pouvez pas le supprimer, des sous-secteurs y sont attachés. proceder à leurs suppression tout d'abord");
				}finally
				{
					List<Secteur> SurSecteurs = (List<Secteur>) serviceSecteur.getAllSurSecteurs();
					List<Secteur> SousSecteurs = (List<Secteur>) serviceSecteur.getAllSecteurs(SurSecteurs.get(0).getIdSecteur().toString()); 
					
					model.addAttribute("SurSecteurs", SurSecteurs);
					model.addAttribute("SousSecteurs", SousSecteurs);
					return "AjouterSecteur";
				}
				
		}catch(Exception e)
		{
			session.invalidate();
	    	
	        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
	        model.addAttribute("demandes", demandes);
	        
	    	return "index";
		}
		
	}
	
	@RequestMapping(value=("/SupprimerSousSecteur"))
	public String SupprimerSousSecteur(Model model,HttpSession session,@RequestParam String idSecteur)
	{
		try{
			 
			String ok = session.getAttribute("idUtilisateur").toString();
			
				serviceSecteur.SupprimerSecteur(Integer.parseInt(idSecteur));
				List<Secteur> SurSecteurs = (List<Secteur>) serviceSecteur.getAllSurSecteurs();
				List<Secteur> SousSecteurs = (List<Secteur>) serviceSecteur.getAllSecteurs(SurSecteurs.get(0).getIdSecteur().toString()); 
				
				model.addAttribute("SurSecteurs", SurSecteurs);
				model.addAttribute("SousSecteurs", SousSecteurs);
				model.addAttribute("msgSupSousSect", "Sous-secteur bien supprimé");
				return "AjouterSecteur";
				
			}catch(Exception e)
			{
				session.invalidate();
		    	
		        List<Demande> demandes = (List<Demande>) serviceDemande.getValideDemandes();
		        model.addAttribute("demandes", demandes);
		        
		    	return "index";
			}
	}
	
	
	
	
	
}
