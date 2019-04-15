package cn.edu.tju.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.edu.tju.pojo.WhisperComment;
import cn.edu.tju.service.WhisperCommentService;
import cn.edu.tju.service.impl.WhisperCommentServiceImpl;

@Controller
@RequestMapping("/whisperComment")
public class WhisperCommentController {
	@Resource
	private WhisperCommentService whisperCommentServiceImpl ; 
	
	@GetMapping("/{wid}")
	@ResponseBody
	public Map<String, Object> showCommentsByPage(@RequestParam(defaultValue = "1") int pageSize,
			@RequestParam(defaultValue = "1") int pageNumber,@PathVariable("wid")int wid) 
	{
		PageInfo<WhisperComment> pi = whisperCommentServiceImpl.selWhisperCommentByPage(pageSize, pageNumber,wid) ; 
		Map<String,Object> map = new HashMap<String, Object>() ; 
		map.put("pi", pi) ; 
		return map ; 
	}
	
	@PostMapping()
	public String insertWhisperComment(int pageSize ,int pageNumber ,WhisperComment wc)
	{
		System.out.println(pageSize + "---->"+pageNumber);
		wc.setDate(new Date().toLocaleString());
		System.out.println(wc);
		whisperCommentServiceImpl.insWhisperComment(wc) ; 
		return "redirect:/whisper?pageSize="+pageSize+"&pageNumber="+pageNumber ; 
	}
}
