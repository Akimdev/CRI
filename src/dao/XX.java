package dao;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class XX
{
  private static SessionFactory sessionFactory = buildSessionFactory();

 private static SessionFactory buildSessionFactory()
  {
     try
     {
        if (sessionFactory == null)
        {
           System.out.println("In HibernateUtil . . .");
           Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
           System.out.println("Configuration Created . . .");
           sessionFactory = configuration.buildSessionFactory();
           
       }
        return sessionFactory;
     } catch (Throwable ex)
     {
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
     }
  }

  public static SessionFactory getSessionFactory()
  {
     return sessionFactory;
  }

  public static void shutdown()
  {
	   getSessionFactory().close();// sessionFactory = null;
  }
}