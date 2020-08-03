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
@Table(name="medical_info")
public class m_info {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int m_id;
	@Column(name="height")
	private float height;
	@Column(name="wight")
	private float weight;
	@Column(name="blood_group")
	private String blood_group;
	@Column(name="diabetes")
	private String diabetes;
	@Column(name="sugar_level")
	private String sugar_level;
	@Column(name="blood_pressure")
	private String b_p;
	public String getSugar_level() {
		return sugar_level;
	}
	public void setSugar_level(String sugar_level) {
		this.sugar_level = sugar_level;
	}
	public String getB_p() {
		return b_p;
	}
	public void setB_p(String b_p) {
		this.b_p = b_p;
	}
	@Column(name="hypertention")
	private String hypertention;
	@Column(name="asthama")
	private String asthama;
	@Column(name="disability")
	private String disability;
	@Column(name="allergy")
	private String allergy;
	@JoinColumn(name="m_r_id")
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private e_reg r_id;
	public e_reg getR_id() {
		return r_id;
	}
	public void setR_id(e_reg r_id) {
		this.r_id = r_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
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
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getDiabetes() {
		return diabetes;
	}
	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}
	public String getHypertention() {
		return hypertention;
	}
	public void setHypertention(String hypertention) {
		this.hypertention = hypertention;
	}
	public String getAsthama() {
		return asthama;
	}
	public void setAsthama(String asthama) {
		this.asthama = asthama;
	}
	public String getDisability() {
		return disability;
	}
	public void setDisability(String disability) {
		this.disability = disability;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
}
