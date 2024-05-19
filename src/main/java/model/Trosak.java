package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the "Trosak" database table.
 * 
 */
@Entity
@Table(name="\"Trosak\"")
@NamedQuery(name="Trosak.findAll", query="SELECT t FROM Trosak t")
public class Trosak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private BigDecimal amount;

	private Boolean isimpulse;

	private String name;

	@Column(name="\"planId\"")
	private Long planId;

	//bi-directional many-to-one association to Plan
	@ManyToOne
	@JoinColumn(name = "\"planId\"", insertable = false, updatable = false, referencedColumnName = "\"id\"")
	private Plan plan;

	public Trosak() {
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

	public Boolean getIsimpulse() {
		return this.isimpulse;
	}

	public void setIsimpulse(Boolean isimpulse) {
		this.isimpulse = isimpulse;
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

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}