package NoticeBoardProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NoticeBoardProject.DAO.NoticeBoardDAOImpl;
import NoticeBoardProject.DAO.NoticeBoardDAOService;
import NoticeBoardProject.DAO.Token.Token;



@WebServlet("/NoticeBoardLoginController")
public class NoticeBoardController extends HttpServlet{
	
	
	
	
	private String userId;
	private String userPwd;
	public NoticeBoardController() {
		
		userId = "";
		userPwd = "";
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//HttpSession session = null;
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//인코딩 설정
		
		userId = request.getParameter("User_Id");
		userPwd = request.getParameter("User_Pwd");
		
		NoticeBoardDAOService noticeBoardDaoImpl = new NoticeBoardDAOImpl();
		PrintWriter out=response.getWriter();
		
		Token check = noticeBoardDaoImpl.GetTokenOfLoginCheck(userId, userPwd);
			

		
		
		switch(check) {
			case LOGINSUCCESS:
				//session.setAttribute("userId", userId);
				out.println("<script>");
				out.println("location.href='main.jsp'");
				out.println("</script>");
				break;
			case LOGINIDPWDNOTMATCH:
				out.println("<script>");
				out.println("alert('비밀번호가 틀립니다')");
				out.println("location.href='loginPage.jsp'");
				out.println("</script>");
				break;
			case LOGINFAIL:
				out.println("<script>");
				out.println("alert('아이디가 없습니다')");
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
