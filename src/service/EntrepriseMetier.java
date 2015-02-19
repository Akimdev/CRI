package service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import dao.Entreprise;

public interface EntrepriseMetier {

	public void AjouterEntreprise(Entreprise entreprise);
	public void SupprimerEntreprise(int idEntreprise);
	public Entreprise getEntreprisebyId(int idEntreprise);
	public Entreprise getEntreprisebyIdUser(int idUtilisateur);
	public List<Entreprise> getAllEntreprise();
	public List<Entreprise> getValideEntreprise();
	public List<Entreprise> getInValideEntreprise();
	public boolean exist(int idEntreprise);
	public List<Entreprise> getInValideEntreprise(String nomEntreprise
			 ,String nomPays
			 ,String villeEntreprise
			 ,String secteur
			 ,String description
			 ,String adresseEntreprise
			 ,String siteWeb
			 ,String registre
			 ,String nomContact
			 ,String prenomContact
			 ,String civilite
			 ,String fonction
			 ,String emailContact
			 ,String fix
			 ,String fax);
	
	public void ModifierEntreprise(Entreprise idEntreprise);
	
//	public String DemandesEntreprises(Model model,HttpSession session);
//	public String ValiderEntreprise(Model model,HttpSession session,String idEntreprise,String nomEntreprise,String descriptionEntreprise,String webEntreprise,String nomContact,String prenomContact,String emailContact);
//	public String SupprimerEntreprise(Model model,HttpSession session,String idEntreprise);
//	public String FilterEntreprisesInv(Model model,HttpSession session,String nomEntreprise,String nomPays,String villeEntreprise,String secteur,String description,String adresseEntreprise,String siteWeb,String registre,String nomContact,String prenomContact,String civilite,String fonction,String emailContact,String fix,String fax);
}
