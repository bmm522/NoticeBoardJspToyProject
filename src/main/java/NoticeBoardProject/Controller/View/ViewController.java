package NoticeBoardProject.Controller.View;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NoticeBoardProject.DAO.ViewDAO;

@WebServlet("/view")
public class ViewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		ViewDAO vd = new ViewDAO();
		request.setAttribute("view", vd.GetView(id));
		request.getRequestDispatcher("/view.jsp").forward(request, response);
		
	}
}
