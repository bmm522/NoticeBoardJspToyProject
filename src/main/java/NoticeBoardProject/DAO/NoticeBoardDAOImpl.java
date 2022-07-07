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
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url, "c##bmm522", "1234");
			
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch(SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public int GetTokenOfLoginCheck(String userid, String userpwd) {
		
		String sql = "SELECT USERPWD FROM BOARDMEMBER WHERE USERID=?";
		
		try {
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, userid);
			rs = pst.executeQuery();
			
			if(rs.next()) { //�˻������ ������ �����͸� �����̴�.
				
				if(rs.getString("USERPWD").equals(userpwd)) {//�ش� ���̵��� �н������ �Է� �н����尡 ������ ��
					return 1; // �ΰ����� ������ �����ϸ� ������ū 1�� ���
				} else {
					return 2; // ��й�ȣ Ʋ������
				}
			} else {
				
			}
			return -1; //�ش����� ������ ������ū -1 ���
		}
		 catch(Exception e) {
				e.printStackTrace();
		}
		finally {
			 jdbcClose.JdbcClose(con, pst, rs); //������ ���ܹ߻����Ѽ� �ݰ���
		}
			
		return -2; //������ �����Ͻÿ��� ������ū -2���
	}
	
	
}
