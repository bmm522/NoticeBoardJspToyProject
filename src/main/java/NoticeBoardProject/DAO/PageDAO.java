package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PageDAO extends NoticeBoardProjectDAO{
	
	public int getTotal() throws SQLException {
		String sql = "SELECT COUNT(ROWNUM) FROM TABLELIST";
		Connection con = ConnectionDriver();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return getTotalCountValue(con, st, rs);
		
	}
}
