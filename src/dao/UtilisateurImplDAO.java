package dao;

import java.util.List;

import org.hibernate.Session;

public class UtilisateurImplDAO implements UtilisateurDAO{

	@Override
	public void AjouterUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		System.out.println("AjouterUtilisateur");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.save(utilisateur);
	    session.getTransaction().commit();
	    session.close();
		
	}

	@Override
	public void SupprimerUtilisateur(int idUtilisateur) {
		// TODO Auto-generated method stub
		System.out.println("SupprimerUtilisateur");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();	
		session.delete((Utilisateur) session.load(Utilisateur.class,idUtilisateur));
		session.getTransaction().commit();
		session.close();
	}
	
	
	@Override
	public Utilisateur getUtilisateurbyId(int idUtilisateur) {
		// TODO Auto-generated method stub
		System.out.println("getUtilisateurbyId");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		Utilisateur u = (Utilisateur) session.load(Utilisateur.class,idUtilisateur);
		
		return u;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		// TODO Auto-generated method stub
		System.out.println("getAllUtilisateurs");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		List<Utilisateur> u = session.createQuery("from Utilisateur").list();
		
		return u;
	}

	@Override
	public void ModifierUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		System.out.println("ModifierUtilisateur");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.update(utilisateur);
	    session.getTransaction().commit();
	    session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Demande> getAllDemandes(int idUtilisateur) {
		// TODO Auto-generated method stub
		System.out.println("get User ValideDemandes");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		List<Demande> d = session.createQuery("from Demande d where d.valide = true and d.entreprise.utilisateur.idUtilisateur = "+idUtilisateur).list();
		
		return d;
	}

}
