package dao;

import java.util.List;

import org.hibernate.Session;

public class EntrepriseImplDAO implements EntrepriseDAO{

	@Override
	public void AjouterEntreprise(Entreprise entreprise) {
		// TODO Auto-generated method stub
		System.out.println("AjouterEntreprise");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(entreprise);
		session.getTransaction().commit();
	    session.close();
	}

	@Override
	public void SupprimerEntreprise(int idEntreprise) {
		// TODO Auto-generated method stub
		System.out.println("SupprimerEntreprise");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.delete((Entreprise) session.load(Entreprise.class,idEntreprise));
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Entreprise getEntreprisebyId(int idEntreprise) {
		// TODO Auto-generated method stub
		System.out.println("getEntreprisebyId");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		Entreprise e = (Entreprise) session.load(Entreprise.class,idEntreprise);
		
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entreprise> getAllEntreprise() {
		// TODO Auto-generated method stub
		System.out.println("getAllEntreprise");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();	
		List<Entreprise> e = session.createQuery("from Entreprise").list();
		
		return e;
	}

	@Override
	public void ModifierEntreprise(Entreprise entreprise) {
		// TODO Auto-generated method stub
		System.out.println("ModifierEntreprise");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.update(entreprise);
	    session.getTransaction().commit();
	    session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entreprise> getValideEntreprise() {
		// TODO Auto-generated method stub
		System.out.println("getvalideEntreprises");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();	
		List<Entreprise> e = session.createQuery("from Entreprise e where e.valide = true").list();
		
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entreprise> getInValideEntreprise() {
		// TODO Auto-generated method stub
		System.out.println("getInvalideEntreprises");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();	
		List<Entreprise> e = session.createQuery("select e from Entreprise e  where e.idEntreprise not in (select d.entreprise.idEntreprise from Demande d) and e.valide = false").list();
		
		return e;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Entreprise> getInValideEntreprise(String nomEntreprise,
												  String nomPays, 
												  String villeEntreprise,
												  String secteur, 
												  String description,
												  String adresseEntreprise,
												  String siteWeb, 
												  String registre, 
												  String nomContact,
												  String prenomContact, 
												  String civilite, 
												  String fonction,
												  String emailContact, 
												  String fix, 
												  String fax) {
		// TODO Auto-generated method stub
		System.out.println("getInvalideEntreprises Filtre");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();	
		System.out.println("DAO"+villeEntreprise);
		List<Entreprise> e =  session.createQuery("from Entreprise e where e.valide = false "
												+ " and e.nomEntreprise like '%"+nomEntreprise+"%' "
    											+ " and e.pays.nomPays like '%"+nomPays+"%' "
												+ " and e.villeEntreprise like '%"+villeEntreprise+"%' "
												+ " and e.adresseEntreprise like '%"+adresseEntreprise+"%' "
												+ " and e.secteur.designiation like '%"+secteur+"%' "
												+ " and e.description like '%"+description+"%' "
												+ " and e.webEntreprise like '%"+siteWeb+"%' "
												+ " and e.registreCommerce like '%"+registre+"%' "
												+ " and e.nomContact like '%"+nomContact+"%' "
												+ " and e.prenomContact like '%"+prenomContact+"%' "
												+ " and e.civilité like '%"+civilite+"%' "
												+ " and e.fonctionContact like '%"+fonction+"%' "
												+ " and e.emailContact like '%"+emailContact+"%' "
												+ " and e.telContact like '%"+fix+"%' "
												+ " and e.faxContact like '%"+fax+"%' ").list();
		
		return e;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean exist(int idEntreprise) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();	
		List<Entreprise> e = session.createQuery("from Entreprise e where e.utilisateur != null and e.idEntreprise = "+idEntreprise).list();
		
		return (e.size()==1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Entreprise getEntreprisebyIdUser(int idUtilisateur) {
		// TODO Auto-generated method stub
		System.out.println("getEntreprisebyIdUser");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		List<Entreprise> e = session.createQuery("from Entreprise e where e.utilisateur.idUtilisateur = "+idUtilisateur).list();
		
		return e.get(0);
	}

	
}
