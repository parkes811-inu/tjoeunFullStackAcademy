package shop.DTO;

import java.util.Date;

public class Users {
	private String id;
	private String password;
	private String name;
	private String gender;
	private String birth;
	private String mail;
	private Date joinDate;
	private Date regDate;
	private Date updDate;
	
	// 기본 생성자, getter&setter, toString()
	public Users() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender + ", birth="
				+ birth + ", mail=" + mail + ", joinDate=" + joinDate + ", regDate=" + regDate + ", updDate=" + updDate
				+ "]";
	}
	
	
	
	
}
