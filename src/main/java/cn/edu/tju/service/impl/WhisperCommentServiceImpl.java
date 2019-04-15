package cn.edu.tju.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.tju.mapper.WhisperCommentMapper;
import cn.edu.tju.pojo.WhisperComment;
import cn.edu.tju.service.WhisperCommentService;

@Service
@Transactional
public class WhisperCommentServiceImpl implements WhisperCommentService
{
	@Resource
	private WhisperCommentMapper whisperCommentMapper ; 
	
	@Override
	public PageInfo<WhisperComment> selWhisperCommentByPage(int pageSize, int pageNumber,int wid) 
	{
		PageHelper.startPage(pageNumber, pageSize) ; 
		List<WhisperComment> list = whisperCommentMapper.selWhisperCommentByPage(wid) ; 
		System.out.println(list);
		PageInfo<WhisperComment> pi = new PageInfo<>(list) ; 
		return pi;
	}
	
}
