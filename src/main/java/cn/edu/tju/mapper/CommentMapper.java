package cn.edu.tju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import cn.edu.tju.pojo.Comment;
import cn.edu.tju.pojo.PageInfo;

public interface CommentMapper 
{
	/**
	 * 插入Comment
	 * @param comment
	 * @return
	 */
	@Insert("insert into comment values(default,#{person},#{date},#{content},#{bid})")
	int insComment(Comment comment) ; 
	
	/**
	 * 分页查询评论
	 * @param bid
	 * @param pi
	 * @return
	 */
	List<Comment> selCommentsByBidAndPage(@Param("bid")int bid,@Param("pi")PageInfo pi) ; 
	/**
	 * 查询总的评论数
	 * @return
	 */
	long selCommentCountByPage(@Param("bid")int bid) ; 
}
