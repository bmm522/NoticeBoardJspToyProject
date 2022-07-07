package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeBoardDAOClose {

	Connection con;
	PreparedStatement st;
	ResultSet rs;
	
	public NoticeBoardDAOClose() {}
	
	public void NoticeBoardDAOClose(Connection con, PreparedStatement st, ResultSet rs) {
		this.con = con;
		this.st = st;
		this.rs =rs;
		
	}
		public void JdbcClose(Connection con, PreparedStatement st, ResultSet rs) {
			if (rs != null) try { rs.close(); } catch(SQLException e) {}
			  if (st != null) try { st.close(); } catch(SQLException e) {}
			  if (con != null) try { con.close(); } catch(SQLException e) {}
			
		
		}

		
	
}
