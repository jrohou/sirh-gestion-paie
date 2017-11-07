package dev.paie.entite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="remunerationemploye")
public class RemunerationEmploye {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String matricule;
	private LocalDate creationDate = LocalDate.now();
	@OneToOne
	@JoinColumn(name = "ID_ENTR")
	private Entreprise entreprise;
	@OneToOne
	@JoinColumn(name = "ID_PRO_REM")
	private ProfilRemuneration profilRemuneration;
	@OneToOne
	@JoinColumn(name = "ID_GRADE")
	private Grade grade;
	
	public String getMatricule() {
		return matricule;
	}
	
	
	
	public RemunerationEmploye() {
		super();
		// TODO Auto-generated constructor stub
	}



	public RemunerationEmploye(Integer id, String matricule, LocalDate creationDate, Entreprise entreprise,
			ProfilRemuneration profilRemuneration, Grade grade) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.creationDate = creationDate;
		this.entreprise = entreprise;
		this.profilRemuneration = profilRemuneration;
		this.grade = grade;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}



	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	

}
