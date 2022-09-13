package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import NoticeBoardProject.DAO.Token.Token;
import NoticeBoardProject.entity.LoginEntity;

public class MakeMemberDAO extends NoticeBoardProjectDAO{
	
	
	public Token getTokenOfMakeMember(String newUserId, String newUserPw, String newUserName, String newUserPhonenum,
			String newUserEmail, String salt) {
		
		Connection con = ConnectionDriver();
		PreparedStatement pst = null;
		
		try {
			addMember(con, pst,newUserId,newUserPw,newUserName,newUserPhonenum,newUserEmail,salt);
			
			return  Token.MAKEMEMBERSUCCESS;
		}
			catch(Exception e) {
			e.printStackTrace();
		}	finally {
			JdbcClose(con, pst);
		}
		return Token.MAKEMEMBERFAIL;
			
	}
	
	public void addMember(Connection con, PreparedStatement pst, String userId, String userPwd, 
			String userName, String userPhoneNum, String userEmail, String salt) {
		String sql1 = "INSERT INTO BOARDMEMBER(USERID, USERPWD, USERNAME, PHONENUM, EMAIL) VALUES (?, ?, ?, ?, ?)";
		String sql2 = "INSERT INTO MEMBERIDCODE(MEMBERID, SALT) VALUES (?, ?)";
		setStringOfAddMember(con,pst,sql1,userId,userPwd,userName,userPhoneNum,userEmail);
		setStringOfAddSalt(con,pst,sql2,userId,salt);
	}
	
	

	private void setStringOfAddMember(Connection con, PreparedStatement pst, String sql,String userId, 
			String userPwd, String userName, String userPhoneNum, String userEmail) {
		
		LoginEntity loginEntity = new LoginEntity
				(userId, userPwd, userName, userPhoneNum, userEmail);
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, loginEntity.getUserId());
			pst.setString(2, loginEntity.getUserPwd());
			pst.setString(3, loginEntity.getUserName());
			pst.setString(4, loginEntity.getPhoneNum());
			pst.setString(5, loginEntity.getEmail());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("setStringOfAddMember¿À·ù");
		}
	}
	private void setStringOfAddSalt(Connection con, PreparedStatement pst, String sql2, String userId, String salt) {
		try {
			pst=con.prepareStatement(sql2);
			pst.setString(1, userId);
			pst.setString(2, salt);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
