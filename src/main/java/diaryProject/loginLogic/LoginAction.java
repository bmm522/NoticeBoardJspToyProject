package diaryProject.loginLogic;

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

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM MEMBER";
		String testid = request.getParameter("checkid");
		String testps = request.getParameter("ps");
		String i = "실패";
		Boolean checklogin = new Boolean(true);
		 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, "c##bmm522", "1234");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String listId = rs.getString("ID");
				String listps = rs.getString("PWD");
			
				System.out.println(listId);
				System.out.println(testid);
			
				if(listId.equals(testid)) {
					if(listps.equals(testps)) {
						i = "성공";
					
					}
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
		if(i.equals("실패")) {
			checklogin = Boolean.FALSE;
			
		}
		request.setAttribute("checklogin",checklogin);
		request.setAttribute("i", i);
		
		
	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginPage.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("loginresult.jsp");
		
		
		
		
	}

	

}
