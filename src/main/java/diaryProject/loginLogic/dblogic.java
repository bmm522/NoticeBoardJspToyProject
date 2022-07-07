package diaryProject.loginLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




public class dblogic {
	String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	String sql = "SELECT * FROM MEMBER";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection(url,"bmm522","1234");
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(sql);
}
