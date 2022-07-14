package NoticeBoardProject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import NoticeBoardProject.entity.ViewEntity;

public class ViewDAO extends NoticeBoardProjectDAO{

	public List<ViewEntity> GetView(int id) {
		String sql = "SELECT TITLE, WRITER_ID,CONTENT, REGDATE FROM TABLELIST WHERE ID=?";
		Connection con = ConnectionDriver();
		PreparedStatement pst = null;
		ResultSet rs = null;
		return GetViewFromDatabase(con, pst, rs, sql, id);
	}

}
