package service;

import java.util.List;

import dao.Partenariat;

public interface PartenariatMetier {

	public void AjouterPartenariat(Partenariat partenariat);
	public void SupprimerPartenariat(int idPartenariat);
	public Partenariat getPartenariatbyId(int idPartenariat);
	public List<Partenariat> getAllPartenariats();
	public void ModifierPartenariat(Partenariat partenariat);
	
}
