package NoticeBoardProject.DAO;

import NoticeBoardProject.DAO.Token.Token;

public interface NoticeBoardDAOService {
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	
	public Token GetTokenOfLoginCheck(String userid, String userpwd);

	public int GetTokenOfMakeMember(String newUserId, String newUserPw, String newUserName, String newUserPhonenum,
			String newUserEmail);
}
