package cn.edu.tju.pojo;

import java.io.Serializable;

public class Album implements Serializable
{
	private int id ; 
	private String location ; 
	private String event ; 
	private String date ; 
	private String imgPath ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	} 
	public Album() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", location=" + location + ", event=" + event + ", date=" + date + ", imgPath="
				+ imgPath + "]";
	}
	
}
