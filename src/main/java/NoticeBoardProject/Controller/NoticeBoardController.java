package NoticeBoardProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NoticeBoardProject.DAO.NoticeBoardDAOImpl;
import NoticeBoardProject.DAO.NoticeBoardDAOService;

@WebServlet("/NoticeBoardLoginController")
public class NoticeBoardController extends HttpServlet{
	private int check;
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
		
		HttpSession session = null;
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//���ڵ� ����
		
		userId = request.getParameter("User_Id");
		userPwd = request.getParameter("User_Pwd");
		
		NoticeBoardDAOService noticeBoardDaoImpl = new NoticeBoardDAOImpl();
		PrintWriter out=response.getWriter();
		
		check = noticeBoardDaoImpl.GetTokenOfLoginCheck(userId, userPwd);
				
		
		
		if (check ==1) { 
			session.setAttribute("userId", userId);
			out.println("<script>");
			out.println("location.href='main.jsp'");
			out.println("</script>");
			
			//response.sendRedirect("/NoticeBoardProject/loginresult.jsp");
		}
			else if (check ==2) {
			out.println("<script>");
			out.println("alert('��й�ȣ�� Ʋ���ϴ�')");
			out.println("location.href='loginPage.jsp'");
			out.println("</script>");
		}
			else if (check == -1) {
			out.println("<script>");
			out.println("alert('���̵� �����ϴ�')");
			out.println("location.href='loginPage.jsp'");
			out.println("</script>");
		}
		
			else {
			out.println("<script>");
			out.println("alert('����')");
			out.println("location.href='loginPage.jsp'");
			out.println("</script>");
		}
		
	}
	
}
