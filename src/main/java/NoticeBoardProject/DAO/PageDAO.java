package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PageDAO extends NoticeBoardProjectDAO{

	
	public int getTotal(String searchKeyword) throws SQLException {
		String countsql = "SELECT COUNT(ROWNUM) FROM (SELECT * FROM TABLELIST WHERE TITLE LIKE ? )A";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		Connection con = ConnectionDriver();
		pst = con.prepareStatement(countsql);
		rs = getTotalSQLGetTable(pst, rs, searchKeyword);
		return getTotalCountValue(con, pst, rs);
	}
	
	private ResultSet getTotalSQLGetTable(PreparedStatement pst, ResultSet rs, String searchKeyword)
			throws SQLException{
			pst.setString(1, searchKeyword+"%");
			return pst.executeQuery();
	}
		
	private int getTotalCountValue(Connection con, PreparedStatement pst, ResultSet rs){
		int totalDataCount = 0;
		try {
			rs.next();
			return totalDataCount = rs.getInt("COUNT(ROWNUM)");
		} catch (SQLException e) {
			System.out.println("getTotalCountValue¿À·ù");
		} finally {
			JdbcClose(con, pst, rs);
		}
		return totalDataCount;
		
	}
}
