package cn.edu.tju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import cn.edu.tju.pojo.Comment;
import cn.edu.tju.pojo.PageInfo;

public interface CommentMapper 
{
	/**
	 * ����Comment
	 * @param comment
	 * @return
	 */
	@Insert("insert into comment values(default,#{person},#{date},#{content},#{bid})")
	int insComment(Comment comment) ; 
	
	/**
	 * ��ҳ��ѯ����
	 * @param bid
	 * @param pi
	 * @return
	 */
	List<Comment> selCommentsByBidAndPage(@Param("bid")int bid,@Param("pi")PageInfo pi) ; 
	/**
	 * ��ѯ�ܵ�������
	 * @return
	 */
	long selCommentCountByPage(@Param("bid")int bid) ; 
}
