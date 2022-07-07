package NoticeBoardProject.service;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeBoardDAOImpl implements NoticeBoardDAOService{
	
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	
	
	public int GetTokenOfLoginCheck(String userid, String userpwd) {
		
		String sql = "SELECT USERPWD FROM BOARDMEMBER WHERE USERID=?";
		Connection con=null; 
		PreparedStatement st =null; 
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url, "c##bmm522", "1234");
			st = con.prepareStatement(sql);
			
			st.setString(1, userid);
			rs = st.executeQuery();
		
		
			
			if(rs.next()) { //�˻������ ������ �����͸� �����̴�.
				
				if(rs.getString("USERPWD").equals(userpwd)) //�ش� ���̵��� �н������ �Է� �н����尡 ������ ��
					return 1; // �ΰ����� ������ �����ϸ� ������ū 1�� ���
					
			
			}
		return -1; //�ش����� ������ ������ū -1 ���
			
		} catch(ClassNotFoundException e) {
				e.printStackTrace();
		} catch(SQLException e) {
				e.printStackTrace();
		} catch(Exception e) {
				e.printStackTrace();
		}
		finally {
			  if (rs != null) try { rs.close(); } catch(SQLException e) {}
			  if (st != null) try { st.close(); } catch(SQLException e) {}
			  if (con != null) try { con.close(); } catch(SQLException e) {} //������ ���ܹ߻����Ѽ� �ݰ���
		}
			
		return -2; //������ �����Ͻÿ��� ������ū -2���
	}
}
