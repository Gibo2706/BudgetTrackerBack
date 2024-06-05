package model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "token")
@NamedQuery(name="Token.findAll", query="SELECT t FROM Token t")
@Getter
@Setter
public class Token implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String token;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name="korisnik")
	private Long korisnikId;

	@OneToOne(targetEntity = Korisnik.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "korisnikId", insertable = false, updatable = false)
	private Korisnik korisnikClass;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Korisnik getKorisnikClass() {
		return korisnikClass;
	}

	public void setKorisnikClass(Korisnik korisnik) {
		this.korisnikClass = korisnik;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
