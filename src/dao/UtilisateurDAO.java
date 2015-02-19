package dao;

import java.util.List;

public interface UtilisateurDAO {

	public void AjouterUtilisateur(Utilisateur utilisateur);
	public void SupprimerUtilisateur(int idUtilisateur);
	public Utilisateur getUtilisateurbyId(int idUtilisateur);
	public List<Utilisateur> getAllUtilisateurs();
	public List<Demande> getAllDemandes(int idUtilisateur);
	public void ModifierUtilisateur(Utilisateur idSecteur);
	
	
}
