package service;

import java.util.List;

import dao.PaysDAO;
import dao.Pays;

public class PaysImplMetier implements PaysMetier{

	private PaysDAO dao;
	
	
	public PaysDAO getDao() {
		return dao;
	}

	public void setDao(PaysDAO dao) {
		this.dao = dao;
	}

	@Override
	public void AjouterPays(Pays pays) {
		// TODO Auto-generated method stub
		
		dao.AjouterPays(pays);
		
	}
	
    @Override
	public void SupprimerPays(int idPays) {
		// TODO Auto-generated method stub
		
		dao.SupprimerPays(idPays);
		
	}

	@Override
	public Pays getPaysbyId(int idPays) {
		// TODO Auto-generated method stub
		return dao.getPaysbyId(idPays);
	}

	@Override
	public List<Pays> getAllPays() {
		// TODO Auto-generated method stub
		return dao.getAllPays();
	}

	@Override
	public void ModifierPays(Pays pays) {
		// TODO Auto-generated method stub
		dao.ModifierPays(pays);
	}

	
	
}
