package VO;

import javax.persistence.*;


@Entity
@Table(name="user")
public class e_user {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uid;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public e_reg getRid() {
		return rid;
	}
	public void setRid(e_reg rid) {
		this.rid = rid;
	}
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@JoinColumn(name="r_id")
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private e_reg rid;
}
