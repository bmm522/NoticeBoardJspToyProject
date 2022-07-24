package NoticeBoardProject.Controller.WriterController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NoticeBoardProject.DAO.WriterDAO;

@WebServlet("/Writer")
public class WriterController extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		WriterDAO wd = new WriterDAO();
		wd.InsertWriter(request.getParameter("title"), 
				session.getAttribute("userId"),
				request.getParameter("content"));
		ReturnPage(response.getWriter());
	}
	
	private void ReturnPage(PrintWriter out) {
		out.println("<script>");
		out.println("alert('글이 생성되었습니다.')");
		out.println("location.href='search?page=1&searchKeyword=null'");
		out.println("</script>");
		
		
	}
	
}
