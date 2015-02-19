package dao;

// Generated 6 f�vr. 2015 12:12:16 by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Demande generated by hbm2java
 */
@Entity
@Table(name = "demande", catalog = "cri_db")
public class Demande implements java.io.Serializable {

	private DemandeId id;
	private Partenariat partenariat;
	private Entreprise entreprise;
	private Secteur secteur;
	private String date;
	private String description;
	private String engagement;
	private boolean valide;

	public Demande() {
	}

	public Demande(DemandeId id, Partenariat partenariat,
			Entreprise entreprise, Secteur secteur, String date,
			String description, String engagement, boolean valide) {
		this.id = id;
		this.partenariat = partenariat;
		this.entreprise = entreprise;
		this.secteur = secteur;
		this.date = date;
		this.description = description;
		this.engagement = engagement;
		this.valide = valide;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idEntreprise", column = @Column(name = "idEntreprise", nullable = false)),
			@AttributeOverride(name = "idSecteur", column = @Column(name = "idSecteur", nullable = false)),
			@AttributeOverride(name = "idPartenariat", column = @Column(name = "idPartenariat", nullable = false)) })
	public DemandeId getId() {
		return this.id;
	}

	public void setId(DemandeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPartenariat", nullable = false, insertable = false, updatable = false)
	public Partenariat getPartenariat() {
		return this.partenariat;
	}

	public void setPartenariat(Partenariat partenariat) {
		this.partenariat = partenariat;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEntreprise", nullable = false, insertable = false, updatable = false)
	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSecteur", nullable = false, insertable = false, updatable = false)
	public Secteur getSecteur() {
		return this.secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	@Column(name = "Date", nullable = false, length = 45)
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "Description", nullable = false, length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Engagement", nullable = false, length = 45)
	public String getEngagement() {
		return this.engagement;
	}

	public void setEngagement(String engagement) {
		this.engagement = engagement;
	}

	@Column(name = "Valide", nullable = false)
	public boolean isValide() {
		return this.valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

}