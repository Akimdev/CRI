package service;

import java.util.List;


import dao.Demande;
import dao.DemandeDAO;
import dao.DemandeId;

public class DemandeImplMetier implements DemandeMetier{

	private DemandeDAO dao;
	
	public DemandeDAO getDao() {
		return dao;
	}

	public void setDao(DemandeDAO dao) {
		this.dao = dao;
	}

	
	@Override
	public void AjouterDemande(Demande demande) {
		// TODO Auto-generated method stub
		dao.AjouterDemande(demande);
	}

	@Override
	public void SupprimerDemande(DemandeId idDemande) {
		// TODO Auto-generated method stub
		dao.SupprimerDemande(idDemande);
	}

	@Override
	public Demande getDemandebyId(DemandeId idDemande) {
		// TODO Auto-generated method stub
		return dao.getDemandebyId(idDemande);
	}

	@Override
	public List<Demande> getAllDemandes() {
		// TODO Auto-generated method stub
		return dao.getAllDemandes();
	}

	@Override
	public void ModifierDemande(Demande demande) {
		// TODO Auto-generated method stub
		dao.ModifierDemande(demande);
	}

	@Override
	public List<Demande> getValideDemandes() {
		// TODO Auto-generated method stub
		return dao.getValideDemandes();
	}

	@Override
	public List<Demande> getInvalideDemandes() {
		// TODO Auto-generated method stub
		return dao.getInvalideDemandes();
	}

	@Override
	public List<Demande> getValideDemandes(String date, String nomPays,
			String designiationSecteurE, String descriptionEntreprise,
			String designiationSecteurD, String designiationPartenariat,
			String descriptionDemande, String engagement) {
		// TODO Auto-generated method stub
		return dao.getValideDemandes(date, nomPays, designiationSecteurE, descriptionEntreprise, designiationSecteurD, designiationPartenariat, descriptionDemande, engagement);
	}

	@Override
	public List<Demande> getValideDemandes(String date, String nomEntreprise,
			String nomPays, String designiationSecteurE,
			String descriptionEntreprise, String siteWeb, String nomContact,
			String prenomContact, String emailContact,
			String designiationSecteurD, String designiationPartenariat,
			String descriptionDemande, String engagement) {
		// TODO Auto-generated method stub
		return dao.getValideDemandes(date, nomEntreprise, nomPays, designiationSecteurE, descriptionEntreprise, siteWeb, nomContact, prenomContact, emailContact, designiationSecteurD, designiationPartenariat, descriptionDemande, engagement);
	}

	
	
	
	
	
	

	
//	  @Override
//	  public String DemandesDePartenariat(Model model,HttpSession session)
//	  {
//		    List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
//	    	List<Demande> demandesInv = (List<Demande>) getInvalideDemandes();
//	    	
//			model.addAttribute("demandes", demandesInv);
//			model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
//			model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
//			
//	    	return "espaceAdmin";
//	  }
//
//	  
//	@Override
//	public String SupprimerDemande(Model model, HttpSession session,
//			String idEntreprise, String idSecteur, String idPartenariat) {
//		// TODO Auto-generated method stub
//		
//		
//		DemandeId demandeId = new DemandeId(Integer.parseInt(idEntreprise),Integer.parseInt(idSecteur),Integer.parseInt(idPartenariat));
//		
//		SupprimerDemande(demandeId);
//		serviceEntreprise.SupprimerEntreprise(Integer.parseInt(idEntreprise));
//		
//		List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
//    	List<Demande> demandesInv = (List<Demande>) getInvalideDemandes();
//    	
//		model.addAttribute("demandes", demandesInv);
//		model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
//		model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
//		
//		return "espaceAdmin";
//	}
//
//	@Override
//	public String ValiderDemande(Model model, HttpSession session,
//			String password, String profile, String idEntreprise,
//			String idSecteur, String idPartenariat, String nomEntreprise,
//			String descriptionEntreprise, String webEntreprise,
//			String nomContact, String prenomContact, String emailContact,
//			String descriptionDemande) {
//		// TODO Auto-generated method stub
//Entreprise entreprise =  serviceEntreprise.getEntreprisebyId(Integer.parseInt(idEntreprise));
//		
//		entreprise.setNomEntreprise(nomEntreprise);
//		entreprise.setDescription(descriptionEntreprise);
//		entreprise.setWebEntreprise(webEntreprise);
//		entreprise.setNomContact(nomContact);
//		entreprise.setPrenomContact(prenomContact);
//		entreprise.setEmailContact(emailContact);
//		entreprise.setValide(true);
//		
//		// J'ai modifier ici
////		if( !serviceEntreprise.exist(Integer.parseInt(idEntreprise)) )
////		{/
//			System.out.println("11");
//			Utilisateur SurUser = serviceUtilisateur.getUtilisateurbyId(Integer.parseInt(session.getAttribute("idUtilisateur").toString()));
//			Utilisateur user = new Utilisateur(SurUser,emailContact,password,nomEntreprise,"Entreprise",profile);
//			user.setFonction(entreprise.getFonctionContact());
//			serviceUtilisateur.AjouterUtilisateur(user);
//			List<Utilisateur> u = serviceUtilisateur.getAllUtilisateurs();
//			
//			entreprise.setUtilisateur(u.get(u.size()-1));
//			System.out.println("22");
////		}
//		
//		serviceEntreprise.ModifierEntreprise(entreprise);
//		System.out.println("33");
//		DemandeId idDemande = new DemandeId(Integer.parseInt(idEntreprise),Integer.parseInt(idSecteur),Integer.parseInt(idPartenariat));
//		Demande demande = getDemandebyId(idDemande);
//		demande.setDescription(descriptionDemande);
//		demande.setValide(true);
//		ModifierDemande(demande);
//		System.out.println("44");
//		List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
//    	List<Demande> demandesInv = (List<Demande>) getInvalideDemandes();
//    	
//		model.addAttribute("demandes", demandesInv);
//		model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
//		model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
//		
//		return "espaceAdmin";
//	}
//
//	@Override
//	public String FilterDemandes(Model model, HttpSession session, String date,
//			String nomEntreprise, String nomPays, String designiationSecteurE,
//			String descriptionEntreprise, String siteWeb, String nomContact,
//			String prenomContact, String emailContact,
//			String designiationSecteurD, String designiationPartenariat,
//			String descriptionDemande, String engagement) {
//		// TODO Auto-generated method stub
//		
//		    List<Demande> demandes = (List<Demande>) getValideDemandes(date, nomEntreprise, nomPays, designiationSecteurE, descriptionEntreprise, siteWeb, nomContact, prenomContact, emailContact, designiationSecteurD, designiationPartenariat, descriptionDemande, engagement);	
//	        model.addAttribute("demandes", demandes);
//	        
//			List<Entreprise> entreprisesInv = (List<Entreprise>) serviceEntreprise.getInValideEntreprise();
//	    	List<Demande> demandesInv = (List<Demande>) getInvalideDemandes();
//	    	
//		
//			model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
//			model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
//	        
//	        return "espaceAdmin";
//	         
//	}


	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	
}
