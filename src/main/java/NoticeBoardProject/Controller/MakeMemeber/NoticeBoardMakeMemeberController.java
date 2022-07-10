package NoticeBoardProject.Controller.MakeMemeber;

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

@WebServlet("/NoticeBoardMakeMemberController")
public class NoticeBoardMakeMemeberController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		MakeMemberAction(request.getParameter("user_ID"), request.getParameter("user_PW"), 
				request.getParameter("user_Name"), request.getParameter("user_Phonenum"),
				request.getParameter("user_Email"), response.getWriter());
	}


	private void MakeMemberAction(String userId, String userPwd, String userName, String userPhonenum,
			String userEmail, PrintWriter out) {
	
		if (userId == "" || userPwd == "" || userName == "" 
				|| userName == "" || userPhonenum == "") {
			out.println("<script>");
			out.println("alert('입력을 안한 곳이 있습니다')");
			out.println("location.href='makeidpage.jsp'");
			out.println("</script>");
			
		}	else { 
			MakeMemberActionLogic(userId, userPwd, userName, userPhonenum,
				userEmail, out);
		}
		
	}
	private void MakeMemberActionLogic(String userId, String userPwd, String userName, String userPhonenum,
			String userEmail, PrintWriter out) {
		
		NoticeBoardDAOService nd = new NoticeBoardDAOImpl();
		try {
			MakeMemberActionLogiccheck(nd.GetTokenOfMakeMember
					(userId, userPwd, userName, userPhonenum, userEmail), out);
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
	}


	private void MakeMemberActionLogiccheck(Token token, PrintWriter out) {
		switch(token) {
			case MAKEMEMBERFAIL:
				out.println("<script>");
				out.println("alert('이미 아이디가 있습니다')");
				out.println("location.href='makeidpage.jsp'");
				out.println("</script>");
				
			case MAKEMEMBERSUCCESS:
				out.println("<script>");
				out.println("alert('회원가입 성공')");
				out.println("location.href='loginPage.jsp'");
				out.println("</script>");
		
		}
	}
}
	

