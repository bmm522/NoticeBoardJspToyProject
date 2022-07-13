package NoticeBoardProject.Controller.WriterController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Writer")
public class WriterController extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charest=UTF-8");
		
		HttpSession session = request.getSession();
		String writer_id = (String) session.getAttribute("userId");
	}
	
}
