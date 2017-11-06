package dev.paie.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="profilremuneration")
public class ProfilRemuneration {

	@Id
	@Column (name="id")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Integer id;
	@Column
	private String code;

	@ManyToMany
	@JoinTable(name="Remu_Coti",
	joinColumns = 
	@JoinColumn(name="ID_REMU", referencedColumnName="id"),
	inverseJoinColumns = 
	@JoinColumn(name="ID_COT_NON_IMPO", referencedColumnName="id")
	)
	private List<Cotisation> cotisationsNonImposables;
	
	@ManyToMany
	@JoinTable(name="Remu_Coti",
	joinColumns = 
	@JoinColumn(name="ID_REMU", referencedColumnName="id"),
	inverseJoinColumns = 
	@JoinColumn(name="ID_COT_IMPO", referencedColumnName="id")
	)
	private List<Cotisation> cotisationsImposables;
	
	@ManyToMany
	@JoinTable(name="Remu_Coti",
	joinColumns = 
	@JoinColumn(name="ID_REMU", referencedColumnName="id"),
	inverseJoinColumns = 
	@JoinColumn(name="ID_AVAN", referencedColumnName="id")
	)
	private List<Avantage> avantages;

	
	
	public ProfilRemuneration(String code, List<Cotisation> cotisationsNonImposables,
			List<Cotisation> cotisationsImposables, List<Avantage> avantages) {
		
		this.code = code;
		this.cotisationsNonImposables = cotisationsNonImposables;
		this.cotisationsImposables = cotisationsImposables;
		this.avantages = avantages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
