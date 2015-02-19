package service;

import java.util.List;

import dao.SecteurDAO;
import dao.Secteur;

public class SecteurImplMetier implements SecteurMetier {

	SecteurDAO dao;
	
	public SecteurDAO getDao() {
		return dao;
	}

	public void setDao(SecteurDAO dao) {
		this.dao = dao;
	}

	@Override
	public void AjouterSecteur(Secteur secteur) {
		// TODO Auto-generated method stub
		dao.AjouterSecteur(secteur);
	}

	@Override
	public void SupprimerSecteur(int idSecteur) {
		// TODO Auto-generated method stub
		dao.SupprimerSecteur(idSecteur);
	}

	@Override
	public Secteur getSecteurbyId(int idSecteur) {
		// TODO Auto-generated method stub
		return dao.getSecteurbyId(idSecteur);
	}

	@Override
	public List<Secteur> getAllSecteurs() {
		// TODO Auto-generated method stub
		return dao.getAllSecteurs();
	}

	@Override
	public List<Secteur> getAllSurSecteurs() {
		// TODO Auto-generated method stub
		return dao.getAllSurSecteurs();
	}

	@Override
	public List<Secteur> getAllSecteurs(String idSurSecteur) {
		// TODO Auto-generated method stub
		return dao.getAllSecteurs(idSurSecteur);
	}
	
	
	@Override
	public void ModifierSecteur(Secteur idSecteur) {
		// TODO Auto-generated method stub
		dao.ModifierSecteur(idSecteur);
	}





}
