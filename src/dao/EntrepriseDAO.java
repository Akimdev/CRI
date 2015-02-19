package dao;

import java.util.List;

public interface EntrepriseDAO {

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
												 ,String desccription
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
	
}
