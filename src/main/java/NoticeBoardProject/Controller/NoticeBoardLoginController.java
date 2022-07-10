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



@WebServlet("/LoginController")
public class NoticeBoardLoginController extends HttpServlet{
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//HttpSession session = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//���ڵ� ����
		LoginAfterMovePage(request.getParameter("User_Id"), request.getParameter("User_Pwd"), response);
		}
		
		
	
	protected void LoginAfterMovePage(String userId, String userPwd, HttpServletResponse response)
			throws IOException {
		
		NoticeBoardDAOService noticeBoardDaoImpl = new NoticeBoardDAOImpl();
		PrintWriter out=response.getWriter();
		LoginAfterMovePageSwitch (noticeBoardDaoImpl.GetTokenOfLoginCheck(userId, userPwd), response.getWriter());
		
		
		
		}

	protected void LoginAfterMovePageSwitch(Token token, PrintWriter out) {
			switch(token) {
				case LOGINSUCCESS:
					//session.setAttribute("userId", userId);
					out.println("<script>");
					out.println("location.href='main.jsp'");
					out.println("</script>");
					break;
				case LOGINFAIL:
					out.println("<script>");
					out.println("alert('���̵� �Ǵ� ��й�ȣ�� �����ϴ�')");
					out.println("location.href='loginPage.jsp'");
					out.println("</script>");
					break;
				default:
					out.println("<script>");
					out.println("alert('����')");
					out.println("location.href='loginPage.jsp'");
					out.println("</script>");
					break;
		}
	}

}
