package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Korisnik" database table.
 * 
 */
@Entity
@Table(name="\"Korisnik\"")
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String lastname;

	private String name;

	private String password;

	private String username;

	//bi-directional many-to-one association to Plan
	@OneToMany(mappedBy="korisnik", cascade = CascadeType.ALL)
	private List<Plan> plans;

	//bi-directional many-to-one association to Prihod
	@OneToMany(mappedBy="korisnik", cascade = CascadeType.ALL)
	private List<Prihod> prihods;

	public Korisnik() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Plan> getPlans() {
		return this.plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public Plan addPlan(Plan plan) {
		getPlans().add(plan);
		plan.setKorisnik(this);

		return plan;
	}

	public Plan removePlan(Plan plan) {
		getPlans().remove(plan);
		plan.setKorisnik(null);

		return plan;
	}

	public List<Prihod> getPrihods() {
		return this.prihods;
	}

	public void setPrihods(List<Prihod> prihods) {
		this.prihods = prihods;
	}

	public Prihod addPrihod(Prihod prihod) {
		getPrihods().add(prihod);
		prihod.setKorisnik(this);

		return prihod;
	}

	public Prihod removePrihod(Prihod prihod) {
		getPrihods().remove(prihod);
		prihod.setKorisnik(null);

		return prihod;
	}
	
	@Override
	public String toString() {
		return "Korisnik [id=" + id + ", email=" + email + ", lastname=" + lastname + ", name=" + name + ", password="
				+ password + ", username=" + username + ", plans=" + plans + ", prihods=" + prihods + "]";
	}

}