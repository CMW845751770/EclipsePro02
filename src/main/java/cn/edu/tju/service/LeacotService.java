package cn.edu.tju.service;

import com.github.pagehelper.PageInfo;

import cn.edu.tju.pojo.Leacot;

public interface LeacotService 
{
	PageInfo<Leacot> selAllLeacotByPage(int pageSize , int pageNumber) ; 
	
	int insLeacot(Leacot leacot) ; 
}
