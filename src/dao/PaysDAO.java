package dao;

import java.util.List;

public interface PaysDAO {

	public void AjouterPays(Pays pays);
	public void SupprimerPays(int idPays);
	public Pays getPaysbyId(int idPays);
	public List<Pays> getAllPays();
	public void ModifierPays(Pays idPays);
	
}
