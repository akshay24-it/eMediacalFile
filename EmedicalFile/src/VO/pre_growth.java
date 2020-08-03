package VO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pre_growth")
public class pre_growth {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getSugar() {
		return sugar;
	}
	public void setSugar(String sugar) {
		this.sugar = sugar;
	}
	public String getBloodpressure() {
		return bloodpressure;
	}
	public void setBloodpressure(String bloodpressure) {
		this.bloodpressure = bloodpressure;
	}
	public e_reg getR_id() {
		return r_id;
	}
	public void setR_id(e_reg r_id) {
		this.r_id = r_id;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="height")
	private float height;
	@Column(name="weight")
	private float weight;
	@Column(name="sugar")
	private String sugar;
	@Column(name="bloodpressure")
	private String bloodpressure;
	@JoinColumn(name="p_r_id")
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private e_reg r_id;
}