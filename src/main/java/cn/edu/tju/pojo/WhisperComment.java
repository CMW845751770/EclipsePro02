package cn.edu.tju.pojo;

import java.io.Serializable;

public class WhisperComment implements Serializable
{
	private int id ; 
	private String content ;; 
	private String date ; 
	private String person ; 
	private int wid ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	@Override
	public String toString() {
		return "WhisperComment [id=" + id + ", content=" + content + ", date=" + date + ", person=" + person + ", wid="
				+ wid + "]";
	} 
	public WhisperComment() {
		// TODO Auto-generated constructor stub
	}
}
