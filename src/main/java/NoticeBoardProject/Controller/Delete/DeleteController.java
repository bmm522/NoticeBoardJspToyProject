package NoticeBoardProject.Controller.Delete;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NoticeBoardProject.DAO.DeleteDAO;

@WebServlet("/delete")
public class DeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		DeleteDAO dd = new DeleteDAO();
		dd.deletePage(Integer.parseInt(request.getParameter("id")));
		movePage(response.getWriter());
	}
	
	public void movePage(PrintWriter out) {
		out.println("<script>");
		out.println("alert('글이 삭제되었습니다.')");
		out.println("location.href='table'");
		out.println("</script>");
		
	}

}
