package cn.edu.tju.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageInfo;
import cn.edu.tju.pojo.Album;
import cn.edu.tju.service.AlbumService;

@Controller
@RequestMapping("/album")
public class AlbumController 
{
	@Resource
	private AlbumService albumServiceImpl ; 

	@GetMapping()
	public String showAlbumByPage(@RequestParam(defaultValue="4") int pageSize , @RequestParam(defaultValue="1")int pageNumber , Model model)
	{
		PageInfo<Album> pi = albumServiceImpl.selAllAlbumByPage(pageSize, pageNumber) ; 
		model.addAttribute("pi", pi) ; 
		return "forward:/album.html" ; 
	}
}
