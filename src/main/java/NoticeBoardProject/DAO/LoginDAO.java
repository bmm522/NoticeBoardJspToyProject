package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import NoticeBoardProject.DAO.Token.Token;

public class LoginDAO extends NoticeBoardProjectDAO{

	

	public Token GetTokenOfLoginCheck(String userId, String userPwd)  {
			String sql = "SELECT USERPWD FROM BOARDMEMBER WHERE USERID=? AND USERPWD=?";
			Connection con = ConnectionDriver();
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				pst = GetLoginPst(con.prepareStatement(sql), sql,con, userId, userPwd);
				rs = pst.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return GetTokenOfLoginCheckIfLogic(con, pst ,rs);
		}
	
	
	public Token GetTokenOfLoginCheckIfLogic(Connection con, PreparedStatement pst, ResultSet rs) {
		try {	
			if(rs.next()) 
				return Token.LOGINSUCCESS;
				
			return Token.LOGINFAIL;
		} catch (SQLException e) {
			e.printStackTrace();
			} finally {
				 LoginJdbcClose(con, pst, rs); //강제로 예외발생시켜서 닫게함
			}
			return Token.LOGINERROR;
		}
}
