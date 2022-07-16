package NoticeBoardProject.entity;

import java.sql.Date;

public class ViewEntity {
	int id;
	String title;
	String writer_id;
	String content;
	Date regdate;
	
	public ViewEntity() {
		
	}
	public ViewEntity(int id, String title, String writer_id, String content, Date regdate) {
		this.id = id;
		this.title = title;
		this.writer_id = writer_id;
		this.content = content;
		this.regdate = regdate;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
