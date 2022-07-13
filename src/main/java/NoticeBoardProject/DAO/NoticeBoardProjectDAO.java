package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import NoticeBoardProject.DAO.Token.Token;
import NoticeBoardProject.entity.LoginEntity;

public abstract class NoticeBoardProjectDAO {
	
	public Connection ConnectionDriver(){
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con =DriverManager.getConnection(url, "c##bmm522", "1234");	
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ConnectionDriver오류");
		} 
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("ConnectionDriver오류");
		}
		return con;
	}
	
	public void AddMember(PreparedStatement pst, String sql,String userId, String userPwd, 
			String userName, String userPhoneNum, String userEmail) {
		SetStringOfAddMember(pst,sql,userId,userPwd,userName,userPhoneNum,userEmail);
		
	}
	
	private void SetStringOfAddMember(PreparedStatement pst, String sql,String userId, 
			String userPwd, String userName, String userPhoneNum, String userEmail) {
		LoginEntity loginEntity = new LoginEntity
				(userId, userPwd, userName, userPhoneNum, userEmail);
		try {
			pst.setString(1, loginEntity.getUserId());
			pst.setString(2, loginEntity.getUserPwd());
			pst.setString(3, loginEntity.getUserName());
			pst.setString(4, loginEntity.getPhoneNum());
			pst.setString(5, loginEntity.getEmail());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SetStringOfAddMember오류");
		}
	}
	
	
	public PreparedStatement GetLoginPst(PreparedStatement pst,String sql, String userId, String userPwd) throws SQLException {
		SetStringOfGetLoginPst(pst, userId, userPwd);
		return pst;
		
	}
	
	public void SetStringOfGetLoginPst(PreparedStatement pst, String userId, String userPwd){
		try {
			pst.setString(1, userId);
			pst.setString(2, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SetStringOfGetLoginPst오류");
		}
	}
	
	public void InsertData(String title, String content, Object userId ,PreparedStatement pst) {
		
		try {
			pst.setString(1, title);
			pst.setString(2, content);
			pst.setObject(3, userId);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("InserData오류");
			
		}
		
	}
	
	public void JdbcClose(Connection con, PreparedStatement pst) {
		if (pst != null) try { pst.close(); } catch(SQLException e) {}
		if (con != null) try { con.close(); } catch(SQLException e) {}	
		
	}

	public void JdbcClose(Connection con, PreparedStatement pst, ResultSet rs) {
		if (rs != null) try { rs.close(); } catch(SQLException e) {}
		if (pst != null) try { pst.close(); } catch(SQLException e) {}
		if (con != null) try { con.close(); } catch(SQLException e) {}
		
	}

	public void JdbcClose(Connection con, Statement st, ResultSet rs) {
		if (rs != null) try { rs.close(); } catch(SQLException e) {}
		if (st != null) try { st.close(); } catch(SQLException e) {}
		if (con != null) try { con.close(); } catch(SQLException e) {}
		
	}
	
	
}

