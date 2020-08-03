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
import java.sql.Date;
@Entity
@Table(name="notes")
public class note {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="date")
	private Date date;
	@Column(name="notes")
	private String note;
	@JoinColumn(name="rid")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private e_reg r_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public e_reg getR_id() {
		return r_id;
	}
	public void setR_id(e_reg r_id) {
		this.r_id = r_id;
	}
	
	
}
