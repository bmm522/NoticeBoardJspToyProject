package NoticeBoardProject.Controller.GetTable;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NoticeBoardProject.DAO.GetTableDAO;

@WebServlet("/table")
public class GetTableController extends HttpServlet{
	 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		GetTableDAO dao = new GetTableDAO();
		try {
			request.setAttribute("table", dao.GetTable());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/table.jsp").forward(request, response);
	}
}
