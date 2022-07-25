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

import NoticeBoardProject.entity.LoginEntity;
import NoticeBoardProject.entity.ViewEntity;

public abstract class NoticeBoardProjectDAO {
	
	public Connection ConnectionDriver(){
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con =DriverManager.getConnection(url, "c##bmm522", "1234");	
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ConnectionDriver오류");
		} 
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("ConnectionDriver오류");
		}
		return con;
	}
	
	public void addMember(PreparedStatement pst, String sql,String userId, String userPwd, 
			String userName, String userPhoneNum, String userEmail) {
		setStringOfAddMember(pst,sql,userId,userPwd,userName,userPhoneNum,userEmail);
		
	}
	
	private void setStringOfAddMember(PreparedStatement pst, String sql,String userId, 
			String userPwd, String userName, String userPhoneNum, String userEmail) {
		LoginEntity loginEntity = new LoginEntity
				(userId, userPwd, userName, userPhoneNum, userEmail);
		try {
			pst.setString(1, loginEntity.getUserId());
			pst.setString(2, loginEntity.getUserPwd());
			pst.setString(3, loginEntity.getUserName());
			pst.setString(4, loginEntity.getPhoneNum());
			pst.setString(5, loginEntity.getEmail());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("setStringOfAddMember오류");
		}
	}
	
	
	public PreparedStatement getLoginPst(PreparedStatement pst,String sql, String userId, String userPwd) throws SQLException {
		setStringOfGetLoginPst(pst, userId, userPwd);
		return pst;
		
	}
	
	public void setStringOfGetLoginPst(PreparedStatement pst, String userId, String userPwd){
		try {
			pst.setString(1, userId);
			pst.setString(2, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SetStringOfGetLoginPst오류");
		}
	}
	
	public void InsertData(String title, Object userId, String content ,Connection con,PreparedStatement pst) {
		
		try {
			pst.setString(1, title);
			pst.setObject(2, userId);
			pst.setString(3, content);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("InserData오류");
			
		} finally {
			JdbcClose(con, pst);
		}
		
	}
	
	public List<ViewEntity> GetViewFromDatabase(Connection con, PreparedStatement pst, ResultSet rs, String sql, int id){
		
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("GetViewFromDatabase오류");
		}
		return GetViewFromDataBaseEntity(con, pst, rs);
	}
	
	public List<ViewEntity> GetViewFromDataBaseEntity(Connection con, PreparedStatement pst, ResultSet rs){
		List<ViewEntity> list = new ArrayList<>();
		try {
			rs.next();
			list.add(GetViewEntity(
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
	
	
	
	public ViewEntity GetViewEntity(int id, String title, String writer_id, String content, Date regdate) {
		ViewEntity ve = new ViewEntity(id, title, writer_id, content, regdate);
		return ve;
		
	}
	


	
	
	public void updateInDatabase(String title, String content, int id, Connection con, PreparedStatement pst) {
		
		try {
			pst.setString(1, title);
			pst.setString(2, content);
			pst.setInt(3, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("updateInDAtabase오류");
			
		} finally {
			JdbcClose(con, pst);
		}
		
	}
	
	public void deleteInDatabase(Connection con, PreparedStatement pst, int id) {
		try {
			pst.setInt(1, id);
			pst.executeUpdate();
		}catch(SQLException e){
			System.out.println("deleteInDatabase오류");
		}finally {
			JdbcClose(con, pst);
		}
		
	}
	
	
		
	
	
	public void JdbcClose(Connection con, PreparedStatement pst) {
		if (pst != null) try { pst.close(); } catch(SQLException e) {}
		if (con != null) try { con.close(); } catch(SQLException e) {}	
		
	}

	public void JdbcClose(Connection con, PreparedStatement pst, ResultSet rs) {
		if (rs != null) try { rs.close(); } catch(SQLException e) {}
		if (pst != null) try { pst.close(); } catch(SQLException e) {}
		if (con != null) try { con.close(); } catch(SQLException e) {}
		
	}

	public void JdbcClose(Connection con, Statement st, ResultSet rs) {
		if (rs != null) try { rs.close(); } catch(SQLException e) {}
		if (st != null) try { st.close(); } catch(SQLException e) {}
		if (con != null) try { con.close(); } catch(SQLException e) {}
		
	}
	
	
}

