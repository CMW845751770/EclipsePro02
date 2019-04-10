package cn.edu.tju.service;

import cn.edu.tju.pojo.Blog;
import cn.edu.tju.pojo.PageInfo;

public interface BlogService 
{
	PageInfo selBlogByPage(int pageSize , int pageNumber,String type) ; 
	
	Blog selById(int id ) ;
	
	Blog selPrevByBid(int bid , String type) ; 
	
	Blog selNextByBid(int bid , String type) ; 
}
