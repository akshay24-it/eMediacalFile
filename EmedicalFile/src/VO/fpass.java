package VO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import VO.e_reg;

@Entity
@Table(name="forgot_password")
public class fpass {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="question")
	private String question;
	@Column(name="ans")
	private String ans;
	@JoinColumn(name="rid")
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private e_reg r_id;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public e_reg getR_id() {
		return r_id;
	}

	public void setR_id(e_reg r_id) {
		this.r_id = r_id;
	}
	
	
}
