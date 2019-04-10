package cn.edu.tju.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.tju.mapper.BlogMapper;
import cn.edu.tju.pojo.Blog;
import cn.edu.tju.pojo.PageInfo;
import cn.edu.tju.service.BlogService;

@Transactional
@Service
public class BlogServiceImpl implements BlogService
{
	@Resource
	private BlogMapper blogMapper ; 
	
	@Override
	public PageInfo selBlogByPage(int pageSize, int pageNumber,String type) 
	{
		PageInfo pi = new PageInfo() ; 
		pi.setPageSize(pageSize);
		pi.setPageNumber(pageNumber);
		pi.setPageStart(pageSize*(pageNumber-1));
		long count = blogMapper.selBlogCountByPage(type) ; 
		pi.setCount(count);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		pi.setList(blogMapper.selBlogByPage(pi , type));
		return pi;
	}
	
	@Override
	public Blog selById(int id) {
		return blogMapper.selBlogById(id);
	}

	@Override
	public Blog selPrevByBid(int bid, String type) 
	{
		return blogMapper.selPrevBlogByBid(bid, type);
	}

	@Override
	public Blog selNextByBid(int bid, String type) {
		return blogMapper.selNextBlogByBid(bid, type);
	}
	
}
