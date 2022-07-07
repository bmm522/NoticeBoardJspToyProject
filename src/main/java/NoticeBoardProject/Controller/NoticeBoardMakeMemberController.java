package NoticeBoardProject.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NoticeBoardProject.DAO.NoticeBoardDAOImpl;
import NoticeBoardProject.DAO.NoticeBoardDAOService;

@WebServlet("/NoticeBoardMakeMemberController")
public class NoticeBoardMakeMemberController extends HttpServlet{
	private String userId;
	private String userPw;
	private String userName;
	private String userPhonenum;
	private String userEmail;
	
	public NoticeBoardMakeMemberController() {
		userId ="";
		userPw ="";
		userName ="";
		userPhonenum = "";
		userEmail = "";
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userId = request.getParameter("user_ID");
		userPw = request.getParameter("user_PW");
		userName = request.getParameter("user_Name");
		userPhonenum = request.getParameter("user_Phonenum");
		userPw = request.getParameter("user_Email");
		
		NoticeBoardDAOService noticeBoardDaoImpl = new NoticeBoardDAOImpl();
		
		
	}
}
