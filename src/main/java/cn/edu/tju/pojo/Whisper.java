package cn.edu.tju.pojo;

import java.io.Serializable;
import java.util.List;

public class Whisper implements Serializable
{
	private int id ;
	private String content ; 
	private String date ; 
	private int likes ; 
	private int commentCount ;
	private List<WhisperImage> imgList ; 
	public List<WhisperImage> getImgList() {
		return imgList;
	}
	public void setImgList(List<WhisperImage> imgList) {
		this.imgList = imgList;
	}
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
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public Whisper() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Whisper [id=" + id + ", content=" + content + ", date=" + date + ", likes=" + likes + ", commentCount="
				+ commentCount + ", imgList=" + imgList + "]";
	}
	
	
}
