package NoticeBoardProject.entity;

import java.sql.Date;

public class LoginEntity {

	private String userId;
	private String userPwd;
	private String userName;
	private String phoneNum;
	private String email;
	private Date regDate;
	
	public LoginEntity() {
		
	}
	
	public LoginEntity(String userId, String userPwd, String userName, String phoneNum, String email) {
		
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phoneNum = phoneNum;
		this.email = email;
		
	
	}
	
	
	public LoginEntity(String userId, String userPwd, String userName, String phoneNum, String email, Date regDate) {
		
		
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phoneNum = phoneNum;
		this.email = email;
		this.regDate = regDate;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
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
