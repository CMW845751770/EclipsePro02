package cn.edu.tju.pojo;

import java.io.Serializable;

public class Leacot implements Serializable
{
	private int id ; 
	private String person ; 
	private String content ; 
	private String date ;
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
	@Override
	public String toString() {
		return "Leacot [id=" + id + ", person=" + person + ", content=" + content + ", date=" + date + "]";
	} 
	public Leacot() {
		// TODO Auto-generated constructor stub
	}

}
