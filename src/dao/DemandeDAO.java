package dao;

import java.util.List;

public interface DemandeDAO {

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
		
}
