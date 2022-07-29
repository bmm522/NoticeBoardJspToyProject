package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import NoticeBoardProject.entity.TableEntity;

public class GetTableDAO extends NoticeBoardProjectDAO{
	
	String sql ="SELECT B.RNUM, B.ID, B.TITLE, B.WRITER_ID, B.REGDATE, B.HIT FROM"
			+ "(SELECT ROWNUM AS RNUM, A.ID, A.TITLE, A.WRITER_ID, A.REGDATE, A.HIT FROM "
			+ "(SELECT * FROM (SELECT * FROM TABLELIST ORDER BY REGDATE DESC) C WHERE TITLE LIKE ? AND PUB = 1) A WHERE ROWNUM <= ?)B"
			+ " WHERE RNUM >= ?";
	public List<TableEntity> getTable(int pageNumber, String searchKeyword) throws SQLException {
	
		int startNumber = 1 +(pageNumber-1)*10;
		int endNumber = pageNumber*10;
		
		Connection con = ConnectionDriver();
		PreparedStatement pst = null;
		ResultSet rs = null;
			
		List<TableEntity> list = new ArrayList<>();
		pst = con.prepareStatement(sql);
		rs = preparedSQLGetTable(pst, rs, startNumber, endNumber, searchKeyword);
		return getTableList(con, pst, rs, list);
	}
	
	private ResultSet preparedSQLGetTable(PreparedStatement pst, ResultSet rs, int startNumber, int endNumber, String searchKeyword) {
		try {
			pst.setString(1, searchKeyword+"%");
			pst.setInt(2, endNumber);
			pst.setInt(3, startNumber);
			return pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}

	private List<TableEntity> getTableList(Connection con, Statement st, ResultSet rs, List<TableEntity> list) {
		try {
			while(rs.next()) {
				list.add(getTableListEntity(rs.getInt("ID"), rs.getString("TITLE"),
						rs.getString("WRITER_ID"), rs.getDate("REGDATE"), rs.getInt("HIT")));
			}
		} catch(SQLException e) {
			System.out.println("GetTableList오류");
		} finally {
			JdbcClose(con, st, rs);
		}
		return list;
	}


	private TableEntity getTableListEntity(int id, String title, 
			String writer_id, Date regdate, int hit) {
		TableEntity te = new TableEntity(id, title, writer_id, regdate, hit);
		return te;
	}
	

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
			System.out.println("getTotalCountValue오류");
		} finally {
			JdbcClose(con, pst, rs);
		}
		return totalDataCount;
		
	}
	


}