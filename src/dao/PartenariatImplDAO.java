package dao;

import java.util.List;

import org.hibernate.Session;

public class PartenariatImplDAO implements PartenariatDAO {

	@Override
	public void AjouterPartenariat(Partenariat partenariat) {
		// TODO Auto-generated method stub
		System.out.println("AjouterPartenariat");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.save(partenariat);
	    session.getTransaction().commit();
	    session.close();
			
	}

	@Override
	public void SupprimerPartenariat(int idPartenariat) {
		// TODO Auto-generated method stub
		System.out.println("SupprimerPartenariat");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.delete((Partenariat) session.load(Partenariat.class,idPartenariat));
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Partenariat getPartenariatbyId(int idPartenariat) {
		// TODO Auto-generated method stub
		System.out.println("getPartenariatbyId");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();	
		Partenariat p = (Partenariat) session.load(Partenariat.class,idPartenariat);
		
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Partenariat> getAllPartenariats() {
		// TODO Auto-generated method stub
		System.out.println("getAllPartenariats");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		List<Partenariat> p = session.createQuery("from Partenariat").list();
		
		return p;
	}

	@Override
	public void ModifierPartenariat(Partenariat partenariat) {
		// TODO Auto-generated method stub
		System.out.println("ModifierPartenariat");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.update(partenariat);
	    session.getTransaction().commit();
	    session.close();
	}

}
