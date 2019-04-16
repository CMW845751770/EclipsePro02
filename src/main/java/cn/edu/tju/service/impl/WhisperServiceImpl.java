package cn.edu.tju.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.tju.mapper.WhisperMapper;
import cn.edu.tju.pojo.Whisper;
import cn.edu.tju.service.WhisperService;

@Service
@Transactional
public class WhisperServiceImpl implements WhisperService
{
	@Resource
	private WhisperMapper whisperMapper; 
	
	@Override
	public PageInfo<Whisper> selWhisperByPage(int pageSize, int pageNumber) 
	{
		PageHelper.startPage(pageNumber, pageSize) ; 
		List<Whisper> list = whisperMapper.selWhisperByPage() ; 
		System.out.println(list);
		PageInfo<Whisper> pi = new PageInfo<>(list) ; 
		return pi;
	}

	@Override
	public int updLikeById(int id, int newLike) 
	{
		return whisperMapper.updLikeById(id, newLike);
	}

}
