package NoticeBoardProject.DAO;

import java.sql.SQLException;

public interface NoticeBoardDAOService {
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	
	public int GetTokenOfLoginCheck(String userid, String userpwd);

	public int GetTokenOfMakeMember(String newUserId, String newUserPw, String newUserName, String newUserPhonenum,
			String newUserEmail);
}
