package NoticeBoardProject.Controller.MakeMemeber;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NoticeBoardProject.DAO.MakeMemberDAO;
import NoticeBoardProject.DAO.NoticeBoardProjectDAO;
import NoticeBoardProject.DAO.Token.Token;

@WebServlet("/NoticeBoardMakeMemberController")
public class NoticeBoardMakeMemeberController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		MakeMemberAction(request.getParameter("user_ID"), request.getParameter("user_PW"), 
				request.getParameter("user_Name"), request.getParameter("user_Phonenum"),
				request.getParameter("user_Email"), response.getWriter(), request);
	}


	private void MakeMemberAction(String userId, String userPwd, String userName, String userPhonenum,
			String userEmail, PrintWriter out, HttpServletRequest request) {
	
		if (userId == "" || userPwd == "" || userName == "" 
				|| userName == "" || userPhonenum == "") {
			out.println("<script>");
			out.println("alert('입력을 안한 곳이 있습니다')");
			out.println("location.href='makeidpage.jsp'");
			out.println("</script>");
			
		}	else { 
			MakeMemberActionLogic(userId, 
					userPwd, 
					userName, 
					userPhonenum,
				userEmail, 
				out, 
				request);
		}
		
	}
	private void MakeMemberActionLogic(String userId, String userPwd, String userName, String userPhonenum,
			String userEmail, PrintWriter out,  HttpServletRequest request) {
		
		MakeMemberDAO nd = new MakeMemberDAO();
		try {
			MakeMemberActionLogiccheck(nd.GetTokenOfMakeMember
					(userId, userPwd, userName, userPhonenum, userEmail), 
					out, 
					request.getSession(), userId);
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
	}


	private void MakeMemberActionLogiccheck(Token token, PrintWriter out, HttpSession session, String userId) {
		switch(token) {
			case MAKEMEMBERFAIL:
				out.println("<script>");
				out.println("alert('이미 아이디가 있습니다')");
				out.println("location.href='makeidpage.jsp'");
				out.println("</script>");
				
			case MAKEMEMBERSUCCESS:
				session.setAttribute("userId", userId);
				out.println("<script>");
				out.println("alert('회원가입 성공')");
				out.println("location.href='table?page=1'");
				out.println("</script>");
		
		}
	}
}
	

