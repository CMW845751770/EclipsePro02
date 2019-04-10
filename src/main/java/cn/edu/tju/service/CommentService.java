package cn.edu.tju.service;

import cn.edu.tju.pojo.Comment;
import cn.edu.tju.pojo.PageInfo;

public interface CommentService 
{
	int insComment(Comment comment) ; 
	
	PageInfo selCommentsByBidAndPage(int bid,int pageSize , int pageNumber) ; 
}
