package VO;

import java.sql.Date;
import java.sql.Time;

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
@Table(name="appoinment")
public class appoinment {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		
		@Column(name="doctor")
		private String doctor;
//		@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		
		@Column(name="a_name")
		private String a_name;
		@Column(name="date")
		private Date date;
		@Column(name="time")
		private Time time;
		@JoinColumn(name="r_id")
		@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		private e_reg r_id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

	

		public String getA_name() {
			return a_name;
		}

		public void setA_name(String a_name) {
			this.a_name = a_name;
		}

		public String getDoctor() {
			return doctor;
		}

		public void setDoctor(String doctor) {
			this.doctor = doctor;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public Time getTime() {
			return time;
		}

		public void setTime(Time time) {
			this.time = time;
		}

		public e_reg getR_id() {
			return r_id;
		}

		public void setR_id(e_reg r_id) {
			this.r_id = r_id;
		}
		
		
}
