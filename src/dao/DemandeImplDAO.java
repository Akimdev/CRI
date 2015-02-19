package dao;

import java.util.List;

import org.hibernate.Session;

public class DemandeImplDAO implements DemandeDAO {

	@Override
	public void AjouterDemande(Demande demande) {
		// TODO Auto-generated method stub
		System.out.println("AjouterDemande");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.save(demande);
	    session.getTransaction().commit();
	    session.close();
	}

	@Override
	public void SupprimerDemande(DemandeId idDemande) {
		// TODO Auto-generated method stub
		System.out.println("SupprimerDemande");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.delete((Demande) session.load(Demande.class,idDemande));
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Demande getDemandebyId(DemandeId idDemande) {
		// TODO Auto-generated method stub
		System.out.println("getDemandebyId");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		Demande demande = (Demande) session.load(Demande.class,idDemande);
		
		return demande;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Demande> getAllDemandes() {
		// TODO Auto-generated method stub
		System.out.println("getAllDemandes");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		List<Demande> d = session.createQuery("from Demande").list();
		
		return d;
	}

	@Override
	public void ModifierDemande(Demande demande) {
		// TODO Auto-generated method stub
		System.out.println("ModifierDemande");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		session.update(demande);
	    session.getTransaction().commit();
	    session.close();
	   
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Demande> getValideDemandes() {
		// TODO Auto-generated method stub
		System.out.println("getValideDemandes");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();
		List<Demande> d = session.createQuery("from Demande d where d.valide = true").list();
		
		return d;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Demande> getInvalideDemandes() {
		// TODO Auto-generated method stub
		System.out.println("getInvalideDemandes");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();	
		List<Demande> d = session.createQuery("from Demande d where d.valide = false").list();
		
		return d;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Demande> getValideDemandes(String date
										  ,String nomPays
										  ,String designiationSecteurE
										  ,String descriptionEntreprise
										  ,String designiationSecteurD
										  ,String designiationPartenariat
										  ,String descriptionDemande
										  ,String engagement){
		// TODO Auto-generated method stub
		
		System.out.println("getValideDemandes");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		
		List<Demande> d = session.createQuery("from Demande d where "
				+ "d.valide = true and "
				+ "d.date like '%"+date+"%' and " 
				+ "d.entreprise.pays.nomPays like '%"+nomPays+"%' and "
				+ "d.entreprise.secteur.designiation like '%"+designiationSecteurE+"%' and "
				+ "d.entreprise.description like '%"+descriptionEntreprise+"%' and "
				+ "d.secteur.designiation like '%"+designiationSecteurD+"%' and "
				+ "d.partenariat.designiation like '%"+designiationPartenariat+"%' and "
				+ "d.description like '%"+descriptionDemande+"%' and "
				+ "d.engagement like '%"+engagement+"%'" ).list();
		
		return d;
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Demande> getValideDemandes(String date
										  ,String nomEntreprise
										  ,String nomPays
										  ,String designiationSecteurE
										  ,String descriptionEntreprise
										  ,String siteWeb
										  ,String nomContact
										  ,String prenomContact
										  ,String emailContact
										  ,String designiationSecteurD
										  ,String designiationPartenariat
										  ,String descriptionDemande
										  ,String engagement) {
		// TODO Auto-generated method stub
		System.out.println("getValideDemandes");
		Session session =  HibernateUtil.getSession();
		session.beginTransaction();	
		
		
		List<Demande> d = session.createQuery("from Demande d where "
				+ "d.valide = true and "
				+ "d.date like '%"+date+"%' and " 
				+ "d.entreprise.nomEntreprise like '%"+nomEntreprise+"%' and " 
				+ "d.entreprise.pays.nomPays like '%"+nomPays+"%' and "
				+ "d.entreprise.secteur.designiation like '%"+designiationSecteurE+"%' and "
				+ "d.entreprise.description like '%"+descriptionEntreprise+"%' and "
				+ "d.entreprise.webEntreprise like '%"+siteWeb+"%' and "
				+ "d.entreprise.nomContact like '%"+nomContact+"%' and "
				+ "d.entreprise.prenomContact like '%"+prenomContact+"%' and "
				+ "d.entreprise.emailContact like '%"+emailContact+"%' and "
				+ "d.secteur.designiation like '%"+designiationSecteurD+"%' and "
				+ "d.partenariat.designiation like '%"+designiationPartenariat+"%' and "
				+ "d.description like '%"+descriptionDemande+"%' and "
				+ "d.engagement like '%"+engagement+"%'" ).list();
		
		return d;
	}

	

}
