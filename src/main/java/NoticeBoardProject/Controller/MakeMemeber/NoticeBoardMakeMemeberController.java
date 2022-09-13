package NoticeBoardProject.Controller.MakeMemeber;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NoticeBoardProject.DAO.MakeMemberDAO;
import NoticeBoardProject.DAO.Token.Token;
import codeEncryption.oneWay.codeObject.CodeObject;
import codeEncryption.oneWay.main.CodeEncryptionOfOneWay;

@WebServlet("/NoticeBoardMakeMemberController")
public class NoticeBoardMakeMemeberController extends HttpServlet{
	ArrayList<CodeObject> hashCodeArr = new ArrayList<CodeObject>();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		hashCodeArr = changePwdToHashCode(request.getParameter("user_ID"), request.getParameter("user_PW"));
		makeMemberAction(hashCodeArr.get(0).getIdCode(), hashCodeArr.get(0).getHashCode(), 
				request.getParameter("user_Name"), request.getParameter("user_Phonenum"),
				request.getParameter("user_Email"), response.getWriter(), request, hashCodeArr.get(0).getSaltCode());
	}

	private ArrayList<CodeObject> changePwdToHashCode(String userId, String userPwd) {
		ArrayList<CodeObject> arr = new ArrayList<CodeObject>();
		CodeEncryptionOfOneWay cw = new CodeEncryptionOfOneWay(userId, userPwd);
		arr = cw.getEncryptingCode();
		return arr;
	}
	
	private void makeMemberAction(String userId, String userPwd, String userName, String userPhonenum,
			String userEmail, PrintWriter out, HttpServletRequest request, String salt) {
	
		if (userId == "" || userPwd == "" || userName == "" 
				|| userName == "" || userPhonenum == "") {
			out.println("<script>");
			out.println("alert('입력을 안한 곳이 있습니다')");
			out.println("location.href='makeidpage.jsp'");
			out.println("</script>");
			
		}	else { 
			makeMemberActionLogic(userId, 
					userPwd, 
					userName, 
					userPhonenum,
				userEmail, 
				out, 
				request,
				salt);
		}
		
	}
	private void makeMemberActionLogic(String userId, String userPwd, String userName, String userPhonenum,
			String userEmail, PrintWriter out,  HttpServletRequest request, String salt) {
		
		MakeMemberDAO nd = new MakeMemberDAO();
		try {
			makeMemberActionLogiccheck(nd.getTokenOfMakeMember
					(userId, userPwd, userName, userPhonenum, userEmail, salt), 
					out, 
					request.getSession(), userId);
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
	}


	private void makeMemberActionLogiccheck(Token token, PrintWriter out, HttpSession session, String userId) {
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
				out.println("location.href='search?page=1&searchKeyword=null'");
				out.println("</script>");
		
		}
	}
}
	

