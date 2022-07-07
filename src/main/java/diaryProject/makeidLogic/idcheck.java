package diaryProject.makeidLogic;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/idcheck")
public class idcheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM MEMBER";
		String testid2 = request.getParameter("user_ID");
		String token =  "중복아님";
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, "c##bmm522", "1234");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			while(rs.next()) {
				String checkIdList = rs.getString("ID");
				if(checkIdList.equals(testid2)) {
					token ="중복";
					System.out.println(token);
					
					
				}
				
			}
		
			
			
			
			
			
			
			
			
			
			rs.close();
			st.close();
			con.close();
			
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		//request.setAttribute("token", token);
		System.out.println(token);
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("makeidpage.jsp");
		//dispatcher.forward(request, response);
		
	}
	
	
	
	

	

}
