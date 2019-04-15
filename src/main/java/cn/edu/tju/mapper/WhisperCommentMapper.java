package cn.edu.tju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.edu.tju.pojo.WhisperComment;

public interface WhisperCommentMapper 
{
	@Select("select count(*) from whisper_comment where wid = #{0}")
	int selWhisperCommentCount(int id) ; 
	
	List<WhisperComment> selWhisperCommentByPage(int wid)  ;
	
	
	@Insert("insert into whisper_comment values(default,#{content},#{date},#{person},#{wid})")
	int insWhisperComment(WhisperComment wc) ; 
}
