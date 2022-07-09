package NoticeBoardProject.DAO.Token;

public class LoginToken {
	
	int check;
	
	public LoginToken(int check) {
		
		this.check = check;
		
	}
	public String getTokenName() {
		switch(check) {
		case 1:
			return "LOGINSUCCESS";
		case 2:
			return "LOGINIDPWDNOTMATCH";
		case -1:
			return "LOGINFAIL";
		default:
			return "LOGINERROR";
		}
			
	}
	
}
