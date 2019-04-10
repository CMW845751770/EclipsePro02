package cn.edu.tju.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.tju.mapper.CommentMapper;
import cn.edu.tju.pojo.Comment;
import cn.edu.tju.pojo.PageInfo;
import cn.edu.tju.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService
{
	@Resource
	private CommentMapper commentMapper ; 

	@Override
	public int insComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentMapper.insComment(comment);
	}

	@Override
	public PageInfo selCommentsByBidAndPage(int bid, int pageSize, int pageNumber) 
	{
		PageInfo pi = new PageInfo() ;
		pi.setPageSize(pageSize);
		pi.setPageNumber(pageNumber);
		pi.setPageStart(pageSize*(pageNumber-1));
		long count =commentMapper.selCommentCountByPage(bid) ; 
		pi.setCount(count);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		pi.setList(commentMapper.selCommentsByBidAndPage(bid, pi));
		return pi;
	}
}
