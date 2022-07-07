package NoticeBoardProject.entity;

import java.sql.Date;

public class LoginEntity {
	private int checkNum;
	private String userId;
	private String userPwd;
	private int phoneNum;
	private String email;
	private Date regDate;
	
	public LoginEntity() {
		
	}
	
	public LoginEntity(int checkNum, String userId, String userPwd, int phoneNum, String email, Date regDate) {
		super();
		this.checkNum = checkNum;
		this.userId = userId;
		this.userPwd = userPwd;
		this.phoneNum = phoneNum;
		this.email = email;
		this.regDate = regDate;
	}
	
	public int getCheckNum() {
		return checkNum;
	}
	public void setCheckNum(int checkNum) {
		this.checkNum = checkNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
