package cn.edu.tju.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		PageInfo<Whisper> pi = whisperServiceImpl.selWhisperByPage(pageSize, pageNumber) ;
		model.addAttribute("pi", pi) ; 
		return "forward:/whisper.html";
	}
	
}
