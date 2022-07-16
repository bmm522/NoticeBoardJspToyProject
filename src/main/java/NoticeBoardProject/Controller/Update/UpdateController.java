package NoticeBoardProject.Controller.Update;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NoticeBoardProject.DAO.UpdateDAO;
@WebServlet("/update")
public class UpdateController extends HttpServlet{
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		UpdateDAO ud = new UpdateDAO();
		ud.updateWrite(request.getParameter("title"),
				request.getParameter("content"),
				Integer.parseInt(request.getParameter("id")));
		updateAftermovepage(response.getWriter());
		
	}
	
	private void updateAftermovepage(PrintWriter out) {
		out.println("<script>");
		out.println("alert('글이 수정되었습니다.')");
		out.println("location.href='table'");
		out.println("</script>");
		
	}
	
}
