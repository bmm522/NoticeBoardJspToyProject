package diaryProject.makeidLogic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/makeidlogic")
public class makeidlogic extends HttpServlet {

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("user_ID");
		String ps = request.getParameter("user_PW1");
		String name = request.getParameter("user_name");
		
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = " INSERT INTO MEMBER(ID,PWD,NAME) " + " VALUES('"+id+"','"+ps+"','"+name+"') ";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, "c##bmm522", "1234");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
				
				
			
			
			
			
			
			
			
			
			
			
			
			
			rs.close();
			st.close();
			con.close();
			
		}catch (SQLException e) {
				
				e.printStackTrace();
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	
		
		
		
	}

	

}
