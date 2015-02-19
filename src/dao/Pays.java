package dao;

// Generated 6 f�vr. 2015 12:12:16 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Pays generated by hbm2java
 */
@Entity
@Table(name = "pays", catalog = "cri_db")
public class Pays implements java.io.Serializable {

	private Integer idPays;
	private String nomPays;
	private String initiale;
	private Set<Entreprise> entreprises = new HashSet<Entreprise>(0);

	public Pays() {
	}

	public Pays(String nomPays, String initiale) {
		this.nomPays = nomPays;
		this.initiale = initiale;
	}

	public Pays(String nomPays, String initiale, Set<Entreprise> entreprises) {
		this.nomPays = nomPays;
		this.initiale = initiale;
		this.entreprises = entreprises;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPays", unique = true, nullable = false)
	public Integer getIdPays() {
		return this.idPays;
	}

	public void setIdPays(Integer idPays) {
		this.idPays = idPays;
	}

	@Column(name = "nomPays", nullable = false, length = 40)
	public String getNomPays() {
		return this.nomPays;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

	@Column(name = "initiale", nullable = false, length = 5)
	public String getInitiale() {
		return this.initiale;
	}

	public void setInitiale(String initiale) {
		this.initiale = initiale;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pays")
	public Set<Entreprise> getEntreprises() {
		return this.entreprises;
	}

	public void setEntreprises(Set<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}

}