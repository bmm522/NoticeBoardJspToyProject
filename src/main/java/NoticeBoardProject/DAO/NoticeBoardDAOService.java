package NoticeBoardProject.DAO;

import java.sql.SQLException;
import java.util.List;

import NoticeBoardProject.DAO.Token.Token;
import NoticeBoardProject.entity.TableEntity;

public interface NoticeBoardDAOService {
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	
	public Token GetTokenOfLoginCheck(String userid, String userpwd);

	public Token GetTokenOfMakeMember(String newUserId, String newUserPw, String newUserName, String newUserPhonenum,
			String newUserEmail);

	public List<TableEntity> GetTable() throws SQLException;
}
