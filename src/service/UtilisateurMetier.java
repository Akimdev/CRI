package service;

import java.util.List;

import dao.Demande;
import dao.Utilisateur;

public interface UtilisateurMetier {

	public void AjouterUtilisateur(Utilisateur utilisateur);
	public void SupprimerUtilisateur(int idUtilisateur);
	public Utilisateur getUtilisateurbyId(int idUtilisateur);
	public List<Utilisateur> getAllUtilisateurs();
	public List<Demande> getAllDemandes(int idUtilisateur);
	public void ModifierUtilisateur(Utilisateur idUtilisateur);
	public boolean TrouverUtilisateur(Utilisateur utilisateur);
}
