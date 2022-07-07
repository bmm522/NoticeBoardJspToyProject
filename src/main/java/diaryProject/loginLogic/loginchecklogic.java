package diaryProject.loginLogic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginchecklogic")
public class loginchecklogic extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String sql = "SELECT * FROM MEMBER";
	
	try {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection(url, "c##bmm522", "1234");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			String idCheck = request.getParameter(idcheck);
			while(rs.next()){
			String id = rs.getString("ID");
			String ps = rs.getString("PWD");
			
			
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} 
	
}	
	
	

