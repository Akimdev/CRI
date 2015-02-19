package dao;

import java.util.List;

public interface PartenariatDAO {

	public void AjouterPartenariat(Partenariat partenariat);
	public void SupprimerPartenariat(int idPartenariat);
	public Partenariat getPartenariatbyId(int idPartenariat);
	public List<Partenariat> getAllPartenariats();
	public void ModifierPartenariat(Partenariat partenariat);
	
	
}
