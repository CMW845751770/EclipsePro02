package cn.edu.tju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import cn.edu.tju.pojo.Leacot;

public interface LeacotMapper 
{
	List<Leacot> selAllLeacotByPage() ;
	
	@Insert("insert into leacot values(default,#{person},#{content},#{date})")
	int insLeacot(Leacot leacot) ; 
}
