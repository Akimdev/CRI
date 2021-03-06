package dao;

// Generated 1 mars 2015 20:34:08 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Secteur generated by hbm2java
 */
@Entity
@Table(name = "secteur", catalog = "cri_db")
public class Secteur implements java.io.Serializable {

	private Integer idSecteur;
	private Secteur secteur;
	private String designiation;
	private Set<Demande> demandes = new HashSet<Demande>(0);
	private Set<Secteur> secteurs = new HashSet<Secteur>(0);
	private Set<Entreprise> entreprises = new HashSet<Entreprise>(0);

	public Secteur() {
	}

	public Secteur(String designiation) {
		this.designiation = designiation;
	}

	public Secteur(Secteur secteur, String designiation, Set<Demande> demandes,
			Set<Secteur> secteurs, Set<Entreprise> entreprises) {
		this.secteur = secteur;
		this.designiation = designiation;
		this.demandes = demandes;
		this.secteurs = secteurs;
		this.entreprises = entreprises;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idSecteur", unique = true, nullable = false)
	public Integer getIdSecteur() {
		return this.idSecteur;
	}

	public void setIdSecteur(Integer idSecteur) {
		this.idSecteur = idSecteur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSurSecteur")
	public Secteur getSecteur() {
		return this.secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	@Column(name = "Designiation", nullable = false, length = 100)
	public String getDesigniation() {
		return this.designiation;
	}

	public void setDesigniation(String designiation) {
		this.designiation = designiation;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secteur")
	public Set<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(Set<Demande> demandes) {
		this.demandes = demandes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secteur")
	public Set<Secteur> getSecteurs() {
		return this.secteurs;
	}

	public void setSecteurs(Set<Secteur> secteurs) {
		this.secteurs = secteurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secteur")
	public Set<Entreprise> getEntreprises() {
		return this.entreprises;
	}

	public void setEntreprises(Set<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}

}
