package service;

import java.util.List;



import dao.Demande;
import dao.Utilisateur;
import dao.UtilisateurDAO;


public class UtilisateurImplMetier implements UtilisateurMetier{

	private UtilisateurDAO dao;
	
	
	public UtilisateurDAO getDao() {
		return dao;
	}

	public void setDao(UtilisateurDAO dao) {
		this.dao = dao;
	}

	@Override
	public void AjouterUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		dao.AjouterUtilisateur(utilisateur);
	}

	@Override
	public void SupprimerUtilisateur(int idUtilisateur) {
		// TODO Auto-generated method stub
		dao.SupprimerUtilisateur(idUtilisateur);
	}

	@Override
	public Utilisateur getUtilisateurbyId(int idUtilisateur) {
		// TODO Auto-generated method stub
		return dao.getUtilisateurbyId(idUtilisateur);
	}

	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		// TODO Auto-generated method stub
		return dao.getAllUtilisateurs();
	}

	@Override
	public void ModifierUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		dao.ModifierUtilisateur(utilisateur);
	}

	@Override
	public boolean TrouverUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		List<Utilisateur> users = getAllUtilisateurs();
		
		for( int i=0; i<users.size() ; i++)
		{
			if(utilisateur.getLogin().equals(users.get(i).getLogin()) && utilisateur.getPassword().equals(users.get(i).getPassword()))
			{
				utilisateur.setIdUtilisateur(users.get(i).getIdUtilisateur());
				utilisateur.setProfile(users.get(i).getProfile());
				return true;
			}
						
		}
		
		
		return false;
	}

	@Override
	public List<Demande> getAllDemandes(int idUtilisateur) {
		// TODO Auto-generated method stub
		return dao.getAllDemandes(idUtilisateur);
	}

	
	

}
