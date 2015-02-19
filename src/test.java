import java.util.List;

import org.hibernate.Session;

import dao.XX;
import dao.Pays;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  Session session =  XX.getSessionFactory().openSession();
			session.beginTransaction();	
			List<Pays> pp = (List<Pays>) session.createQuery("from Pays").list();
			session.getTransaction().commit();
	       // session.close();
	      
		
		
		Pays p = new Pays("FRR","fr");
		p.setIdPays(1);
	    session =  XX.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		session.update(p);
		session.getTransaction().commit();
        session.close();
        
        session =  XX.getSessionFactory().openSession();
		session.beginTransaction();	
		p = (Pays) session.load(Pays.class, 1);
		session.getTransaction().commit();
       // session.close();
      

      
        System.out.print(p.getNomPays());
        
		
	}

}
