package cn.edu.tju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.edu.tju.pojo.WhisperComment;

public interface WhisperCommentMapper 
{
	@Select("select count(*) from whisper_comment where id = #{0}")
	int selWhisperCommentCount(int id) ; 
	
	List<WhisperComment> selWhisperCommentByPage()  ;
}
