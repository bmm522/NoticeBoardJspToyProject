package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDAO extends NoticeBoardProjectDAO{
	
	public void updateWrite(String title, String content, int id) {
		String sql = "UPDATE TABLELIST SET TITLE =?,CONTENT = ? WHERE ID=?";
		Connection con = ConnectionDriver();
		PreparedStatement pst = null;
		try {
			pst= con.prepareStatement(sql);
			updateInDatabase(title, content, id, con, pst);
		} catch (SQLException e) {
			System.out.println("updateWrite");
			e.printStackTrace();
		}
		
	}
	
}
