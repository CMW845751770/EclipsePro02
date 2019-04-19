package cn.edu.tju.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.tju.mapper.AlbumMapper;
import cn.edu.tju.pojo.Album;
import cn.edu.tju.service.AlbumService;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

	@Resource
	private AlbumMapper albumMapper ; 
	
	@Override
	public PageInfo<Album> selAllAlbumByPage(int pageSize, int pageNumber) 
	{
		PageHelper.startPage(pageNumber, pageSize) ; 
		List<Album> list = albumMapper.selAllAlbumByPage() ; 
		PageInfo<Album> pi = new PageInfo<>(list) ; 
		return pi;
	}

}
