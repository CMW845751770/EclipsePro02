package cn.edu.tju.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.edu.tju.pojo.Leacot;
import cn.edu.tju.service.LeacotService;

@Controller
@RequestMapping("/leacot")
public class LeacotController 
{
	@Resource
	private LeacotService leacotServiceImpl ; 
	
	@GetMapping()
	public String showLeacotByPage(@RequestParam(defaultValue="1") int pageSize , @RequestParam(defaultValue="1") int pageNumber,Model model)
	{
		PageInfo<Leacot> pi = leacotServiceImpl.selAllLeacotByPage(pageSize, pageNumber) ; 
		System.out.println(pi);
		model.addAttribute("pi", pi) ; 
		return "forward:/leacots.html";
	}
	
	
	@PostMapping()
	public String insertLeacot(Leacot leacot)
	{
		leacot.setDate(new Date().toLocaleString());
		System.out.println(leacot);
		leacotServiceImpl.insLeacot(leacot) ; 
		return "redirect:/leacot" ; 
	}
}
