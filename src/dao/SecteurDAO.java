package dao;

import java.util.List;

import dao.Secteur;

public interface SecteurDAO {

	public void AjouterSecteur(Secteur secteur);
	public void SupprimerSecteur(int idSecteur);
	public Secteur getSecteurbyId(int idSecteur);
	public List<Secteur> getAllSecteurs();
	public List<Secteur> getAllSecteurs(String idSurSecteur);
	public void ModifierSecteur(Secteur idSecteur);
	public List<Secteur> getAllSurSecteurs();
	
	
}
