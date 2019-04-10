package cn.edu.tju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JSPController 
{
	@RequestMapping("/{page}")
	public ModelAndView jspRequest(String page)
	{
		System.out.println("JSPController.jspRequest()");
		return new ModelAndView(page) ;
	}
	
	@RequestMapping("/")
	public ModelAndView indexRequest()
	{
		return new ModelAndView("forward:/blog/show") ; 
	}
}// query/{id}
