package VO;

import java.sql.Date;

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
@Table(name="vaccine")
public class vaccine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="vaccine_name")
	private String vname;
	
	@Column(name="disease_name")
	private String disease;
	
	@Column(name="vaccine_date")
	private Date date;
	
	@Column(name="next_dose_date")
	private Date d_date;
	
	@JoinColumn(name="r_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private e_reg r_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getD_date() {
		return d_date;
	}

	public void setD_date(Date d_date) {
		this.d_date = d_date;
	}

	public e_reg getR_id() {
		return r_id;
	}

	public void setR_id(e_reg r_id) {
		this.r_id = r_id;
	}
	
	
}
