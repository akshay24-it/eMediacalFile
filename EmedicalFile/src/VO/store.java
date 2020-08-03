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
@Table(name="medical_store")
public class store {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public e_reg getR_id() {
		return r_id;
	}

	public void setR_id(e_reg r_id) {
		this.r_id = r_id;
	}

	@Column(name="store_name")
	private String store;
	
	@Column(name="owner_name")
	private String owner;
	
	@Column(name="mobile")
	private String mob;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@JoinColumn(name="r_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private e_reg r_id;
}
