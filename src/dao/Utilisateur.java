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
 * Utilisateur generated by hbm2java
 */
@Entity
@Table(name = "utilisateur", catalog = "cri_db")
public class Utilisateur implements java.io.Serializable {

	private Integer idUtilisateur;
	private Utilisateur utilisateur;
	private String login;
	private String password;
	private String organisme;
	private String type;
	private String profile;
	private String fonction;
	private Set<Entreprise> entreprises = new HashSet<Entreprise>(0);
	private Set<Message> messages = new HashSet<Message>(0);
	private Set<Utilisateur> utilisateurs = new HashSet<Utilisateur>(0);

	public Utilisateur() {
	}

	public Utilisateur(Utilisateur utilisateur, String login, String password,
			String organisme, String type, String profile) {
		this.utilisateur = utilisateur;
		this.login = login;
		this.password = password;
		this.organisme = organisme;
		this.type = type;
		this.profile = profile;
	}

	public Utilisateur(Utilisateur utilisateur, String login, String password,
			String organisme, String type, String profile, String fonction,
			Set<Entreprise> entreprises, Set<Message> messages,
			Set<Utilisateur> utilisateurs) {
		this.utilisateur = utilisateur;
		this.login = login;
		this.password = password;
		this.organisme = organisme;
		this.type = type;
		this.profile = profile;
		this.fonction = fonction;
		this.entreprises = entreprises;
		this.messages = messages;
		this.utilisateurs = utilisateurs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUtilisateur", unique = true, nullable = false)
	public Integer getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSurUtilisateur", nullable = false)
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Column(name = "Login", nullable = false, length = 45)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "Password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Organisme", nullable = false, length = 45)
	public String getOrganisme() {
		return this.organisme;
	}

	public void setOrganisme(String organisme) {
		this.organisme = organisme;
	}

	@Column(name = "Type", nullable = false, length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "Profile", nullable = false, length = 45)
	public String getProfile() {
		return this.profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Column(name = "Fonction", length = 45)
	public String getFonction() {
		return this.fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
	public Set<Entreprise> getEntreprises() {
		return this.entreprises;
	}

	public void setEntreprises(Set<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
	public Set<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
	public Set<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}
