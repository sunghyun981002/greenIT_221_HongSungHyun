package board;

import java.sql.Timestamp;
import java.util.Date;

public class BoardDTO {
	
	private int no, code, viewCnt, likeCnt;
	private Timestamp createdAt, modifiedAt;
	private String title, content;
	
	// constructor
	public BoardDTO(int no, int code, String title, String content) {
		this.no = no;
		this.code = code;
		this.title = title;
		this.content = content;
	}
	
	// sql용 생성자
	public BoardDTO(int no, int code, String title, String content, int viewCnt, int likeCnt, Timestamp createdAt, Timestamp modifiedAt){
		this.no = no;
		this.code = code;
		this.title = title;
		this.content = content;
		this.viewCnt = viewCnt;
		this.likeCnt = likeCnt;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}
	
	// getter & setter
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCode() {
		return code;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	public Timestamp getModifiedAt() {
		return modifiedAt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}