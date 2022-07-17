package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDAO extends NoticeBoardProjectDAO{
	
	public void deletePage(int id) {
		String sql = "UPDATE TABLELIST SET PUB = 0 WHERE ID=?";
		Connection con = ConnectionDriver();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			deleteInDatabase(con,pst,id);
		} catch (SQLException e) {
			System.out.println("deletePage¿À·ù");
		}
		
	}

	
}
