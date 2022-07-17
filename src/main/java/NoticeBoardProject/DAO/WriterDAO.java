package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WriterDAO extends NoticeBoardProjectDAO{

	public void InsertWriter(String title, Object userId,String content ) {
		String sql = "INSERT INTO (SELECT a.TITLE, a.WRITER_ID, a.CONTENT, a.PUB FROM TABLELIST  a LEFT OUTER JOIN BOARDMEMBER ON a.WRITER_ID =BOARDMEMBER.USERID)(TITLE,WRITER_ID,CONTENT,PUB) "
				+ "VALUES (?, ?, ?, 1)";
		Connection con = ConnectionDriver();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			InsertData(title, userId, content, con ,pst);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("InsertWriter¿À·ù");
		} 
		
	}
	
}
