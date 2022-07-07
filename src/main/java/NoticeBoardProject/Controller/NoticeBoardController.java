package NoticeBoardProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NoticeBoardProject.DAO.NoticeBoardDAOImpl;
import NoticeBoardProject.DAO.NoticeBoardDAOService;

@WebServlet("/NoticeBoardLoginController")
public class NoticeBoardController extends HttpServlet{
	int check;
	private String userId;
	private String userPwd;
	public NoticeBoardController() {
		check = 0;
		userId = "";
		userPwd = "";
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//인코딩 설정
		
		userId = request.getParameter("User_Id");
		userPwd = request.getParameter("User_Pwd");
		
		NoticeBoardDAOService noticeBoardDaoImpl = new NoticeBoardDAOImpl();
		
		check = noticeBoardDaoImpl.GetTokenOfLoginCheck(userId, userPwd);
		
		request.setAttribute("check", check);
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("loginresult.jsp");
//		dispatcher.forward(request, response);
		
		PrintWriter out=response.getWriter();
		
		if (check ==1) { 
			out.println("<script>");
			out.println("location.href='main.jsp'");
			out.println("</script>");
			
			//response.sendRedirect("/NoticeBoardProject/loginresult.jsp");
		}
			else if (check ==2) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다')");
			out.println("location.href='loginPage.jsp'");
			out.println("</script>");
		}
			else if (check == -1) {
			out.println("<script>");
			out.println("alert('아이디가 없습니다')");
			out.println("location.href='loginPage.jsp'");
			out.println("</script>");
		}
		
			else {
			out.println("<script>");
			out.println("alert('오류')");
			out.println("location.href='loginPage.jsp'");
			out.println("</script>");
		}
		
	}
	
}
