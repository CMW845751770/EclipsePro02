package cn.edu.tju.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.edu.tju.pojo.Whisper;
import cn.edu.tju.service.WhisperService;

@Controller
@RequestMapping("/whisper")
public class WhisperController 
{
	@Resource
	private WhisperService whisperServiceImpl ; 
	
	
	@GetMapping()
	public String showWhisperByPage(@RequestParam(defaultValue = "2") int pageSize,
			@RequestParam(defaultValue = "1") int pageNumber,Model model) 
	{
		System.out.println(pageSize+"-----"+pageNumber);
		PageInfo<Whisper> pi = whisperServiceImpl.selWhisperByPage(pageSize, pageNumber) ;
		System.out.println(pi);
		model.addAttribute("pi", pi) ; 
		return "forward:/whisper.html";
	}
	
	@ResponseBody
	@GetMapping("/{id}/like")
	public Map<String, Object> updateLike(@PathVariable("id")int id , int newLike)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		int index = whisperServiceImpl.updLikeById(id, newLike) ; 
		if(index > 0 )
		{
			map.put("msg", "success") ; 
			return map ; 
		}
		map.put("msg", "failed") ; 
		return map ; 
	}
	
}
