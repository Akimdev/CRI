package service;

import java.util.List;

import dao.Pays;

public interface PaysMetier {

	public void AjouterPays(Pays pays);
	public void SupprimerPays(int idPays);
	public Pays getPaysbyId(int idPays);
	public List<Pays> getAllPays();
	public void ModifierPays(Pays idPays);
	
}
