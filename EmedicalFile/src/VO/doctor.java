package VO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Doctor")
public class doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="clinic_name")
	private String clinic;
	
	public String getClinic() {
		return clinic;
	}

	public void setClinic(String clinic) {
		this.clinic = clinic;
	}

	@Column(name="firstname")
	private String fn;
	
	@Column(name="lastname")
	private String ln;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile_no")
	private String mob;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="Address")
	private String Address;
	
	@Column(name="degree")
	private String degree;
	
	@Column(name="specialist")
	private String specialist;
	
	@Column(name="experience")
	private int experience;
	
	@JoinColumn(name="r_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private e_reg r_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public e_reg getR_id() {
		return r_id;
	}

	public void setR_id(e_reg r_id) {
		this.r_id = r_id;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	
	
	
}
