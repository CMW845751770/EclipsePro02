package cn.edu.tju.pojo;

import java.io.Serializable;

public class Comment implements Serializable
{
	private int id ; 
	private String person ; 
	private String date ; 
	private String content ;
	private int bid ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
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
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	} 
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", person=" + person + ", date=" + date + ", content=" + content + ", bid=" + bid
				+ "]";
	}
}
