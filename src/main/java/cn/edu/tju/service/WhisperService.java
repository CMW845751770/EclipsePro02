package cn.edu.tju.service;

import com.github.pagehelper.PageInfo;

import cn.edu.tju.pojo.Whisper;

public interface WhisperService 
{
	PageInfo<Whisper> selWhisperByPage(int pageSize , int pageNumber) ; 
	
	int updLikeById(int id ,int newLike) ; 
}
