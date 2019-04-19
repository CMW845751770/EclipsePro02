package cn.edu.tju.service;

import com.github.pagehelper.PageInfo;

import cn.edu.tju.pojo.Album;

public interface AlbumService 
{
	PageInfo<Album> selAllAlbumByPage(int pageSize , int pageNumber) ; 
}
