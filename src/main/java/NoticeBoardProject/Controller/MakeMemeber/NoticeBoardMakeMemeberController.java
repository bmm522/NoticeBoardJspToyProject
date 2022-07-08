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

@WebServlet("/NoticeBoardMakeMemberController")
public class NoticeBoardMakeMemeberController extends HttpServlet{
	private int check;
	private String newUserId;
	private String newUserPw;
	private String newUserName;
	private String newUserPhonenum;
	private String newUserEmail;
	
	public NoticeBoardMakeMemeberController() {
		check = -1;
		newUserId = "";
		newUserPw = "";
		newUserName = "";
		newUserPhonenum = "";
		newUserEmail = "";
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//인코딩 설정
		PrintWriter out = response.getWriter();
		
		newUserId = request.getParameter("user_ID");
		newUserPw = request.getParameter("user_PW");
		newUserName = request.getParameter("user_Name");
		newUserPhonenum = request.getParameter("user_Phonenum");
		newUserEmail = request.getParameter("user_Email");
		//각 객체에 담기
		
		
		if (newUserId == "" || newUserPw == "" || newUserName == "" 
				|| newUserPhonenum == "" || newUserEmail == "") {
			
			out.println("<script>");
			out.println("alert('입력을 안한 곳이 있습니다')");
			out.println("location.href='makeidpage.jsp'");
			out.println("</script>");
			
		}	else {
			NoticeBoardDAOService makeMemberInstance = new NoticeBoardDAOImpl();
			
			
			try {
				check = makeMemberInstance.GetTokenOfMakeMember
						(newUserId, newUserPw, newUserName, newUserPhonenum, newUserEmail);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			if(check == -1) {
				
				out.println("<script>");
				out.println("alert('이미 아이디가 있습니다')");
				out.println("location.href='makeidpage.jsp'");
				out.println("</script>");
				
			} else {
				
				
				out.println("<script>");
				out.println("alert('회원가입 성공')");
				out.println("location.href='loginPage.jsp'");
				out.println("</script>");
			}
		}
		
		
		
		
		
		
	}
}
