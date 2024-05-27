package model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the "Plan" database table.
 * 
 */
@Entity
@Table(name="\"Plan\"")
@NamedQuery(name="Plan.findAll", query="SELECT p FROM Plan p")
@Getter
@Setter
@AllArgsConstructor
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="\"korisnikId\"")
	private Long korisnikId;

	private String name;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"korisnikId\"", insertable = false, updatable = false, referencedColumnName = "\"id\"")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Prihod
	@OneToMany(mappedBy="plan", cascade = CascadeType.PERSIST)
	private List<Prihod> prihods = new ArrayList<>();

	//bi-directional many-to-one association to Trosak
	@OneToMany(mappedBy="plan", cascade = CascadeType.PERSIST)
	private List<Trosak> trosaks = new ArrayList<>();

	private BigDecimal goal;	
	
	@Column(name="\"time_period\"")
	private Long timePeriod;

	public Plan() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<Prihod> getPrihods() {
		return this.prihods;
	}

	public void setPrihods(List<Prihod> prihods) {
		this.prihods = prihods;
	}

	public Prihod addPrihod(Prihod prihod) {
		getPrihods().add(prihod);
		prihod.setPlan(this);

		return prihod;
	}

	public Prihod removePrihod(Prihod prihod) {
		getPrihods().remove(prihod);
		prihod.setPlan(null);

		return prihod;
	}

	public List<Trosak> getTrosaks() {
		return this.trosaks;
	}

	public void setTrosaks(List<Trosak> trosaks) {
		this.trosaks = trosaks;
	}

	public Trosak addTrosak(Trosak trosak) {
		getTrosaks().add(trosak);
		trosak.setPlan(this);

		return trosak;
	}

	public Trosak removeTrosak(Trosak trosak) {
		getTrosaks().remove(trosak);
		trosak.setPlan(null);

		return trosak;
	}
	
	public BigDecimal getGoal() {
		return goal;
	}

	public void setGoal(BigDecimal goal) {
		this.goal = goal;
	}

	public Long getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(Long timePeriod) {
		this.timePeriod = timePeriod;
	}
	
}