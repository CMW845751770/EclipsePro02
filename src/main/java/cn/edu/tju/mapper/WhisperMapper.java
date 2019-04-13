package cn.edu.tju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.edu.tju.pojo.Whisper;
import cn.edu.tju.pojo.WhisperImage;

public interface WhisperMapper 
{
	List<Whisper> selWhisperByPage() ; 
	
	@Select("select id , image_path as  imgPath , wid from whisper_imgpath where wid = #{0}")
	List<WhisperImage> selWhisperImageById(int id ) ; 
}
