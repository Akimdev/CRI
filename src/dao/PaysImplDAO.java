package dao;

import java.util.List;

import org.hibernate.Session;

public class PaysImplDAO implements PaysDAO {

	@Override
	public void AjouterPays(Pays pays) {
		// TODO Auto-generated method stub
		System.out.println("AjouterPays");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.save(pays);
	    session.getTransaction().commit();
	    session.close();
	}

	@Override
	public void SupprimerPays(int idPays) {
		// TODO Auto-generated method stub
		System.out.println("SupprimerPays");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.delete((Pays) session.load(Pays.class,idPays));
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Pays getPaysbyId(int idPays) {
		// TODO Auto-generated method stub
		System.out.println("getPaysbyId");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		Pays p = (Pays) session.load(Pays.class,idPays);
		
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pays> getAllPays() {
		// TODO Auto-generated method stub
		System.out.println("getAllPays");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();
		List<Pays> p = session.createQuery("from Pays").list();
		
		return p;
	}

	@Override
	public void ModifierPays(Pays pays) {
		// TODO Auto-generated method stub
		System.out.println("ModifierPays");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.update(pays);
	    session.getTransaction().commit();
	    session.close();
	}

}
