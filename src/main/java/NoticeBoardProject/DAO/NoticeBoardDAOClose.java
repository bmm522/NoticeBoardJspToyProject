package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeBoardDAOClose {

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public NoticeBoardDAOClose() {}
	
	public NoticeBoardDAOClose(Connection con, PreparedStatement pst) {
		this.con = con;
		this.pst = pst;
		
	}
	
	public NoticeBoardDAOClose(Connection con, PreparedStatement pst, ResultSet rs) {
		this.con = con;
		this.pst = pst;
		this.rs =rs;
		
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

		
	
}
