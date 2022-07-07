package NoticeBoardProject.DAO;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeBoardDAOImpl implements NoticeBoardDAOService{
	
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	Connection con; 
	PreparedStatement pst; 
	ResultSet rs;
	NoticeBoardDAOClose jdbcClose;
	
	public NoticeBoardDAOImpl() {
		con=null; 
		pst =null; 
		rs = null;
		jdbcClose = new NoticeBoardDAOClose();
	}
	
	public int GetTokenOfLoginCheck(String userid, String userpwd) {
		
		String sql = "SELECT USERPWD FROM BOARDMEMBER WHERE USERID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url, "c##bmm522", "1234");
			pst = con.prepareStatement(sql);
			
			pst.setString(1, userid);
			rs = pst.executeQuery();
			
			if(rs.next()) { //검색결과가 있으면 데이터를 돌것이다.
				
				if(rs.getString("USERPWD").equals(userpwd)) //해당 아이디의 패스워드와 입력 패스워드가 같은지 비교
					return 1; // 두가지의 조건을 만족하면 성공토큰 1을 출력
			
			}
			return -1; //해당하지 않으면 실패토큰 -1 출력
			
		} catch(ClassNotFoundException e) {
				e.printStackTrace();
		} catch(SQLException e) {
				e.printStackTrace();
		} catch(Exception e) {
				e.printStackTrace();
		}
		finally {
			 jdbcClose.JdbcClose(con, pst, rs); //강제로 예외발생시켜서 닫게함
		}
			
		return -2; //데이터 오류일시에는 오류토큰 -2출력
	}
}
