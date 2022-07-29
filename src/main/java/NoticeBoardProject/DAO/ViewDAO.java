package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import NoticeBoardProject.entity.ViewEntity;

public class ViewDAO extends NoticeBoardProjectDAO{

	public List<ViewEntity> getView(int id) {
		String sql = "SELECT ID, TITLE, WRITER_ID,CONTENT, REGDATE FROM TABLELIST WHERE ID=?";
		Connection con = ConnectionDriver();
		PreparedStatement pst = null;
		ResultSet rs = null;
		return getViewFromDatabase(con, pst, rs, sql, id);
	}
	
	
	private List<ViewEntity> getViewFromDatabase(Connection con, PreparedStatement pst, ResultSet rs, 
			String sql, int id){
			
			try {
				pst=con.prepareStatement(sql);
				pst.setInt(1, id);
				rs=pst.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("GetViewFromDatabase오류");
			}
			return getViewFromDataBaseEntity(con, pst, rs);
		}

	
	
	private List<ViewEntity> getViewFromDataBaseEntity(Connection con, PreparedStatement pst, ResultSet rs){
		List<ViewEntity> list = new ArrayList<>();
		try {
			rs.next();
			list.add(getViewEntity(
					rs.getInt("ID"),
					rs.getString("TITLE"), 
					rs.getString("WRITER_ID"),
					rs.getString("CONTENT"),
					rs.getDate("REGDATE")));
			JdbcClose(con, pst, rs);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("GetViewFromDataBaseEntity오류");
		}
		return list;
		
	}
	private ViewEntity getViewEntity(int id, String title, String writer_id, String content, Date regdate) {
		ViewEntity ve = new ViewEntity(id, title, writer_id, content, regdate);
		return ve;
		
	}
	
}
