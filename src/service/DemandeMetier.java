package service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import dao.Demande;
import dao.DemandeId;

public interface DemandeMetier {

	public void AjouterDemande(Demande demande);
	public void SupprimerDemande(DemandeId idDemande);
	public Demande getDemandebyId(DemandeId demandeId);
	public List<Demande> getAllDemandes();
	public List<Demande> getValideDemandes();
	
	public List<Demande> getValideDemandes(String date
										  ,String nomPays
										  ,String designiationSecteurE
										  ,String descriptionEntreprise
										  ,String designiationSecteurD
										  ,String designiationPartenariat
										  ,String descriptionDemande
										  ,String engagement);
	
	public List<Demande> getValideDemandes(String date
			  ,String nomEntreprise
			  ,String nomPays
			  ,String designiationSecteurE
			  ,String descriptionEntreprise
			  ,String siteWeb
			  ,String nomContact
			  ,String prenomContact
			  ,String emailContact
			  ,String designiationSecteurD
			  ,String designiationPartenariat
			  ,String descriptionDemande
			  ,String engagement);
	
	
	public List<Demande> getInvalideDemandes();
	public void ModifierDemande(Demande demande);
	
	
	
//	public String DemandesDePartenariat(Model model,HttpSession session);
//	public String SupprimerDemande(Model model,HttpSession session,String idEntreprise,String idSecteur,String idPartenariat);
//	public String ValiderDemande(Model model,HttpSession session,String password,String profile,String idEntreprise,String idSecteur,String idPartenariat,String nomEntreprise,String descriptionEntreprise,String webEntreprise,String nomContact,String prenomContact,String emailContact,String descriptionDemande);
//	public String FilterDemandes(Model model,HttpSession session,String date,@RequestParam String nomEntreprise,String nomPays,String designiationSecteurE,@RequestParam String descriptionEntreprise,String siteWeb,String nomContact,String prenomContact,String emailContact,String designiationSecteurD,String designiationPartenariat,String descriptionDemande,String engagement);
//	
}
