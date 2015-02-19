package dao;

import java.util.List;

import org.hibernate.Session;

import dao.Secteur;


public class SecteurImplDAO implements SecteurDAO{


	@Override
	public void AjouterSecteur(Secteur secteur) {
		// TODO Auto-generated method stub	
		System.out.println("AjouterSecteur");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.save(secteur);
	    session.getTransaction().commit();
	    session.close();
			
	}
	
	@Override
	public void SupprimerSecteur(int idSecteur) {
		// TODO Auto-generated method stub
		System.out.println("SupprimerSecteur");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.delete((Secteur) session.load(Secteur.class,idSecteur));
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Secteur getSecteurbyId(int idSecteur) {
		// TODO Auto-generated method stub
		System.out.println("getSecteurbyId");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		Secteur s = (Secteur) session.load(Secteur.class,idSecteur);
		session.close();
		return s;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Secteur> getAllSecteurs() {
		// TODO Auto-generated method stub
		System.out.println("getAllSecteurs");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
	    List<Secteur> s = session.createQuery("from Secteur s where s.secteur is not null").list();
	    
		return s;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Secteur> getAllSurSecteurs() {
		// TODO Auto-generated method stub
		System.out.println("getAllSurSecteurs");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
	    List<Secteur> s = session.createQuery("from Secteur s where s.secteur is null").list();
	   
		return s;
	}
	
	
	
	@Override
	public void ModifierSecteur(Secteur secteur) {
		// TODO Auto-generated method stub
		System.out.println("ModifierSecteur");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.update(secteur);
	    session.getTransaction().commit();
	    session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Secteur> getAllSecteurs(String idSurSecteur) {
		// TODO Auto-generated method stub
		System.out.println("getAllSecteurs by SurSecteur");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		List<Secteur> s = session.createQuery("from Secteur s where s.secteur.idSecteur ="+idSurSecteur).list();
	    
		return s;
	}

	




	
}
