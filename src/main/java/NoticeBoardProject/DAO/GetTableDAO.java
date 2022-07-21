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
	
	public List<TableEntity> GetTable(int pageNumber) throws SQLException {
		
		
		
		int startNumber = 1 +(pageNumber-1)*10;
		int endNumber = pageNumber*10;
		
		
		
		String sql ="SELECT B.RNUM, B.ID, B.TITLE, B.WRITER_ID, B.REGDATE, B.HIT FROM"
				+ "(SELECT ROWNUM AS RNUM, A.ID, A.TITLE, A.WRITER_ID, A.REGDATE, A.HIT FROM "
				+ "(SELECT * FROM TABLELIST ORDER BY REGDATE DESC) A WHERE ROWNUM <= ?)B WHERE RNUM >= ?";
		Connection con = ConnectionDriver();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		List<TableEntity> list = new ArrayList<>();
		pst = con.prepareStatement(sql);
		rs = preparedSQLGetTable(pst, rs, startNumber, endNumber);
		return GetTableList(con, pst, rs, list);
	}


	private List<TableEntity> GetTableList(Connection con, Statement st, ResultSet rs, List<TableEntity> list) {
		try {
			while(rs.next()) {
				list.add(GetTableListEntity(rs.getInt("ID"), rs.getString("TITLE"),
						rs.getString("WRITER_ID"), rs.getDate("REGDATE"), rs.getInt("HIT")));
			}
		} catch(SQLException e) {
			System.out.println("GetTableList¿À·ù");
		} finally {
			JdbcClose(con, st, rs);
		}
		return list;
	}


	private TableEntity GetTableListEntity(int id, String title, 
			String writer_id, Date regdate, int hit) {
		TableEntity te = new TableEntity(id, title, writer_id, regdate, hit);
		return te;
	}
	

}