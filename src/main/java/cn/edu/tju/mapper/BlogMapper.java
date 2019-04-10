package cn.edu.tju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.tju.pojo.Blog;
import cn.edu.tju.pojo.PageInfo;

public interface BlogMapper 
{
	List<Blog> selBlogByPage(@Param("pi")PageInfo pi ,@Param("type") String type) ; 
	
	long selBlogCountByPage(String type) ; 
	
	Blog selBlogById(@Param("bid")int bid) ; 
	
	Blog selPrevBlogByBid(@Param("bid")int bid,@Param("type")String type) ; 
	
	Blog selNextBlogByBid(@Param("bid")int bid,@Param("type")String type) ; 
}
