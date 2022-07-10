package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import NoticeBoardProject.DAO.Token.Token;
import NoticeBoardProject.entity.LoginEntity;
import NoticeBoardProject.entity.TableEntity;


	


public class NoticeBoardDAOImpl implements NoticeBoardDAOService{
	
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
	Connection con;
	Statement st;
	PreparedStatement pst; 
	ResultSet rs;
	NoticeBoardDAOClose jdbcClose;
	
	
	public NoticeBoardDAOImpl() {
		con=null; 
		pst =null; 
		rs = null;
		st=null;
		jdbcClose = new NoticeBoardDAOClose();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con =DriverManager.getConnection(url, "c##bmm522", "1234");	
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Token GetTokenOfLoginCheck(String userid, String userpwd) {
		
		String sql = "SELECT USERPWD FROM BOARDMEMBER WHERE USERID=? AND USERPWD=?";
		
		try { 
			pst = con.prepareStatement(sql);
			pst.setString(1, userid);
			pst.setString(2, userpwd);
			rs = pst.executeQuery();
			
		}catch(Exception e) {
				e.printStackTrace();
		}	
		return GetTokenOfLoginCheckIfLogic(rs);
	}
	
	public Token GetTokenOfLoginCheckIfLogic(ResultSet rs) {
		try {	
			if(rs.next()) 
				return Token.LOGINSUCCESS;
			
			return Token.LOGINFAIL;
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			 jdbcClose.JdbcClose(con, pst, rs); //강제로 예외발생시켜서 닫게함
		}
		return Token.LOGINERROR;
	}
	
	
	
	
	
	
	
	
	public Token GetTokenOfMakeMember(String newUserId, String newUserPw, String newUserName, String newUserPhonenum,
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
			pst.executeUpdate();
			
			return  Token.MAKEMEMBERSUCCESS;
		}
			catch(Exception e) {
			e.printStackTrace();
		}	finally {
			jdbcClose.JdbcClose(con, pst);
		}
		return Token.MAKEMEMBERFAIL;
			
	}

	
	public List<TableEntity> GetTable() throws SQLException {
		String sql ="SELECT ID, TITLE, WRITER_ID, REGDATE, HIT FROM TABLELIST";
		List<TableEntity> list = new ArrayList<>();
		st = con.createStatement();
		rs = st.executeQuery(sql);
		return GetTableList(rs, list);
	}


	private List<TableEntity> GetTableList(ResultSet rs, List<TableEntity> list) {
		try {
			while(rs.next()) {
				list.add(GetTableListEntity(rs.getInt("ID"), rs.getString("TITLE"),
						rs.getString("WRITER_ID"), rs.getDate("REGDATE"), rs.getInt("HIT")));
			}
		} catch(SQLException e) {
			System.out.println("GetTableList오류");
		} finally {
			jdbcClose.JdbcClose(con, st, rs);
		}
		return list;
	}


	private TableEntity GetTableListEntity(int id, String title, 
			String writer_id, Date regdate, int hit) {
		TableEntity te = new TableEntity(id, title, writer_id, regdate, hit);
		return te;
	}


}	

