package NoticeBoardProject.Controller.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NoticeBoardProject.DAO.LoginDAO;
import NoticeBoardProject.DAO.NoticeBoardProjectDAO;
import NoticeBoardProject.DAO.Token.Token;



@WebServlet("/LoginController")
public class NoticeBoardLoginController extends HttpServlet{
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		loginAfterMovePage(request.getParameter("User_Id"), request.getParameter("User_Pwd"), response, request);
		}
		
		
	
	protected void loginAfterMovePage(String userId, String userPwd, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		NoticeBoardProjectDAO logindao = new LoginDAO();
		loginAfterMovePageSwitch (((LoginDAO) logindao)
				.getTokenOfLoginCheck(userId, userPwd), 
				response.getWriter(),
				request.getSession(), 
				userId);
		}
	
	

	protected void loginAfterMovePageSwitch(Token token, PrintWriter out, HttpSession session, String userId) {
			
			switch(token) {
				case LOGINSUCCESS:
					session.setAttribute("userId", userId);
					out.println("<script>");
					out.println("location.href='search?page=1&searchKeyword=null'");
					out.println("</script>");
					break;
				case LOGINFAIL:
					out.println("<script>");
					out.println("alert('아이디 또는 비밀번호가 없습니다')");
					out.println("location.href='loginPage.jsp'");
					out.println("</script>");
					break;
				default:
					out.println("<script>");
					out.println("alert('오류')");
					out.println("location.href='loginPage.jsp'");
					out.println("</script>");
					break;
		}
	}

}
