package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import NoticeBoardProject.DAO.Token.Token;

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
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public Statement GetStatement() {
		Statement st= null;
		return st;
	}
	
	public PreparedStatement GetLoginPst(PreparedStatement pst,String sql,
			Connection con, String userId, String userPwd) throws SQLException {
		SetStringOfGetLoginPst(pst, userId, userPwd);
		return pst;
		
	}
	
	public void SetStringOfGetLoginPst(PreparedStatement pst, String userId, String userPwd){
		try {
			pst.setString(1, userId);
			pst.setString(2, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet GetResultSet() {
		ResultSet rs = null;
		return rs;
		
	}
	public void LoginJdbcClose(Connection con, PreparedStatement pst, ResultSet rs) {
		if (rs != null) try { rs.close(); } catch(SQLException e) {}
		if (pst != null) try { pst.close(); } catch(SQLException e) {}
		if (con != null) try { con.close(); } catch(SQLException e) {}
		
	}

}

