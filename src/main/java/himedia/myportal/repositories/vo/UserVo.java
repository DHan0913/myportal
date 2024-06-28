package himedia.myportal.repositories.vo;

import java.util.Date;

public class UserVo {
	private Long no;
	private String name;
	private String email;
	private String password;
	private String gender;
	private Date joinDate;
	
	//	생성자
	public UserVo() {
		
	}
	
	public UserVo(String name, String email, String password, String gender) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}

	//	Getters / Setters
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", joinDate=" + joinDate + "]";
	}
	
	
}
