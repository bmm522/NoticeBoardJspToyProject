package NoticeBoardProject.DAO;

public interface NoticeBoardDAOService {
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	
	public int GetTokenOfLoginCheck(String userid, String userpwd);
}
