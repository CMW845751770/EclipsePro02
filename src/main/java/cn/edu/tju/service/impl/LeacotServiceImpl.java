package cn.edu.tju.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.tju.mapper.LeacotMapper;
import cn.edu.tju.pojo.Leacot;
import cn.edu.tju.service.LeacotService;

@Service
@Transactional
public class LeacotServiceImpl implements LeacotService 
{
	@Resource
	private LeacotMapper leacotMapper ; 
	
	@Override
	public PageInfo<Leacot> selAllLeacotByPage(int pageSize, int pageNumber) 
	{
		PageHelper.startPage(pageNumber, pageSize) ; 
		List<Leacot> list = leacotMapper.selAllLeacotByPage() ; 
		PageInfo<Leacot> pi = new PageInfo<>(list) ; 
		return pi;
	}

	@Override
	public int insLeacot(Leacot leacot) 
	{
		return leacotMapper.insLeacot(leacot);
	}

}
