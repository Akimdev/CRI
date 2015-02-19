package service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import dao.Demande;
import dao.Entreprise;
import dao.EntrepriseDAO;

public class EntrepriseImplMetier implements EntrepriseMetier{

	private EntrepriseDAO dao;
	@Autowired
	PaysMetier serivcePays;
	@Autowired
	SecteurMetier serviceSecteur;
    @Autowired
    UtilisateurMetier serviceUtilisateur;
    @Autowired
    DemandeMetier serviceDemande;
    @Autowired
    PartenariatMetier servicePartenariat;
	
	public EntrepriseDAO getDao() {
		return dao;
	}

	public void setDao(EntrepriseDAO dao) {
		this.dao = dao;
	}

	@Override
	public void AjouterEntreprise(Entreprise entreprise) {
		// TODO Auto-generated method stub
		dao.AjouterEntreprise(entreprise);
	}

	@Override
	public void SupprimerEntreprise(int idEntreprise) {
		// TODO Auto-generated method stub
		dao.SupprimerEntreprise(idEntreprise);
	}

	@Override
	public Entreprise getEntreprisebyId(int idEntreprise) {
		// TODO Auto-generated method stub
		return dao.getEntreprisebyId(idEntreprise);
	}

	@Override
	public List<Entreprise> getAllEntreprise() {
		// TODO Auto-generated method stub
		return dao.getAllEntreprise();
	}

	@Override
	public void ModifierEntreprise(Entreprise entreprise) {
		// TODO Auto-generated method stub
		dao.ModifierEntreprise(entreprise);
	}

	@Override
	public List<Entreprise> getValideEntreprise() {
		// TODO Auto-generated method stub
		return dao.getInValideEntreprise();
	}

	@Override
	public List<Entreprise> getInValideEntreprise() {
		// TODO Auto-generated method stub
		return dao.getInValideEntreprise();
	}

	@Override
	public List<Entreprise> getInValideEntreprise(String nomEntreprise,
												  String nomPays, 
												  String villeEntreprise,
												  String secteur, 
												  String description,
												  String adresseEntreprise,
												  String siteWeb, 
												  String registre, 
												  String nomContact,
												  String prenomContact, 
												  String civilite, 
												  String fonction,
												  String emailContact, 
												  String fix, 
												  String fax) {
		// TODO Auto-generated method stub
		System.out.println("Service"+villeEntreprise);
		return dao.getInValideEntreprise(nomEntreprise, nomPays, villeEntreprise, secteur, description, adresseEntreprise, siteWeb, registre, nomContact, prenomContact, civilite, fonction, emailContact, fix, fax);
	}

	@Override
	public boolean exist(int idEntreprise) {
		// TODO Auto-generated method stub
		return dao.exist(idEntreprise);
	}

	@Override
	public Entreprise getEntreprisebyIdUser(int idUtilisateur) {
		// TODO Auto-generated method stub
		return dao.getEntreprisebyIdUser(idUtilisateur);
	}

	
	
	
//	@Override
//	public String DemandesEntreprises(Model model,HttpSession session)
//	{
//		List<Entreprise> entreprisesInv = (List<Entreprise>) getInValideEntreprise();
//    	List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
//		 
//		model.addAttribute("entreprises", entreprisesInv);
//		model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
//		model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
//		
//    	return "DemandesEntreprises";
//	}
//	
//	@Override
//	public String SupprimerEntreprise(Model model, HttpSession session,
//			String idEntreprise) {
//		// TODO Auto-generated method stub
//		SupprimerEntreprise(Integer.parseInt(idEntreprise));
//		
//		List<Entreprise> entreprisesInv = (List<Entreprise>) getInValideEntreprise();
//    	List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
//    	
//		model.addAttribute("entreprises", entreprisesInv);
//		model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
//		model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
//		
//		return "DemandesEntreprises";
//	}
//
//	@Override
//	public String ValiderEntreprise(Model model, HttpSession session,
//			String idEntreprise, String nomEntreprise,
//			String descriptionEntreprise, String webEntreprise,
//			String nomContact, String prenomContact, String emailContact) {
//		// TODO Auto-generated method stub
//
//		Entreprise entreprise =  getEntreprisebyId(Integer.parseInt(idEntreprise));
//		entreprise.setNomEntreprise(nomEntreprise);
//		entreprise.setDescription(descriptionEntreprise);
//		entreprise.setWebEntreprise(webEntreprise);
//		entreprise.setNomContact(nomContact);
//		entreprise.setPrenomContact(prenomContact);
//		entreprise.setEmailContact(emailContact);
//		entreprise.setValide(true);
//		ModifierEntreprise(entreprise);
//		
//		
//		List<Entreprise> entreprisesInv = (List<Entreprise>) getInValideEntreprise();
//    	List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
//    	
//		model.addAttribute("entreprises", entreprisesInv);
//		model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
//		model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
//		
//		return "DemandesEntreprises";
//	}
//
//	@Override
//	public String FilterEntreprisesInv(Model model, HttpSession session,
//			String nomEntreprise, String nomPays, String villeEntreprise,
//			String secteur, String description, String adresseEntreprise,
//			String siteWeb, String registre, String nomContact,
//			String prenomContact, String civilite, String fonction,
//			String emailContact, String fix, String fax) {
//		// TODO Auto-generated method stub
//
//		System.out.println("Controller"+villeEntreprise);
//	 	List<Entreprise> entreprises = (List<Entreprise>) getInValideEntreprise(nomEntreprise, nomPays, villeEntreprise, secteur, description,adresseEntreprise, siteWeb, registre, nomContact, prenomContact, civilite, fonction, emailContact, fix, fax);
//    	List<Demande> demandesInv = (List<Demande>) serviceDemande.getInvalideDemandes();
//    	List<Entreprise> entreprisesInv = (List<Entreprise>) getInValideEntreprise();
//    	
//		model.addAttribute("entreprises", entreprises);
//		model.addAttribute("nb_DemandesEntreprise", entreprisesInv.size());
//		model.addAttribute("nb_DemandesPartenariat", demandesInv.size());
//		
//    	return "DemandesEntreprises";
//	}
	
	
	
	
}
