package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import NoticeBoardProject.entity.LoginEntity;

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

	
	
	@Override
	public int GetTokenOfMakeMember(String newUserId, String newUserPw, String newUserName, String newUserPhonenum,
			String newUserEmail) {
		String sql = "INSERT INTO BOARDMEMBER(USERID, USERPWD, USERNAME, PHONENUM, EMAIL) VALUES (?, ?, ?, ?, ?)";
		LoginEntity loginEntity = new LoginEntity
				(newUserId, newUserPw, newUserName, newUserPhonenum,newUserEmail);
		
		try {
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, loginEntity.getUserId());
			pst.setString(2, loginEntity.getUserPwd());
			pst.setString(3, loginEntity.getUserName());
			pst.setString(4, loginEntity.getPhoneNum());
			pst.setString(5, loginEntity.getEmail());
			
			try {
				return pst.executeUpdate(); //ȸ������ ������ū 1
				
			} catch(SQLException e) {
				e.printStackTrace();
				return -1;
			}
			
			
		}
			catch(Exception e) {
			
			e.printStackTrace();
			
			
		}	finally {
			 
			
			jdbcClose.JdbcClose(con, pst);
			
		
		}
		
		return -1;
			
	}
	
	
	
	
}
