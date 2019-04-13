package cn.edu.tju.pojo;

import java.io.Serializable;

public class WhisperImage implements Serializable
{
	private int id ; 
	private String imgPath ; 
	private int wid ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	@Override
	public String toString() {
		return "WhisperImage [id=" + id + ", imgPath=" + imgPath + ", wid=" + wid + "]";
	} 
	public WhisperImage() {
		// TODO Auto-generated constructor stub
	}
}
