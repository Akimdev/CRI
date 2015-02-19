package service;

import java.util.List;

import dao.Partenariat;
import dao.PartenariatDAO;

public class PartenariatImplMetier implements PartenariatMetier {

	private PartenariatDAO dao;
	
	public PartenariatDAO getDao() {
		return dao;
	}

	public void setDao(PartenariatDAO dao) {
		this.dao = dao;
	}

	@Override
	public void AjouterPartenariat(Partenariat partenariat) {
		// TODO Auto-generated method stub
		dao.AjouterPartenariat(partenariat);
	}

	@Override
	public void SupprimerPartenariat(int idPartenariat) {
		// TODO Auto-generated method stub
		dao.SupprimerPartenariat(idPartenariat);
	}

	@Override
	public Partenariat getPartenariatbyId(int idPartenariat) {
		// TODO Auto-generated method stub
		return dao.getPartenariatbyId(idPartenariat);
	}

	@Override
	public List<Partenariat> getAllPartenariats() {
		// TODO Auto-generated method stub
		return dao.getAllPartenariats();
	}

	@Override
	public void ModifierPartenariat(Partenariat partenariat) {
		// TODO Auto-generated method stub
		dao.ModifierPartenariat(partenariat);
	}

}
