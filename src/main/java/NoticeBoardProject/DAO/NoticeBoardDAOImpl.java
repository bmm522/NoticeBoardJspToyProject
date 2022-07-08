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
			
			if(rs.next()) { //검색결과가 있으면 데이터를 돌것이다.
				
				if(rs.getString("USERPWD").equals(userpwd)) {//해당 아이디의 패스워드와 입력 패스워드가 같은지 비교
					return 1; // 두가지의 조건을 만족하면 성공토큰 1을 출력
				} else {
					return 2; // 비밀번호 틀렸을때
				}
			} else {
				
			}
			return -1; //해당하지 않으면 실패토큰 -1 출력
		}
		 catch(Exception e) {
				e.printStackTrace();
		}
		finally {
			 jdbcClose.JdbcClose(con, pst, rs); //강제로 예외발생시켜서 닫게함
		}
			
		return -2; //데이터 오류일시에는 오류토큰 -2출력
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
				return pst.executeUpdate(); //회원가입 성공토큰 1
				
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
