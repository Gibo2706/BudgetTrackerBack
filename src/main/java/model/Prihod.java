package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the "Prihod" database table.
 * 
 */
@Entity
@Table(name="\"Prihod\"")
@NamedQuery(name="Prihod.findAll", query="SELECT p FROM Prihod p")
public class Prihod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private BigDecimal amount;

	@Column(name="\"korisnikId\"")
	private Long korisnikId;

	private String name;

	@Column(name="\"planId\"")
	private Long planId;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"korisnikId\"", insertable = false, updatable = false, referencedColumnName = "\"id\"")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Plan
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"planId\"", insertable = false, updatable = false, referencedColumnName = "\"id\"")
	private Plan plan;

	public Prihod() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getKorisnikId() {
		return this.korisnikId;
	}

	public void setKorisnikId(Long korisnikId) {
		this.korisnikId = korisnikId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPlanId() {
		return this.planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}