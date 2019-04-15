package cn.edu.tju.service;

import com.github.pagehelper.PageInfo;
import cn.edu.tju.pojo.WhisperComment;

public interface WhisperCommentService 
{
	PageInfo<WhisperComment> selWhisperCommentByPage(int pageSize , int pageNumber,int wid) ; 
}
