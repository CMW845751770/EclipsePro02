package cn.edu.tju.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.edu.tju.pojo.WhisperComment;
import cn.edu.tju.service.WhisperCommentService;
import cn.edu.tju.service.impl.WhisperCommentServiceImpl;

@Controller
@RequestMapping("whisperComment")
public class WhisperCommentController {
	@Resource
	private WhisperCommentService whisperCommentServiceImpl ; 
	
	@GetMapping()
	@ResponseBody
	public Map<String, Object> showCommentsByPage(@RequestParam(defaultValue = "2") int pageSize,
			@RequestParam(defaultValue = "1") int pageNumber) 
	{
		PageInfo<WhisperComment> pi = whisperCommentServiceImpl.selWhisperCommentByPage(pageSize, pageNumber) ; 
		Map<String,Object> map = new HashMap<String, Object>() ; 
		map.put("pi", pi) ; 
		return map ; 
	}
}
