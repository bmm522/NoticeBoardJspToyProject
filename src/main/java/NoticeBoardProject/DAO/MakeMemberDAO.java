package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import NoticeBoardProject.DAO.Token.Token;
import NoticeBoardProject.entity.LoginEntity;

public class MakeMemberDAO extends NoticeBoardProjectDAO{
	
	
	
	public Token GetTokenOfMakeMember(String newUserId, String newUserPw, String newUserName, String newUserPhonenum,
			String newUserEmail) {
		String sql = "INSERT INTO BOARDMEMBER(USERID, USERPWD, USERNAME, PHONENUM, EMAIL) VALUES (?, ?, ?, ?, ?)";
		Connection con = ConnectionDriver();
		PreparedStatement pst = null;
		
		try {
			AddMember(con.prepareStatement(sql),sql,newUserId,newUserPw,newUserName,newUserPhonenum,newUserEmail);			
			return  Token.MAKEMEMBERSUCCESS;
		}
			catch(Exception e) {
			e.printStackTrace();
		}	finally {
			MakeMemberJdbcClose(con, pst);
		}
		return Token.MAKEMEMBERFAIL;
			
	}
}
