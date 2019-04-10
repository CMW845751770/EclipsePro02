package cn.edu.tju.pojo;

import java.io.Serializable;
import java.util.List;

public class Blog implements Serializable
{
	private int id ;
	private String title ; 
	private String keyword ;
	private String type ; 
	private String date ; 
	private String content ;
	private PageInfo comments ;
	private String imgPath ; 
	public Blog() {
		// TODO Auto-generated constructor stub
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public PageInfo getComments() {
		return comments;
	}
	public void setComments(PageInfo comments) {
		this.comments = comments;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", keyword=" + keyword + ", type=" + type + ", date=" + date
				+ ", content=" + content + ", comments=" + comments + ", imgPath=" + imgPath + "]";
	}
	
}
