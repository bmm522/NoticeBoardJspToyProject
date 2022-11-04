package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import NoticeBoardProject.DAO.Token.Token;
import codeEncryption.oneWay.action.CheckMachingCode;

public class LoginDAO extends NoticeBoardProjectDAO{

	
	public Token getTokenOfLoginCheck(String userId, String userPwd)  {
//			String sql = "SELECT USERPWD FROM BOARDMEMBER WHERE USERID=? AND USERPWD=?";
			Connection con = ConnectionDriver();
			PreparedStatement pst = null;
			ResultSet rs = null;
			
//			checkPwd(con, pst, rs, userId, userPwd);
//			try {
//				pst = getLoginPst(con.prepareStatement(sql), sql, userId, userPwd);
//				rs = pst.executeQuery();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			
			return getTokenOfLoginCheckIfLogic(con, pst ,rs, userId, userPwd);
		}
	



	private boolean checkPwd(Connection con, PreparedStatement pst, ResultSet rs, String userId, String userPwd) {
		CheckMachingCode cmc = new CheckMachingCode();
		return cmc.checkMachingCode(userId, userPwd, getSalt(con, pst, rs, userId), getHashCode(con,pst,rs,userId));
		
	}

	private String getSalt(Connection con, PreparedStatement pst, ResultSet rs, String userId) {
		String sql = "SELECT * FROM MEMBERIDCODE WHERE MEMBERID = ?";
		String salt = "";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, userId);
			rs = pst.executeQuery();
			if(rs.next()) {
				salt = rs.getString("SALT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salt;	
	}


	private String getHashCode(Connection con, PreparedStatement pst, ResultSet rs, String userId) {
		String sql = "SELECT * FROM BOARDMEMBER WHERE USERID = ?";
		String hashCode = "";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, userId);
			rs = pst.executeQuery();
			if(rs.next()) {
				hashCode = rs.getString("USERPWD");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hashCode;
	}





	public Token getTokenOfLoginCheckIfLogic(Connection con, PreparedStatement pst, ResultSet rs,String userId, String userPwd) {
			
			if(checkPwd(con,pst,rs,userId,userPwd)) {
				JdbcClose(con, pst, rs);
				return Token.LOGINSUCCESS;
			}
			return Token.LOGINFAIL;
		 
		}
}
