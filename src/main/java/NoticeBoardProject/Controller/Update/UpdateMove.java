package NoticeBoardProject.Controller.Update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NoticeBoardProject.DAO.ViewDAO;

@WebServlet("/updatemove")
public class UpdateMove extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		ViewDAO vd = new ViewDAO();
		request.setAttribute("update", vd.GetView(id)); 
		request.getRequestDispatcher("/update.jsp").forward(request, response);
		
	}
}
