package NoticeBoardProject.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NoticeBoardProject.service.NoticeBoardDAOImpl;
import NoticeBoardProject.service.NoticeBoardDAOService;

@WebServlet("/NoticeBoardController")
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
		
		
		userId = request.getParameter("User_Id");
		userPwd = request.getParameter("User_Pwd");
		
		NoticeBoardDAOService noticeBoardDaoImpl = new NoticeBoardDAOImpl();
		
		check = noticeBoardDaoImpl.GetTokenOfLoginCheck(userId, userPwd);
		System.out.println(check);
		if (check ==1) {
			response.sendRedirect("/NoticeBoardProject/loginresult.jsp");
			
		} else if (check ==-1) {
			response.sendRedirect("/NoticeBoardProject/loginresult.jsp");
			
		} else {
			response.sendRedirect("/NoticeBoardProject/loginresult.jsp");
		}
		
		
		
		
		
		
	}
	
}
