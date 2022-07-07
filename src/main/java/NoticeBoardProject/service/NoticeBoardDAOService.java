package NoticeBoardProject.service;

public interface NoticeBoardDAOService {
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	
	public int GetTokenOfLoginCheck(String userid, String userpwd);
}
