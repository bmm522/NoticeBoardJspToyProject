package NoticeBoardProject.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import NoticeBoardProject.DAO.NoticeBoardDAOClose;

public class DBEntity {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	NoticeBoardDAOClose jdbcClose;
	
	public DBEntity() {
		
	}
	
	public DBEntity(Connection con, PreparedStatement pst, ResultSet rs, NoticeBoardDAOClose jdbcClose) {
		super();
		this.con = con;
		this.pst = pst;
		this.rs = rs;
		this.jdbcClose = jdbcClose;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public PreparedStatement getPst() {
		return pst;
	}

	public void setPst(PreparedStatement pst) {
		this.pst = pst;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public NoticeBoardDAOClose getJdbcClose() {
		return jdbcClose;
	}

	public void setJdbcClose(NoticeBoardDAOClose jdbcClose) {
		this.jdbcClose = jdbcClose;
	}
	
	
}
